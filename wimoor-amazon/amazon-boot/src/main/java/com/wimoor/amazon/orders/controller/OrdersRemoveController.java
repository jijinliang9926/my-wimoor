package com.wimoor.amazon.orders.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wimoor.amazon.auth.pojo.entity.AmazonGroup;
import com.wimoor.amazon.auth.service.IAmazonAuthorityService;
import com.wimoor.amazon.auth.service.IAmazonGroupService;
import com.wimoor.amazon.auth.service.IMarketplaceService;
import com.wimoor.amazon.orders.pojo.dto.AmazonOrdersRemoveDTO;
import com.wimoor.amazon.orders.pojo.dto.AmazonOrdersReturnDTO;
import com.wimoor.amazon.orders.pojo.vo.AmazonOrdersRemoveVo;
import com.wimoor.amazon.orders.pojo.vo.AmazonOrdersReturnVo;
import com.wimoor.amazon.orders.service.IAmzOrderItemService;
import com.wimoor.amazon.orders.service.IAmzOrderMainService;
import com.wimoor.amazon.orders.service.IAmzOrderRemovesService;
import com.wimoor.amazon.orders.service.IAmzOrderSolicitationsService;
import com.wimoor.amazon.orders.service.IOrderManagerService;
import com.wimoor.amazon.orders.service.IOrderReturnService;
import com.wimoor.amazon.report.service.IReportAmzOrderInvoiceService;
import com.wimoor.common.result.Result;
import com.wimoor.common.service.IPictureService;
import com.wimoor.common.service.ISerialNumService;
import com.wimoor.common.service.impl.OSSApiService;
import com.wimoor.common.user.UserInfo;
import com.wimoor.common.user.UserInfoContext;
import com.wimoor.common.user.UserLimitDataType;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 订单抓取 前端控制器
 * </p>
 *
 * @author wimoor team
 * @since 2022-05-14
 */
@Api(tags = "订单移除接口")
@RestController
@Slf4j
@RequestMapping("/api/v0/orders/remove")
public class OrdersRemoveController{
	 
    @Resource
    IAmzOrderRemovesService iAmzOrderRemovesService;

	@ApiOperation("订单移除列表")
	@PostMapping("/removelist")
	public Result<IPage<AmazonOrdersRemoveVo>> getRemovelistAction(@RequestBody AmazonOrdersRemoveDTO condition) {
		UserInfo userinfo = UserInfoContext.get();
		if(userinfo.isLimit(UserLimitDataType.operations)) {
			condition.setOwner(userinfo.getId());
		}
		IPage<AmazonOrdersRemoveVo> list = iAmzOrderRemovesService.selectRemovesList(condition);
		return Result.success(list);
	}
	  
	  	
	  	@ApiOperation("订单退货列表导出")
	  	@GetMapping("/downloadRemovelist")
	    public  void downloadlistAction(
	    		AmazonOrdersRemoveDTO condition,
	    		 HttpServletResponse response){
	  		try {
		  		SXSSFWorkbook workbook = new SXSSFWorkbook();
				response.setContentType("application/force-download");// 设置强制下载不打开
				response.addHeader("Content-Disposition", "attachment;fileName=ReturnsReport.xlsx");// 设置文件名
				UserInfo userinfo = UserInfoContext.get();
				if(userinfo.isLimit(UserLimitDataType.operations)) {
					condition.setOwner(userinfo.getId());
				}
				iAmzOrderRemovesService.downloadRemoveslist(workbook,condition);
				ServletOutputStream fOut = response.getOutputStream();
				workbook.write(fOut);
				workbook.close();
				fOut.flush();
				fOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	  	
}


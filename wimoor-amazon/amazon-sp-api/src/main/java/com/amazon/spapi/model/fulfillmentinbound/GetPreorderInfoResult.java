/*
 * Selling Partner API for Fulfillment Inbound
 * The Selling Partner API for Fulfillment Inbound lets you create applications that create and update inbound shipments of inventory to Amazon's fulfillment network.
 *
 * OpenAPI spec version: v0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.amazon.spapi.model.fulfillmentinbound;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetPreorderInfoResult
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-12-21T11:58:54.268+08:00")
public class GetPreorderInfoResult {
  @SerializedName("ShipmentContainsPreorderableItems")
  private Boolean shipmentContainsPreorderableItems = null;

  @SerializedName("ShipmentConfirmedForPreorder")
  private Boolean shipmentConfirmedForPreorder = null;

  @SerializedName("NeedByDate")
  private String needByDate = null;

  @SerializedName("ConfirmedFulfillableDate")
  private String confirmedFulfillableDate = null;

  public GetPreorderInfoResult shipmentContainsPreorderableItems(Boolean shipmentContainsPreorderableItems) {
    this.shipmentContainsPreorderableItems = shipmentContainsPreorderableItems;
    return this;
  }

   /**
   * Indicates whether the shipment contains items that have been enabled for pre-order. For more information about enabling items for pre-order, see the Seller Central Help.
   * @return shipmentContainsPreorderableItems
  **/
  @ApiModelProperty(value = "Indicates whether the shipment contains items that have been enabled for pre-order. For more information about enabling items for pre-order, see the Seller Central Help.")
  public Boolean isShipmentContainsPreorderableItems() {
    return shipmentContainsPreorderableItems;
  }

  public void setShipmentContainsPreorderableItems(Boolean shipmentContainsPreorderableItems) {
    this.shipmentContainsPreorderableItems = shipmentContainsPreorderableItems;
  }

  public GetPreorderInfoResult shipmentConfirmedForPreorder(Boolean shipmentConfirmedForPreorder) {
    this.shipmentConfirmedForPreorder = shipmentConfirmedForPreorder;
    return this;
  }

   /**
   * Indicates whether this shipment has been confirmed for pre-order.
   * @return shipmentConfirmedForPreorder
  **/
  @ApiModelProperty(value = "Indicates whether this shipment has been confirmed for pre-order.")
  public Boolean isShipmentConfirmedForPreorder() {
    return shipmentConfirmedForPreorder;
  }

  public void setShipmentConfirmedForPreorder(Boolean shipmentConfirmedForPreorder) {
    this.shipmentConfirmedForPreorder = shipmentConfirmedForPreorder;
  }

  public GetPreorderInfoResult needByDate(String needByDate) {
    this.needByDate = needByDate;
    return this;
  }

   /**
   * Date that the shipment would need to arrive at an Amazon fulfillment center to avoid delivery promise breaks for pre-ordered items if this shipment is later confirmed for pre-order. In YYYY-MM-DD format. See also the confirmPreorder operation.
   * @return needByDate
  **/
  @ApiModelProperty(value = "Date that the shipment would need to arrive at an Amazon fulfillment center to avoid delivery promise breaks for pre-ordered items if this shipment is later confirmed for pre-order. In YYYY-MM-DD format. See also the confirmPreorder operation.")
  public String getNeedByDate() {
    return needByDate;
  }

  public void setNeedByDate(String needByDate) {
    this.needByDate = needByDate;
  }

  public GetPreorderInfoResult confirmedFulfillableDate(String confirmedFulfillableDate) {
    this.confirmedFulfillableDate = confirmedFulfillableDate;
    return this;
  }

   /**
   * Date in YYYY-MM-DD format that determines which pre-order items in the shipment are eligible for pre-order. If this shipment is confirmed for pre-order with a subsequent call to the confirmPreorder operation, the pre-order Buy Box will appear for any pre-order items in the shipment with a release date on or after this date. Call the getShipmentItems operation to get the release dates for the pre-order items in this shipment.
   * @return confirmedFulfillableDate
  **/
  @ApiModelProperty(value = "Date in YYYY-MM-DD format that determines which pre-order items in the shipment are eligible for pre-order. If this shipment is confirmed for pre-order with a subsequent call to the confirmPreorder operation, the pre-order Buy Box will appear for any pre-order items in the shipment with a release date on or after this date. Call the getShipmentItems operation to get the release dates for the pre-order items in this shipment.")
  public String getConfirmedFulfillableDate() {
    return confirmedFulfillableDate;
  }

  public void setConfirmedFulfillableDate(String confirmedFulfillableDate) {
    this.confirmedFulfillableDate = confirmedFulfillableDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPreorderInfoResult getPreorderInfoResult = (GetPreorderInfoResult) o;
    return Objects.equals(this.shipmentContainsPreorderableItems, getPreorderInfoResult.shipmentContainsPreorderableItems) &&
        Objects.equals(this.shipmentConfirmedForPreorder, getPreorderInfoResult.shipmentConfirmedForPreorder) &&
        Objects.equals(this.needByDate, getPreorderInfoResult.needByDate) &&
        Objects.equals(this.confirmedFulfillableDate, getPreorderInfoResult.confirmedFulfillableDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shipmentContainsPreorderableItems, shipmentConfirmedForPreorder, needByDate, confirmedFulfillableDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPreorderInfoResult {\n");
    
    sb.append("    shipmentContainsPreorderableItems: ").append(toIndentedString(shipmentContainsPreorderableItems)).append("\n");
    sb.append("    shipmentConfirmedForPreorder: ").append(toIndentedString(shipmentConfirmedForPreorder)).append("\n");
    sb.append("    needByDate: ").append(toIndentedString(needByDate)).append("\n");
    sb.append("    confirmedFulfillableDate: ").append(toIndentedString(confirmedFulfillableDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}


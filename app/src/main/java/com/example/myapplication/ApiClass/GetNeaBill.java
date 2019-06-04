package com.example.myapplication.ApiClass;

import java.util.ArrayList;

public class GetNeaBill {

    private  String Code;

    private  String Message;

    private String CustomerName;

    private  String Office;

    private String TotalDueAmount;

    private ArrayList<BillDetail> BillDetail;

    private String UserName;

    private String Password;

    private  String SCNo;

    private  String OfficeCode;

    private  String ConsumerId;

    public GetNeaBill(String userName, String password, String SCNo, String officeCode, String consumerId) {
        UserName = userName;
        Password = password;
        this.SCNo = SCNo;
        OfficeCode = officeCode;
        ConsumerId = consumerId;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getOffice() {
        return Office;
    }

    public void setOffice(String office) {
        Office = office;
    }

    public String getTotalDueAmount() {
        return TotalDueAmount;
    }

    public void setTotalDueAmount(String totalDueAmount) {
        TotalDueAmount = totalDueAmount;
    }

    public ArrayList<com.example.myapplication.ApiClass.BillDetail> getBillDetail() {
        return BillDetail;
    }

    public void setBillDetail(ArrayList<com.example.myapplication.ApiClass.BillDetail> billDetail) {
        BillDetail = billDetail;
    }

    public String getSCNo() {
        return SCNo;
    }

    public void setSCNo(String SCNo) {
        this.SCNo = SCNo;
    }

    public String getOfficeCode() {
        return OfficeCode;
    }

    public void setOfficeCode(String officeCode) {
        OfficeCode = officeCode;
    }

    public String getConsumerId() {
        return ConsumerId;
    }

    public void setConsumerId(String consumerId) {
        ConsumerId = consumerId;
    }

    @Override
    public String toString() {
        return "GetNeaBill{" +
                "Code='" + Code + '\'' +
                ", Messga='" + Message + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", Office='" + Office + '\'' +
                ", TotalDueAmount='" + TotalDueAmount + '\'' +
                ", BillDetail=" + BillDetail +
                ", SCNo='" + SCNo + '\'' +
                ", OfficeCode='" + OfficeCode + '\'' +
                ", ConsumerId='" + ConsumerId + '\'' +
                '}';
    }
}

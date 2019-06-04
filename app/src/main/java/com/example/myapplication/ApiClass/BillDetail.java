package com.example.myapplication.ApiClass;

public class BillDetail {

    private  String BillDate;

    private String DueBillOf;

    private String BillAmount;

    private  String NoOfDays;

    private String Status;

    private String PayableAmount;

    public String getBillDate() {
        return BillDate;
    }

    public void setBillDate(String billDate) {
        BillDate = billDate;
    }

    public String getDueBillOf() {
        return DueBillOf;
    }

    public void setDueBillOf(String dueBillOf) {
        DueBillOf = dueBillOf;
    }

    public String getBillAmount() {
        return BillAmount;
    }

    public void setBillAmount(String billAmount) {
        BillAmount = billAmount;
    }

    public String getNoOfDays() {
        return NoOfDays;
    }

    public void setNoOfDays(String noOfDays) {
        NoOfDays = noOfDays;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getPayableAmount() {
        return PayableAmount;
    }

    public void setPayableAmount(String payableAmount) {
        PayableAmount = payableAmount;
    }

    @Override
    public String toString() {
        return "{" +
                "'" + BillDate + '\'' +
                ",'" + DueBillOf + '\'' +
                ",'" + BillAmount + '\'' +
                ",'" + NoOfDays + '\'' +
                ",'" + Status + '\'' +
                ",'" + PayableAmount + '\'' +
                '}';
    }
}

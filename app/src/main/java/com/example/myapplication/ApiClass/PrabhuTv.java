package com.example.myapplication.ApiClass;

public class PrabhuTv {

    private String Code;

    private String Message;

    private String CustomerId;

    private String  CustomerName;





    private String UserName;

    private String Password;

    private String CasId;

    public PrabhuTv(String userName, String password, String casId) {
        UserName = userName;
        Password = password;
        CasId = casId;

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

    public String getCasId() {
        return CasId;
    }

    public void setCasId(String casId) {
        CasId = casId;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    @Override
    public String toString() {
        return "PrabhuTv{" +
                "Code='" + Code + '\'' +
                ", Message='" + Message + '\'' +
                ", CustomerId='" + CustomerId + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", CasId='" + CasId + '\'' +
                '}';
    }
}

package com.example.myapplication.ApiClass;

public class OfficeCodes {

    private String OfficeCodes;

    private String Office;

    public String getOfficeCodes() {
        return OfficeCodes;
    }

    public void setOfficeCodes(String officeCodes) {
        OfficeCodes = officeCodes;
    }

    public String getOffice() {
        return Office;
    }

    public void setOffice(String office) {
        Office = office;
    }

    @Override
    public String toString() {
        return "OfficeCodes{" +
                "OfficeCodes='" + OfficeCodes + '\'' +
                ", Office='" + Office + '\'' +
                '}';
    }
}

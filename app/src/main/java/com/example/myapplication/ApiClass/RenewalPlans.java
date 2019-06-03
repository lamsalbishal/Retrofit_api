package com.example.myapplication.ApiClass;

public class RenewalPlans {

    private String PlanId;

    private String PlanName;

    private String PlanAmount;

    public String getPlanId() {
        return PlanId;
    }

    public void setPlanId(String planId) {
        PlanId = planId;
    }

    public String getPlanName() {
        return PlanName;
    }

    public void setPlanName(String planName) {
        PlanName = planName;
    }

    public String getPlanAmount() {
        return PlanAmount;
    }

    public void setPlanAmount(String planAmount) {
        PlanAmount = planAmount;
    }

    @Override
    public String toString() {
        return "RenewalPlans{" +
                "PlanId='" + PlanId + '\'' +
                ", PlanName='" + PlanName + '\'' +
                ", PlanAmount='" + PlanAmount + '\'' +
                '}';
    }
}

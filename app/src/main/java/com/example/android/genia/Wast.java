package com.example.android.genia;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Marhuz on 27.09.2017.
 */

public class Wast {
    private int salary;
    private int saveMoney;
    private int municipalServices;
    private SmsListener smsListener = new SmsListener();

    public Wast(int salary, int saveMoney, int municipalServices) {
        this.salary = salary;
        this.saveMoney = saveMoney;
        this.municipalServices = municipalServices;
    }

    //Вычесляем рекомендуемые траты в день.
    public int recommendedWastADay() {
        Calendar calendar = GregorianCalendar.getInstance();
        int daysOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int sumRecommendedWastADay = ((salary - saveMoney) - municipalServices) / daysOfMonth;
        return sumRecommendedWastADay;
    }

    public int recommendedWastAWeek() {
        int sumRecommendedWastAWeek = recommendedWastADay() * 7;
        return sumRecommendedWastAWeek;

    }
    public int actualWastADay(){
        return recommendedWastADay() - smsListener.getExpenses();
    }

    public int actualWastAWeek(){
        return recommendedWastAWeek() - smsListener.getExpenses();
    }


    public int getSalary() {
        return salary;
    }

    public int getSaveMoney() {
        return saveMoney;
    }

    public int getMunicipalServices() {
        return municipalServices;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSaveMoney(int saveMoney) {
        this.saveMoney = saveMoney;
    }

    public void setMunicipalServices(int municipalServices) {
        this.municipalServices = municipalServices;
    }
}

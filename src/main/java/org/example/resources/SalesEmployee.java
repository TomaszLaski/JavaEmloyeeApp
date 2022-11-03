package org.example.resources;

import com.fasterxml.jackson.annotation.JsonCreator;

public class SalesEmployee extends Employee{


    private int employee_id_fk;
    private float comissionRate;

    public int getEmployee_id_fk() {
        return employee_id_fk;
    }

    public void setEmployee_id_fk(int employee_id_fk) {
        this.employee_id_fk = employee_id_fk;
    }

    private int totalSales;

    public float getComissionRate() {
        return comissionRate;
    }

    public void setComissionRate(float comissionRate) {
        this.comissionRate = comissionRate;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    public SalesEmployee(String name, String address, String nationalInsuranceNo, String bankAccountIBANorBic, int startingSalary, int employeeNumber, float comissionRate) {
        super(name, address, nationalInsuranceNo, bankAccountIBANorBic, startingSalary, employeeNumber);
        this.comissionRate = comissionRate;
    }

    @JsonCreator
    public SalesEmployee(String name, String address, String nationalInsuranceNo, String bankAccountIBANorBic, int startingSalary, int employeeNumber, float comissionRate, int totalSales) {
        this(name, address, nationalInsuranceNo, bankAccountIBANorBic, startingSalary, employeeNumber, comissionRate);
        this.totalSales = totalSales;
    }


}

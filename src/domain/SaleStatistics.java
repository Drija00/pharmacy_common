/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Andrija - PC
 */
public class SaleStatistics extends AbstractDO implements Serializable{
    private Medicine medicine;
    private Pharmacist pharmacist;
    private int number_of_sales;
    private double earnings;

    public SaleStatistics() {
    }

    public SaleStatistics(Medicine medicine, Pharmacist pharmacist, int number_of_sales, double earnings) {
        this.medicine = medicine;
        this.pharmacist = pharmacist;
        this.number_of_sales = number_of_sales;
        this.earnings = earnings;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    

    public int getNumber_of_sales() {
        return number_of_sales;
    }

    public void setNumber_of_sales(int number_of_sales) {
        this.number_of_sales = number_of_sales;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.medicine);
        hash = 89 * hash + Objects.hashCode(this.pharmacist);
        hash = 89 * hash + this.number_of_sales;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.earnings) ^ (Double.doubleToLongBits(this.earnings) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SaleStatistics other = (SaleStatistics) obj;
        if (this.number_of_sales != other.number_of_sales) {
            return false;
        }
        if (Double.doubleToLongBits(this.earnings) != Double.doubleToLongBits(other.earnings)) {
            return false;
        }
        if (!Objects.equals(this.medicine, other.medicine)) {
            return false;
        }
        return Objects.equals(this.pharmacist, other.pharmacist);
    }

    @Override
    public String toString() {
        return "SaleStatistics{" + "medicine=" + medicine + ", pharmacist=" + pharmacist + ", number_of_sales=" + number_of_sales + ", earnings=" + earnings + '}';
    }

    @Override
    public String getAttributeList() {
        return "id_pharmacist,JKL_medicine,number_of_sales,earnings";
    }

    @Override
    public String getClassName() {
        return "sale_statistics";
    }

    @Override
    public String getAttributeValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(pharmacist.getId()).append(",").append(medicine.getJKL()).append(",").append(number_of_sales)
                .append(",").append(earnings);
        return sb.toString();
    }

    @Override
    public String getQueryCondition() {
        return "id_pharmacist="+getPharmacist().getId()+" AND JKL_medicine="+getMedicine().getJKL();
    }

    @Override
    public int getNumberOfBountObject() {
        return 0;
    }

    @Override
    public Object getBoundObject(int numberOfObjects, int numberOfAttributesBoundObjects) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getNumberOfAttributesBoundObjects() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String setAttributeValues() {
        return "id_pharmacist="+getPharmacist().getId()+","
                +"JKL_medicine="+getMedicine().getJKL()+","+
                "number_of_sales="+getNumber_of_sales()+","+
                "earnings="+getEarnings();
    }

    @Override
    public void setForeignId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AbstractDO getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        Pharmacist p = new Pharmacist(resultSet.getLong("s.id_pharmacist"), resultSet.getString("p.name"), resultSet.getString("p.lastname"), resultSet.getString("p.username"), resultSet.getString("p.password"),resultSet.getBoolean("p.logged"));
        Medicine m = new Medicine(resultSet.getLong("s.JKL_medicine"), resultSet.getString("m.ATC"), resultSet.getString("m.INN"), resultSet.getString("m.zasticeno_ime"), resultSet.getString("m.FO"), resultSet.getString("m.pakovanje_jacina"), resultSet.getString("m.naziv_proizvodjaca"), resultSet.getString("m.drzava_proizvodnje"), resultSet.getDouble("m.cena_leka_na_veliko_za_pakovanje"), resultSet.getInt("m.DDD"), resultSet.getDouble("m.cena_leka_na_veliko_po_DDD"), resultSet.getDouble("m.participacija_osiguranog_lica"), resultSet.getInt("m.quantity"));
        return new SaleStatistics(m, p, resultSet.getInt("s.number_of_sales"), resultSet.getDouble("s.earnings"));
    }

    @Override
    public String getStatementSelectAllQuery() {
        return "SELECT s.id_pharmacist,p.name,p.lastname,p.username,p.password,p.logged,s.JKL_medicine,"
                + "s.number_of_sales,s.earnings,m.ATC,m.INN,m.zasticeno_ime,m.FO,m.pakovanje_jacina,"
                + "m.naziv_proizvodjaca,m.drzava_proizvodnje,m.cena_leka_na_veliko_za_pakovanje,m.DDD,"
                + "m.cena_leka_na_veliko_po_DDD,m.participacija_osiguranog_lica,m.quantity "
                + "FROM sale_statistics AS s INNER JOIN pharmacist AS p ON s.id_pharmacist=p.id "
                + "INNER JOIN medicine AS m ON s.JKL_medicine=m.JKL";
    }

    @Override
    public String getBoundType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getBoundQueryCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ItemUpdateAction getAction() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
}

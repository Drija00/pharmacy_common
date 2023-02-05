/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Andrija - PC
 */
public class ReceiptItem extends AbstractDO implements Serializable{
    private Receipt receipt;
    private Long id_item;
    private Long orderNumber;
    private int amount;
    private double price;
    private Medicine medicine;
    private ItemUpdateAction action;

    public ReceiptItem() {
    }

    public ReceiptItem(Receipt receipt,Long id_item, Long orderNumber, int amount, double price, Medicine medicine) {
        this.receipt = receipt;
        this.id_item=id_item;
        this.orderNumber = orderNumber;
        this.amount = amount;
        this.price = price;
        this.medicine = medicine;
        this.action = null;
    }
    
    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Long getId_item() {
        return id_item;
    }

    public void setId_item(Long id_item) {
        this.id_item = id_item;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.receipt);
        hash = 47 * hash + Objects.hashCode(this.orderNumber);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.medicine);
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
        final ReceiptItem other = (ReceiptItem) obj;
        if (this.amount != other.amount) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.receipt, other.receipt)) {
            return false;
        }
        if (!Objects.equals(this.id_item, other.id_item)) {
            return false;
        }
        if (!Objects.equals(this.orderNumber, other.orderNumber)) {
            return false;
        }
        return Objects.equals(this.medicine, other.medicine);
    }

    @Override
    public String toString() {
        return "ReceiptItem{" + "receipt=" + receipt + ", id_item=" + id_item + ", orderNumber=" + orderNumber + ", amount=" + amount + ", price=" + price + ", medicine=" + medicine + ", action=" + action + '}';
    }

    @Override
    public String getAttributeList() {
        return "id_receipt,id_item,order_number,quantity,price,JKL_medicine";
    }

    @Override
    public String getClassName() {
        return "receipt_item";
    }

    @Override
    public String getAttributeValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(getReceipt().getId()).append(",").append(getId_item()).append(",").append(getOrderNumber()).append(",").append(getAmount())
                .append(",").append(getPrice()).append(",").append(getMedicine().getJKL());
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getQueryCondition() {
        return "id_receipt="+getReceipt().getId()+" AND "+"id_item="+getId_item();
    }

    @Override
    public int getNumberOfBountObject() {
        return 1;
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
        return  "order_number="+getOrderNumber()+","+
                "quantity="+getAmount()+","+
                "price="+getPrice()+","+
                "JKL_medicine="+getMedicine().getJKL();
    }

    @Override
    public void setForeignId(Long id) {
        getReceipt().setId(id);
    }

    @Override
    public AbstractDO getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        Medicine m = new Medicine(resultSet.getLong("r.JKL_medicine"), resultSet.getString("m.ATC"), resultSet.getString("m.INN"), resultSet.getString("m.zasticeno_ime"), resultSet.getString("m.FO"), resultSet.getString("m.pakovanje_jacina"), resultSet.getString("m.naziv_proizvodjaca"), resultSet.getString("m.drzava_proizvodnje"), resultSet.getDouble("m.cena_leka_na_veliko_za_pakovanje"), resultSet.getInt("m.DDD"), resultSet.getDouble("m.cena_leka_na_veliko_po_DDD"), resultSet.getDouble("m.participacija_osiguranog_lica"), resultSet.getInt("m.quantity"));
        Pharmacist ph = new Pharmacist(resultSet.getLong("re.id_pharmacist"), resultSet.getString("ph.name"), resultSet.getString("ph.lastname"), resultSet.getString("ph.username"), resultSet.getString("ph.password"),resultSet.getBoolean("ph.logged"));
        Patient pa = new Patient(resultSet.getLong("re.id_patient"), resultSet.getString("pa.name"), resultSet.getString("pa.lastname"), resultSet.getString("pa.adress"), resultSet.getInt("pa.card_number"));
        Receipt re = new Receipt(resultSet.getLong("r.id_receipt"), resultSet.getDate("re.date"), resultSet.getDouble("re.total_amount"), ph, pa,new ArrayList());
        return new ReceiptItem(re,resultSet.getLong("r.id_item"), resultSet.getLong("r.order_number"), resultSet.getInt("r.quantity"), resultSet.getDouble("r.price"), m);
    }

    @Override
    public String getStatementSelectAllQuery() {
        return "SELECT r.id_receipt,r.id_item,r.order_number,r.quantity,r.price,r.JKL_medicine,"
                + "m.ATC,m.INN,m.zasticeno_ime,m.FO,m.pakovanje_jacina,m.naziv_proizvodjaca,m.drzava_proizvodnje,"
                + "m.cena_leka_na_veliko_za_pakovanje,m.DDD,m.cena_leka_na_veliko_po_DDD,"
                + "m.participacija_osiguranog_lica,m.quantity,re.date,re.total_amount,re.id_pharmacist,"
                + "re.id_patient,ph.name,ph.lastname,ph.username,ph.password,ph.logged,pa.name,pa.lastname,pa.adress,pa.card_number "
                + "FROM receipt_item AS r INNER JOIN medicine AS m ON r.JKL_medicine=m.JKL INNER JOIN receipt AS re ON r.id_receipt=re.id "
                + "INNER JOIN pharmacist AS ph ON re.id_pharmacist=ph.id INNER JOIN patient AS pa ON re.id_patient=pa.id";
    }

    @Override
    public String getBoundType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getBoundQueryCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ItemUpdateAction getAction() {
        return action;
    }

    public void setAction(ItemUpdateAction action) {
        this.action = action;
    }
    
    
    

    
    
    
}

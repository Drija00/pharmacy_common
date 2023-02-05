/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Andrija - PC
 */
public class Receipt extends AbstractDO implements Serializable{
    private Long id;
    private Date date;
    private double total_amount;
    private Pharmacist pharmacist;
    private Patient patient;
    
    List<ReceiptItem> items;

    public Receipt() {
        items = new ArrayList<>();
        total_amount = 0;
    }

    public Receipt(Long id, Date date, double total_amount, Pharmacist pharmacist, Patient patient,List<ReceiptItem> items) {
        this.id = id;
        this.date = date;
        this.total_amount = total_amount;
        this.pharmacist = pharmacist;
        this.patient = patient;
        this.items = items;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public void setItems(List<ReceiptItem> items) {
        this.items = items;
    }
    
    public void addListItem(ReceiptItem i){
        items.add(i);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.date);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.total_amount) ^ (Double.doubleToLongBits(this.total_amount) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.pharmacist);
        hash = 83 * hash + Objects.hashCode(this.patient);
        hash = 83 * hash + Objects.hashCode(this.items);
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
        final Receipt other = (Receipt) obj;
        if (Double.doubleToLongBits(this.total_amount) != Double.doubleToLongBits(other.total_amount)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.pharmacist, other.pharmacist)) {
            return false;
        }
        if (!Objects.equals(this.patient, other.patient)) {
            return false;
        }
        return Objects.equals(this.items, other.items);
    }

    @Override
    public String toString() {
        return "Receipt{" + "id=" + id + ", date=" + date + ", total_amount=" + total_amount + ", pharmacist=" + pharmacist + ", patient=" + patient + ", items=" + items + '}';
    }

    @Override
    public String getAttributeList() {
        return "id,date,total_amount,id_pharmacist,id_patient";
    }

    @Override
    public String getClassName() {
        return "receipt";
    }

    @Override
    public String getAttributeValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(",'").append(new java.sql.Date(getDate().getTime())).append("',")
                .append(getTotal_amount()).append(",").append(getPharmacist().getId()).append(",")
                .append(getPatient().getId());
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getQueryCondition() {
        return "id="+getId();
    }

    @Override
    public int getNumberOfBountObject() {
        return getItems().size();
    }

    @Override
    public Object getBoundObject(int numberOfObjects, int numberOfAttributesBoundObjects) {
        return getItems().get(numberOfObjects);
    }

    @Override
    public int getNumberOfAttributesBoundObjects() {
        return 1;
    }

    @Override
    public String setAttributeValues() {
        return  "date='"+new java.sql.Date(getDate().getTime())+"',"+
                "total_amount="+getTotal_amount()+","+
                "id_pharmacist="+getPharmacist().getId()+","+
                "id_patient="+getPatient().getId();
    }

    @Override
    public void setForeignId(Long id) {
        setId(id);
    }

    @Override
    public AbstractDO getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        Pharmacist ph = new Pharmacist(resultSet.getLong("r.id_pharmacist"), resultSet.getString("ph.name"), resultSet.getString("ph.lastname"), resultSet.getString("ph.username"), resultSet.getString("ph.password"),resultSet.getBoolean("ph.logged"));
        Patient pa = new Patient(resultSet.getLong("r.id_patient"), resultSet.getString("pa.name"), resultSet.getString("pa.lastname"), resultSet.getString("pa.adress"), resultSet.getInt("pa.card_number"));
        return new Receipt(resultSet.getLong("r.id"), resultSet.getDate("r.date"), resultSet.getDouble("r.total_amount"), ph, pa,new ArrayList<ReceiptItem>());
    }

    @Override
    public String getStatementSelectAllQuery() {
        return "SELECT r.id,r.date,r.total_amount,r.id_pharmacist,ph.name,ph.lastname,ph.username,ph.password,ph.logged,r.id_patient,pa.name,pa.lastname,pa.adress,pa.card_number "
                + "FROM receipt AS r INNER JOIN pharmacist AS ph ON r.id_pharmacist=ph.id INNER JOIN patient AS pa ON r.id_patient=pa.id ";
    }

    @Override
    public String getBoundType() {
        return "receipt_item";
    }

    @Override
    public String getBoundQueryCondition() {
        return "id_receipt="+getId();
    }

    @Override
    public ItemUpdateAction getAction() {
        return getAction();
    }
    

    

    

    

    
    
    
}

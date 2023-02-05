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
public class Patient extends AbstractDO implements Serializable{
    private Long id;
    private String name;
    private String lastname;
    private String adress;
    private int card_number;

    public Patient() {
    }

    public Patient(Long id, String name, String lastname, String adress, int card_number) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.adress = adress;
        this.card_number = card_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getCard_number() {
        return card_number;
    }

    public void setCard_number(int cardNumber) {
        this.card_number = cardNumber;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.lastname);
        hash = 41 * hash + Objects.hashCode(this.adress);
        hash = 41 * hash + Objects.hashCode(this.card_number);
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
        final Patient other = (Patient) obj;
        return Objects.equals(this.id, other.id);
    }

    public boolean equalsWithoutID(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (this.card_number != other.card_number) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        return Objects.equals(this.adress, other.adress);
    }
    

    @Override
    public String toString() {
        return name + " "+lastname;
    }

    @Override
    public String getAttributeList() {
        return "id,name,lastname,adress,card_number";
    }

    @Override
    public String getClassName() {
        return "patient";
    }

    @Override
    public String getAttributeValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(",'").append(getName()).append("','").append(getLastname())
                .append("','").append(getAdress()).append("',").append(getCard_number());
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getQueryCondition() {
        return "id="+getId();
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
    public String setAttributeValues() {
        return "id="+getId()+","
                +"name='"+getName()+"',"+
                "lastname='"+getLastname()+"',"+
                "adress='"+getAdress()+"',"+
                "card_number="+getCard_number();
    }

    @Override
    public void setForeignId(Long id) {
        setId(id);
    }

    @Override
    public AbstractDO getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return new Patient(resultSet.getLong("id"),
                resultSet.getString("name"), 
                resultSet.getString("lastname"), 
                resultSet.getString("adress"), 
                resultSet.getInt("card_number"));
    }

    @Override
    public String getStatementSelectAllQuery() {
        return "SELECT id,name,lastname,adress,card_number FROM patient";
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

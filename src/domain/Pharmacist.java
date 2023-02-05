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
public class Pharmacist extends AbstractDO implements Serializable{
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String password;
    private boolean logged;

    public Pharmacist() {
    }

    public Pharmacist(Long id, String name, String lastname, String username, String password,boolean logged) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password= password;
        this.logged=logged;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.lastname);
        hash = 53 * hash + Objects.hashCode(this.username);
        hash = 53 * hash + Objects.hashCode(this.password);
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
        final Pharmacist other = (Pharmacist) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return name+" "+lastname;
    }

    @Override
    public String getAttributeList() {
        return "id,name,lastname,username,password,logged";
    }

    @Override
    public String getClassName() {
        return "pharmacist";
    }

    @Override
    public String getAttributeValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",'").append(name).append("','").append(lastname)
                .append("','").append(username).append("','").append(password).append("',").append(logged);
        return sb.toString();
    }

    @Override
    public String getQueryCondition() {
        return "id="+getId();
    }

    @Override
    public int getNumberOfBountObject() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
                "username='"+getUsername()+"',"+
                "password='"+getPassword()+"',"+
                "logged="+isLogged();
    }

    @Override
    public void setForeignId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AbstractDO getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return new Pharmacist(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("lastname"), resultSet.getString("username"), resultSet.getString("password"),resultSet.getBoolean("logged"));
    }

    @Override
    public String getStatementSelectAllQuery() {
        return "SELECT id,name,lastname,username,password,logged FROM pharmacist";
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

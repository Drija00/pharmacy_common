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
public class Medicine extends AbstractDO implements Serializable{
    private Long JKL;
    private String ATC;
    private String INN;
    private String zasticeno_ime;
    private String FO;
    private String pakovanja_jacina;
    private String naziv_proizvodjaca;
    private String drzavva_proizvodnje;
    private double cena_leka_na_veliko_za_pakovanje;
    private int DDD;
    private double cena_leka_na_veliko_po_DDD;
    private double participacija_osiguranog_lica;
    private int quantity;

    public Medicine() {
    }

    public Medicine(Long JKL, String ATC, String INN, String zasticeno_ime, String FO, String pakovanja_jacina, String naziv_proizvodjaca, String drzavva_proizvodnje, double cena_leka_na_veliko_za_pakovanje, int DDD, double cena_leka_na_veliko_po_DDD, double participacija_osiguranog_lica, int quantity) {
        this.JKL = JKL;
        this.ATC = ATC;
        this.INN = INN;
        this.zasticeno_ime = zasticeno_ime;
        this.FO = FO;
        this.pakovanja_jacina = pakovanja_jacina;
        this.naziv_proizvodjaca = naziv_proizvodjaca;
        this.drzavva_proizvodnje = drzavva_proizvodnje;
        this.cena_leka_na_veliko_za_pakovanje = cena_leka_na_veliko_za_pakovanje;
        this.DDD = DDD;
        this.cena_leka_na_veliko_po_DDD = cena_leka_na_veliko_po_DDD;
        this.participacija_osiguranog_lica = participacija_osiguranog_lica;
        this.quantity = quantity;
    }


    public Long getJKL() {
        return JKL;
    }

    public void setJKL(Long JKL) {
        this.JKL = JKL;
    }

    public String getATC() {
        return ATC;
    }

    public void setATC(String ATC) {
        this.ATC = ATC;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getZasticeno_ime() {
        return zasticeno_ime;
    }

    public void setZasticeno_ime(String zasticeno_ime) {
        this.zasticeno_ime = zasticeno_ime;
    }

    public String getFO() {
        return FO;
    }

    public void setFO(String FO) {
        this.FO = FO;
    }

    public String getPakovanja_jacina() {
        return pakovanja_jacina;
    }

    public void setPakovanja_jacina(String pakovanja_jacina) {
        this.pakovanja_jacina = pakovanja_jacina;
    }

    public String getNaziv_proizvodjaca() {
        return naziv_proizvodjaca;
    }

    public void setNaziv_proizvodjaca(String naziv_proizvodjaca) {
        this.naziv_proizvodjaca = naziv_proizvodjaca;
    }

    public String getDrzavva_proizvodnje() {
        return drzavva_proizvodnje;
    }

    public void setDrzavva_proizvodnje(String drzavva_proizvodnje) {
        this.drzavva_proizvodnje = drzavva_proizvodnje;
    }

    public double getCena_leka_na_veliko_za_pakovanje() {
        return cena_leka_na_veliko_za_pakovanje;
    }

    public void setCena_leka_na_veliko_za_pakovanje(double cena_leka_na_veliko_za_pakovanje) {
        this.cena_leka_na_veliko_za_pakovanje = cena_leka_na_veliko_za_pakovanje;
    }

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    public double getCena_leka_na_veliko_po_DDD() {
        return cena_leka_na_veliko_po_DDD;
    }

    public void setCena_leka_na_veliko_po_DDD(double cena_leka_na_veliko_po_DDD) {
        this.cena_leka_na_veliko_po_DDD = cena_leka_na_veliko_po_DDD;
    }

    public double getParticipacija_osiguranog_lica() {
        return participacija_osiguranog_lica;
    }

    public void setParticipacija_osiguranog_lica(double participacija_osiguranog_lica) {
        this.participacija_osiguranog_lica = participacija_osiguranog_lica;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.JKL);
        hash = 83 * hash + Objects.hashCode(this.ATC);
        hash = 83 * hash + Objects.hashCode(this.INN);
        hash = 83 * hash + Objects.hashCode(this.zasticeno_ime);
        hash = 83 * hash + Objects.hashCode(this.FO);
        hash = 83 * hash + Objects.hashCode(this.pakovanja_jacina);
        hash = 83 * hash + Objects.hashCode(this.naziv_proizvodjaca);
        hash = 83 * hash + Objects.hashCode(this.drzavva_proizvodnje);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.cena_leka_na_veliko_za_pakovanje) ^ (Double.doubleToLongBits(this.cena_leka_na_veliko_za_pakovanje) >>> 32));
        hash = 83 * hash + this.DDD;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.cena_leka_na_veliko_po_DDD) ^ (Double.doubleToLongBits(this.cena_leka_na_veliko_po_DDD) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.participacija_osiguranog_lica) ^ (Double.doubleToLongBits(this.participacija_osiguranog_lica) >>> 32));
        hash = 83 * hash + this.quantity;
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
        final Medicine other = (Medicine) obj;
        if (Double.doubleToLongBits(this.cena_leka_na_veliko_za_pakovanje) != Double.doubleToLongBits(other.cena_leka_na_veliko_za_pakovanje)) {
            return false;
        }
        if (this.DDD != other.DDD) {
            return false;
        }
        if (Double.doubleToLongBits(this.cena_leka_na_veliko_po_DDD) != Double.doubleToLongBits(other.cena_leka_na_veliko_po_DDD)) {
            return false;
        }
        if (Double.doubleToLongBits(this.participacija_osiguranog_lica) != Double.doubleToLongBits(other.participacija_osiguranog_lica)) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.ATC, other.ATC)) {
            return false;
        }
        if (!Objects.equals(this.INN, other.INN)) {
            return false;
        }
        if (!Objects.equals(this.zasticeno_ime, other.zasticeno_ime)) {
            return false;
        }
        if (!Objects.equals(this.FO, other.FO)) {
            return false;
        }
        if (!Objects.equals(this.pakovanja_jacina, other.pakovanja_jacina)) {
            return false;
        }
        if (!Objects.equals(this.naziv_proizvodjaca, other.naziv_proizvodjaca)) {
            return false;
        }
        if (!Objects.equals(this.drzavva_proizvodnje, other.drzavva_proizvodnje)) {
            return false;
        }
        return Objects.equals(this.JKL, other.JKL);
    }

    @Override
    public String toString() {
        return zasticeno_ime;
    }

    @Override
    public String getAttributeList() {
        return "JKL,ATC,INN,zasticeno_ime,FO,pakovanje_jacina,naziv_proizvodjaca,"
                + "drzava_proizvodnje,cena_leka_na_veliko_za_pakovanje,DDD,cena_leka_na_veliko_po_DDD,"
                + "participacija_osiguranog_lica,quantity";
    }

    @Override
    public String getClassName() {
        return "medicine";
    }

    @Override
    public String getAttributeValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(JKL).append(",'").append(ATC).append("','").append(INN)
                .append("','").append(zasticeno_ime).append("','").append(FO)
                .append("','").append(pakovanja_jacina).append("','").append(naziv_proizvodjaca).append("','")
                .append(drzavva_proizvodnje).append("',").append(cena_leka_na_veliko_za_pakovanje).append(",").append(DDD)
                .append(",")
                .append(cena_leka_na_veliko_po_DDD).append(",").append(participacija_osiguranog_lica).append(",").append(quantity);
        return sb.toString();
    }

    @Override
    public String getQueryCondition() {
        return "JKL="+getJKL();
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
        
    }

    @Override
    public Long getId() {
        return getJKL();
    }

    @Override
    public String setAttributeValues() {
        return "JKL="+getJKL()+","
                +"ATC='"+getATC()+"',"+
                "INN='"+getINN()+"',"+
                "zasticeno_ime='"+getZasticeno_ime()+"',"+
                "FO='"+getFO()+"',"+
                "pakovanje_jacina='"+getPakovanja_jacina()+"',"
                +"naziv_proizvodjaca='"+getNaziv_proizvodjaca()+"',"+
                "drzava_proizvodnje='"+getDrzavva_proizvodnje()+"',"+
                "cena_leka_na_veliko_za_pakovanje="+getCena_leka_na_veliko_za_pakovanje()+","+
                "DDD="+getDDD()+","+
                "cena_leka_na_veliko_po_DDD="+getCena_leka_na_veliko_po_DDD()+","
                +"participacija_osiguranog_lica="+getParticipacija_osiguranog_lica()+","+
                "quantity="+getQuantity();
    }

    @Override
    public void setForeignId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AbstractDO getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return new Medicine(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), 
                resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                resultSet.getString(7), resultSet.getString(8), 
                resultSet.getDouble(9), resultSet.getInt(10), resultSet.getDouble(11), resultSet.getDouble(12), resultSet.getInt(13));
    }

    @Override
    public String getStatementSelectAllQuery() {
        return "SELECT JKL,ATC,INN,zasticeno_ime,FO,pakovanje_jacina,naziv_proizvodjaca,"
                +"drzava_proizvodnje,cena_leka_na_veliko_za_pakovanje,DDD,cena_leka_na_veliko_po_DDD,"
                + "participacija_osiguranog_lica,quantity FROM medicine";
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

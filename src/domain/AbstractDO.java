package domain;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jeks
 */
public abstract class AbstractDO {
    
    public abstract String getAttributeList();
    public abstract String getClassName();
    public abstract String getAttributeValues();
    public abstract String getQueryCondition();
    public abstract String getBoundQueryCondition();
    //vrati broj vezanih objekata
    public abstract int getNumberOfBountObject();
    //vrati slog vezanog objekta
    public abstract Object getBoundObject(int numberOfObjects, int numberOfAttributesBoundObjects);
    //vrati broj slogova vezanog objekta
    public abstract int getNumberOfAttributesBoundObjects();
    
    public abstract String getBoundType();
    
    public abstract void setId(Long id);
    
    public abstract Long getId();
    
    public abstract String setAttributeValues();
    
    public abstract void setForeignId(Long id);
    
    public abstract AbstractDO getEntityFromResultSet(ResultSet resultSet) throws SQLException;
    
    public abstract String getStatementSelectAllQuery();
    
    public abstract ItemUpdateAction getAction();
}

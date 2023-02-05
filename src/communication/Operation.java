/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Cartman
 */
public enum Operation  implements Serializable{
    LOGIN,
    GET_ALL_PATIENTS,
    GET_ALL_MEDICINES,
    REMOVE_PATIENT,
    REMOVE_MEDICINE,
    ADD_PATIENT,
    ADD_MEDICINE,
    EDIT_PATIENT,
    EDIT_MEDICINE,
    GET_ALL_SUBSTANCES,
    ADD_RECEIPT,
    REMOVE_RECEIPT,
    EDIT_RECEIPT,
    GET_RECEIPT,
    GET_ALL_RECEIPTS,
    GET_ALL_RECEIPT_ITEMS,
    GET_ALL_SALE_STATISTICS,
    ADD_SALE_STATISTIC,
    EDIT_SALE_STATISTIC,
    LOG_OUT,
    GET_ALL_MEDICINES_BY_QUERY,
    GET_ALL_PATIENTS_BY_QUERY,
    REFRESH_MEDS;
}

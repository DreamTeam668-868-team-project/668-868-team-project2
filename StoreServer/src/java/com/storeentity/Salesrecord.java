/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storeentity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Travis
 */
@Entity
@Table(name = "SALESRECORD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salesrecord.findAll", query = "SELECT s FROM Salesrecord s")
    , @NamedQuery(name = "Salesrecord.findById", query = "SELECT s FROM Salesrecord s WHERE s.id = :id")
    , @NamedQuery(name = "Salesrecord.findByTransactiondate", query = "SELECT s FROM Salesrecord s WHERE s.transactiondate = :transactiondate")
    , @NamedQuery(name = "Salesrecord.findByTransactiontime", query = "SELECT s FROM Salesrecord s WHERE s.transactiontime = :transactiontime")
    , @NamedQuery(name = "Salesrecord.findByCustomername", query = "SELECT s FROM Salesrecord s WHERE s.customername = :customername")
    , @NamedQuery(name = "Salesrecord.findByTransactionrecord", query = "SELECT s FROM Salesrecord s WHERE s.transactionrecord = :transactionrecord")
    , @NamedQuery(name = "Salesrecord.findByPaymenttype", query = "SELECT s FROM Salesrecord s WHERE s.paymenttype = :paymenttype")
    , @NamedQuery(name = "Salesrecord.findByPaymenttotal", query = "SELECT s FROM Salesrecord s WHERE s.paymenttotal = :paymenttotal")
    , @NamedQuery(name = "Salesrecord.findByPaymentamount", query = "SELECT s FROM Salesrecord s WHERE s.paymentamount = :paymentamount")
    , @NamedQuery(name = "Salesrecord.findByPaymentchange", query = "SELECT s FROM Salesrecord s WHERE s.paymentchange = :paymentchange")
    , @NamedQuery(name = "Salesrecord.findByPaymentccnumber", query = "SELECT s FROM Salesrecord s WHERE s.paymentccnumber = :paymentccnumber")})
public class Salesrecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TRANSACTIONDATE")
    @Temporal(TemporalType.DATE)
    private Date transactiondate;
    @Column(name = "TRANSACTIONTIME")
    @Temporal(TemporalType.TIME)
    private Date transactiontime;
    @Size(max = 50)
    @Column(name = "CUSTOMERNAME")
    private String customername;
    @Size(max = 255)
    @Column(name = "TRANSACTIONRECORD")
    private String transactionrecord;
    @Size(max = 6)
    @Column(name = "PAYMENTTYPE")
    private String paymenttype;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PAYMENTTOTAL")
    private Float paymenttotal;
    @Column(name = "PAYMENTAMOUNT")
    private Float paymentamount;
    @Column(name = "PAYMENTCHANGE")
    private Float paymentchange;
    @Size(max = 5)
    @Column(name = "PAYMENTCCNUMBER")
    private String paymentccnumber;

    public Salesrecord() {
    }

    public Salesrecord(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(Date transactiondate) {
        this.transactiondate = transactiondate;
    }

    public Date getTransactiontime() {
        return transactiontime;
    }

    public void setTransactiontime(Date transactiontime) {
        this.transactiontime = transactiontime;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getTransactionrecord() {
        return transactionrecord;
    }

    public void setTransactionrecord(String transactionrecord) {
        this.transactionrecord = transactionrecord;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public Float getPaymenttotal() {
        return paymenttotal;
    }

    public void setPaymenttotal(Float paymenttotal) {
        this.paymenttotal = paymenttotal;
    }

    public Float getPaymentamount() {
        return paymentamount;
    }

    public void setPaymentamount(Float paymentamount) {
        this.paymentamount = paymentamount;
    }

    public Float getPaymentchange() {
        return paymentchange;
    }

    public void setPaymentchange(Float paymentchange) {
        this.paymentchange = paymentchange;
    }

    public String getPaymentccnumber() {
        return paymentccnumber;
    }

    public void setPaymentccnumber(String paymentccnumber) {
        this.paymentccnumber = paymentccnumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salesrecord)) {
            return false;
        }
        Salesrecord other = (Salesrecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.storeentity.Salesrecord[ id=" + id + " ]";
    }
    
}

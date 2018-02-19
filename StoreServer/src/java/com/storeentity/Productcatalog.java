/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storeentity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Travis
 */
@Entity
@Table(name = "PRODUCTCATALOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productcatalog.findAll", query = "SELECT p FROM Productcatalog p")
    , @NamedQuery(name = "Productcatalog.findByUpc", query = "SELECT p FROM Productcatalog p WHERE p.upc = :upc")
    , @NamedQuery(name = "Productcatalog.findByDescription", query = "SELECT p FROM Productcatalog p WHERE p.description = :description")
    , @NamedQuery(name = "Productcatalog.findByPrice", query = "SELECT p FROM Productcatalog p WHERE p.price = :price")})
public class Productcatalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "UPC")
    private String upc;
    @Size(max = 20)
    @Column(name = "DESCRIPTION")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Float price;

    public Productcatalog() {
    }

    public Productcatalog(String upc) {
        this.upc = upc;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (upc != null ? upc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productcatalog)) {
            return false;
        }
        Productcatalog other = (Productcatalog) object;
        if ((this.upc == null && other.upc != null) || (this.upc != null && !this.upc.equals(other.upc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.storeentity.Productcatalog[ upc=" + upc + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.ea1.model;

import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexe
 */
public class ProductModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private String productName;
    
    public ProductModel() {
    }

    public ProductModel(Integer id) {
        this.id = id;
    }

    public ProductModel(Integer id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
        if (!(object instanceof ProductModel)) {
            return false;
        }
        ProductModel other = (ProductModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.tyaa.ea1.entity.ProductModel[ id=" + id + " ]";
    }
    
}

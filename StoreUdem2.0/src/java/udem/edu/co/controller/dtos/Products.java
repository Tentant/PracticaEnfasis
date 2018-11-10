/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udem.edu.co.controller.dtos;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;


/**
 *
 * @author juliandrestrepom
 */

public class Products implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idproducts;

    private String name;

    private String brand;
    
    private Date dateBuy;

    private double cost;

    private double price;

    private String description;
    @Basic(optional = false)

    private short uso;

    public Products() {
    }

    public Products(Integer idproducts) {
        this.idproducts = idproducts;
    }

    public Products(Integer idproducts, String name, String brand, Date dateBuy, double cost, double price, short uso) {
        this.idproducts = idproducts;
        this.name = name;
        this.brand = brand;
        this.dateBuy = dateBuy;
        this.cost = cost;
        this.price = price;
        this.uso = uso;
    }

    public Integer getIdproducts() {
        return idproducts;
    }

    public void setIdproducts(Integer idproducts) {
        this.idproducts = idproducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(Date dateBuy) {
        this.dateBuy = dateBuy;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getUso() {
        return uso;
    }

    public void setUso(short uso) {
        this.uso = uso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducts != null ? idproducts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.idproducts == null && other.idproducts != null) || (this.idproducts != null && !this.idproducts.equals(other.idproducts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "udem.edu.co.entities.Products[ idproducts=" + idproducts + " ]";
    }
    
}

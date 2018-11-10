/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udem.edu.co.controller.dtos;


import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author juliandrestrepom
 */

public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idequipment;

    private String brand;

    private String status;

    private Date dateBuy;

    private String name;

    private String description;

    public Equipment() {
    }

    public Equipment(Integer idequipment) {
        this.idequipment = idequipment;
    }

    public Equipment(Integer idequipment, String brand, String status, Date dateBuy, String name, String description) {
        this.idequipment = idequipment;
        this.brand = brand;
        this.status = status;
        this.dateBuy = dateBuy;
        this.name = name;
        this.description = description;
    }

    public Integer getIdequipment() {
        return idequipment;
    }

    public void setIdequipment(Integer idequipment) {
        this.idequipment = idequipment;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(Date dateBuy) {
        this.dateBuy = dateBuy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idequipment != null ? idequipment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipment)) {
            return false;
        }
        Equipment other = (Equipment) object;
        if ((this.idequipment == null && other.idequipment != null) || (this.idequipment != null && !this.idequipment.equals(other.idequipment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "udem.edu.co.entities.Equipment[ idequipment=" + idequipment + " ]";
    }
    
}

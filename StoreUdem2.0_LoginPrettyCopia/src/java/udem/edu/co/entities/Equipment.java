/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udem.edu.co.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juliandrestrepom
 */
@Entity
@Table(name = "equipment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipment.findAll", query = "SELECT e FROM Equipment e")
    , @NamedQuery(name = "Equipment.findByIdequipment", query = "SELECT e FROM Equipment e WHERE e.idequipment = :idequipment")
    , @NamedQuery(name = "Equipment.findByBrand", query = "SELECT e FROM Equipment e WHERE e.brand = :brand")
    , @NamedQuery(name = "Equipment.findByStatus", query = "SELECT e FROM Equipment e WHERE e.status = :status")
    , @NamedQuery(name = "Equipment.findByDateBuy", query = "SELECT e FROM Equipment e WHERE e.dateBuy = :dateBuy")
    , @NamedQuery(name = "Equipment.findByName", query = "SELECT e FROM Equipment e WHERE e.name = :name")
    , @NamedQuery(name = "Equipment.findByDescription", query = "SELECT e FROM Equipment e WHERE e.description = :description")})
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idequipment")
    private Integer idequipment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "brand")
    private String brand;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateBuy")
    @Temporal(TemporalType.DATE)
    private Date dateBuy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
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

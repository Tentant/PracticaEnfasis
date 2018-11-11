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
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p")
    , @NamedQuery(name = "Products.findByIdproducts", query = "SELECT p FROM Products p WHERE p.idproducts = :idproducts")
    , @NamedQuery(name = "Products.findByName", query = "SELECT p FROM Products p WHERE p.name = :name")
    , @NamedQuery(name = "Products.findByBrand", query = "SELECT p FROM Products p WHERE p.brand = :brand")
    , @NamedQuery(name = "Products.findByDateBuy", query = "SELECT p FROM Products p WHERE p.dateBuy = :dateBuy")
    , @NamedQuery(name = "Products.findByCost", query = "SELECT p FROM Products p WHERE p.cost = :cost")
    , @NamedQuery(name = "Products.findByPrice", query = "SELECT p FROM Products p WHERE p.price = :price")
    , @NamedQuery(name = "Products.findByDescription", query = "SELECT p FROM Products p WHERE p.description = :description")
    , @NamedQuery(name = "Products.findByUso", query = "SELECT p FROM Products p WHERE p.uso = :uso")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducts")
    private Integer idproducts;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "brand")
    private String brand;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateBuy")
    @Temporal(TemporalType.DATE)
    private Date dateBuy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private double cost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uso")
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
        String tipo = "";
        if (uso ==0 ) {
            
            tipo= "nuevo";
        }else{
            tipo = "usado";
        }
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
    
    public String verGarantia(){
        String garantia = "";
        if (uso == 0) {
            garantia  = "3 años de garantia";
        }else{
            garantia = "1 año de garantia";
            
        }      
        return garantia;
    }
    
    public String mostrarUso(){
        getUso();
        String usado = "";
        if (uso == 0) {
            usado = "Nuevo";
        }else{
            usado = "De segunda mano";
        
        }
        return usado;
                
    
    }
    
}

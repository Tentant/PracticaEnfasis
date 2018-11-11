package udem.edu.co.entities;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * La clase Users es la conexión de los campos que están la tabla users de la base de datos con el todo el proyecto.
 * @author Santiago Arciniegas Carmona
 * @author Juan Fernando Arteaga Acevedo
 * @author Michelle Gomez Villa
 * @author Julian David Restrepo Muñoz
 * @version 1.0
 * @since StoreUdem2.0 0.1
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByIdusers", query = "SELECT u FROM Users u WHERE u.idusers = :idusers")
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusers")
    private Integer idusers;
    @Size(max = 15)
    @Column(name = "username")
    private String username;
    @Size(max = 15)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne(optional = false)
    private Rol idrol;

    public Users() {
    }

    public Users(Integer idusers) {
        this.idusers = idusers;
    }

    public Integer getIdusers() {
        return idusers;
    }

    public void setIdusers(Integer idusers) {
        this.idusers = idusers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        
        byte[] authBytes = password.getBytes(StandardCharsets.UTF_8);
        String codificado = Base64.getEncoder().encodeToString(authBytes);
        password = codificado;
        this.password = password;
    }

    public Rol getIdrol() {
        
        
        return idrol;
    }

    public void setIdrol(Rol idrol) {
        this.idrol = idrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusers != null ? idusers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idusers == null && other.idusers != null) || (this.idusers != null && !this.idusers.equals(other.idusers))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "udem.edu.co.entities.Users[ idusers=" + idusers + " ]";
    }
    
    /**
     * El método mostrarRol se encarga de obtener el rol del usurio 
     * @return String propiedad de los productos al ser de primera o segunda mano
     * @since StoreUdem2.0 0.1
     */
    public String mostrarRol(){
        String rolUs = "";
        getIdrol();
        rolUs = idrol.getRol();
        return rolUs;
    
    }
    
}

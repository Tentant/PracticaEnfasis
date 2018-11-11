package udem.edu.co.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import udem.edu.co.entities.Users;
/**
 * La clase UsersFacade estable la conexión entre las entities y el controlador del programa de los objetos Usuarios (Users).
 * @author Santiago Arciniegas Carmona
 * @author Juan Fernando Arteaga Acevedo
 * @author Michelle Gomez Villa
 * @author Julian David Restrepo Muñoz
 * @version 1.0
 * @since StoreUdem2.0 0.1
 */

@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "StoreUdem2.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    /**
     * El método iniciarSesion se encargar de realizar una busqueda en la base de datos según los datos que ingreso el usuario (usuario y contraseña)
     * y en caso de encontrar dichos valores, este trae todos los atributos que conforman el objeto Users 
     * @return Users retornar el usuario con los datos completos almacenados en la base de datos
     * @since StoreUdem2.0 0.1
     */    
    public Users iniciarSesion(Users us){
        Users user = null;
        String consulta;
        try {
            consulta  = "FROM Users u WHERE u.username = ?1 and u.password = ?2";//Busqueda de los datos que se ingresan en la base de datos
            Query query = em.createQuery(consulta);
            query.setParameter(1, us.getUsername());
            
            query.setParameter(2, us.getPassword());
            List<Users> lista = query.getResultList();
            if (!lista.isEmpty()) {
                user = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        
        return user; 
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udem.edu.co.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import udem.edu.co.entities.Users;

/**
 *
 * @author juliandrestrepom
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

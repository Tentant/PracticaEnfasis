package udem.edu.co.controller;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import udem.edu.co.entities.Users;
/**
 * La clase PlantillaController se usa para controlar el estado de sesión en todos las vistas.
 * @author Santiago Arciniegas Carmona
 * @author Juan Fernando Arteaga Acevedo
 * @author Michelle Gomez Villa
 * @author Julian David Restrepo Muñoz
 * @version 1.0
 * @since StoreUdem2.0 0.7
 */
@Named
@ViewScoped
public class PlantillaController implements Serializable {
    
    /**
    * El método verificarSesion se encarga de verficar que el usuario si este logeado cuando desde otro navegador se ingresa a la url viewTables, si no
    * se ésta logueado se redirige a la penstaña index.
    * @since StoreUdem2.0 0.7
    */
    public void verificarSesion() {
        try {
            Object us = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            //System.out.println(us.getIdrol().getIdrol());
            if (us == null) {
                //System.out.println("no tiene nada");
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            } else {
                //FacesContext.getCurrentInstance().getExternalContext().redirect("viewTables.xhtml");
            }
        } catch (Exception e) {
            //System.out.println("Entre el catch");
        }
    }

    /**
    * El método verificarSesionGerente se encarga de verficar que el usuario logueado si sea un gerente ya que es el único rol que tiene derecho
    * a ingresar a la vista usuarios y tener, en caso contrario si se redirige a la vista viewTables.
    * @since StoreUdem2.0 0.7
    */
    public void verificarSesionGerente() {
        try {
            Object us = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            
            //System.out.println(us.getIdrol().getIdrol());
            if (us == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../viewTables.xhtml");
            } else {
                Users user = (Users) us;
                System.out.println(user.getIdrol().getRol());
                if (!user.getIdrol().getRol().equals("gerente")) {

                    FacesContext.getCurrentInstance().getExternalContext().redirect("../viewTables.xhtml");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Usted no tiene permisos"));
                }
            }

        } catch (Exception e) {
        }
    }

    /**
    * El método verificarSesionVendedor se encarga de verficar que el usuario si este logeado ademas de esto revisar que su rol 
    * sea vendedor cuando desde otro navegador se ingresa a la vista de equipos o desde el mismo, ya este rol no tiene permisos 
    * para ingresar a ésta vista, en caso contrario si se redirige a la vista viewTables
    * @since StoreUdem2.0 0.7
    */
    public void verificarSesionVendedor() {
        try {
            Object us = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            //System.out.println(us.getIdrol().getIdrol());
            if (us == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../viewTables.xhtml");
            } else {
                Users user = (Users) us;
                if (user.getIdrol().getRol().equals("vendedor")) {

                    FacesContext.getCurrentInstance().getExternalContext().redirect("../viewTables.xhtml");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Usted no tiene permisos"));
                }
            }

        } catch (Exception e) {
        }
    }

    
//    public String enviarRol() {
//        String rol = "";
//        try {
//            Object us = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
//            //System.out.println(us.getIdrol().getIdrol());
//            if (us == null) {
//            } else {
//                Users user = (Users) us;
//                rol = user.getIdrol().getRol();
//            }
//        } catch (Exception e) {
//        }
//        return rol;
//    }

    
//    public String paginaUsers() {
//        String pagina = "users/List";
//
//        try {
//            //System.out.println("Estoy probando para ver si un gerente");
//            Object us = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
//            //System.out.println(us.getIdrol().getIdrol());
//            if (us == null) {
//            } else {
//                Users user = (Users) us;
//                String rol = user.getIdrol().getRol();
//                if (rol.equals("contador") || rol.equals("vendedor")) {
//                    pagina = "NoPermisos";
//                }
//            }
//        } catch (Exception e) {
//        }
//
//        return pagina;
//    }


}

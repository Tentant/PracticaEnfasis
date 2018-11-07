package udem.edu.co.controller;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import udem.edu.co.entities.Users;

@Named
@ViewScoped
public class PlantillaController implements Serializable{
    
    public void verificarSesion(){
        try {
            Object us =  FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            //System.out.println(us.getIdrol().getIdrol());
            if (us == null) {
                System.out.println("no tiene nada");
              FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
            }else{
                //FacesContext.getCurrentInstance().getExternalContext().redirect("viewTables.xhtml");
            }
            
        } catch (Exception e) {
           
            System.out.println("Entre el catch");
           
        }
    }
        public void verificarSesionGerente(){
        try {
            Object us =  FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            //System.out.println(us.getIdrol().getIdrol());
            if (us == null) {
            }else{
                Users user = (Users)us;
                if (!user.getIdrol().getRol().equals("gerente")) {
                    
                    FacesContext.getCurrentInstance().getExternalContext().redirect("../viewTables.xhtml");
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Usted no tiene permisos"));
                }               
            }
            
        } catch (Exception e) {        
        }
    }
    
    public String verificarProducRolCrear(){
        String pagina = "ProductsCreateDialog";
       try {
            Object us =  FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            //System.out.println(us.getIdrol().getIdrol());
            if (us == null) {      
            }else{
                System.out.println("Por lo menos estoy aquí");
                Users user = (Users)us;
                System.out.println(user.getIdrol().getRol());
                String rol = user.getIdrol().getRol();
                if (rol.equals("contador")) {
                    pagina = "NoPermisos";
                }
            }
            
        } catch (Exception e) {         
        }
    
    return pagina;
    }
        public String verificarProducRolEditar(){
        String pagina = "ProductsEditDialog";
        try {
            Object us =  FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            //System.out.println(us.getIdrol().getIdrol());
            if (us == null) {      
            }else{              
                Users user = (Users)us;               
                String rol = user.getIdrol().getRol();
                if (rol.equals("contador")) {
                    pagina = "NoPermisos";
                }
            }            
        } catch (Exception e) {          
        }    
    return pagina;
    }
    
    
    public String verificarRolEquiposCrear(){
        String pagina = "EquipmentCreateDialog";
       try {
            Object us =  FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            //System.out.println(us.getIdrol().getIdrol());
            if (us == null) {      
            }else{              
                Users user = (Users)us;               
                String rol = user.getIdrol().getRol();
                if (rol.equals("contador") || rol.equals("vendedor")) {
                    pagina = "NoPermisos";
                }
            }            
        } catch (Exception e) {          
        }    
    return pagina;
    }
    
    public String verificarRolEquiposEditar(){
        String pagina = "EquipmentCreateDialog";
        try {
            Object us =  FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            //System.out.println(us.getIdrol().getIdrol());
            if (us == null) {      
            }else{              
                Users user = (Users)us;               
                String rol = user.getIdrol().getRol();
                if (rol.equals("contador") || rol.equals("vendedor")) {
                    pagina = "NoPermisos";
                }
            }            
        } catch (Exception e) {          
        }    
    return pagina;
    }
        public String enviarRol(){
        String rol = "";
        try {
            Object us =  FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            //System.out.println(us.getIdrol().getIdrol());
            if (us == null) {      
            }else{              
                Users user = (Users)us;               
                rol = user.getIdrol().getRol();
            }            
        } catch (Exception e) {          
        }    
    return rol;
    }
        
    public String paginaUsers(){
        String pagina = "users/List";
        
        try {
            System.out.println("Estoy probando para ver si un gerente");
            Object us =  FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            //System.out.println(us.getIdrol().getIdrol());
            if (us == null) {      
            }else{              
                Users user = (Users)us;               
                String rol = user.getIdrol().getRol();
                if (rol.equals("contador") || rol.equals("vendedor")) {
                    pagina = "NoPermisos";
                }
            }            
        } catch (Exception e) {          
        } 
        
        return pagina;
    }
    
    
}

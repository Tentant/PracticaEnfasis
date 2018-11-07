package udem.edu.co.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import udem.edu.co.controller.dtos.Users;
import udem.edu.co.webServicesClient.RestUsers;
/*
@Curso énfasis 2
@fecha: 09/14/2018
@modificación: 09/16/2018
*/
@Named(value = "LoginController")
@SessionScoped
public class LoginController implements Serializable {
   
    private RestUsers restUser;
    private Users usuario;
    private String initUser;
    private String initPassword;
    
    /**
     * Creates a new instance of Login
     */
    @PostConstruct
    public void init(){
        usuario =new Users(); 
        restUser = new RestUsers();
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
    
    
    public LoginController() {
        usuario =new Users();
    }

    public String getInitUser() {
        return initUser;
    }

    public void setInitUser(String initUser) {
        this.initUser = initUser;
    }

    public String getInitPassword() {
        return initPassword;
    }

    public void setInitPassword(String initPassword) {
        this.initPassword = initPassword;
    }
    public String loginSession(){
        Users us;
        String  redirection = null;
        try {
            System.out.println("usuario: "+initUser+","+initPassword);
            us = restUser.findUserLogin_JSON(Users.class,initUser,initPassword);
            if (us != null) {//Validación para ver si el usuario si se encuentra
                
                //Almacenar en la sesión de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                //redirection = "viewTables"; //Si el usuario esta y la constraseña fue correcta, puede ingresar  
                redirection = "viewTables.xhtml";
            }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Credenciales incorrectas"));//uno de los datos o ambos pueden estar mal ingresados
            }   
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
            
        }
        return redirection;
    
    }

    
}

package udem.edu.co.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import udem.edu.co.ejb.UsersFacade;
import udem.edu.co.entities.Users;
/*
@Curso énfasis 2
@fecha: 09/14/2018
@modificación: 09/16/2018
*/
@Named(value = "LoginController")
@SessionScoped
public class LoginController implements Serializable {
    @EJB
    private UsersFacade usersFacade;
    private Users usuario;
    private String initUser;
    private String initPassword;
    
    /**
     * Creates a new instance of Login
     */
    @PostConstruct
    public void init(){
        usuario =new Users();    
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
    public String login (){
        
        return "viewTables";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoginController other = (LoginController) obj;
        if (!Objects.equals(this.initUser, other.initUser)) {
            return false;
        }
        if (!Objects.equals(this.initPassword, other.initPassword)) {
            return false;
        }
        return true;
    }
    /**Método: loginSession
    *Este método va de la mano con el método de la clase UsersFacade ya que es donde
    * son llevados los datos que ingresa el usuario para posteriormente realizar un busqueda en la base de datos
    * en caso tal de no encontrar el usuario la busqueda va a retornar un valor de error.
    *
    */
    public String loginSession(){
        Users us;
        String  redirection = null;
        try {
            us = usersFacade.iniciarSesion(usuario);
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

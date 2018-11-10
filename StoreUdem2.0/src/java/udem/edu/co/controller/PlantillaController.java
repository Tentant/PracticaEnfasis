package udem.edu.co.controller;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named
@ViewScoped
public class PlantillaController implements Serializable{
    
    public void verificarSesion(){
        try {
            Object us =  FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            //System.out.println(us.getIdrol().getIdrol());
            if (us == null) {
                System.out.println("no tiene nada");
              FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }
            
        } catch (Exception e) {
           
            System.out.println("Entre el catch");
           
        }
        //System.out.println("Voy a cambiar de página");
        //return "permisos.xhtml";
    }
}

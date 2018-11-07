package udem.edu.co.controller;



import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import udem.edu.co.controller.dtos.Rol;

@Named("rolController")
@SessionScoped
public class RolController implements Serializable {

 
    private List<Rol> items = null;
    private Rol selected;

    public RolController() {
    }

    public Rol getSelected() {
        return selected;
    }

    public void setSelected(Rol selected) {
        this.selected = selected;
    }



}

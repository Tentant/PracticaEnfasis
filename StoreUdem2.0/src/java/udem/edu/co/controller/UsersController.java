package udem.edu.co.controller;



import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import udem.edu.co.controller.dtos.Users;

@Named("usersController")
@SessionScoped
public class UsersController implements Serializable {

    private List<Users> items = null;
    private Users selected;

    public UsersController() {
    }

    public Users getSelected() {
        return selected;
    }

    public void setSelected(Users selected) {
        this.selected = selected;
    }

   
}

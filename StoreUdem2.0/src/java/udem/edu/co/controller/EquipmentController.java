package udem.edu.co.controller;


import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import udem.edu.co.controller.dtos.Equipment;
import udem.edu.co.webServicesClient.RestEquipment;

@Named("equipmentController")
@SessionScoped
public class EquipmentController implements Serializable {

    
    private RestEquipment restEquipment;
    private List<Equipment> items = null;
    private Equipment selected;
       
    public EquipmentController() {
        restEquipment = new RestEquipment();
    }

    public RestEquipment getRestEquipment() {
        return restEquipment;
    }

    public void setRestEquipment(RestEquipment restEquipment) {
        this.restEquipment = restEquipment;
    }    
   
    public Equipment getSelected() {
        return selected;
    }

    public void setSelected(Equipment selected) {
        this.selected = selected;
    }
    
     public List<Equipment> getItems() {
        if (items == null) {
            //items = restEquipment.findAll_JSON(List<Equipment>.class);
        }
        return items;
    }
    



   
}

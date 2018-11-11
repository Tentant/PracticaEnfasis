package udem.edu.co.controller;

import udem.edu.co.entities.Products;
import udem.edu.co.controller.util.JsfUtil;
import udem.edu.co.controller.util.JsfUtil.PersistAction;
import udem.edu.co.ejb.ProductsFacade;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import udem.edu.co.entities.Users;
/**
 * La clase ProductosController se usa para controlar todas las acciones pertientes a los objetos productos (products).
 * @author Santiago Arciniegas Carmona
 * @author Juan Fernando Arteaga Acevedo
 * @author Michelle Gomez Villa
 * @author Julian David Restrepo Muñoz
 * @version 1.0
 * @since StoreUdem2.0 0.1
 */


@Named("productsController")
@SessionScoped
public class ProductsController implements Serializable {

    @EJB
    private udem.edu.co.ejb.ProductsFacade ejbFacade;
    private List<Products> items = null;
    private Products selected;    
    /**
     * El método constructor se emplea para crear objetos de la clase de la ProductsController
     */
    public ProductsController() {
    }

    public Products getSelected() {
        return selected;
    }

    public void setSelected(Products selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProductsFacade getFacade() {
        return ejbFacade;
    }

    public Products prepareCreate() {
        selected = new Products();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProductsCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProductsUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProductsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Products> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Products getProducts(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Products> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Products> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Products.class)
    public static class ProductsControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductsController controller = (ProductsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productsController");
            return controller.getProducts(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Products) {
                Products o = (Products) object;
                return getStringKey(o.getIdproducts());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Products.class.getName()});
                return null;
            }
        }

    }
    /**
    * el método habilitarBotonesCrud sirve para verificar a que secciones tiene derecho el usuario y esto depenede del rol, Para este caso, 
    * se válida que el usuario sea un contador, ya que este solo puede visualizar los datos presentes en la tabla equipos.
    * @return la propiedad display para la vista (html)
    * @since StoreUdem2.0 0.9
    */
    public String habilitarBotonesCrud() {
        String verBoton = "display: ";

        Object us = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        if (us != null) {
            Users user = (Users) us;
            if (user.getIdrol().getRol().equals("contador")) {
                verBoton = "display: none";
            }
        }
        
        return verBoton;
    }


}

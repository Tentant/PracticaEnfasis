package udem.edu.co.controller;


import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import udem.edu.co.controller.dtos.Products;

@Named("productsController")
@SessionScoped
public class ProductsController implements Serializable {


    private List<Products> items = null;
    private Products selected;

    public ProductsController() {
    }

    public Products getSelected() {
        return selected;
    }

    public void setSelected(Products selected) {
        this.selected = selected;
    }



    

}

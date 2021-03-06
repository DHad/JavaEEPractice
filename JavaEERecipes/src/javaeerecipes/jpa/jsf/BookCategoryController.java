/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeerecipes.jpa.jsf;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javaeerecipes.jpa.session.BookCategoryFacade;

/**
 *
 * @author Juneau
 */
@Named(value = "bookCategoryController")
@RequestScoped
public class BookCategoryController {
    
    @EJB
    BookCategoryFacade ejbFacade;

    /**
     * Creates a new instance of BookCategoryController
     */
    public BookCategoryController() {
    }
    
    public List getBookCategories(){
        return ejbFacade.getBookCategories();
    }
}

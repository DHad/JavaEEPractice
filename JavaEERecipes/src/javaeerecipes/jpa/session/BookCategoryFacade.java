
package javaeerecipes.jpa.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javaeerecipes.jpa.entity.BookCategory;

/**
 *
 * @author Juneau
 */

@Stateless
public class BookCategoryFacade extends AbstractFacade<BookCategory> {

    @PersistenceContext(unitName = "JavaEERecipesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public BookCategoryFacade(){
        super(BookCategory.class);
    }

    public List getBookCategories(){
        TypedQuery<Object[]> qry = em.createQuery("select a.name, a.genre, a.description " +
               "from BookStore s JOIN TREAT(s.categories as ItCategory) a", Object[].class);
        
       List data = new ArrayList();
        if (!qry.getResultList().isEmpty()) {
             List<Object[]> tdata = qry.getResultList();
            for (Object[] t : tdata) {
                HashMap resultMap = new HashMap();
                resultMap.put("name", t[0]);
                resultMap.put("genre", t[1]);
                resultMap.put("categoryDesc", t[2]);
                data.add(resultMap);
            }
        }
        return data;
    }
    
}

package recipe08_03;

import java.util.Iterator;
import java.util.List;
import javax.persistence.*;
import chapter08.entity.BookAuthor08;

/**
 * Recipe 8-3: Persistence Unit Teat
 *
 * @author juneau
 */
public class PUTester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEERecipesLOCAL");
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction entr = em.getTransaction();
            entr.begin();
            Query query = em.createNamedQuery("BookAuthor08.findAll");
            List authorList = query.getResultList();
            Iterator authorIterator = authorList.iterator();
            while (authorIterator.hasNext()) {
                BookAuthor08 author = (BookAuthor08) authorIterator.next();
                System.out.print("Name:" + author.getFirst() + " " + author.getLast());
                System.out.println();
            }
        } catch (Exception ex){
            System.err.println(ex);
        } finally {
            if (em != null){
                em.close();
            }
        }
    }
}

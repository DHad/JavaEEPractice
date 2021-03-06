
package chapter06;

import java.util.ArrayList;
import java.util.List;

/**
 * Chapter 6
 * @author juneau
 */
public class Cart implements java.io.Serializable {
    // List containing book objects
    private List<Item> books = null;
    
    public Cart(){
        books = null;
    }

    /**
     * @return the books
     */
    public List <Item> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List books) {
        this.books = books;
    }
    
    /**
     * Utility method to add a book and quantity
     */
    public void addBook(Book title, int qty){
        if (books == null){
            books = new ArrayList();
        }
        books.add(new Item(title, qty));
    }
}

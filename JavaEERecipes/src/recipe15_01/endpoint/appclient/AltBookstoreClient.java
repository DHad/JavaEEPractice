/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe15_01.endpoint.appclient;

import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;
import recipe15_01.endpoint.BookstoreService;

public class AltBookstoreClient {
//    @WebServiceRef(wsdlLocation = 
//      "http://localhost:8080/JavaEERecipesJPA/BookstoreService?WSDL")
    private static Service service;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println(obtainContacts());
    }

    private static String obtainContacts() {
        recipe15_01.endpoint.BookstoreService port = service.getPort(BookstoreService.class);
        return port.obtainCompleteContactList();

    }
}
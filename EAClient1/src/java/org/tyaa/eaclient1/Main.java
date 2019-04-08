/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.eaclient1;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.tyaa.ea1.model.BookingModel;
import org.tyaa.ea1.model.PersonModel;
import org.tyaa.ea1.session.ServiceSessionBeanRemote;

/**
 *
 * @author student
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        InitialContext context = new InitialContext();
        ServiceSessionBeanRemote proxy =
                (ServiceSessionBeanRemote) context.lookup("rmi/ServiceSessionBean");
        for (PersonModel personModel : proxy.getPeople()) {
            System.out.println(personModel.getFirstName());
        }
        for (BookingModel bookingModel : proxy.getBookings()) {
            System.out.println("Номер заказа: " + bookingModel.getId().toString());
            System.out.println("Имя заказчика: " + bookingModel.getFirstName() + " " + bookingModel.getLastName());
            System.out.println("Продукт: " + bookingModel.getProductName());
            System.out.println("");
        }
    }
    
}

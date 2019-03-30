/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.ea1.session;

import java.util.List;
import javax.ejb.Remote;
import org.tyaa.ea1.model.BookingModel;

/**
 *
 * @author student
 */
@Remote
public interface ServiceSessionBeanRemote {

    List<org.tyaa.ea1.model.PersonModel> getPeople();

    public List<BookingModel> getBookings();
    
}

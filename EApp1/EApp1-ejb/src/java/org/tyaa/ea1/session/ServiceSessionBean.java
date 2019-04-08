/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.ea1.session;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.tyaa.ea1.model.BookingModel;
import org.tyaa.ea1.model.PersonModel;
import org.tyaa.ea1.model.ProductModel;

/**
 *
 * @author student
 */
@Stateless
public class ServiceSessionBean implements ServiceSessionBeanRemote {

    @EJB
    private PersonFacade personFacade;
    @EJB
    private BookingFacade bookingFacade;
    
    @Override
    public List<org.tyaa.ea1.model.PersonModel> getPeople() {
        return personFacade.findAll().stream()
                .map((p) -> {
                    return new PersonModel(
                            p.getId()
                            , p.getFirstName()
                            , p.getLastName()
                            , p.getAge()
                    );
                })
                .collect(Collectors.toList());
    }
    
    @Override
    public List <org.tyaa.ea1.model.BookingModel> getBookings(){
        //List <BookingModel> bmList = new ArrayList<>();
        
        return bookingFacade.findAll().stream().map((booking) -> {
            BookingModel bm = new BookingModel();
            bm.setId(booking.getId());
            bm.setFirstName(booking.getPerson().getFirstName());
            bm.setLastName(booking.getPerson().getLastName());
            bm.setProductName(booking.getProduct().getProductName());
            return bm;
        }).collect(Collectors.toList());
    }
}

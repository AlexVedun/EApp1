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
            bm.setPerson(new PersonModel (
                    booking.getPerson().getId(), 
                    booking.getPerson().getFirstName(),
                    booking.getPerson().getLastName(),
                    booking.getPerson().getAge()));
            bm.setProduct(new ProductModel(
                    booking.getProduct().getId(),
                    booking.getProduct().getProductName()));
            return bm;
        }).collect(Collectors.toList());
//        .forEachOrdered((bm) -> {
//            bmList.add(bm);
//        });
//        return bmList;
//        return bookingFacade.findAll().stream()
//                .map(((p) -> {
//                    BookingModel bm = new BookingModel;
//                    return new BookingModel(p.getId(), p.getPerson(), p.getProduct());
//                }))
    }
}

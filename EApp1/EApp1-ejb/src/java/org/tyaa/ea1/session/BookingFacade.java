/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.ea1.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tyaa.ea1.entity.Booking;

/**
 *
 * @author alexe
 */
@Stateless
public class BookingFacade extends AbstractFacade<Booking> {

    @PersistenceContext(unitName = "EApp1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookingFacade() {
        super(Booking.class);
    }
    
}

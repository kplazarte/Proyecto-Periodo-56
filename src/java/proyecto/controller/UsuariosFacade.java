/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import proyecto.entities.Usuarios;

/**
 *
 * @author AZUS
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "PROYECTO_56PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    public Usuarios encontrarUsuarioxlogin(String nombreUsuario){
        Query q=em.createNamedQuery("Usuarios.findByUsuario",Usuarios.class).setParameter("usuario",nombreUsuario);
        List <Usuarios> listado=q.getResultList();
        if(!listado.isEmpty()){
            return listado.get(0);
        }
        return null;
    }
    
}

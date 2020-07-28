/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import proyecto.controller.UsuariosFacade;
import proyecto.entities.Usuarios;

/**
 *
 * @author AZUS
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    private String nombreUsuario;
    private String password;
    
    @EJB
    private UsuariosFacade usuFacade;
    private Usuarios usuarioAutenticado;

    public Usuarios getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuarios usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }
    
    

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
     public String autenticar(){
         usuarioAutenticado=usuFacade.encontrarUsuarioxlogin(nombreUsuario);
         if(usuarioAutenticado!=null){
             if(usuarioAutenticado.getContraseña().equals(password)){
                return "ingresar"; 
             }
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "El password no es correcto","El password no es correcto"));
         return null;
        }
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "El usuario no existe","El usuario no existe"));
         return null;
    }
}

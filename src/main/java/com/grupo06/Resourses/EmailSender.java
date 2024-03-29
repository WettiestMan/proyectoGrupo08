/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses;

/**
 * Un Java Record que contiene el usuario y contraseña de un emisor
 * 
 * @author santi
 */
public record EmailSender(String usuario, String contrasenaAppl) {
    
    public EmailSender(String usuario, String contrasenaAppl){
        this.usuario = usuario;
        this.contrasenaAppl = contrasenaAppl;
    }
    
}

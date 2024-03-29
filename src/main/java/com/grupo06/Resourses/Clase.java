/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses;

/**
 *
 * @author santi
 */
public class Clase implements java.io.Serializable{
    private Integer id;
    private String nivel;
    private byte grado;
    private char seccion;
    private int id_profesor;

    public Clase(String nivel, byte grado, char seccion, int id_profesor) {
        this.nivel = nivel;
        this.grado = grado;
        this.seccion = seccion;
        this.id_profesor = id_profesor;
        this.id = null;
    }

    public Clase(Integer id, String nivel, byte grado, char seccion, int id_profesor) {
        this.id = id;
        this.nivel = nivel;
        this.grado = grado;
        this.seccion = seccion;
        this.id_profesor = id_profesor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public byte getGrado() {
        return grado;
    }

    public void setGrado(byte grado) {
        this.grado = grado;
    }

    public char getSeccion() {
        return seccion;
    }

    public void setSeccion(char seccion) {
        this.seccion = seccion;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

}

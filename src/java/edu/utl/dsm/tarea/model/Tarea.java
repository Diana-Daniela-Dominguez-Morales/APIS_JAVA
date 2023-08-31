/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utl.dsm.tarea.model;

/**
 *
 * @author DANIELA
 */
public class Tarea {
    private int id;
    private String descripcion;
    private String estatus;

    public Tarea() {}

    public Tarea( String descripcion, String estatus) {
        this.descripcion = descripcion;
        this.estatus = estatus;
    }
    
    public Tarea(int id, String descripcion,  String estatus) {
        this.id = id;
        this.descripcion = descripcion;
        this.estatus = estatus;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "tarea{" + "id=" + id + ", descripcion=" + descripcion + ", estatus=" + estatus + '}';
    }
}

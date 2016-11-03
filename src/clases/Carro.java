/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author hp14
 */
public class Carro implements java.io.Serializable{
    private String placa;
    private Persona propietario;

    public Carro(String placa, Persona propietario) {
        this.placa = placa;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }
 
    public void guardar(ObjectOutputStream salida) throws IOException{
        salida.writeObject(this);
    }
    
}
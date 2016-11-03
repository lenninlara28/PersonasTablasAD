/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp 14
 */
public class Helper {

    public static void mensaje(Component ventana, String mensaje, int tipo) {
        switch (tipo) {
            case 1:
                JOptionPane.showMessageDialog(ventana, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(ventana, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(ventana, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public static void limpiadoTabla(JTable tabla1) {
        int nf, nc;

        nf = tabla1.getRowCount();
        nc = tabla1.getColumnCount();
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
                tabla1.setValueAt("", i, j);

            }
        }
    }

    public static void porDefectoTabla(JTable tabla1) {
        DefaultTableModel tm;
        tm = (DefaultTableModel) tabla1.getModel();
        tm.setColumnCount(0);
        tm.setRowCount(0);

    }

    public static void habilitarBotones(JButton[] botonesH) {
        for (int i = 0; i < botonesH.length; i++) {
            botonesH[i].setEnabled(true);

        }
    }

    public static void deshabilitarBotones(JButton[] botonesD) {
        for (int i = 0; i < botonesD.length; i++) {
            botonesD[i].setEnabled(false);

        }
    }

    public static void llenarTabla(JTable tabla, String ruta) {
        DefaultTableModel tm;
        int nf;
        ArrayList<Persona> personas = traerDatos(ruta);
        tm = (DefaultTableModel) tabla.getModel();
        limpiadoTabla(tabla);
        nf = personas.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
            tabla.setValueAt(i + 1, i, 0);
            tabla.setValueAt(personas.get(i).getCedula(), i, 1);
            tabla.setValueAt(personas.get(i).getNombre(), i, 2);
            tabla.setValueAt(personas.get(i).getApellido(), i, 3);
            tabla.setValueAt(personas.get(i).getSexo(), i, 4);
        }

    }

    public static void llenarTablaCarros(JTable tabla, String ruta) {
        DefaultTableModel tm;
        int nf;
        ArrayList<Carro> carros = traerDatos(ruta);
        tm = (DefaultTableModel) tabla.getModel();
        limpiadoTabla(tabla);
        nf = carros.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
            tabla.setValueAt(i + 1, i, 0);
            tabla.setValueAt(carros.get(i).getPlaca(), i, 1);
            tabla.setValueAt(carros.get(i).getPropietario().getCedula(), i, 2);
            tabla.setValueAt(carros.get(i).getPropietario().getNombre(), i, 3);
            tabla.setValueAt(carros.get(i).getPropietario().getApellido(), i, 4);
        }
    }

    public static void llenarTablaCarros(JTable tabla, ArrayList<Carro> carros) {
        DefaultTableModel tm;
        int nf;

        tm = (DefaultTableModel) tabla.getModel();
        limpiadoTabla(tabla);
        nf = carros.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
            tabla.setValueAt(i + 1, i, 0);
            tabla.setValueAt(carros.get(i).getPlaca(), i, 1);
            tabla.setValueAt(carros.get(i).getPropietario().getCedula(), i, 2);
            tabla.setValueAt(carros.get(i).getPropietario().getNombre(), i, 3);
            tabla.setValueAt(carros.get(i).getPropietario().getApellido(), i, 4);
        }
    }

    public static ArrayList traerDatos(String ruta) {
        FileInputStream archivo;
        ObjectInputStream entrada;
        ArrayList persona = new ArrayList();
        Object p;
        try {
            archivo = new FileInputStream(ruta);
            entrada = new ObjectInputStream(archivo);
            while ((p = entrada.readObject()) != null) {
                persona.add(p);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return persona;
    }

    public static void llenarTabla(JTable tabla, ArrayList<Persona> personas) {
        DefaultTableModel tm;
        int nf;
        tm = (DefaultTableModel) tabla.getModel();
        limpiadoTabla(tabla);
        nf = personas.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
            tabla.setValueAt(i + 1, i, 0);
            tabla.setValueAt(personas.get(i).getCedula(), i, 1);
            tabla.setValueAt(personas.get(i).getNombre(), i, 2);
            tabla.setValueAt(personas.get(i).getApellido(), i, 3);
            tabla.setValueAt(personas.get(i).getSexo(), i, 4);
        }
    }

    public static void volcado(ObjectOutputStream salida, ArrayList personas) {
        for (int i = 0; i < personas.size(); i++) {
            try {
                salida.writeObject(personas.get(i));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void listadoPorSexo(JTable tabla, String ruta, String sexo) {
        ArrayList<Persona> personas = traerDatos(ruta);
        ArrayList<Persona> personasFiltradas = new ArrayList();
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getSexo().equals(sexo)) {
                personasFiltradas.add(personas.get(i));
            }

        }
        llenarTabla(tabla, personasFiltradas);

    }

    public static boolean buscarPersonaCedula(String cedula, String ruta) {
        ArrayList<Persona> personas = traerDatos(ruta);
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    public static Persona traerPersonaCedula(String cedula, String ruta) {
        ArrayList<Persona> personas = traerDatos(ruta);
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCedula().equals(cedula)) {
                return personas.get(i);
            }
        }
        return null;
    }

    public static boolean buscarCarroPlaca(String placa, String ruta) {
        ArrayList<Carro> carros = traerDatos(ruta);
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getPlaca().equals(placa)) {
                return true;
            }
        }
        return false;
    }

    public static Carro traerCarroPlaca(String placa, String ruta) {
        ArrayList<Carro> carros = traerDatos(ruta);
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getPlaca().equals(placa)) {
                return carros.get(i);
            }

        }
        return null;
    }

    public static ArrayList<Persona> modificarPersona(String ruta, String cedula, String nombre, String apellido, String sexo) {
        ArrayList<Persona> personas = traerDatos(ruta);
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCedula().equals(cedula)) {
                personas.get(i).setNombre(nombre);
                personas.get(i).setApellido(apellido);
                personas.get(i).setSexo(sexo);

                return personas;
            }
        }
        return null;
    }

    public static ArrayList<Carro> modificarCarro(String ruta, String placa, Persona propietario) {
        ArrayList<Carro> carros = traerDatos(ruta);
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getPlaca().equals(placa)) {
                carros.get(i).setPlaca(placa);
                carros.get(i).setPropietario(propietario);

                return carros;
            }

        }
        return null;
    }

    public static void llenarComboPersonas(JComboBox combo, String ruta) {
        ArrayList<Persona> personas = traerDatos(ruta);
        DefaultComboBoxModel dcbm = (DefaultComboBoxModel) combo.getModel();
        dcbm.removeAllElements();
        Persona p;
        for (int i = 0; i < personas.size(); i++) {
            p = personas.get(i);
            dcbm.addElement(p.getCedula() + " - " + p.getNombre() + " " + p.getApellido());
        }
    }
}

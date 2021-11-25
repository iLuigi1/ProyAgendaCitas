/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import datos.Paciente;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author aarga
 */
public class GestorPersistencia {

    private final String NOMBREAP = "lospacientes.asi";

    public boolean guardarArchivo(ArrayList<Paciente> pacientes) {
        FileOutputStream fc = null;
        try {
            fc = new FileOutputStream(NOMBREAP);
            ObjectOutputStream oo = new ObjectOutputStream(fc);
            oo.writeObject(pacientes);
            oo.close();
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fc.close();
            } catch (IOException ex) {

            }
        }
        return false;
    }

    public ArrayList<Paciente> abrirArchivo() {
        ArrayList<Paciente> pacientesArchivo = null;
        FileInputStream fc = null;
        try {
            fc = new FileInputStream(NOMBREAP);
            ObjectInputStream oo = new ObjectInputStream(fc);
            pacientesArchivo = (ArrayList<Paciente>) oo.readObject();
            oo.close();
            fc.close();
            return pacientesArchivo;
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            
        }
        return null;
    }
}

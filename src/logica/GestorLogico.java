/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.Paciente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import persistencia.GestorPersistencia;

/**
 *
 * @author aarga
 */
public class GestorLogico implements Serializable {

    private ArrayList<Paciente> pacientes;

    public GestorLogico() {
        this.buscarPacientes();
        if (this.pacientes == null) {
            this.pacientes = new ArrayList<>();
        }
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public boolean adicionarPaciente(Paciente paciente) {
        if (paciente == null) {
            return false;
        }
        if (this.pacientes.add(paciente)) {
            return this.actualizaPersistencia();
        }
        return false;
    }

    public boolean adicionarHistoriaClinica(Paciente paciente) {
        if (paciente == null) {
            return false;
        }
        if (this.pacientes.add(paciente)) {
            return this.actualizaPersistencia();
        }
        return false;
    }

    public boolean editarPaciente(Paciente paciente) {
        if (paciente == null) {
            return false;
        } else {
            for (Paciente elpaciente : pacientes) {
                if (elpaciente.getDocumentoIdentidad() == paciente.getDocumentoIdentidad()) {
                    elpaciente.setNombreCompleto(paciente.getNombreCompleto());
                    elpaciente.setCorreoElectronico(paciente.getCorreoElectronico());
                    elpaciente.setFechaNacimiento(paciente.getFechaNacimiento());
                    elpaciente.setNumeroTelefono(paciente.getNumeroTelefono());
                    return this.actualizaPersistencia();
                }
            }
            return false;
        }
    }

    public boolean borrarPaciente(Paciente paciente) {
        if (paciente == null) {
            return false;
        }
        if (this.pacientes.remove(paciente)) {
            return this.actualizaPersistencia();
        }
        return false;
    }

    public void buscarPacientes() {
        GestorPersistencia gestor = new GestorPersistencia();
        this.pacientes = gestor.abrirArchivo();
    }

    public void ordenarPacientes() {
        Collections.sort(pacientes, new Comparator<Paciente>() {
            @Override
            public int compare(Paciente c1, Paciente c2) {
                return c1.getDocumentoIdentidad().compareTo(c2.getDocumentoIdentidad());
            }
        });
    }

    public Paciente buscarPaciente(Long DocumentoIdentidad) {
        if (DocumentoIdentidad == null) {
            return null;
        }
        for (Paciente elpaciente : pacientes) {
            if (elpaciente.getDocumentoIdentidad() == DocumentoIdentidad) {
                return elpaciente;
            }
        }
        return null;
    }

    private boolean actualizaPersistencia() {
        GestorPersistencia gestor = new GestorPersistencia();
        return gestor.guardarArchivo(pacientes);
    }

}

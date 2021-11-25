/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import datos.Paciente;
import java.util.ArrayList;
import logica.GestorLogico;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author aarga
 */
public class PacienteTest {

    @Test
    public void registraPaciente() {
        GestorLogico miGestorLogico = new GestorLogico();
        Paciente p = new Paciente();
        p.setNombreCompleto("Nombre");
        boolean rta = miGestorLogico.adicionarPaciente(p);
        Assert.assertTrue(rta);
    }
    
    @Test
    public void registraHistoriaClinica() {
        GestorLogico miGestorLogico = new GestorLogico();
        Paciente p = new Paciente();
        p.setMotivoConsulta("Consulta");
        p.setAntecedentes("Ninguno");
        boolean rta = miGestorLogico.adicionarHistoriaClinica(p);
        Assert.assertTrue(rta);
    }

    @Test
    public void modificaPaciente() {
        GestorLogico miGestorLogico = new GestorLogico();
        Paciente p = new Paciente();
        boolean rta = miGestorLogico.editarPaciente(p);
        Assert.assertTrue(rta);
    }

    @Test
    public void registraPacienteNull() {
        GestorLogico miGestorLogico = new GestorLogico();
        //Paciente p = new Paciente();
        //p.setNombreCompleto("Gerardo");
        boolean rta = miGestorLogico.adicionarPaciente(null);
        Assert.assertFalse(rta);

    }

    @Test
    public void consultaPaciente() {
        GestorLogico miGestorLogico = new GestorLogico();
        Paciente p = new Paciente();
        //p.setNombreCompleto("Carlos");
        //p.setDocumentoIdentidad(12L);
        boolean rta = miGestorLogico.adicionarPaciente(p);

        Paciente pacien = miGestorLogico.buscarPaciente(12L);
        Assert.assertEquals(null, pacien);
    }

    @Test
    public void borraPaciente() {
        GestorLogico miGestorLogico = new GestorLogico();
        Paciente p = new Paciente();
        //p.setNombreCompleto("Carlos");
        //p.setDocumentoIdentidad(14L);
        boolean rta = miGestorLogico.adicionarPaciente(p);

        rta = miGestorLogico.borrarPaciente(p);

        Paciente pacien = miGestorLogico.buscarPaciente(1L);
        Assert.assertEquals(pacien, null);
    }

    @Test
    public void buscarPaciente() {
        GestorLogico miGestorLogico = new GestorLogico();
        ArrayList<Paciente> lista = miGestorLogico.getPacientes();
        for (Paciente paciente : lista) {
            System.out.println(paciente);
        }

        Paciente pacien = miGestorLogico.buscarPaciente(14L);
        Assert.assertTrue(lista.size() > 0);
    }
}

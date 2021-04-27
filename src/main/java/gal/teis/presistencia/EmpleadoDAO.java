/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.presistencia;

import gal.teis.modelo.Departamento;
import gal.teis.modelo.Empleado;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Esther Ferreiro
 */
public class EmpleadoDAO {
    
     
    /**
     * Permite guardar un empleado en la BD
     *
     * @param empleado Contacto, elemento a insertar en la BD
     * @return
     */
    public static int guardaEmpleado(Empleado empleado)  throws HibernateException{
        int id = 0;

        try {
            HibernateDAO.iniciaOperacion();
            //guarda el empleado en la base de datos y devuelve el id generado
            id = (int) HibernateDAO.sesion.save(empleado);
            HibernateDAO.transa.commit();
        } catch (HibernateException he) {
            HibernateDAO.manejaExcepcion(he);
        } finally {
            HibernateDAO.sesion.close();
        }
        return id;
    }
    
    
    public static void actualizaEmpleado(Empleado empleado) throws HibernateException {
        try {
            HibernateDAO.iniciaOperacion();
            HibernateDAO.sesion.update(empleado);
            HibernateDAO.transa.commit();
        } catch (HibernateException he) {
            HibernateDAO.manejaExcepcion(he);
        } finally {
            HibernateDAO.sesion.close();
        }
    }
    
    public static Empleado obtenEmpleado(int id)  throws HibernateException{
        Empleado empleado = null;
        boolean obtenido = false;

        try {
            //abre la sesión e inicia la transición
            HibernateDAO.iniciaOperacion();

            empleado = HibernateDAO.sesion.get(Empleado.class, id);
            HibernateDAO.transa.commit();
        } catch (HibernateException he) {
            HibernateDAO.manejaExcepcion(he);
        } finally {
            HibernateDAO.sesion.close();
        }
        return empleado;
    }

    public static void eliminaEmpleado(Empleado empleado) throws HibernateException {
        try {
            HibernateDAO.iniciaOperacion();
            HibernateDAO.sesion.delete(empleado);
            HibernateDAO.transa.commit();
        } catch (HibernateException he) {
            HibernateDAO.manejaExcepcion(he);
        } finally {
            HibernateDAO.sesion.close();
        }
    }
    public static List<Empleado> obtenListaEmpleados() throws HibernateException {
        List<Empleado> listaEmpleados = null;

        try {
            HibernateDAO.iniciaOperacion();
            listaEmpleados = HibernateDAO.sesion.createQuery("from Empleado").list();
        } finally {
            HibernateDAO.sesion.close();
        }

        return listaEmpleados;
    }

}

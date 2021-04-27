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

/**
 *
 * @author Esther Ferreiro
 */
public class DepartamentoDAO {
   
     public static int guardaDepartamento (Departamento departamento)  throws HibernateException{
        int id = 0;

        try {
            HibernateDAO.iniciaOperacion();
            //guarda el empleado en la base de datos y devuelve el id generado
            id = (int) HibernateDAO.sesion.save(departamento);
            HibernateDAO.transa.commit();
        } catch (HibernateException he) {
            HibernateDAO.manejaExcepcion(he);
        } finally {
            HibernateDAO.sesion.close();
        }
        return id;
    }
     
       public static void actualizaDepartamento(Departamento departamento) throws HibernateException {
        try {
            HibernateDAO.iniciaOperacion();
            HibernateDAO.sesion.update(departamento);
            HibernateDAO.transa.commit();
        } catch (HibernateException he) {
            HibernateDAO.manejaExcepcion(he);
        } finally {
            HibernateDAO.sesion.close();
        }
    }
       
       public static Departamento obtenDepartamento(int id)  throws HibernateException{
        Departamento departamento = null;
        boolean obtenido = false;

        try {
            //abre la sesión e inicia la transición
            HibernateDAO.iniciaOperacion();

            departamento = HibernateDAO.sesion.get(Departamento.class, id);
            HibernateDAO.transa.commit();
        } catch (HibernateException he) {
            HibernateDAO.manejaExcepcion(he);
        } finally {
            HibernateDAO.sesion.close();
        }
        return departamento;
    }
    
     public static void eliminaDepartamento(Departamento departamento) throws HibernateException {
        try {
            HibernateDAO.iniciaOperacion();
            HibernateDAO.sesion.delete(departamento);
            HibernateDAO.transa.commit();
        } catch (HibernateException he) {
            HibernateDAO.manejaExcepcion(he);
        } finally {
            HibernateDAO.sesion.close();
        }
    }  
     
     public static List<Departamento> obtenListaDepartamentos() throws HibernateException {
        List<Departamento> listaDepartamentos = null;

        try {
            HibernateDAO.iniciaOperacion();
            listaDepartamentos = HibernateDAO.sesion.createQuery("from Departamento").list();
        } finally {
            HibernateDAO.sesion.close();
        }

        return listaDepartamentos;
    }
     
     public static List<Object[]> obtenListaDepEmpleados() throws HibernateException {
        List<Object[]> listaDepEmpleados = null;

        try {
            HibernateDAO.iniciaOperacion();
            listaDepEmpleados = HibernateDAO.sesion.createQuery("from Empleado emp "
                    + "inner join emp.departamento").list();
        } finally {
            HibernateDAO.sesion.close();
        }

        return listaDepEmpleados;
    }
}

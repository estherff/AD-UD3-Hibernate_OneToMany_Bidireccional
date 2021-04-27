/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.presistencia;

import gal.teis.modelo.Direccion;
import static gal.teis.presistencia.HibernateDAO.sesion;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Esther Ferreiro
 */
public class EmpleadoDireccionDAO {
     public static List<Object[]> obtenerListaEmpDirec() throws HibernateException {
        List<Object[]> empleadoDireccion = null;

        try {
            HibernateDAO.iniciaOperacion();
            //En este caso, recuperamos una lista de arrays de objetos pues 
            //la consulta incluye dos tablas.
            /*Instrucción HQL para acceder a dos tablas relacionadas 1 a 1 de forma unidireccional.
            “ver elementos mapeados con la clase Direccion (alias dire) enlazada 
            con dire.empleado (alias emp)” */
            empleadoDireccion = HibernateDAO.sesion.createQuery("from Direccion as dire "
                    + "inner join dire.empleado as emp").list();
        } finally {
            HibernateDAO.sesion.close();
        }

        return empleadoDireccion;
    }
    

    

    
    public static List<Object[]> obtenEmplDirec(int id)  throws HibernateException{
        List<Object[]>  empleadoDireccion = null;
        boolean obtenido = false;

        try {
            //abre la sesión e inicia la transición
            HibernateDAO.iniciaOperacion();
            empleadoDireccion = sesion.createQuery("from Direccion as dire "
                    + "inner join dire.empleado as emp where emp.id = :id").
                    setParameter("id", id).list();
            //query.uniqueResult();
            HibernateDAO.transa.commit();
        } catch (HibernateException he) {
            HibernateDAO.manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return empleadoDireccion;
    }
}

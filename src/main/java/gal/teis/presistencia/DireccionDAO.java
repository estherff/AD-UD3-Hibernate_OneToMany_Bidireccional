/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.presistencia;

import gal.teis.modelo.Direccion;
import static gal.teis.presistencia.HibernateDAO.sesion;
import org.hibernate.HibernateException;

/**
 *
 * @author Esther Ferreiro
 */
public class DireccionDAO {
      /*
    Ahora crearemos los métodos que nos permitirán realizar las tareas de persistencia 
    de una entidad "Contacto", conocidas en lenguaje de base de datos como CRUD: guardarla, 
    actualizarla, eliminarla, buscar un entidad "Contacto" y obtener todas los contactos 
    que existen en la base de datos*/
    

    public static long guardaDireccion(Direccion dir)  throws HibernateException{
        int id = 0;

        try {
            HibernateDAO.iniciaOperacion();
            //guarda el empleado en la base de datos y devuelve el id generado
            id = (int) HibernateDAO.sesion.save(dir);
            HibernateDAO.transa.commit();
        } catch (HibernateException he) {
            HibernateDAO.manejaExcepcion(he);
         } finally {
            sesion.close();
        }
        return id;
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
https://www.javatutoriales.com/2009/09/hibernate-parte-7-hql-primera-parte.html
 */
package gal.teis.aplicacion;


import gal.teis.modelo.Departamento;
import gal.teis.modelo.Direccion;
import gal.teis.modelo.Empleado;
import gal.teis.presistencia.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;



/**
 *
 * @author Esther Ferreiro
 */
public class Principal {

    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * *********GUARDAR*************
         */
        /**
         * Añadir departamentos
         */
         //1º Se crear instancia de Departamento
         Departamento dep1 = new Departamento ("Comercial","Se ocupa de las operaciones comerciales");
         DepartamentoDAO.guardaDepartamento(dep1);
         Departamento dep2 = new Departamento ("Marketing","Maneja y coordina estrategias de venta");
         DepartamentoDAO.guardaDepartamento(dep2);

        //2º Se crear instancia de Empleado y se guarda en la BD
        Empleado emp1 = new Empleado("Rosa", "Pin", 2000.0);
        Empleado emp2 = new Empleado("Alberto", "Pereira", 2500.0);
        emp1.setDepartamento(dep1);
        emp2.setDepartamento(dep2);

        EmpleadoDAO.guardaEmpleado(emp1);
        EmpleadoDAO.guardaEmpleado(emp2);

        //3º Se crea instancia de dirección, se hace setter a Empleado y se almacena en la BD
        Direccion dire1 = new Direccion("C/Sol nº 5", "Vigo");
        Direccion dire2 = new Direccion("C/Principal nº 30", "Vigo");

        //3º Guardo el empleado en el atributo que hay en Dirección
        dire1.setEmpleado(emp1);
        dire2.setEmpleado(emp2);
//
//        //4º Almaceno cada dirección (cada una lleva a su empleado)
//        DireccionDAO.guardaDireccion(dire1);
//        DireccionDAO.guardaDireccion(dire2);
//        
//        //5ª Agrego departamentos
//        
//
//        /**
//         * ********LISTAR LOS ELEMENTOS *************
//         */
//        //Listar todos los elementos de la tabla empleado con su dirección
//        //Devuelve una lista de array de objetos
//        //que tendrá tantos elementos como registro haya extraído
//        //Cada elemento se corresponde con un array de Object con 2 posiciones,
//        //una por cada tabla relacionada que uso en la consulta
//        List<Object[]> listaEmpleadosDireccion = EmpleadoDireccionDAO.obtenerListaEmpDirec();
//        if (!Objects.isNull(listaEmpleadosDireccion)) {
//            System.out.println("Hay " + listaEmpleadosDireccion.size() + " empleados en la base de datos");
//            for (int i = 0; i < listaEmpleadosDireccion.size(); i++) {
//                System.out.println("Empleado " + i + ": " + listaEmpleadosDireccion.get(i)[0] + ", Empleado: " + listaEmpleadosDireccion.get(i)[1]);
//            }
//        }
//
//        /**
//         * *********OBTENER UN EMPLEADO POR SU ID*************
//         */
//        //Buscar un empleado por su id
//        //Aquí no obtengo su dirección 
//        System.out.println("Introduce el id del elemento a buscar ");
//        int id1 = ControlData.lerInt(sc);
//        Empleado empleado1 = EmpleadoDAO.obtenEmpleado(id1);
//        System.out.println(empleado1);
//
//        //Buscar un empleado por su id
//        //Aquí obtengo su dirección 
//        //Solo va a obtener un elemento que es un array de Object de dos posiciones,
//        //una para cada tabla relacionada que uso en la consulta
//        List<Object[]> empleadosDireccion = EmpleadoDireccionDAO.obtenEmplDirec(id1);
//        if (!Objects.isNull(empleadosDireccion)) {
//            System.out.println("Dirección " + listaEmpleadosDireccion.get(0)[0] + ", Empleado: " + listaEmpleadosDireccion.get(0)[1]);
//        }
//
//        /**
//         * *********ELIMINAR EMPLEADO*************
//         */
//        System.out.println("Introduce el id del elemento a eliminar ");
//        int id2 = ControlData.lerInt(sc);
//        Empleado empleado2 = EmpleadoDAO.obtenEmpleado(id2);
//        if (!Objects.isNull(empleado2)) {
//            System.out.println(empleado2);
//            EmpleadoDAO.eliminaEmpleado(empleado2);
//        } else {
//            System.out.println("El empleado no existe");
//        }
//
//        /**
//         * *********ACTUALIZAR EMPLEADO*************
//         */
//        System.out.println("Introduce el id del elemento a modificar ");
//        int id3 = ControlData.lerInt(sc);
//         System.out.println("Introduce el nuevo nombre del empleado");
//        String nombre = ControlData.lerString(sc);
//        List<Object[]> empDire1 = EmpleadoDireccionDAO.obtenEmplDirec(id3);
//        if (!Objects.isNull(empDire1)) {
//            Empleado empActualizar = ((Empleado) (empDire1.get(0)[1]));
//            empActualizar.setNombre(nombre);
//            EmpleadoDAO.actualizaEmpleado(empActualizar);
//        }
        //Listar los Departamentos con sus empleados
        
        //Obtener una lista de los departamentos con sus empleados
        List<Object[]> listaDepEmpleados = DepartamentoDAO.obtenListaDepEmpleados();
        if (!Objects.isNull(listaDepEmpleados)) {
            System.out.println("Hay " + listaDepEmpleados.size() + " empleados en la base de datos");
            for (int i = 0; i < listaDepEmpleados.size(); i++) {
                System.out.println("Empleado " + i + ": " + listaDepEmpleados.get(i)[0] + ", Empleado: " + listaDepEmpleados.get(i)[1]);
            }
        }
        //Cierra la sesión de Hibernate
        HibernateUtil.shutdown();
        //Cierra el objeto Scanner
        sc.close();
    }

}

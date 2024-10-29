package interfaz;

import entidades.Paciente;

public class App {
    public static void main(String[] args) {
        Paciente paciente= null;
        String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        int opcion;

        do{
            opcion= menu();

            switch (opcion){
                case 1:
                    paciente = crearPaciente();
                    break;
                case 2:
                    if(paciente==null){
                        System.out.println("***Por favor Ingrese Datos del Paciente***");
                    } else {
                        System.out.println("--------------------");
                        System.out.println("DATOS DEL PACIENTE");
                        System.out.println("--------------------");
                        System.out.println("RUT del Paciente: " + paciente.getRut());
                        System.out.println("Nombre del Paciente: " + paciente.getNombre());
                        System.out.println("Edad del Paciente: " + paciente.getEdad());
                        System.out.println("Sexo del Paciente: " + paciente.getSexo());
                        System.out.println("Estatura del Paciente:. " + paciente.getEstatura());
                        System.out.println();
                        System.out.println("-----------------------");
                        System.out.println("PESOS OBTENIDOS POR MES");
                        System.out.println("-----------------------");
                        for (int i = 0; i < paciente.getPesoMensual().length; i++) {
                            System.out.println(nombresMeses[i] + ": " + paciente.getPesoMensual()[i] + "Kg");
                        }
                    }
                    break;
                case 3:
                    if(paciente==null){
                        System.out.println("***Por favor Ingrese Datos del Paciente***");
                    } else {
                        System.out.println("----------------------------------------------");
                        System.out.println("MES EN EL QUE EL PACIENTE OBTUVO EL MENOR PESO");
                        System.out.println("----------------------------------------------");
                        System.out.println("Mes: "+ paciente.menorPesoMensual());
                    }
                    break;
                case 4:
                    if(paciente==null){
                        System.out.println("***Por favor Ingrese Datos del Paciente***");
                    } else {
                        int x;
                        do {
                            System.out.println("-----------------------------------------------");
                            System.out.println("MESES EN LOS QUE EL PACIENTE PESÓ MENOS DE X KG");
                            System.out.println("-----------------------------------------------");
                            System.out.println("Ingrese el peso");
                            x = Leer.datoInt();
                        } while (x < 90 || x > 100);

                        String[] meses = paciente.menosDeXKilos(x);
                        if (meses == null) {
                            System.out.println("**El paciente nunca pesó menos de " + x + "Kg**");
                        } else {
                            System.out.println(" ");
                            System.out.println("**El paciente pesó menos de " + x + "Kg en los meses:** ");
                            System.out.println(" ");
                            for (String mes : meses) {
                                System.out.println(mes + " ");
                            }
                        }
                    }
                    break;
                case 5:
                    if(paciente==null){
                        System.out.println("***Por favor Ingrese Datos del Paciente***");
                    } else {
                        int mes;
                        do{
                            System.out.println("**Ingrese el Mes a Consultar (Entre 1 y 12)**");
                            mes= Leer.datoInt();
                        }while(mes <1 || mes>12);

                        System.out.println("--------------------");
                        System.out.println("ESTADO DEL PACIENTE");
                        System.out.println("--------------------");
                        System.out.println("---> IMC "+ nombresMeses[mes - 1]+"= " + paciente.indiceMasaCorporal(mes, paciente.getEstatura()));
                        System.out.println(" ");
                        System.out.println("---> El ESTADO del Paciente corresponde a: "+ "**"+paciente.pesoMesX(mes, paciente.getEstatura())+"**");
                    }
                    break;
            }

        }while(opcion != 6);

    }

    public static int menu(){
        System.out.println("-------------------------------------");
        System.out.println("SISTEMA DE REGISTRO Y CONTROL DE PESO");
        System.out.println("       CLINICA CONTIGO APRENDO       ");
        System.out.println("-------------------------------------");
        System.out.println("1.) Ingresar datos del Paciente") ;
        System.out.println("2.) Datos del Paciente");
        System.out.println("3.) Mes con menor peso del Paciente");
        System.out.println("4.) Meses en los que el paciente pesó menos de X Kilos");
        System.out.println("5.) Estado del paciente en el mes de Noviembre (Normal, Sobrepeso, Obeso)");
        System.out.println("6.) Salir del Sistema");
        return Leer.datoInt();
    }

    public static Paciente crearPaciente() {
        System.out.println("***Por favor Ingrese los datos que se solicitan a continuación:***");
        System.out.println(" ");
        System.out.println("**Rut del Paciente**");
        String rut = Leer.dato();

        String nombre;
        String[] datosNombre = null;
        do {
            System.out.println("**Nombre del Paciente (Nombre y Apellido)**");
            nombre= Leer.dato();
            datosNombre = nombre.split(" ");
        } while (datosNombre.length != 2);

        int edad;
        do {
            System.out.println("**Edad del Paciente**");
            edad = Leer.datoInt();
        } while (edad < 12 || edad > 80);

        char sexo;
        do{
            System.out.println("**Sexo del paciente (M:Masculino F:Femenino)**");
            sexo = Leer.datoChar();
            sexo = Character.toUpperCase(sexo);
        }  while (sexo != 'M' && sexo != 'F');

        double estatura;
        do {
            System.out.println("**Estatura del paciente en metros**");
            estatura = Leer.datoDouble();
        } while (estatura < 1.50 || estatura > 1.90);

        System.out.println(" ");
        System.out.println("****** Registro del paciente se realizó exitosamente ******");
        return new Paciente(rut,nombre,edad,sexo,estatura);

    }
}

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
                    System.out.println("RUT del Paciente: " + paciente.getRut());
                    System.out.println("Nombre del Paciente: " + paciente.getNombre());
                    System.out.println("Edad del Paciente: " + paciente.getEdad());
                    System.out.println("Sexo del Paciente: " + paciente.getSexo());
                    System.out.println("Estatura del Paciente:. "+ paciente.getEstatura());
                    System.out.println("-----Pesos obtenidos por mes-----");
                    for (int i = 0; i < paciente.getPesoMensual().length; i++) {
                        System.out.println("El peso obtenido en el mes de " + nombresMeses[i] + " es: " + paciente.getPesoMensual()[i] + "Kg");
                    }
                    break;
                case 2:
                    if(paciente==null){
                        System.out.println("Por favor Ingrese Datos del Paciente");
                    } else {
                        System.out.println("El mes en el que el paciente obtuvo el menor peso es: " + paciente.menorPesoMensual());
                    }
                    break;
                case 3:
                    if(paciente==null){
                        System.out.println("Por favor Ingrese Datos del Paciente");
                    } else {
                        int x;
                        do {
                            System.out.println("-----Meses en los que el paciente pesó menos de X Kg-----");
                            System.out.println("Ingrese el peso");
                            x = Leer.datoInt();
                        } while (x < 90 || x > 100);
                        String[] meses = paciente.menosDeXKilos(x);
                        if (meses == null) {
                            System.out.println("El paciente nunca pesó menos de " + x + "Kg.");
                        } else {
                            System.out.println("Los meses en los que el paciente pesó menos de " + x + "Kg son: ");
                            for (String mes : meses) {
                                System.out.print(mes + " ");
                            }
                        }
                    }
                    break;
                case 4:
                    if(paciente==null){
                        System.out.println("Por favor Ingrese Datos del Paciente");
                    } else {
                        int mes;
                        do{
                            System.out.println("-----Calculo del IMC del paciente-----");
                            System.out.println("Ingrese el Mes a Consultar (Entre 1 y 12)");
                            mes= Leer.datoInt();
                        }while(mes <1 || mes>12);

                        System.out.println("IMC para el mes de "+ nombresMeses[mes - 1]+ " es: "+ paciente.indiceMasaCorporal(mes, paciente.getEstatura()));
                        System.out.println("El estado del paciente para estos valores es: "+ paciente.pesoMesX(mes, paciente.getEstatura()));
                    }
                    break;
            }

        }while(opcion != 5);

    }

    public static int menu(){
        System.out.println("Bienvenido al Sistema de Registro de Peso de la Clinica Contigo Aprendo ");
        System.out.println("1.) Ingresar datos del Paciente") ;
        System.out.println("2.) Mes con menor peso del Paciente");
        System.out.println("3.) Meses en los que el paciente pesó menos de X Kilos");
        System.out.println("4.) Estado del paciente en el mes de Noviembre (Normal, Sobrepeso, Obeso");
        System.out.println("5.) Salir del Sistema");
        return Leer.datoInt();
    }

    public static Paciente crearPaciente() {
        System.out.println("Ingrese Rut del Paciente");
        String rut = Leer.dato();

        String nombre;
        String[] datosNombre = null;
        do {
            System.out.println("Ingrese el nombre del Paciente (Nombre y Apellido)");
            nombre= Leer.dato();
            datosNombre = nombre.split(" ");
        } while (datosNombre.length != 2);

        int edad;
        do {
            System.out.println("Ingrese la edad del Paciente");
            edad = Leer.datoInt();
        } while (edad < 12 || edad > 80);

        char sexo;
        do{
            System.out.println("Ingrese el sexo del paciente (M:Masculino F:Femenino");
            sexo = Leer.datoChar();
            sexo = Character.toUpperCase(sexo);
        }  while (sexo != 'M' && sexo != 'F');

        double estatura;
        do {
            System.out.println("Ingrese la estatura del paciente en metros (rango 1.50 a 1.90): ");
            estatura = Leer.datoDouble();
        } while (estatura < 1.50 || estatura > 1.90);

        System.out.println("Registro del paciente se realizó exitosamente");
        return new Paciente(rut,nombre,edad,sexo,estatura);

    }
}

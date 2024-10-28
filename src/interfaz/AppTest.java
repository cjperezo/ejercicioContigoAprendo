package interfaz;

import entidades.Paciente;

public class AppTest {
    public static void main(String[] args) {

        String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        //Creamos un objeto
        Paciente paciente = new Paciente("20-95860010-1", "Carlos Perez", 39, 'M', 1.78);

        //	2) Mostrar todos los atributos del paciente registrado (objeto).
        System.out.println("-----Registro de Pacientes-----");
        System.out.println("RUT del Paciente: " + paciente.getRut());
        System.out.println("Nombre del Paciente: " + paciente.getNombre());
        System.out.println("Edad del Paciente: " + paciente.getEdad());
        System.out.println("Sexo del Paciente: " + paciente.getSexo());
        System.out.println("Estatura del Paciente:. "+ paciente.getEstatura());

        //	3) Mostrar el mes con menor peso del paciente registrado (objeto).
        System.out.println("-----Pesos obtenidos por mes-----");

        for (int i = 0; i < paciente.getPesoMensual().length; i++) {
            System.out.println("El peso obtenido en el mes de " + nombresMeses[i] + " es: " + paciente.getPesoMensual()[i] + "Kg");
        }
        System.out.println("El mes en el que el paciente obtuvo el menor peso es: " + paciente.menorPesoMensual());

        /*	4) Solicitar el ingreso de un peso para comparar y si el método menosDeXKilos retorna valor distinto de null,
         mostrar array con los meses en que el paciente pesó menos kilos que los ingresados por el usuario,
         de lo contrario dar mensaje adecuado*/

        int x;
        do {
            System.out.println("-----Meses en los que el paciente pesó menos de X Kg-----");
            System.out.println("Ingrese el peso");
            x = Leer.datoInt();
        } while (x < 70 || x > 250);
        String[] meses = paciente.menosDeXKilos(x);
        if (meses == null) {
            System.out.println("El paciente nunca pesó menos de " + x + "Kg.");
        } else {
            System.out.print("Los meses en los que el paciente pesó menos de " + x + "Kg son: ");
            for (String mes : meses) {
                System.out.print(mes + " ");
            }
        }

        // 5) Dada la estatura, mostrar la condición del paciente en el mes de noviembre (normal, sobrepeso u obeso)

        int mes;
        do{
            System.out.println("-----Calculo del IMC del paciente-----");
            System.out.println("Ingrese el Mes a Consultar (Entre 1 y 12)");
            mes= Leer.datoInt();
        }while(mes <1 || mes>12);

        System.out.println("IMC para el mes de "+ nombresMeses[mes - 1]+ " es: "+ paciente.indiceMasaCorporal(mes, paciente.getEstatura()));
        System.out.println("El estado del paciente para estos valores es: "+ paciente.pesoMesX(mes, paciente.getEstatura()));
    }
}




package entidades;

public class Paciente {

    //Declarar Atributos

    private String rut;
    private String nombre;
    private int edad;
    private char sexo; //F para Femenino y M para Masculino
    private double estatura;
    private int[] pesoMensual;

    String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    //Constructores

    public Paciente() {
    }

    public Paciente(String rut, String nombre, int edad, char sexo, double estatura) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.estatura = estatura;
        this.pesoMensual = new int[12];

        for (int i = 0; i < pesoMensual.length; i++) {
            //Obtenemos el valor aleatorio de 70 a 250
            pesoMensual[i] = (int) (Math.random() * (100 - 90 + 1) + 90);
        }
    }

    //Accesadores y Mutadores

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public int[] getPesoMensual() {
        return pesoMensual;
    }

    public void setPesoMensual(int[] pesoMensual) {
        this.pesoMensual = pesoMensual;
    }

    // Método que retorna el mes en que el paciente pesó menos kilos
    public String menorPesoMensual() {
        int mesMenorPeso = 0;
        int menorPeso = pesoMensual[0];

        for (int i = 1; i < pesoMensual.length; i++) {
            if (pesoMensual[i] < menorPeso) {
                menorPeso = pesoMensual[i];
                mesMenorPeso = i;
            }
        }

        return nombresMeses[mesMenorPeso]; // Retornar el nombre del mes
    }

    // Método que retorna el índice de masa corporal para un mes x
    public double indiceMasaCorporal(int mes, double estatura) {

        int peso = pesoMensual[mes - 1];
        return peso / (estatura * estatura);
    }

    // Método que retorna los meses en que el paciente pesó menos de X kilos
    public String[] menosDeXKilos(int x) {
        int contador = 0;
        for (int peso : pesoMensual) {
            if (peso < x) {
                contador++;
            }
        }

        if (contador == 0) {
            return null;
        }

        String[] meses = new String[contador];
        int indice = 0;
        for (int i = 0; i < pesoMensual.length; i++) {
            if (pesoMensual[i] < x) {
                meses[indice++] = nombresMeses [i]; // Meses de Enero a Diciembre
            }
        }

        return meses;
    }

    // Método que retorna el estado del peso para un mes específico
    public String pesoMesX(int mes, double estatura) {
        double imc = indiceMasaCorporal(mes, estatura);

        if (imc >= 15 && imc < 20) {
            return "Normal";
        } else if (imc >= 20 && imc < 28) {
            return "Sobrepeso";
        } else if (imc >= 28) {
            return "Obeso";
        } else {
            return "IMC fuera de rango";
        }
    }

}


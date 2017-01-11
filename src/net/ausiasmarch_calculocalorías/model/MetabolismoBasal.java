package net.ausiasmarch_calculocalorías.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author a0y3770325h
 */
public class MetabolismoBasal {

    private String genero;
    private double peso;
    private int altura;
    private int edad;
    private String actividad;
    private String mensaje;
    private StringBuilder sb;

    private final String PUNTO = "\u2022";

    /**
     *
     * @param genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getActividad() {
        return actividad;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Valida las reglas que debe cumplir el calculo de calorias
     *
     * @return boolean
     */
    public boolean validate() {
        sb = new StringBuilder();

        if (peso <= 0) {
            sb.append(PUNTO + "El peso no puede ser menor o igual que 0\n");
        }

        if (altura <= 0) {
            sb.append(PUNTO + "La altura no puede ser menor o igual que 0\n");
        }

        if (edad <= 0) {
            sb.append(PUNTO + "La edad no puede ser menor o igual que 0\n");

        }
        mensaje = sb.toString();
        return mensaje.isEmpty();

    }

    /**
     * Calcula el metabolismoBasal
     *
     * @return
     */
    public double getMetabolismoBasal() {

        double TMB = (10 * peso) + (6.25 * altura) - (5 * edad);

        genero = genero.toUpperCase();

        switch (genero) {
            case "HOMBRE":
                TMB = TMB + 5;
                break;
            case "MUJER":
                TMB = TMB - 161;

        }
        return TMB;
    }

    public double getCaloriasMantenerPeso() {

        double calorias = 0;

        if (actividad.equals(TipoActividad.SEDENTARIA.toString())) {

            calorias = getMetabolismoBasal() * TipoActividad.SEDENTARIA.getValor();
        }
        if (actividad.equals(TipoActividad.LIGERA.toString())) {
            calorias = getMetabolismoBasal() * TipoActividad.LIGERA.getValor();
        }
        if (actividad.equals(TipoActividad.MODERADA.toString())) {
            calorias = getMetabolismoBasal() * TipoActividad.MODERADA.getValor();
        }
        if (actividad.equals(TipoActividad.INTENSA.toString())) {
            calorias = getMetabolismoBasal() * TipoActividad.INTENSA.getValor();
        }
        if (actividad.equals(TipoActividad.MUY_INTENSA.toString())) {
            calorias = getMetabolismoBasal() * TipoActividad.MUY_INTENSA.getValor();
        }
        return calorias;
    }

}

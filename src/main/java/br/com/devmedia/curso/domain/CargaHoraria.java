package br.com.devmedia.curso.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CargaHoraria {

    VINTE_HORAS("20HRS"), TRINTA_HORAS("30HRS"), QUARENTA_HORAS("40HRS"),SESSENTA_HORAS("60HRS");

    private String horas;

    CargaHoraria(String horas){
        this.horas = horas;
    }

    @JsonValue
    public String getHoras(){
        return horas;
    }
}

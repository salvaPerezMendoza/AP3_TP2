package edu.fiuba.algo3.modelo.Bonificadores;

import edu.fiuba.algo3.modelo.RespuestaPuntuada;

public class BonificadorConcreto implements Bonificador {
    public BonificadorConcreto() {

    }
    public RespuestaPuntuada modificarPuntaje(RespuestaPuntuada respuestaPuntuada){
        return respuestaPuntuada;
    }

    @Override
    public String getNombreBonificador() {
        return "Base";
    }
}
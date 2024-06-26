package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestaCorregida;

public interface TipoDePregunta {
    RespuestaCorregida corregirRespuesta(Respuesta respuestaJugador);
}

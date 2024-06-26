/*package edu.fiuba.algo3.entrega_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class OrderedChoiceTest {

    @Test
    public void Test01OrderedChoiceEsRespondidoCorrectamente(){
        RespuestaOrderedChoice respuestaCorrecta = new RespuestaOrderedChoice("Messi","Cristiano Ronaldo", "Neymar", "Lewandowski", "Suarez");
        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordenar los jugadores acorde a su posicion en la votacion Balon de Oro 2015", respuestaCorrecta);

        RespuestaOrderedChoice respuestaJugador = new RespuestaOrderedChoice("Messi","Cristiano Ronaldo", "Neymar", "Lewandowski", "Suarez");

        Assertions.assertEquals(1, pregunta.validarRespuesta(respuestaJugador));
    }

    @Test
    public void Test02OrderedChoiceEsRespondidoIncorrectamente(){
        RespuestaOrderedChoice respuestaCorrecta = new RespuestaOrderedChoice("Messi","Cristiano Ronaldo", "Neymar", "Lewandowski", "Suarez");
        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordenar los jugadores acorde a su posicion en la votacion Balon de Oro 2015", respuestaCorrecta);

        RespuestaOrderedChoice respuestaJugador = new RespuestaOrderedChoice("Cristiano Ronaldo","Messi","Neymar","Lewandowski","Suarez");

        Assertions.assertEquals(0, pregunta.validarRespuesta(respuestaJugador));
    }

}*/

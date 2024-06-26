/*package edu.fiuba.algo3.entrega_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupChoiceTest {

    @Test
    public void Test01GroupChoiceEsRespondidoCorrectamente(){
        Grupo grupoA = new Grupo("Animal", "Tigre", "Vaca", "Mono");
        Grupo grupoB = new Grupo("Insecto", "Mosquito", "Arania", "Abeja");

        RespuestaGroupChoice respuestaCorrecta = new RespuestaGroupChoice(grupoA, grupoB);
        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Agrupar las opciones en el grupo que corresponda", respuestaCorrecta);

        RespuestaGroupChoice respuestaJugador = new RespuestaGroupChoice();
        respuestaJugador.agregarElementoGrupoA("Tigre");
        respuestaJugador.agregarElementoGrupoA("Vaca");
        respuestaJugador.agregarElementoGrupoA("Mono");
        respuestaJugador.agregarElementoGrupoB("Mosquito");
        respuestaJugador.agregarElementoGrupoB("Arania");
        respuestaJugador.agregarElementoGrupoB("Abeja");

        Assertions.assertEquals(1, pregunta.validarRespuesta(respuestaJugador));

    }

    @Test
    public void Test02GroupChoiceEsRespondidoInorrectamente(){
        Grupo grupoA = new Grupo("Animal", "Tigre", "Vaca", "Mono");
        Grupo grupoB = new Grupo("Insecto", "Mosquito", "Arania", "Abeja");

        RespuestaGroupChoice respuestaCorrecta = new RespuestaGroupChoice(grupoA, grupoB);
        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Agrupar las opciones en el grupo que corresponda", respuestaCorrecta);

        RespuestaGroupChoice respuestaJugador = new RespuestaGroupChoice();
        respuestaJugador.agregarElementoGrupoA("Mosquito");
        respuestaJugador.agregarElementoGrupoA("Vaca");
        respuestaJugador.agregarElementoGrupoA("Mono");
        respuestaJugador.agregarElementoGrupoB("Tigre");
        respuestaJugador.agregarElementoGrupoB("Arania");
        respuestaJugador.agregarElementoGrupoB("Abeja");

        Assertions.assertEquals(0, pregunta.validarRespuesta(respuestaJugador));
    }
}*/

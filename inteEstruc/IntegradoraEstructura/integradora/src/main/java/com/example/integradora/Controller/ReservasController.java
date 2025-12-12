package com.example.integradora.Controller;

import com.example.integradora.dto.RespuestaRequest;
import com.example.integradora.service.Reservas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservasController {

    private final Reservas reservasService;

    public ReservasController(Reservas reservasService) {
        this.reservasService = reservasService;
    }

    @GetMapping("/book/{libroId}")
    public ResponseEntity<RespuestaRequest> ReservaEstado(
            @PathVariable   Integer libroId, //extrae el valor url
            @RequestParam(required = false) Integer UsuarioId) { //pasar datos pasdos a parametros consulta

        String resultMessage = reservasService.consultarReservas(libroId, UsuarioId);

        return new ResponseEntity<>(new RespuestaRequest("exito"+ resultMessage, null), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<RespuestaRequest> cancelarReserva(
            @RequestParam Integer usuarioId,//pasar datos pasdos a parametros consulta
            @RequestParam Integer libroId) {

        String resultMessage = reservasService.cancelarEliminarReserva(usuarioId, libroId);

        if (resultMessage.startsWith("error")) {
            return new ResponseEntity<>(new RespuestaRequest("error"+ resultMessage, null), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new RespuestaRequest( resultMessage, null), HttpStatus.OK);
    }
}

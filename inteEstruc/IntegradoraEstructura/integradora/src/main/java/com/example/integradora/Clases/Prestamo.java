package com.example.integradora.Clases;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prestamo {

    private Integer id;
    private Boolean estado;
    private Integer usuarioId;
    private Integer libroId;
    private String devolucion;


    public Prestamo(int id) {
        this.id = id;
    }
}

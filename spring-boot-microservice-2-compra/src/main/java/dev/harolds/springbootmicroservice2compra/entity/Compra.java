package dev.harolds.springbootmicroservice2compra.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "compra" )
public class Compra {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "user_id", nullable = false )
    private Long userId;

    @Column( name = "inmueble_id", nullable = false )
    private Long inmueble;

    @Column( name = "titulo", nullable = false )
    private String titulo;

    @Column( name = "precio", nullable = false )
    private Double precio;

    @Column( name= "fecha_compra", nullable = false)
    private LocalDateTime fechaCompra;
}
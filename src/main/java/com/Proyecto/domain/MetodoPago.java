package com.Proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "metodos_pago")
public class MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo_pago")
    private Long idMetodoPago;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "numero_tarjeta")
    private String numeroTarjeta;

    @Column(name = "fecha_vencimiento")
    private String fechaVencimiento;

    @Column(name = "codigo_verificacion")
    private Integer codigoVerificacion;

    @Column(name = "ruta_imagen_marca")
    private String rutaImagenMarca;

    // Constructores, getters y setters generados por Lombok
}

package cl.ahian.interside.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacciones")
public class Transaccion {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente")
    private Cliente idCliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto")
    private Producto idProducto;

    @Column(name = "movimiento")
    private Integer movimiento;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_transaccion", nullable = false)
    private Integer idTransaccion;

    public Transaccion(Cliente cliente, Producto producto, int monto) {
        this.idCliente = cliente;
        this.idProducto = producto;
        this.movimiento = monto;
        this.fecha = LocalDateTime.now();
    }

    public Transaccion() {
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Integer movimiento) {
        this.movimiento = movimiento;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

}
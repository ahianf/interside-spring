package cl.ahian.interside.entity;

public class Compra {

    private int idCliente;
    private int idProducto;

    public Compra(int idCliente, int idProducto) {
        this.idCliente = idCliente;
        this.idProducto = idProducto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "idCliente=" + idCliente +
                ", idProducto=" + idProducto +
                '}';
    }
}

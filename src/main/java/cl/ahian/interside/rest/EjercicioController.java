package cl.ahian.interside.rest;

import cl.ahian.interside.entity.*;
import cl.ahian.interside.repository.ClienteRepository;
import cl.ahian.interside.repository.ProductoRepository;
import cl.ahian.interside.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/test")
public class EjercicioController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;

    @PostMapping
    public void agregarSaldo() {
    }

    @GetMapping("transacciones")
    public List<Transaccion> obtenerTransacciones() {
        return transaccionRepository.findAll();
    }

    public void comprarProducto() {
    }

    public void editarCliente() {

    }

    @GetMapping("cliente")
    public List<Cliente> obtenerListaClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("cliente/{strId}")
    public Optional<Cliente> obtenerCliente(@PathVariable String strId) {
        Integer id = Integer.parseInt(strId);
        return clienteRepository.findById(id);
    }

    @PutMapping("cliente/{strId}")
    public void actualizarCliente(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @GetMapping("producto")
    public List<Producto> obtenerProducto() {
        return productoRepository.findAll();
    }

    @PostMapping("recarga")
    public void recarga(@RequestBody Recarga recarga) {
        int monto = recarga.getMonto();
        if (monto <= 0) {
            return;
        }
        Optional<Cliente> cliente = clienteRepository.findById(recarga.getId());
        if (cliente.isPresent()) {
            int saldoActual = cliente.get().getSaldo();
            cliente.get().setSaldo(saldoActual + monto);
            clienteRepository.save(cliente.get());
            Transaccion t = new Transaccion(cliente.get(), obtenerProducto().get(0), monto);
            transaccionRepository.save(t);

        }
    }

    @PostMapping("compra")
    public void compra(@RequestBody Compra compra) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(compra.getIdCliente());
        Optional<Producto> productoOptional = productoRepository.findById(compra.getIdProducto());
        if(clienteOptional.isEmpty() && productoOptional.isEmpty()){
            return;
        }
        var cliente = clienteOptional.get();
        var producto = productoOptional.get();

        int saldo = cliente.getSaldo();
        int remanente = saldo - Integer.parseInt(producto.getPrecio());
        if (remanente > 0){
            cliente.setSaldo(remanente);
            clienteRepository.save(cliente);
            Transaccion t = new Transaccion(cliente, producto, Integer.parseInt(producto.getPrecio()));
            transaccionRepository.save(t);
        }

    }
}

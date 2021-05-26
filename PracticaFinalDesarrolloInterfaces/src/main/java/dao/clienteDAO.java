package dao;

import constructores.Cliente;

import constructores.TipoDocumento;
import excepciones.ErrorCrearCliente;
import excepciones.ErrorFechaPedido;
import java.util.*;

public class clienteDAO implements DAO<Cliente> {

    List<Cliente> clientes;

    public clienteDAO() {
        clientes = new ArrayList<>();
        clientes.add(
                new Cliente.ClienteBuilder(1).setTipoDocumentationn(TipoDocumento.DNI).setDocumentation("475836485P").setNombre("Samuel").setApellido("Sierra").setTelefono("12345").setEmail("ssierra@gmail.com").setPassword("contraseña").build());
        clientes.add(new Cliente.ClienteBuilder(2).setTipoDocumentationn(TipoDocumento.DNI).setDocumentation("489345728P").setNombre("Luis").setApellido("Lopez").setTelefono("29374").setEmail("luislopez@gmail.com").setPassword("contraseña1234").build());
    }

    public List<Cliente> getAll() {
        return clientes;
    }

    public Cliente get(int cod_cliente) {
        return clientes.stream().filter(c -> c.getCod_cliente() == cod_cliente).findAny().orElse(null);
    }

    public void save(Cliente cliente) throws ErrorCrearCliente {

        if (clientes.stream().anyMatch(c -> c.getCod_cliente() == cliente.getCod_cliente())) {
            throw new ErrorCrearCliente("Codigo de cliente en uso. No se pudo agregar el cliente");
        } else if (clientes.stream().anyMatch(c -> c.getNombre().equals(cliente.getNombre())
                && c.getApellido().equals(cliente.getApellido()) && c.getTelefono().equals(cliente.getTelefono()))) {
            throw new ErrorCrearCliente("Dato duplicado. No se pudo agregar el cliente");
        } else {
            clientes.add(cliente);
        }
    }

    public void delete(int cod_cliente) {
        clientes.remove(clientes.stream().filter(c -> c.getCod_cliente() == cod_cliente).findAny().orElse(null));
    }
}

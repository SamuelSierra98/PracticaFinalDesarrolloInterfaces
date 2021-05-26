package dao;

import excepciones.ErrorCrearCliente;
import excepciones.ErrorFechaEntrega;
import excepciones.ErrorFechaPedido;
import java.util.*;

import excepciones.ErrorFechaEntrega;
import excepciones.ErrorFechaPedido;

public interface DAO<T> {

    List<T> getAll();

    T get(int cod);

    void save(T t) throws ErrorCrearCliente, ErrorFechaPedido, ErrorFechaEntrega;

    void delete(int cod);
}
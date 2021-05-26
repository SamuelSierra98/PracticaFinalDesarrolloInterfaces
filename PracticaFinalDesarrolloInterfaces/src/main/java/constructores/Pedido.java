package constructores;

import java.util.*;



public class Pedido {

    public static class PedidoBuilder {

        int cod_pedido, cod_cliente;
        Date fecha_creacion, fecha_entrega;

        public PedidoBuilder(int cod_pedido) {
            this.cod_pedido = cod_pedido;
        }

        public PedidoBuilder setCod_cliente(int cod_cliente) {
            this.cod_cliente = cod_cliente;
            return this;
        }

        public PedidoBuilder setFecha_creacion(Date fecha_creacion) {
            this.fecha_creacion = fecha_creacion;
            return this;
        }

        public PedidoBuilder setFecha_entrega(Date fecha_entrega) {
            this.fecha_entrega = fecha_entrega;
            return this;
        }

        public Pedido build() {
            Pedido pedido = new Pedido();

            pedido.cod_pedido = this.cod_pedido;
            pedido.cod_cliente = this.cod_cliente;
            pedido.fecha_creacion = this.fecha_creacion;
            pedido.fecha_entrega = this.fecha_entrega;

            return pedido;
        }
    }

    int cod_pedido, cod_cliente;
    Date fecha_creacion, fecha_entrega;

    public int getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String toString() {
        return "[Cod_pedido: " + cod_pedido + " cod_cliente: " + cod_cliente + " fecha_creacion: " + fecha_creacion
                + " fecha_entrega: " + fecha_entrega + "]";
    }
}

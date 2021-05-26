package aplicacion;

import java.util.*;

import dao.clienteDAO;
import dao.PedidoDAO;
import constructores.*;
import testing.Testing;
import excepciones.ClienteNoEncontrado;
import excepciones.ErrorCrearCliente;
import excepciones.ErrorFechaEntrega;
import excepciones.ErrorFechaPedido;

public class Main {

	private static PedidoDAO pd = new PedidoDAO();
	private static clienteDAO cd = new clienteDAO();
	final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ClienteNoEncontrado, ErrorFechaEntrega {
		//Menu
		while (true) {
			System.out.println("MENU");
			System.out.println("1. Visualizar clientes");
			System.out.println("2. Visualizar pedidos");
			System.out.println("3. Busqueda cliente");
			System.out.println("4. Busqueda pedido");
			System.out.println("5. Nuevo cliente");
			System.out.println("6. Nuevo pedido");
			System.out.println("7. Eliminar cliente");
			System.out.println("8. Eliminar pedido");

			int opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				mostrarClientes();
				break;

			case 2:
				mostrarPedidos();
				break;

			case 3:
				buscarCliente();
				break;

			case 4:
				buscarPedido();
				break;

			case 5:
				nuevoCliente();
				break;

			case 6:
				nuevoPedido();
				break;

			case 7:
				eliminarCliente();
				break;

			case 8:
				eliminarPedido();
				break;

			default:
				break;
			}
		}
	}
	
	//Metodo Mostrar clientes
	public static void mostrarClientes() {
		for (Cliente c : cd.getAll()) {
			System.out.println(c.toString());
		}
	}

	//Metodo Mostrar Pedidos
	public static void mostrarPedidos() {
		for (Pedido p : pd.getAll()) {
			System.out.println(p.toString());
		}
	}

	//Metodo Buscar Cliente
	public static void buscarCliente() {
		try {
			System.out.println("¿Codigo cliente?");
			Cliente cliente = cd.get(sc.nextInt());

			if (cliente != null) {
				System.out.println(cliente.toString());
			} else {
				throw new ClienteNoEncontrado("El cliente no ha sido encontrado en la base de datos");
			}
		} catch (ClienteNoEncontrado e) {
		}
	}

	//Metodo Buscar Pedido
	public static void buscarPedido() {
		System.out.println("¿Codigo pedido?");
		Pedido p = pd.get(sc.nextInt());
		if (p != null) {
			System.out.println(p.toString());
		} else {
			System.out.println("No existe el pedido");
		}
	}

	//Meotodo nuevo cliente
	public static void nuevoCliente() {
		try {
			System.out.println("Codigo cliente");
			int cod_cliente = sc.nextInt();
			sc.nextLine();

			System.out.println("Tipo de documentacion (1.DNI or 2.NIe)");
			int tipoDocumentacion = sc.nextInt();

			TipoDocumento t;

			if (tipoDocumentacion == 1) {
				t = TipoDocumento.DNI;
			} else {
				t = TipoDocumento.NIE;
			}

			sc.nextLine();

			System.out.println("Numero de identificacion");
			String documentacion = sc.nextLine();

			Testing.validarDocumento(t, documentacion);

			System.out.println("Nombre");
			String nombre = sc.nextLine();

			System.out.println("Apellido");
			String apellido = sc.nextLine();

			System.out.println("Telefono");
			String telefono = sc.nextLine();

			System.out.println("Email");
			String email = sc.nextLine();

			Testing.validarEmail(email);

			System.out.println("Password");
			String password = sc.nextLine();

			cd.save(new Cliente.ClienteBuilder(cod_cliente).setTipoDocumentationn(t).setDocumentation(documentacion)
					.setNombre(nombre).setApellido(apellido).setTelefono(telefono).setEmail(email).setPassword(password)
					.build());
		} catch (ErrorCrearCliente e) {
			e.printStackTrace();
		}
	}

	public static void nuevoPedido() {
		try {
			System.out.println("Codigo pedido");
			int cod_pedido = sc.nextInt();

			System.out.println("Codigo cliente");
			int cod_cliente = sc.nextInt();
			sc.nextLine();

			System.out.println("Fecha creacion (mm/dd/yyyy)");
			String fecha_creacion = sc.nextLine();

			System.out.println("Fecha entrega (mm/dd/yyyy)");
			String fecha_entrega = sc.nextLine();

			pd.save(new Pedido.PedidoBuilder(cod_pedido).setCod_cliente(cod_cliente)
					.setFecha_creacion(new Date(fecha_creacion)).setFecha_entrega(new Date(fecha_entrega)).build());
		} catch (ErrorFechaPedido e) {
			e.printStackTrace();
		} catch (ErrorFechaEntrega e) {
			e.printStackTrace();
		}
	}

	//Metodo eliminar cliente
	public static void eliminarCliente() {
		System.out.println("Codigo cliente");
		cd.delete(sc.nextInt());
	}

	//Metodo eliminar pedido
	public static void eliminarPedido() {
		System.out.println("Codigo pedido");
		pd.delete(sc.nextInt());
	}
}

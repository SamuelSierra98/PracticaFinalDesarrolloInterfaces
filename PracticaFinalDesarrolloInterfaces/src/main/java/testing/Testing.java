package testing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import excepciones.ErrorCrearCliente;
import constructores.TipoDocumento;

public class Testing {
	
	//Verificacion de documentacion y email
    public static void validarDocumento(TipoDocumento tipoDocumentacion, String documentacion) throws ErrorCrearCliente {
		if (tipoDocumentacion == TipoDocumento.DNI) {
			int caracterASCII = 0;
			if (documentacion.length() == 9 && Character.isLetter(documentacion.charAt(8))) {
				for (int i = 0; i < documentacion.length() - 1; i++) {
					caracterASCII = documentacion.charAt(i);
					if (caracterASCII > 47 && caracterASCII < 58) {
						//Correcto
					} else {
						throw new ErrorCrearCliente("El dni introducido es incorrecto");
					}
				}
			} else {
				throw new ErrorCrearCliente("El dni introducido es incorrecto");
			}
		} else {
			int caracterASCII = 0;
			if (documentacion.length() == 9 && Character.isLetter(documentacion.charAt(8))
					&& Character.isLetter(documentacion.charAt(0))) {
				for (int i = 1; i < documentacion.length() - 1; i++) {
					caracterASCII = documentacion.charAt(i);
					if (caracterASCII > 47 && caracterASCII < 58) {
						//Correcto
					} else {
						throw new ErrorCrearCliente("El nie introducido es incorrecto");
					}
				}
			} else {
				throw new ErrorCrearCliente("El nie introducido es incorrecto");
			}
		}
	}
    
    public static void validarEmail(String email) throws ErrorCrearCliente {
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);

		if (mather.find() == false) {
			throw new ErrorCrearCliente("El email introducido no es correcto");
		}
	}
}


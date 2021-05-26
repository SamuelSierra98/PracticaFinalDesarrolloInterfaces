package constructores;

public class Cliente {

    public static class ClienteBuilder {

        int cod_cliente;
        TipoDocumento tipoDocumentation;
        String documentation, nombre, apellido, telefono, email, password;

        public ClienteBuilder(int cod_cliente) {
            this.cod_cliente = cod_cliente;
        }

        public ClienteBuilder setTipoDocumentationn(TipoDocumento tipoDocumentation) {
            this.tipoDocumentation = tipoDocumentation;
            return this;
        }

        public ClienteBuilder setDocumentation(String documentation) {
            this.documentation = documentation;
            return this;
        }

        public ClienteBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public ClienteBuilder setApellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public ClienteBuilder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public ClienteBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public ClienteBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Cliente build() {
            Cliente cliente = new Cliente();

            cliente.cod_cliente = this.cod_cliente;
            cliente.tipoDocumentation = this.tipoDocumentation;
            cliente.documentation = this.documentation;
            cliente.nombre = this.nombre;
            cliente.apellido = this.apellido;
            cliente.telefono = this.telefono;
            cliente.email = this.email;
            cliente.password = this.password;

            return cliente;
        }
    }

    int cod_cliente;
    TipoDocumento tipoDocumentation;
    String documentation, nombre, apellido, telefono, email, password;

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public TipoDocumento getTipoDocumentation() {
        return tipoDocumentation;
    }

    public void setTipoDocumentationn(TipoDocumento tipoDocumentation) {
        this.tipoDocumentation = tipoDocumentation;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "[cod_cliente: " + cod_cliente + " tipoDocumentation: " + tipoDocumentation + " documentation: " + documentation + " nombre: " + nombre + " apellido: " + apellido + " telefono: "
                + telefono + " email: " + email + " password: " + password + "]";
    }
}
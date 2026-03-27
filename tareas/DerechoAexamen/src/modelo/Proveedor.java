package modelo;

public class Proveedor {

    public int id;
    public String codigo;
    public String nombre;
    public String contacto;
    public String telefono;
    public String correo;
    public String direccion;
    public String rfc;
    public String terminoPago;

    public Proveedor() {}

    public Proveedor(int id, String codigo, String nombre, String contacto,
                     String telefono, String correo, String direccion,
                     String rfc, String terminoPago) {

        this.id          = id;
        this.codigo      = codigo;
        this.nombre      = nombre;
        this.contacto    = contacto;
        this.telefono    = telefono;
        this.correo      = correo;
        this.direccion   = direccion;
        this.rfc         = rfc;
        this.terminoPago = terminoPago;
    }

    public int getId()            { return id; }
    public String getCodigo()     { return codigo; }
    public String getNombre()     { return nombre; }
    public String getContacto()   { return contacto; }
    public String getTelefono()   { return telefono; }
    public String getCorreo()     { return correo; }
    public String getDireccion()  { return direccion; }
    public String getRfc()        { return rfc; }
    public String getTerminoPago(){ return terminoPago; }

    public void setNombre(String nombre)         { this.nombre = nombre; }
    public void setContacto(String contacto)     { this.contacto = contacto; }
    public void setTelefono(String telefono)     { this.telefono = telefono; }
    public void setCorreo(String correo)         { this.correo = correo; }
    public void setDireccion(String direccion)   { this.direccion = direccion; }
    public void setRfc(String rfc)               { this.rfc = rfc; }
    public void setTerminoPago(String terminoPago){ this.terminoPago = terminoPago; }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
public class Contacto {
    private String Nombre;
    private String Numero;

    public Contacto(String Nombre, String Numero) {
        this.Nombre = Nombre;
        this.Numero = Numero; 
    }

    public String getNombre() {
        return Nombre;
    }

    public String getNumero() {
        return Numero;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacto otro = (Contacto) obj;
        return this.Nombre.equalsIgnoreCase(otro.Nombre);
    }

    @Override

    public String toString() {
        return "Contacto{nombre='" + Nombre + "', telefono='" + Numero + "'}";
    }
}

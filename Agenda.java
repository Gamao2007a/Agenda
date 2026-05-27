public class Agenda {
    private Contacto[] contactos;
    private int numContactos;

    public Agenda() {
        this(10);
    }

    public Agenda(int tamaño) {
        contactos = new Contacto[tamaño];
        numContactos = 0;
    }

    public boolean añadirContacto(Contacto c) {
        if (estaLlena()) {
            System.out.println("La agenda está llena. No se puede añadir más contactos.");
            return false;
        }
        if (existeContacto(c)) {
            System.out.println("Ya existe un contacto con el nombre '" + c.getNombre() + "'. No se puede duplicar.");
            return false;
        }
        contactos[numContactos] = c;
        numContactos++;
        System.out.println("Contacto '" + c.getNombre() + "' añadido correctamente.");
        return true;
    }

    public boolean existeContacto(Contacto c) {
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].equals(c)) {
                return true;
            }
        }
        return false;
    }

    public Contacto buscarContacto(String nombre) {
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto encontrado -> Nombre: " + contactos[i].getNombre()
                        + " | Número: " + contactos[i].getNumero());
                return contactos[i];
            }
        }
        System.out.println("No se encontró ningún contacto con el nombre '" + nombre + "'.");
        return null;
    }

    public boolean eliminarContacto(Contacto c) {
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].equals(c)) {
                for (int j = i; j < numContactos - 1; j++) {
                    contactos[j] = contactos[j + 1];
                }
                contactos[numContactos - 1] = null;
                numContactos--;
                System.out.println("Contacto '" + c.getNombre() + "' eliminado correctamente.");
                return true;
            }
        }
        System.out.println("No se encontró el contacto '" + c.getNombre() + "' para eliminar.");
        return false;
    }

    public boolean estaLlena() {
        return numContactos == contactos.length;
    }

    public int huecosDisponibles() {
        return contactos.length - numContactos;
    }

    public void listarAgenda() {
        if (numContactos == 0) {
            System.out.println("La agenda está vacía.");
            return;
        }
        System.out.println("AGENDA (" + numContactos + "/" + contactos.length + " contactos)");
        for (int i = 0; i < numContactos; i++) {
            System.out.println((i + 1) + ". " + contactos[i]);
        }
        System.out.println("--------------------------------");
    }
}
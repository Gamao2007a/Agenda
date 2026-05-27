import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = null;
        boolean ejecutando = true;

        System.out.println(" AGENDA TELEFÓNICA ");

        System.out.println("\n¿Cómo desea crear la agenda?");
        System.out.println("1. Tamaño por defecto (10)");
        System.out.println("2. Indicar tamaño");
        System.out.print("Opción: ");
        int opcionInicio = leerEntero(sc);

        if (opcionInicio == 2) {
            System.out.print("Introduzca el tamaño de la agenda: ");
            int tamaño = leerEntero(sc);
            agenda = new Agenda(tamaño);
            System.out.println("Agenda creada con tamaño " + tamaño + ".");
        } else {
            agenda = new Agenda();
            System.out.println("Agenda creada con tamaño por defecto (10).");
        }

        while (ejecutando) {
            System.out.println("\n MENÚ ");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Verificar si un contacto existe");
            System.out.println("3. Listar toda la agenda");
            System.out.println("4. Buscar contacto por nombre");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. ¿Está la agenda llena?");
            System.out.println("7. ¿Cuántos contactos más puedo meter?");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            int opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del contacto: ");
                    String nombre = sc.nextLine().trim();
                    System.out.print("Número del contacto: ");
                    String numero = sc.nextLine().trim();
                    Contacto nuevoContacto = new Contacto(nombre, numero);
                    agenda.añadirContacto(nuevoContacto);
                    break;

                case 2:
                    System.out.print("Nombre del contacto a verificar: ");
                    String nombreVerificar = sc.nextLine().trim();
                    Contacto contactoVerificar = new Contacto(nombreVerificar, "");
                    if (agenda.existeContacto(contactoVerificar)) {
                        System.out.println("El contacto '" + nombreVerificar + "' SÍ existe en la agenda.");
                    } else {
                        System.out.println("El contacto '" + nombreVerificar + "' NO existe en la agenda.");
                    }
                    break;

                case 3:
                    agenda.listarAgenda();
                    break;

                case 4:
                    System.out.print("Nombre a buscar: ");
                    String nombreBuscar = sc.nextLine().trim();
                    agenda.buscarContacto(nombreBuscar);
                    break;

                case 5:
                    System.out.print("Nombre del contacto a eliminar: ");
                    String nombreEliminar = sc.nextLine().trim();
                    System.out.print("Número del contacto a eliminar: ");
                    String numeroEliminar = sc.nextLine().trim();
                    Contacto contactoEliminar = new Contacto(nombreEliminar, numeroEliminar);
                    agenda.eliminarContacto(contactoEliminar);
                    break;

                case 6:
                    if (agenda.estaLlena()) {
                        System.out.println("La agenda está LLENA.");
                    } else {
                        System.out.println("La agenda NO está llena.");
                    }
                    break;

                case 7:
                    System.out.println("Puedes añadir " + agenda.huecosDisponibles() + " contacto(s) más.");
                    break;

                case 0:
                    System.out.println("¡Hasta luego!");
                    ejecutando = false;
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        sc.close();
    }

    private static int leerEntero(Scanner sc) {
        int valor = -1;
        try {
            valor = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida, se usará -1.");
        }
        return valor;
    }
}
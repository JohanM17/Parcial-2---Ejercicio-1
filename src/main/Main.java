package main;

import model.RutaBus;
import repository.RutaBusRepository;
import repository.RutaBusRepositoryImpl;
import service.RutaBusService;
import service.RutaBusServiceImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RutaBusRepository rutaBusRepository = new RutaBusRepositoryImpl();
        RutaBusService rutaBusService = new RutaBusServiceImpl(rutaBusRepository);

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n1. Agregar Ruta\n2. Ver Ruta\n3. Ver Todas las Rutas\n4. Actualizar Ruta\n5. Eliminar Ruta\n6. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre de la Ruta: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Cantidad de Pasajeros: ");
                    int pasajeros = scanner.nextInt();
                    rutaBusService.agregarRuta(new RutaBus(id, nombre, pasajeros));
                    break;

                case 2:
                    System.out.print("ID de la Ruta: ");
                    id = scanner.nextInt();
                    RutaBus ruta = rutaBusService.obtenerRuta(id);
                    System.out.println(ruta != null ? ruta : "Ruta no encontrada.");
                    break;

                case 3:
                    rutaBusService.obtenerTodasLasRutas().forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("ID de la Ruta a actualizar: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nuevo Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Nueva Cantidad de Pasajeros: ");
                    pasajeros = scanner.nextInt();
                    rutaBusService.actualizarRuta(new RutaBus(id, nombre, pasajeros));
                    break;

                case 5:
                    System.out.print("ID de la Ruta a eliminar: ");
                    id = scanner.nextInt();
                    rutaBusService.eliminarRuta(id);
                    break;

                case 6:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }
}

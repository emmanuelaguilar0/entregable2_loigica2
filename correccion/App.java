import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        ListaPedidos listaSimple = new ListaPedidos();
        ListaCircularPedidos listaCircular = new ListaCircularPedidos();
        ListaDoblePedidos listaDoble = new ListaDoblePedidos();

        System.out.println("Sistema de Inventarios de mi Casa");
        System.out.println("Productos Disponibles: ");
        inventario.mostrarInventario();

        while (true) {
            //Con sout se hace automaticamente
            System.out.println("1) Agregar un pedido.");
            System.out.println("2) Mostrar pedidos en Lista Simple");
            System.out.println("3) Mostrar pedidos en Lista Circular");
            System.out.println("4) Mostrar pedidos en Lista Doble (Adelante)");
            System.out.println("5) Mostrar pedidos en Lista Doble (Inversa)");
            System.out.println("6) Salir");
            System.out.println("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if(opcion == 6) {
                System.out.println("Saliendo del sistema, mucha suerte!");
                break;
            }
            switch (opcion) {
                case 1:
                   System.out.println("Ingresa el nombre del producto: "); 
                   String producto = scanner.nextLine();
                   System.out.println("Ingresa la cantidad: ");
                   int cantidad = scanner.nextInt();

                   int indiceproducto = inventario.buscarProducto(producto);
                   if (indiceproducto == -1) {
                    System.out.println("Producto no encontrado.");
                    continue;
                   }
                   if (!inventario.verificarStock(indiceproducto, cantidad)){
                    System.out.println("Stock insuficiente");
                    continue;
                   }
                   inventario.actualizarStock(indiceproducto, cantidad);
                   System.out.println("Selecciona la lista donde vas a agregar ese pedido");
                   System.out.println("1) Lista Simple");
                   System.out.println("2) Lista Circular");
                   System.out.println("3) Lista Doble");
                   int listaSeleccionada = scanner.nextInt();

                   switch (listaSeleccionada) {
                    case 1:
                        listaSimple.agregarPedido(producto, cantidad);
                        break;
                    case 2:
                    listaCircular.agregarPedido(producto, cantidad);
                        break;
                    case 3:
                    listaDoble.agregarPedido(producto, cantidad);
                        break;
                    default:
                        System.out.println("Opción no válida");
                   }

                   case 2:
                   System.out.println("Pedidos en lista simple: ");
                   listaSimple.mostrarPedido();
                   break;
               case 3:
                   System.out.println("Pedidos en lista circular: ");
                   listaCircular.mostrarPedidoCircular();
                   break;
               case 4:
                   System.out.println("Pedidos en lista doble(adelante): ");
                   listaDoble.mostrarPedidoAdelante();
                   break;
               case 5:
                   System.out.println("Pedidos en lista doble(atras): ");
                   listaDoble.mostrarPedidoAtras();
                   break;
               default:
                   System.out.println("Opción no válida");
               
           }

       }
       scanner.close();
   }
}

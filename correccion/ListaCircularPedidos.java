public class ListaCircularPedidos {
    private Pedido ultimo;

    public void agregarPedido(String producto, int cantidad){
        Pedido nuevo = new Pedido(producto, cantidad, null, null);

        if (ultimo == null ) {
            ultimo = nuevo;
            ultimo.siguiente = ultimo;            
        } else {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    public void mostrarPedidoCircular(){
        if (ultimo == null){
            System.out.println("Ups! Aún no hay pedidos");
        return;
        }
        Pedido temp = ultimo.siguiente;
        do {
            System.out.println("Pedido circular: " + temp.producto + " Cantidad: " + temp.cantidad);
            temp = temp.siguiente;
        } while (temp != ultimo.siguiente);
    }
}

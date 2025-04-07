public class ListaDoblePedidos {
    private Pedido cabeza;
    private Pedido cola;
    public void agregarPedido(String producto, int cantidad){
        Pedido nuevo = new Pedido(producto, cantidad, null, null);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    public void mostrarPedidoAdelante(){
        Pedido temp = cabeza;
        while (temp != null) {
            System.out.println("Pedido Doble: " + temp.producto + " Cantidad: " + temp.cantidad);
            temp = temp.siguiente;
        }
    }

    public void mostrarPedidoAtras(){
        Pedido temp = cola;
        while (temp != null) {
            System.out.println("Pedido Doble (Reversa): " + temp.producto + " Cantidad: " + temp.cantidad);
            temp = temp.anterior;
        }
    }
}


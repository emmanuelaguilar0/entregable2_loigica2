public class Inventario {
    private String[] productos = {"Laptop", "Mouse", "Teclado", "Monitor", "Impresora"};
    private double[][] stockPrecio = {
        {10, 500000}, 
        {15, 50000},
        {12, 80000},  
        {8, 200000}, 
        {2, 150000}, 
    };

    public void mostrarInventario(){
        System.out.println("Inventario de Productos");
        for (int i = 0; i < productos.length; i++) {
            System.out.println("Producto: "+ productos[i]+ " Stock"+ stockPrecio[i][0] + " Precio: "+ stockPrecio[i][1]);
            
        }
    }

    public int buscarProducto(String nombre){
        for (int index = 0; index < productos.length; index++) {
            if (productos[index].equalsIgnoreCase(nombre)) {
                return index;
            }
            
        }
        return -1;
    }

    public boolean verificarStock(int indice, int cantidad) {
        return stockPrecio[indice][0] >= cantidad;
    }

    public void actualizarStock(int indice, int cantidad){
        stockPrecio[indice][0] -= cantidad;
    }

}

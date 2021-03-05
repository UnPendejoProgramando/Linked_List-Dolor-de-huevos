import javax.swing.JOptionPane;

public class Lista {

    private Nodo inicio;

    private int tam;

    public void Lista(){
        inicio = null;
        tam = 0;
    }
   
    public boolean Vacia(){
        return inicio == null;
    }
   
    public boolean tamFull(){
        return tam == 10;
    }
    
    public void addAtEnd(int valor){
        // Define un nuevo nodo.
        Nodo nuevo = new Nodo();
        // Agrega al valor al nodo.
        nuevo.setValor(valor);
        // Consulta si la lista esta vacia.
        if (Vacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = nuevo;
        // Caso contrario recorre la lista hasta llegar al ultimo nodo
        //y agrega el nuevo.
        } else{
            // Crea ua copia de la lista.
            Nodo aux = inicio;
            // Recorre la lista hasta llegar al ultimo nodo.
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            // Agrega el nuevo nodo al final de la lista.
            aux.setSiguiente(nuevo);
        }
        tam++;
    }
  
    public void addAtFront(int valor){
        // Define un nuevo nodo
        Nodo nuevo = new Nodo();
        // Agrega al valor al nodo
        nuevo.setValor(valor);
        // Consulta si la lista esta vacia
        if (Vacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo
            inicio = nuevo;
         // Caso contrario va agregando los nodos al inicio de la lista
        } else {
            // Une el nuevo nodo con la lista existente
            nuevo.setSiguiente(inicio);
            // Renombra al nuevo nodo como el inicio de la lista
            inicio = nuevo;
        }
        tam++;
     
    }
    public void addNextTo(int referencia, int valor){
        //se crea un nuevo nodo
        Nodo nuevo = new Nodo();
        //se agrega un valor al nodo
        nuevo.setValor(valor);
        //verifica si la lista esta llena
        if (!Vacia()) {
            // Consulta si el valor existe en la lista
            if (buscar(referencia)) {
                // Crea ua copia de la lista
                Nodo aux = inicio;
                // Recorre la lista hasta llegar al nodo de referencia
                while (aux.getValor() != referencia) {
                    aux = aux.getSiguiente();
                }
                // Crea un respaldo de la continuación de la lista
                Nodo siguiente = aux.getSiguiente();
                // Enlaza el nuevo nodo despues del nodo de referencia
                aux.setSiguiente(nuevo);
                // Une la continuacion de la lista al nuevo nodo
                nuevo.setSiguiente(siguiente);
                tam++;
            }
        }
    }
    
   
    public boolean buscar(int referencia){
        //se crea una copia de la lista
        Nodo aux = inicio;
        //bandera para saber si el valor existe
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta 
        // llegar al final de la lista.
        while(aux != null && encontrado != true){
            // Consulta si el valor del nodo es igual al de referencia.
            if (referencia == aux.getValor()){
                //cambia el valor de la bandera
                encontrado = true;
            }
            else {
                //avanza al siguiente nodo
                aux = aux.getSiguiente();
            }
        }
        return encontrado;
    }


    public void removerPorReferencia(int referencia){
       // Consulta si el valor de referencia existe en la lista
       if (buscar(referencia)) {
        // Consulta si el nodo a eliminar es el pirmero
        if (inicio.getValor() == referencia) {
            // El primer nodo apunta al siguiente
            inicio = inicio.getSiguiente();
        } else{
            // Crea ua copia de la lista
            Nodo aux = inicio;
            // Recorre la lista hasta llegar al nodo anterior 
            // al de referencia
            while(aux.getSiguiente().getValor() != referencia){
                aux = aux.getSiguiente();
            }
            // Guarda el nodo siguiente del nodo a eliminar
            Nodo siguiente = aux.getSiguiente().getSiguiente();
            // Enlaza el nodo anterior al de eliminar con el 
            // sguiente despues de el
            aux.setSiguiente(siguiente);  
        }
        // Disminuye el contador de tamaño de la lista
        tam--;
    }
    }

    public void removeEnd(){
        //crea una copia de la lista
        Nodo segundo = inicio;
        //recorre toda la lista
        while(segundo.getSiguiente().getSiguiente() != null){
            //iguala la lista secundaria al valor siguiente de la lista y elimina el ultimo valor
            segundo = segundo.getSiguiente();
        }
        //se borra toda la lista secundaria
        segundo.setSiguiente(null);
    
        
    }
    public void eliminar(){
        inicio = null;
        tam = 0;
    }

    public void listar(){
        //Verifica si hay valores en la lista
        if (!Vacia()) {
            //crea una copia de la lista
            Nodo aux = inicio;
            //recorre la lista hasta el final
            String listaaa = "";
            while(aux != null){
                //System.out.print(aux.getValor() + "" + " --> ");
                //agrega los resultados a la variable listaaa
                listaaa += aux.getValor() + "" + " --> ";
                //avanza al siguiente nodo
                aux = aux.getSiguiente();
            }
            //imprime la lista completa
            JOptionPane.showMessageDialog(null, listaaa, "Lista", 1);
        }
    }
}

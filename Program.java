import javax.swing.JOptionPane;

public class Program {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();
        
        lista.addAtFront(4);
        lista.addAtFront(5);
        lista.addAtEnd(1);
        lista.addAtEnd(2);
        lista.addAtEnd(3);
        lista.addAtFront(6);
        

        lista.listar();
        lista.removeEnd();
        lista.listar();
        JOptionPane.showMessageDialog(null, "AGREGAR DESPUES DE UN VALOR ESPECIFICO");
        lista.addNextTo(5, 16);
        lista.listar();

        
        
        JOptionPane.showMessageDialog(null, "ELIMINAR VALOR ESPECIFICO");
        lista.removerPorReferencia(4);  
        lista.listar();
        
        JOptionPane.showMessageDialog(null, "Lista Eliminada" ,"ELIMINAR LA LISTA", 1);
        lista.eliminar();
        
        JOptionPane.showMessageDialog(null, lista.Vacia(), "La lista esta vacia?", 1);
    }   
}

import javax.swing.*;

public class Lista {
    public Nodo ini;
    public int tam;

    public Lista() {
        ini=null;
         tam=0;
    }

    public void mostrarLista(JTextArea txtCont){
        if(ini==null){
            txtCont.setText("Lista Vacia");
        }else{
            StringBuilder listaStr = new StringBuilder();
            Nodo actual=ini;

            while(actual!=null){
                listaStr.append(actual.dato)
                        .append("\n");
                actual=actual.sig;
            }
            txtCont.setText(listaStr.toString());
        }
    }

    public void actualizarContenedor(JTextArea txtCont){
        mostrarLista(txtCont);
    }

    public void ordenarBurbuja (JTextArea txtCont){
        if(ini==null || ini.sig==null){
            return;
        }
        boolean burbujear;
        do {
            burbujear=false;
            Nodo actual=ini;
            Nodo sig=ini.sig;

            while (sig!=null){
                if(actual.dato>sig.dato){
                    int temp=actual.dato;

                    actual.dato=sig.dato;
                    sig.dato=temp;
                    burbujear=true;
                }
                actual=sig;
                sig=sig.sig;
            }
        }while (burbujear);
        actualizarContenedor(txtCont);
    }

    public int [] convertirAarray(){
        int [] array=new int[tam];
        Nodo actual=ini;
        int i=0;
        while(actual!=null){
            array[i++]=actual.dato;
            actual=actual.sig;
        }
        return array;
    }

    public void agregar(int dato, JTextArea txtCont){
        Nodo nuevoNodo=new Nodo(dato);
        if(ini==null){
            ini=nuevoNodo;
        }else {
            Nodo actual=ini;

            while(actual.sig!=null){
                actual=actual.sig;
            }
            actual.sig=nuevoNodo;
        }
        tam++;
        actualizarContenedor(txtCont);

    }

    public boolean eliminar(int dato, JTextArea txtCont){
        if(ini==null){
            JOptionPane.showMessageDialog(null,"Lista Vacia");
            return false;
        }
        if(ini.dato==dato){
            ini=ini.sig;
            tam--;
            actualizarContenedor(txtCont);
            return true;
        }
        Nodo actual=ini;
        while(actual.sig!=null && actual.sig.dato!=dato){
            actual=actual.sig;
        }
        if(actual.sig!=null){
            actual.sig=actual.sig.sig;
            tam--;
            actualizarContenedor(txtCont);
            return true;
        }
        JOptionPane.showMessageDialog(null,"Elemento no encontrado");
        return false;
    }

    public int busquedaLineal(int dato, JTextArea txtCont){
        Nodo actual=ini;
        int posicion=0;
        while(actual!=null){
            if(actual.dato==dato){
                return posicion;
            }
            actual=actual.sig;
            posicion++;
        }
        return -1;
    }

    public int buscarInterpolada(int dato, JTextArea txtCont){
        ordenarBurbuja(txtCont);
        int []array=convertirAarray();
        int inicio=0, fin= tam-1;
        while (inicio<=fin && dato>=array[inicio] && dato<=array[fin]){
            int pos=inicio+((dato-array[inicio])*(fin-inicio)/(array[fin]-array[inicio]));

            if (array [pos] == dato ) {
                return pos;
            }
            if (array[pos] < dato) {
                inicio = pos + 1;
            }else {
                fin = pos - 1;
            }
        }
        return -1;
    }

    public int buscarBinaria(int valor, JTextArea txtCont) {
        ordenarBurbuja(txtCont);
        int []array=convertirAarray();
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (array[medio] == valor) {
                return medio;
            } else if (array[medio] < valor) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

}

public class Invertido {

    public static void main(String[] args) {
       String cadenaInv= reverse("hola mundo");
        System.out.println(cadenaInv);
        cadenaInv=reverse("Primer Punto del Taller Final");
        System.out.println(cadenaInv);
    }

    /**
     *
     *Escribe el código que devuelva una cadena al revés. Por ejemplo,
     * la cadena "hola mundo", debe retornar "odnum aloh".
     */
    public static String reverse(String texto){
        String cadenaInvertida="";
        for(int i=texto.length()-1;i>=0;i--){
            cadenaInvertida+=texto.charAt(i);
        }
        return cadenaInvertida;
    }
}

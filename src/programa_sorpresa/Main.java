package programa_sorpresa;

import java.io.*;
import java.util.ArrayList;

public class Main {
    /**
     * Este programa extrae información de los usuarios de un archivo.txt
     * Crea objetos del tipo usuario con esta información y los almacena en un ArrayList.
     * Por último los ordena según su salario y los imprime en un archivo_ordenado.txt.
     *
     */

    static ArrayList<Usuario> usuarios=new ArrayList<>();

    public static void main(String[] args) {

        byte[] contenidoBytes=extraerContenidoTxt(); //Leo todo el contenido    y lo convierto a String
        String contenido=castearContenido(contenidoBytes);
        String[] contenidoArray=contenido.split("\\.");  //Separo el contenido por "." para manejar toda la información como Array.
        agregarUsuarios(contenidoArray); //Creo y agrego los usuarios a mi arrayList.
        usuarios=ordenarUsuarios(usuarios);//Ordenamos a los usuarios de menor a mayor según su salario.
        imprimirUsuariosOrdenadosTxt(usuarios); //generamos una copia en formato txt con los usuarios ordenados.
    }
    public static byte[] extraerContenidoTxt(){
        InputStream fichero;
        byte[] datos=null;
        try {
            fichero = new FileInputStream("C:\\Users\\Camilo\\Desktop\\archivo.txt");
            datos=fichero.readAllBytes();
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer bien el archico archivo.txt, favor verificar la ruta del archivo.");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("No se puede interpretar en bytes el archivo.txt");
            throw new RuntimeException(e);
        }
        return datos;
    }
    public static String castearContenido(byte[] contenidoBytes){
        String concatenador="";
        for(byte caracter:contenidoBytes){
            concatenador+=(char)caracter;
        }
        return concatenador;
    }
    public static void agregarUsuarios(String[] contenidoArray){
        //Ahora creo los objetos del tipo usuario para almacenarlos en mi ArrayList.
        for(int i=0;i<contenidoArray.length;i+=4){
            Usuario usuario=new Usuario(contenidoArray[i],contenidoArray[i+1],contenidoArray[i+2],Double.parseDouble(contenidoArray[i+3]));
            usuarios.add(usuario);
        }

    }

    public static ArrayList<Usuario> ordenarUsuarios(ArrayList<Usuario> usuarios){

        for(int i=0;i<usuarios.size();i++){
            int k=i;
            for(int j=i+1;j< usuarios.size();j++){
                if(usuarios.get(j).getSueldo()<usuarios.get(k).getSueldo()){
                    k=j;
                }
            }
            //Ahora intercambiamos los usuarios.
            Usuario aux=usuarios.get(i);
//

            usuarios.add(i,usuarios.get(k));
            usuarios.remove(i+1); //Libero espacio en memoria.

            usuarios.add(k,aux);
            usuarios.remove(k+1); //Libero espacio en memoria


        }
        return usuarios;
    }
    public static void imprimirUsuariosOrdenadosTxt(ArrayList<Usuario> usuarios){
        PrintStream info;
        String concatenador="";
        for(Usuario usuario:usuarios){
            concatenador+=usuario.toString();
        }
        byte[] informacion=concatenador.getBytes();

        try {
            info=new PrintStream("C:\\Users\\Camilo\\Desktop\\archivo_ordenado.txt");
            info.write(informacion);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }





}

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Numerales {
    public static void main(String[] args) {
    //1. Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores.
        System.out.println("********** Primer Punto **********");
        String[] arrayUni={"Juan","Camilo","Paredes","Zamora"};
        for(String item:arrayUni){
            System.out.println(item);
        }


    //2. Crea un array bidimensional de enteros y recórrelo, mostrando la posición y el valor
    // de cada elemento en ambas dimensiones.
        System.out.println("********** Segundo Punto **********");
        int[][] arrayBidi=new int[3][2];
        arrayBidi[0][0]=1;
        arrayBidi[0][1]=2;

        arrayBidi[1][0]=11;
        arrayBidi[1][1]=22;

        arrayBidi[2][0]=111;
        arrayBidi[2][1]=222;

        for(int i=0;i<arrayBidi.length;i++){ //Iterando las filas
            for(int j=0;j<arrayBidi[i].length;j++){ //Iterando las columnas.
                System.out.println("Fila: "+i+" Columna: "+j+" Valor: "+arrayBidi[i][j]+"  =>  "+"["+i+"]"+"["+j+"]"+"="+arrayBidi[i][j]);
            }
        }
        //3. Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos.
        // Elimina el 2o y 3er elemento y muestra el resultado final..
        System.out.println("********** Tercer Punto **********");
        Vector<Double> notas=new Vector();
        notas.add(4.1);
        notas.add(3.7);
        notas.add(2.3);
        notas.add(4.3);
        notas.add(3.5);

        notas.remove(1); //Índice 1 es el segundo elemento del vector
        notas.remove(2); //Índice 2 es el tercer elemento del vector.
        System.out.println(notas);

        //4. Indica cuál es el problema de utilizar un Vector con la capacidad por defecto
        // si tuviésemos 1000 elementos para ser añadidos al mismo.

        /**
         * R/ La capacidad por defecto de un vector es de 10, con incrementos de 10 en 10; cada vez que rebaso la capacidad
         * del vector se crea un nuevo array internamente que copia los datos del anterior vector en un nuevo array de una
         * capacidad mayor para así generar el nuevo vector; el problema es que este proceso es muy costoso computcionlmente
         * y más con un número de elementos
         * tan grande como 1000. Se realizaría 100 veces el proceso de copia de los arrays si dejamos
         * al vector con sus inicializaciones por defecto, lo que puede hacer muy lento nuestro
         * programa o aplicación innecesariamente. Para evitar este tipo de contratiempos, lo ideal sería directamente inicializar
         * el vector con el número de datos que sabemos que contendrá, que para el caso es de 1000 elementos. Y quizá
         * también modificar el incremento a 100, para que cada vez que sea necesario incrementar la capacidad del
         * vector tengamos 100 posiciones más en memoria que podemos utilizar antes de un nuevo incremento.
         *
         */

         //5. Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList.
        // Recorre ambos mostrando únicamente el valor de cada elemento.
        System.out.println("********** Quinto Punto **********");
        ArrayList<String> usuarios= new ArrayList<>();
        usuarios.add("Myriam");
        usuarios.add("Tulio");
        usuarios.add("Martha");
        usuarios.add("Amparo");

        LinkedList<String> usuariosEnlazados=new LinkedList<String>(usuarios);
        for(int i=0;i<usuarios.size();i++){
            System.out.println(usuarios.get(i));
            System.out.println(usuariosEnlazados.get(i));
        }

        //6. Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10.
        // A continuación, con otro bucle, recórrelo y elimina los numeros pares.
        // Por último, vuelve a recorrerlo y muestra el ArrayList final. Si te atreves,
        // puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.

        System.out.println("********** Sexto Punto **********");
        ArrayList<Integer>numeros=new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            numeros.add(i+1);
        }

        for(int i=0;i< numeros.size();i++){
            if(numeros.get(i) % 2==0){
                numeros.remove(numeros.get(i));
            }
        }

        for(Integer numero:numeros){
            System.out.println(numero);
        }

        //Me animo a hacerlo en menos pasos...
        ArrayList<Integer>numerosOptimizado=new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            if(i%2==0){
                numerosOptimizado.add(i+1);
            }
        }
        System.out.println(numerosOptimizado);


        //7. Crea una función DividePorCero. Esta, debe generar una excepción ("throws") a su llamante del tipo
        // ArithmeticException que será capturada por su llamante (desde "main", por ejemplo).
        // Si se dispara la excepción, mostraremos el mensaje "Esto no puede hacerse".
        // Finalmente, mostraremos en cualquier caso: "Demo de código".

        System.out.println("********** Séptimo Punto **********");
        try{
            int resultado=dividePorCero(30,6);
            System.out.println("El resultado es: "+resultado);
        }catch (ArithmeticException e){
            System.out.println("Esto no puede hacerse");
        }finally{
            System.out.println("Demo de código");
            System.out.println("\n");
        }
        try{
            int resultado=dividePorCero(30,0);
            System.out.println("El resultado es: "+resultado);
        }catch (ArithmeticException e){
            System.out.println("Esto no puede hacerse");
        }finally{
            System.out.println("Demo de código");
        }

        //8. Utilizando InputStream y PrintStream,
        // crea una función que reciba dos parámetros: "fileIn" y "fileOut".
        // La tarea de la función será realizar la copia del fichero
        // dado en el parámetro "fileIn" al fichero dado en "fileOut".
        System.out.println("********** Octavo Punto **********");
        try {
            /**
             * Modificar la ruta del archico NotasJava.txt a conveniencia,
             * el archivo se anexa en la carpera src del código.
             */
            InputStream fileIn=new FileInputStream("C:\\Users\\Camilo\\Desktop\\NotasJava.txt");
            PrintStream fileOut=new PrintStream("C:\\Users\\Camilo\\Desktop\\NotasJavaCopiaRespaldo.txt");
            realizarCopia(fileIn,fileOut);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("********** El programa del punto 9 mirarlo en el paquete programa_sorpresa **********");
        System.out.println("Utiliza algo de POO por lo que son varios archivos y por orden los puse todos en este paquete.");

    }


    //Esta función es para el Séptimo punto (PUNTO 7).
    public static int dividePorCero(int a,int b) throws ArithmeticException{
        int resultado=0;
        try{
            resultado=a/b;

        }catch(Exception e){
            throw new ArithmeticException();
        }
        return resultado;
    }

    //Esta función es para el Octavo punto (PUNTO 8).
    public static void realizarCopia(InputStream fileIn, PrintStream fileOut){
        try {
            byte[] datos=fileIn.readAllBytes(); //Copia todos los bytes del archivo.
            fileOut.write(datos); //Copio los datos en el otro archivo
            System.out.println("Archivo copiado correctamente.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}

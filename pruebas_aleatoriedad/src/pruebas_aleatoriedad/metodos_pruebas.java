/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas_aleatoriedad;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author DELL
 */
public class metodos_pruebas {

    public static void prueba_Series(ArrayList<Double> n_pseudoaleatorios) {
        //ArrayList<Double> n = new ArrayList<>();

        System.out.println("\n*****Prueba de Series*****");
        int N = n_pseudoaleatorios.size();
        int n = 5;
        int pareja = N - 1;

        double x[] = new double[pareja];
        double y[] = new double[pareja];
        int aux = 0, aux2 = 0;

        for (int i = 0; i < pareja; i++) {
            x[i] = n_pseudoaleatorios.get(i);
            y[i] = n_pseudoaleatorios.get(i + 1);
        }

        int subintervalos = (int) Math.pow(n, 2);
        double cont[] = new double[subintervalos];
        int x1 = 0;
        int xx = 0;
        for (double i = 0; i < n; i++) {
            for (double k = 0; k < n; k++) {
                for (int j = 0; j < x.length; j++) {
                    if (x[j] < ((i + 1) / n) && y[j] < ((k + 1) / n) && x[j] >= (i / n) && y[j] >= (k / n)) {
                        x1++;
                    }
                }
                cont[xx] = x1;
                xx++;
                x1 = 0;
            }
        }
        double suma = 0;
        for (int i = 0; i < cont.length; i++) {
            suma = suma + Math.pow((cont[i] - ((N - 1.0) / (double) Math.pow(n, 2))), 2);// estadistico X
        }
        double resultado = suma * (cont.length / (double) (n_pseudoaleatorios.size() - 1));// * n^2 / N-1
        System.out.println("Suma: " + suma + "\nResultado: " + resultado);
        if (suma < 36.41) {//con un nivel de significancia del 5%
            System.out.println("NO se rechaza la hipotesis de uniformidad de numeros pseudo aleatorios");
        } else {
            System.out.println("SE rechaza la hipotesis de uniformidad de numeros pseudo aleatorios");
        }
    }

    public static void prueba_Kolmogorov(ArrayList<Double> n_pseudoaleatorios) {
        System.out.println("\n>>>> PRUEBA DE KOLMOGOROV-SMIRNOV <<<<");
        int n = n_pseudoaleatorios.size();
        DecimalFormat df = new DecimalFormat("0.00000");

        Collections.sort(n_pseudoaleatorios); //ordenar los numeros de menor a mayor
        ArrayList<Double> dist_ac = new ArrayList<>();//para guardar las distribuciones acumuladas

        String n_aux = "";
        double DnAux = 0.00;
        System.out.println("\nNUMEROS ORDENADOS CON DISTRIBUCION ACUMULADA\n");
        System.out.println("\tFo(x)\t\tFn(x)");
        for (int i = 0; i < n_pseudoaleatorios.size(); i++) {
            dist_ac.add((double) (i + 1) / n);//Fn(X) =i/n;

            n_aux = n_aux + (i + 1) + "\t" + n_pseudoaleatorios.get(i) + "\t\t" + df.format(dist_ac.get(i)) + "\n"; //cadena para presentar los numeros
            //System.out.println("ORDENADOS--"+n_pseudoaleatorios.get(i));

            double Dn = Math.abs(dist_ac.get(i) - n_pseudoaleatorios.get(i));// |Dn| estadistico 'Dn'

            if (Dn > DnAux) {
                DnAux = Dn;
            }

        }
        System.out.println("" + n_aux);

        System.out.println("El estadistico Dn es: " + DnAux);//valor del estadistico

        //basado en la tabla con una muestra de 30 el valor de Dα,n  es igual a 0,242
        double d_alpha_n = 0.242;
        if (DnAux < d_alpha_n) {
            System.out.println("No se puede rechazar la hipotesis de que los números generados provienen de una distribución uniforme");
        } else {
            System.out.println("Se rechaza la hipotesis de que los números generados provienen de una distribución uniforme");
        }

    }

    public static void prueba_Poker(ArrayList<Double> n_pseudoaleatorios) {
        System.out.println("\n\n<<<< PRUEBA DE POKER >>>>\n");
        DecimalFormat df = new DecimalFormat("0.00000");

        //double num[] = {0.22826, 0.33161};
        int N = n_pseudoaleatorios.size();

        int par1 = 0, doblepar = 0, tercia1 = 0, poker1 = 0, full = 0, quintilla1 = 0, todosdiferentes1 = 0;
        //
        for (int l = 0; l < N; l++) {/////////////////////////////////
            int rep[] = new int[10];
            int par = 0, tercia = 0, poker = 0, quintilla = 0, todosdiferentes = 0;

            String n = df.format(n_pseudoaleatorios.get(l));

            String x[] = n.split(",");  //separa 0.22826 en 0 y 22826
            String dig[] = x[1].split(""); //tomo solo 22826 y separo en caracteres
            //System.out.println("nn "+n);

            for (int i = 0; i < dig.length; i++) {
                //System.out.println("" + dig[i]);
                rep[Integer.parseInt(dig[i])]++;

                //System.out.println(i+"=="+dig[i]);
                //System.out.println("sss "+i+"--"+rep[Integer.parseInt(dig[i])]);
            }

            int d = 0;
            int par_aux = 0, auxp = 0;

            for (int i = 0; i < 10; i++) {

//                if (rep[i] == 0) {
//                    System.out.println("HOLA");
//                    todosdiferentes++;
//                }
                if (rep[i] == 2) {
                    par++;
                }

                if (rep[i] == 3) {
                    tercia++;
                }
                if (rep[i] == 4) {
                    poker++;
                }
                if (rep[i] == 5) {
                    quintilla++;
                }
                if (par == 0 && tercia == 0 && poker == 0 && quintilla == 0) {
                    todosdiferentes++;
                }

            }

            if (todosdiferentes == 10) {
                todosdiferentes1++;
                //System.out.println("todos diferentes " + todosdiferentes);
            }
            if (quintilla == 1) {
                quintilla1++;
                // System.out.println("quintilla " + quintilla);
            }

            if (poker == 1) {
                poker1++;
                //System.out.println("poker" + poker);
            }
            if (par == 1 && tercia == 1) {
                full++;
                //System.out.println("full ");
            } else {
                if (par == 1) {
                    par1++;
                    //System.out.println("par " + par);
                }
                if (tercia == 1) {
                    tercia1++;
                    //System.out.println("tercia " + tercia);
                }
            }

            if (par == 2) {
                doblepar++;
                //System.out.println("doble par " + par);
            }

        }
        System.out.println("Par... " + par1);  //FE = 50.40
        System.out.println("Dos pares... " + doblepar);  //FE = 10.80 
        System.out.println("Tercia... " + tercia1);  //FE = 7.20
        System.out.println("Poker... " + poker1);  //FE = 0.45
        System.out.println("Full... " + full);  //FE =  0.90
        System.out.println("Quintilla... " + quintilla1);  //FE = 0.10 
        System.out.println("Todos diferentes... " + todosdiferentes1); //FE = 30.24

        double x0 = Math.pow((par1 - 50.40), 2) / 50.40 + Math.pow((doblepar - 10.80), 2) / 10.80
                + //SE LE PUEDE UNIR EN CASO DE QUE LAS FRECUENCIAS SALGAN MENORES QUE 5
                Math.pow((tercia1 - 7.20), 2) / 7.20 + Math.pow((poker1 - 0.45), 2) / 0.45
                + Math.pow((full - 0.90), 2) / 0.90 + Math.pow((quintilla1 - 0.10), 2) / 0.10
                + Math.pow((todosdiferentes1 - 30.24), 2) / 30.24;//estadistico ((FO-FE)^2)/FE

        System.out.println("\nEstadistico Xo --> " + x0);

        //n del chi cuadrado == al numero de grupos -1 
        if (x0 < 12.59) { //con un nivel de significancia del 5%
            System.out.println("No se puede rechazar la hipotesis de que los numeors pseudoaleatorios provienen de una distribucion uniforme");
        } else {
            System.out.println("Se rechaza la hipotesis de que los numeors pseudoaleatorios provienen de una distribucion uniforme");
        }
    }
    
    public static void prueba_Corridas(double n_pseudoaleatorios[]) {
        System.out.println("\n<<<< PRUEBA CORRIDAS >>>>\n");
        ArrayList<Integer>binarios=new ArrayList<>();
        String aux="";
        int n1=0, n2=0, R=1;
        double Xr=0, h=0.00, Sr=0.00, Zo=0.00;
        int N = n_pseudoaleatorios.length;
        for (int i = 0; i < N; i++) {
            if (n_pseudoaleatorios[i]>0.5) {
                binarios.add(1);
                n2++;//# de corridas
            }else{
                binarios.add(0);
                n1++;
            }
            if (i>0) {
                if (binarios.get(i-1)!=binarios.get(i)) {
                    R++;
                }
            }
            aux=aux+binarios.get(i)+" ";
        }
        System.out.println(aux);
        System.out.println("R... "+R);
        Xr=((double)(2*n1*n2)/(n1+n2))+1;//+1;//promedio de las corridas
        System.out.println("Xr... "+Xr);
        if (R<Xr) {
            h=0.5;
        }else{
            h=-0.5;
        }
        System.out.println("h... "+h);
       // 182104/26100//0.0083
  
        double desv=(((2*n1*n2)*((2*n1*n2)-n1-n2))/((Math.pow((n1+n2), 2))*(n1+n2-1)));
        
        Sr=Math.sqrt(desv);//desviacion estandar de las corridas
        System.out.println("Sr... "+Sr);
        Zo= (R+h-Xr)/Sr;
        System.out.println("Estadistico Zo... "+Zo);
        //nivel de confianza del 95%  --> 0.975  (Tabla dist normal Z )   Z(α/2)   α=0.05
        if (Zo<1.96 && Zo>-1.96) {
            System.out.println("\nLa muestra sigue una secuencia aleatoria");
        }else{
            System.out.println("\nLa muestra no sigue una secuencia aleatoria");
        }
        
    }
}

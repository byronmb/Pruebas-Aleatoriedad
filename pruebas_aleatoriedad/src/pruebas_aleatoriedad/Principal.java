/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas_aleatoriedad;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Principal {

    public static void main(String[] args) {
        String aux = "";
        int np = 0;
        ArrayList<Double> n_pseudoaleatorios = new ArrayList<>();
//        double valoresLista[] = {0.64138, 0.55837, 0.81593, 0.04994, 0.61265, 0.06787, 0.30465, 0.54264, 0.81159, 0.61163, 
//                                 0.47681, 0.52127, 0.69239, 0.92006, 0.37913, 0.32035, 0.37248, 0.57836, 0.19180, 0.28920, 
//                                 0.79302, 0.08124, 0.53401, 0.48201, 0.03268, 0.38087, 0.68054, 0.69251, 0.60284, 0.69351};

        double valoresLista[] = {0.64138,
            0.55837,
            0.81593,
            0.04994,
            0.61265,
            0.06787,
            0.30465,
            0.54264,
            0.81159,
            0.61163,
            0.47681,
            0.52127,
            0.69239,
            0.92006,
            0.37913,
            0.32035,
            0.37248,
            0.57836,
            0.19180,
            0.28920,
            0.79302,
            0.08124,
            0.53401,
            0.48201,
            0.03268,
            0.38087,
            0.68054,
            0.69251,
            0.60284,
            0.69351,
            0.64264,
            0.22409,
            0.80242,
            0.58071,
            0.31629,
            0.03585,
            0.46034,
            0.57039,
            0.15096,
            0.15523,
            0.64388,
            0.83371,
            0.04198,
            0.49796,
            0.16087,
            0.68317,
            0.39974,
            0.48571,
            0.93409,
            0.90760,
            0.59867,
            0.10238,
            0.57576,
            0.20976,
            0.25934,
            0.27937,
            0.74035,
            0.26204,
            0.06659,
            0.75064,
            0.08396,
            0.14600,
            0.07700,
            0.76808,
            0.90808,
            0.19125,
            0.71868,
            0.31794,
            0.81621,
            0.47948,
            0.93661,
            0.72871,
            0.96122,
            0.52904,
            0.18658,
            0.81139,
            0.71166,
            0.92589,
            0.23092,
            0.92253,
            0.81515,
            0.91642,
            0.93912,
            0.59072,
            0.38699,
            0.22783,
            0.54638,
            0.59725,
            0.30204,
            0.63166,
            0.07339,
            0.65144,
            0.81809,
            0.01614,
            0.86034,
            0.05137,
            0.50878,
            0.98290,
            0.41824,
            0.97056};

        for (int i = 0; i < valoresLista.length / 3; i++) { //para mostrar los numeros en pantalla
            for (int j = 0; j < 10; j++) {
                if (np == valoresLista.length) {
                    break;
                }
                aux = aux + valoresLista[np] + ", ";
                np++;

            }
            aux = aux + "\n";
        }
        System.out.println("" + aux);

        for (int i = 0; i < valoresLista.length; i++) {
            n_pseudoaleatorios.add(valoresLista[i]);
            // System.out.println(""+n_pseudoaleatorios.get(i)+", ");
        }

        metodos_pruebas.prueba_Series(n_pseudoaleatorios);
        metodos_pruebas.prueba_Kolmogorov(n_pseudoaleatorios);
        metodos_pruebas.prueba_Poker(n_pseudoaleatorios);

        metodos_pruebas.prueba_Corridas(valoresLista);
    }
}

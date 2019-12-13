/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package Hash;

import java.util.Random;

/**
 *
 * @author jlgut
 */
public class TestBloomFilter {
    public static void main(String[] args){
        BloomFilter<Integer> bf;
        Random r = new Random();
        int [] arr ;
        for(int j = 100; j <= 1000 ; j += 100){
            arr = new int[j];
            for(int i = 0; i < j; i++){//se guardan j valores numericos al azar
                arr[i] = r.nextInt(100000); 
            }//for
            bf = new BloomFilter(j*10, j);
            for(int i = 0; i < arr.length; i++){
                bf.add(arr[i]);
            }//for
            System.out.println("cont - " + bf.cont);
            System.out.println("Control - " + bf.FalsosPositivos()*100 + "%");
            for(int i = 1; i <= 15; i++){//relacion falsos positivos con k
                bf = new BloomFilter(j*10,j,i);
                for(int u = 0; u < arr.length; u++){
                    bf.add(arr[u]);
                }//for
                System.out.println("cont - " + bf.cont);
                System.out.println(i + " - " + bf.FalsosPositivos()*100 + "%");
            }//for
        }//for
    }//main
}//class

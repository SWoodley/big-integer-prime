/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigintegerprime;
import java.math.*;

/**
 *
 * @author Rig
 */
public class BigIntegerPrime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        long counter = 1;
       
        System.out.print("Prime palindrome numbers > 10^8 and < 10^9: \n");
        
        for (BigInteger i = new BigInteger("100000000"); //begin loop at 10^8
                i.multiply(i).compareTo(BigInteger.valueOf(1000000000)) > 0; //if (i*i==10^9), exit loop
                i = i.add(BigInteger.ONE)) {
            
            if(isPrime(i)) {
                System.out.print(i + " ");
                
                if(counter%5==0) {
                    System.out.print("\n"); //five outputs per line
                }  
                
                counter++; 
            }    

        }
    }
    
    public static boolean isPrime(BigInteger arg) {
        if(!arg.isProbablePrime(5))
            return false;
        
        for (BigInteger i = new BigInteger("2"); i.multiply(i).compareTo(arg) < 1; i = i.add(BigInteger.ONE)) {
            if (BigInteger.ZERO.equals(arg.mod(i)))
                return false;
        }
        
        return true;
    }
    
}

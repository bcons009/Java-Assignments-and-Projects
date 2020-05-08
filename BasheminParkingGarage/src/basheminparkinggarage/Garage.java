/*
 * File: Garage.java
 * Creates a Garage object representing a garage with 10 parking spaces using
 * an array of Car objects with an array length of 10. Car objects within the
 * "garage" can either be parked into the garage or removed from the garage 
 * using the "arrve" and "depart" methods respectively. Both of those methods
 * return a String used for the status message printed in the Test class.
 */
package basheminparkinggarage ;

import java.util.Scanner ;
import java.util.Arrays ;


/**
 * Creates a Garage object with room for 10 Car objects which can be parked into 
 * and pulled out of the garage.
 * @author Bryan Consuegra
 */
public class Garage {
    //Initialize final Integer GARAGE_SIZE, which dictates tha size of the
    //garage array.
    private final int GARAGE_SIZE = 10 ;
    //Integer garageCount is also initialized. This variabel keeps count of the 
    //number of filled spots in the garage.
    private int garageCount = 0 ;
    //String message, Array of Cars garage, and integer moveCount are
    //declared.
    private String message ;
    private Car[] garage ;
    private int moveCount ;
    
    /**
     * Constructor which initializes Array of Cars garage to equal a new 
     * Array of Cars with a size of GARAGE_SIZE (10).
     */
    public Garage(){
        garage = new Car[GARAGE_SIZE] ;
    }
    
    /**
     * Method for parking a car in the garage.
     * @param licenseNum The license number of the car trying to be parked.
     * @return String message; a String used for the status message printed into
     * the output file from the Test class.
     */
    public String arrive(String licenseNum){
        if(garageCount < GARAGE_SIZE){
            garage[garageCount] = new Car(licenseNum, 0) ;
            message = "Car has been parked." ;
            garageCount++;
        }
        else{
            message = "The garage is full. Car could not be parked." ;
        }
        return message ;
    }
    
    /**
     * Method for withdrawing a car from the garage.
     * @param licenseNum The license number of the car trying to be parked.
     * @return String message; a String used for the status message printed into
     * the output file from the Test class.
     */    
    public String depart(String licenseNum){
        String movedCars = "" ;
        Boolean stopLoop = false ;
        Boolean carFound = false  ;
        int departIndex = 0 ;
        for(int i = 0; i <= garageCount && !stopLoop; i++){
            if(i < garageCount){
                if(garage[i].getLicenseNum().equals(licenseNum)){
                    departIndex = i ;
                    moveCount = garage[i].getMove() ;
                    garageCount-- ;
                    carFound = true ;
                    stopLoop = true ;
                }
            }
            else if(i == garageCount && !stopLoop){
                carFound = false ;
                stopLoop = true ;
            }
        }
        if (carFound){
            for(int i = 0; i < departIndex; i++){
                movedCars += garage[i].getLicenseNum() + " " ;
                garage[i].moveIncrease() ;
                movedCars += Integer.toString(garage[i].getMove()) + " " ;
            }
            Arrays.fill(garage, 0, departIndex, null) ;
            for(int i = departIndex; i >= 0; i--){
                if(i > 0){
                    garage[i - 1] = garage [i] ;
                    garage[i] = null ;
                }
                else{
                    garage[i] = null ;
                }
            }
            Scanner s = new Scanner(movedCars) ;
            for (int i = 0; i < departIndex; i++){
                String licNum = s.next() ;
                int moveNum = Integer.parseInt(s.next()) ;
                garage[i] = new Car(licNum, moveNum) ;
            } 
            for (int i = departIndex; i < 9; i++){
                garage[i] = garage[i + 1] ;
                garage[i + 1] = null ;
            }
            message = "Car has exited the garage. Moved " + moveCount 
                    + " times." ;
        }
        else if (!carFound){
            message = "Car could not be found." ;
        }
        return message ;
    }  
}

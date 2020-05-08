/*
 * File: Car.java
 * Creates an object representing a car with Strings representing the car's
 * license number and number of times
 */
package basheminparkinggarage ;

/**
 * Creates a Car object with a String representing the car's license number and
 * an integer representing the number of times the car had been temporarily 
 * moved out of the garage.
 * @author Bryan Consuegra
 */
public class Car {
    //Declare String licenseNum, representing the car's license number.
    private String licenseNum ;
    //Declare int move, representing the number of times the car was moved.
    private int move ;
    
    /**
     * Constructs a Car object with default values "licenseNum" and "move".
     * @param licenseNum String representation of the car's license number,
     * @param move Integer representation of the number of times the car was 
     * temporarily moved out of the garage.
     */
    public Car(String licenseNum, int move){
        this.licenseNum = licenseNum ;
        this.move = move ;
    }
    
    /**
     * Accessor method for String licenseNum, aka the car's license number.
     * @return String licenseNum.
     */
    public String getLicenseNum(){
        return licenseNum ;
    }
    
    /**
     * Accessor method for Integer move, aka the number of times the car moved.
     * @return Integer move.
     */
    public int getMove(){
        return move ;
    }
    
    /**
     * Increases the Integer move by 1; increasing the counter of the amount of
     * times the car was moved.
     */
    public void moveIncrease(){
        move++ ;
    }
}

package vehicleRegistrationPlateValue;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

//Tool I used:
//I used TestNG to create my tests with text annotation abilities via extending this interface.
//Hash map to use key-value structure opportunities to find a value via key.
//Regex pattern util to set a range for alphanumeric characters.
//I used nested two classes. I aimed to show all of it in the same place in my presentation.


public class vehicleRegistrationPlateValue{
    @Test
//I would like to prefer to explain the task via positive and negative tests outputs. Let's look at the results.
    public void test(){
        String positiveTest[]={"BA01XTY","CA12XTY","DA65XTY"};
        String negativeTest[] ={"BA","9999999999999","QA12XTY","iA12XTY","Bq12XTY","BA12XTy","BAA2XTY","BA1AXTY","BA12,TY", "BA15XT9","BA12 TY", "BA49XTY", "BA99XTY" };

        //I used for loops to run all the options from string arrays.
        for(int i=0; i<positiveTest.length;i++){
            System.out.println(i+1+" ) for the test= "+ positiveTest[i]);
            testCompletion(positiveTest[i]);
            System.out.println("------------------------------------------------------------------------------------------");
        }
        for(int i=0; i<negativeTest.length;i++){
            System.out.println(i+1+" ) for the test= "+ negativeTest[i]);
            testCompletion(negativeTest[i]);
            System.out.println("------------------------------------------------------------------------------------------");
        }
    }
    //I completed the task with five methods.

    //First one is the "first check".
    //Then the second one is areaVerification. It's dealing with the first letter of the plate value.
    //Third one is age verification.
    public void testCompletion(String plate) {
        plateInfo obj =new plateInfo(plate);
        if(obj.fistCheck()&&obj.areaVerification()&&obj.ageVerification()) {

            //if first, three tests passed properly then the next two methods complete our test. Otherwise, the user taking a warning message related to the mistake.
            //In the given scenario first three and last two methods are asked as separate sections but to demonstrate all the tests and outputs of them together,
            // I prefer to run them in these steps.
            // If two-section is still compulsory, I could separate them in this level.

            //first method of this section provides the region of the registration.
            obj.areaName();

            //Then the final part gives the registration year.
            obj.age();

        }

    }
}


class plateInfo {
    String vehicleRegistrationPlateValue;
    String[] vRPV;
    String a ;
    String b ;
    String y1 ;
    String y2 ;
    String r1 ;
    String r2 ;
    String r3 ;
    Pattern p = Pattern.compile("[^A-HJ-PR-Z]");
    private Map<String, String> areaAndCodes = new HashMap<>();
    public plateInfo(String vehicleRegistrationPlateValue){
        this.vehicleRegistrationPlateValue=vehicleRegistrationPlateValue;
        setAreaAndCodes();
    }
    public void setAreaAndCodes() {
        // ( Code and Area )
        areaAndCodes.put("A","Anglia");
        areaAndCodes.put("B","Birmingham");
        areaAndCodes.put("C","Cymru(Wales)");
        areaAndCodes.put("D","Deeside");
        areaAndCodes.put("E","Essex");
        areaAndCodes.put("F","Forest and Fens");
        areaAndCodes.put("G","Garden of England");
        areaAndCodes.put("H","Hampshire");
        areaAndCodes.put("K","Milton Keynes");
        areaAndCodes.put("L","London");
        areaAndCodes.put("M","Manchester");
        areaAndCodes.put("N","Newcastle");
        areaAndCodes.put("O","Oxford)");
        areaAndCodes.put("P","Preston");
        areaAndCodes.put("R","Reading");
        areaAndCodes.put("S","Scotland");
        areaAndCodes.put("V","Severn Valley");
        areaAndCodes.put("W","West of England");
        areaAndCodes.put("X","Export");
        areaAndCodes.put("Y","Yorkshire");
    }

    //I checked the length of the String to ensure the proper entrance of the value.
    //I split the Plate value to create an array(vPRV) and I can handle each character as a single string and this gives the flexibility to check all needs separately.
    //I took b,r1,r2 and r3(random letters) and I concatenate them then I used Regex pattern matcher options to check all random characters in expected conditions or not.
    public boolean fistCheck() {
        if(vehicleRegistrationPlateValue.length()==7){
            vRPV = vehicleRegistrationPlateValue.split("");
            a = vRPV[0];
            b = vRPV[1];
            y1 = vRPV[2];
            y2 = vRPV[3];
            r1 = vRPV[4];
            r2 = vRPV[5];
            r3 = vRPV[6];}else{
            System.out.println("You need to enter 7 character only. You entered:"+ vehicleRegistrationPlateValue.length()+" character.  Please do not enter less or more than 7 character. ");
            return false;}
        boolean randomLetters = p.matcher(b+r1+r2+r3).find();
               if (randomLetters) {
            System.out.println("Please check your vehicle registration plate value and type it correctly. Do not use Q, I, any sign, number or lower case letter.");
            return false;
        }return true;
    }
    //This is the second check. If the first letter does not match with area codes, test giving a warning to the user.
    public boolean areaVerification(){
        String area = null;
        area = areaAndCodes.get(a);
        if (area == null) {
            System.out.println("Please check your vehicle registration plate value and type it correctly.Do not use Q, I, any sign, number or lower case letter for the first character of the plate.");
            return false;
        }return true;
    }
    //We are using the first letter as a key in the hash map and we are taking the value of this key as the region of the registration.
    public void areaName(){
        String area = areaAndCodes.get(a);
        if (area != null) {
            System.out.println("Region of registration is: " + area);
        }
    }
    //I checked numerical part of the plate values is a digit or not.
    //Then using the Local date function of Java and comparing register year and the current year. If our car is younger than the current year I did not accept it.
    // It was not in the acceptance criteria but I considered the situation from the client-side and I decided that this additional check would be good to increase the quality.
    //At the final check of this method according to acceptance criteria test gives a warning if the user entered the year 2000.
    public boolean ageVerification(){
        if(Character.isDigit(vehicleRegistrationPlateValue.charAt(2))&&(Character.isDigit(vehicleRegistrationPlateValue.charAt(3)))){
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        try {
            int year = Integer.parseInt(y1) * 10 + Integer.parseInt(y2);
            if (year < 50) {
                    if (2000+year>currentYear||year== 0){
                        System.out.println("Please check your vehicle registration plate value and type it correctly. You can not enter 00 or you can not enter further year plate number.");
                        return false;}

            }else {
                    if (1950+year>currentYear||year== 0){
                    System.out.println("Please check your vehicle registration plate value and type it correctly. You can not enter 00.or you can not enter further year plate number.");
                    return false;}
            }
         } catch (NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("Please check your vehicle registration plate value and type it correctly.You can not use letter or sign for numerical part.");
        }return true;
    }
        System.out.println("Please check your vehicle registration plate value and type it correctly.You can not use letter or sign for numerical part");
    return false;}
    //I took the third and fourth characters and I parsed from String to integer. Then I multiply the first number with ten for place value then added to the second digit.
    // If it is greater than fifty I subtract 50(which is added by the new system) from 2000 to calculate the registration year.
    public void age(){

        try {
            int year = Integer.parseInt(y1) * 10 + Integer.parseInt(y2);
            if (year < 50) {
                System.out.println("The year of registration is: " + (2000 + year));
            } else {
                System.out.println("The year of registration is: " + (1950 + year));
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("Please check your vehicle registration plate value and type it correctly.You can not use letter or sign for numerical part.");
        }

    }

}
//This is the end of my presentation. Thank you very much for giving this opportunity and time.
// Thank you very much for your interest. Now, I am ready for your questions.

package vehicleRegistrationPlateValue;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class vehicleRegistrationPlateValue{
    public static int length; //?????
    @Test

    public void test(){
        String positiveTest[]={"BA01XTY","CA12XTY","DA65XTY"};
        String negativeTest[] ={"QA12XTY","iA12XTY","Bq12XTY","BA12XTy","BAA2XTY","BA1AXTY","BA12,TY","BA12 TY", "BA49XTY", "BA99XTY", "BA15XT9", "BA","9999999999999"};

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
    public void testCompletion(String plate) {
        plateInfo obj =new plateInfo(plate);
        if(obj.fistCheck()&&obj.areaVerification()&&obj.ageVerification()) {
            obj.areaName();
            obj.age();
        }

    }
}

** inner class kullanmaya gerek yok bence
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

**  first check yerine checkSize() or checkLength() olabilir
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
        
**  bu toplamanin ne anlama geldigi sorulabilir
        boolean randomLetters = p.matcher(b+r1+r2+r3).find();
        
     
                //Arrays.stream(unexpected).anyMatch(r1::equals)||Arrays.stream(unexpected).anyMatch(r2::equals)||Arrays.stream(unexpected).anyMatch(r3::equals)||Arrays.stream(unexpected).anyMatch(b::equals);
        //System.out.println(randomLetters)2

                if (randomLetters) {
            System.out.println("Please check your vehicle registration plate value and type it correctly. Do not use Q, I, any sign, number or lower case letter.");
            //System.out.println("Length of the vRPV"+vRPV.length);
            return false;
        }return true;
    }

    public boolean areaVerification(){
        String area = null;
        area = areaAndCodes.get(a);
        if (area == null) {
            System.out.println("Please check your vehicle registration plate value and type it correctly.Do not use Q, I, any sign, number or lower case letter for the first character of the plate.");
            return false;
        }return true;
    }
    public void areaName(){
        String area = areaAndCodes.get(a);
        if (area != null) {
            System.out.println("Region of registration is: " + area);
        }
    }

    public boolean ageVerification(){
        if(Character.isDigit(vehicleRegistrationPlateValue.charAt(2))&&(Character.isDigit(vehicleRegistrationPlateValue.charAt(3)))){
        LocalDate currentdate = LocalDate.now();
        int currentYear = currentdate.getYear();
        try {
            int year = Integer.parseInt(y1) * 10 + Integer.parseInt(y2);
            if (year < 50) {
                    if (2000+year>currentYear||year== 0){
                        System.out.println("Please check your vehicle registration plate value and type it correctly. You can not enter 00 or you can not enter further year plate number.");
                        return false;}

            }else {
                    if (1950+year>currentYear||year== 0){
                    System.out.println("Please check your vehicle registration plate value and type it correctly. You can not enter 00.or you can not enter further year plate number");
                    return false;}
            }
         } catch (NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("Please check your vehicle registration plate value and type it correctly.You can not use letter or sign for numerical part");
        }return true;
    }
        System.out.println("Please check your vehicle registration plate value and type it correctly.You can not use letter or sign for numerical part");
    return false;}

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

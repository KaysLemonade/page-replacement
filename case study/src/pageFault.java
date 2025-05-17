package src;
//import java.util.*;
//import javax.swing.JPanel;


public class pageFault {
    
    //declaring the variables
    public static int num;
    public static int[] ranString;
    public static int[] pageframe;
    public static int pageFault;
    public static int counter;
    public static boolean checks;

    public static void main(String[] args) {
        //initializing the JFrame
        Gui frame = new Gui();

        //letting the user enter the number of page frames
        //checking if the number of page frames are within the limitations      
        int PFnum;
        System.out.print("Choosing the Number of Page Frame:");
        while (true){  
            PFnum = num;
            if (PFnum < 3 || PFnum > 5){
                System.out.print("");
            }
            else {
                break;
            }
        }

        //initializing the arrays/variables
        ranString = new int[20];      //array for the randomly generated number string
        pageframe = new int[PFnum];   //array for the page frames with PFnum = the number of frames
        pageFault = 0;                  //variable containing the number of page faults
        counter = 0;                    //variable for keeping track of the location on the page frame array
        checks = false;             //variable for determining if the page frame array has a number the same with the other array

        //filling up the array with a number greater than 9 to replace the 0's
        for (int x = 0; PFnum > x; x++){
            pageframe[x] = 11;           
        }
        frame.revalidate();
    }

    //a method for the counter variable, checking if the number exceeds the number of page frames, if true return 0.
    public static int check (int counter, int max){
        int x;

        if (counter > max){
            x = 0;
        }
        else {
            x = counter;
        }
        return x;
    }
}    
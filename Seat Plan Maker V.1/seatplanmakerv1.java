import java.io.*;
import java.util.*;

class layout{
    public static void setuplayout(int row, int left, int right){
        int seatnumber = 1;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < left + right; c++){
                if(c == left){
                    if(seatnumber <= 9){
                        System.out.print("     [0" + seatnumber + "]");
                    } else{
                        System.out.print("     [" + seatnumber + "]");
                    }
                    seatnumber++;
                } else{
                    if(seatnumber <= 9){
                        System.out.print("[0" + seatnumber + "]");
                    } else{
                        System.out.print("[" + seatnumber + "]");
                    }
                    seatnumber++;
                    }
                }
                System.out.print("\n");
        }
    }
}

public class seatplanmakerv1{
    public static void main(String[] args) {
        
        System.out.print("Enter row#, left column#, and right column#, separated by space: ");

        Scanner scanner = new Scanner(System.in);
        layout Layout = new layout();

        int row = scanner.nextInt();
        int left = scanner.nextInt();
        int right = scanner.nextInt();

        int totalseats = row * (left + right);

        if (totalseats > 99) {
                System.out.println("Total number of seats should not exceed 99.");
        } else {
            Layout.setuplayout(row, left, right);
        }
    }
}

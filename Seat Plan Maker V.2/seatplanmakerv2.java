import java.util.Scanner;

class Seat {
    public boolean status;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
    // true means the seat is taken and false means the seat is available.
}

class Layout {
    private int rows;
    private int left;
    private int right;

    public void setRows(int rows){
        this.rows = rows;
    }
    public int getRows(){
        return rows;
    }
    public void setLeftcolumn(int left){
        this.left = left;
    }
    public int getLeftcolumn(){
        return left;
    }
    public void setRightcolumn(int right){
        this.right = right;
    }
    public int getRightcolumn(){
        return right;
    }

    public static void setupLayout(int row, int left, int right) {
        int seatNumber = 1;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < left + right; c++) {
                if (c == left) {
                    if (seatNumber <= 9) {
                        System.out.print("     [0" + seatNumber + "]");
                    } else {
                        System.out.print("     [" + seatNumber + "]");
                    }
                    seatNumber++;
                } else {
                    if (seatNumber <= 9) {
                        System.out.print("[0" + seatNumber + "]");
                    } else {
                        System.out.print("[" + seatNumber + "]");
                    }
                    seatNumber++;
                }
            }
            System.out.print("\n");
        }
    }

    public void displayLayout(Seat[] seats, int rows, int left, int right) {
        int seatNumber = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < left; j++) {
                seatNumber++;
                if (seats[seatNumber - 1].getStatus()) {
                    System.out.print("[XX]");
                } else {
                    System.out.printf("[%02d]", seatNumber);
                }
            }
            System.out.print("     ");
            for (int j = 0; j < right; j++) {
                seatNumber++;
                if (seats[seatNumber - 1].getStatus()) {
                    System.out.print("[XX]");
                } else {
                    System.out.printf("[%02d]", seatNumber);
                }
            }
            System.out.println();
        }
    }
}

public class seatplanmakerv2 {
    public static void main(String[] args) {

        System.out.print("Enter row#, left column#, and right column#, separated by space: ");

        Scanner scanner = new Scanner(System.in);
        Layout layout = new Layout();
        Seat isTaken = new Seat();

        int rows = scanner.nextInt();
        int left = scanner.nextInt();
        int right = scanner.nextInt();

        int totalSeats = rows * (left + right);

        if (totalSeats > 99) {
            System.out.println("Total number of seats should not exceed 99.");
        } else {
            layout.setupLayout(rows, left, right);
            Seat[] seats = new Seat[totalSeats];
            for (int i = 0; i < totalSeats; i++) {
                seats[i] = new Seat();
            }

            while (true) {
                System.out.print("Select seat number to take <Enter 0 to quit>: ");
                int chosen = scanner.nextInt();
                if (chosen == 0) {
                    break;}
                if ((chosen <= totalSeats) && (chosen > 0)) {
                    //seats[chosen - 1].status;
                    if (seats[chosen - 1].getStatus()){
                        System.out.println("SEAT TAKEN.");
                    } else{
                        seats[chosen - 1].setStatus(true);
                        seats[chosen - 1].getStatus();
                        layout.displayLayout(seats, rows, left, right);
                    }
                } else{
                    System.err.println("Invalid Seat Number.");
                }
            }
        }
    }
}

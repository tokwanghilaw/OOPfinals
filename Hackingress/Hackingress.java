//comments para maintindihan ko

import java.util.Scanner;

public class HackingressLabrador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            // VARIABLES
            int testing = scanner.nextInt();
            int currentnumber = scanner.nextInt();
            int success = 1;
            int cyclestart = currentnumber;
            int successcount = 1;
            int nextcycle = cyclestart + 400;
            int possiblehack = currentnumber + 5;

            // change nextcycle if exceeds 2400
            if (nextcycle >= 2400) {
                nextcycle = nextcycle - 2400;
            }

            // iterate thru testing cases
            for (int i = 1; i < testing; i++) {
                // store prev number for comparison
                int previousnumber = currentnumber;

                currentnumber = scanner.nextInt();

                // check for possibility if successful hack in da current cycle uwu nariribong
                // ako pero sige
                if (possiblehack <= currentnumber && currentnumber < nextcycle && successcount != 4) {
                    possiblehack = currentnumber + 5; // update
                    successcount++;
                    success++;
                } else if ((nextcycle <= currentnumber) || (currentnumber <= cyclestart)
                        || (currentnumber <= previousnumber)) {
                    cyclestart = currentnumber; // reset
                    nextcycle = cyclestart + 400;
                    possiblehack = currentnumber + 5;
                    success++;

                    // change nextcycle if exceeds 2400
                    if (nextcycle >= 2400) {
                        nextcycle -= 2400;
                    }
                }
            }
            System.out.println(success);
        }
    }
}

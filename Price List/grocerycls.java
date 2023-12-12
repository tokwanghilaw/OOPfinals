import java.io.*;
import java.util.Scanner;

public class grocerycls {
    private String[] productcode;
    private double[] productprice;
    private String code;
    public int qty;
    public double price;

    public grocerycls(String fileName) {
        try {
            Scanner scanner = new Scanner(new FileReader(fileName));
            int productsnumber = 1000;
            productcode = new String[productsnumber];
            productprice = new double[productsnumber];
            int index = 0;

            while (scanner.hasNext() && index < productsnumber) {
                String[] parts = scanner.nextLine().split(" ");
                if (parts.length == 2) {
                    productcode[index] = parts[0];
                    productprice[index] = Double.parseDouble(parts[1]);
                    index++;
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCodeQty() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Product Code and Quantity: ");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        if (parts.length == 2) {
            code = parts[0];
            qty = Integer.parseInt(parts[1]);
        }
    }

    public String getCode() {
        return code;
    }

    public int getQty() {
        return qty;
    }

    public boolean setPrice() {
        int index = findProductIndex(code);
        if (index != -1) {
            price = productprice[index];
            return true;
        } else {
            System.out.println("PRODUCT NOT FOUND.");
            price = 0;
            return false;
        }
    }

    public double getPrice() {
        return price;
    }

    public double getsubtotal() {
        return price * qty;
    }

    private int findProductIndex(String look) {
        for (int i = 0; i < productcode.length; i++) {
            if (productcode[i] != null && productcode[i].equals(look)) {
                return i;
            }
        }
        return -1;
    }
}

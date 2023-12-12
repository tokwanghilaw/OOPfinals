public class grocerymain {
    public static void main(String[] args) {
        grocerycls grocery = new grocerycls("pricelist.txt");
        double total = 0;

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            grocery.setCodeQty();
            if (grocery.getCode().equals("0") && grocery.getQty() == 0) {
                break;
            }
            if (grocery.setPrice()) {
                double subtotal = grocery.getsubtotal();
                System.out.println(grocery.qty + " @ Php " + grocery.price + " = Php " + subtotal);
                total += subtotal;
            }
        }

        System.out.println("TOTAL PRICE: Php " + total);
        scanner.close();
    }
}

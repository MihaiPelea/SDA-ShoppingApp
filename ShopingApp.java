import java.util.Scanner;

public class ShopingApp {
    public static boolean cosGol = true;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ShopListUtils product = new ShopListUtils();

        boolean exit = false;
        product.printProductList();

        while (exit == false) {
            product.printOptions();
            while (!scan.hasNext("[a-e]")) {
                System.out.println("Optiunea aleasa nu este valida");
                System.out.println();
                product.printOptions();
                scan.next();
            }
            char optiune = scan.next().charAt(0);

            switch (optiune) {
                case 'a':
                    System.out.println("Ai ales sa adaugi un produs in cos");
                    System.out.println("Alege produsul si apasa tasta ENTER");
                    product.printProductList();
                    while (!scan.hasNext("[1-9]|1[0]")) {
                        System.out.println("Optiunea aleasa nu este valida");
                        product.printProductList();
                        scan.next();
                    }
                    String chosenProduct = scan.next();
                    product.addToCart(Integer.parseInt(chosenProduct));
                    cosGol = false;
                    break;
                case 'b':
                    System.out.println("Ai ales sa elimini un produs din cos");
                    System.out.println("Alege produsul pe care vrei sa il elimini si apasa tasta ENTER");
                    product.cartCheck();
                    scan.nextLine();
                    String chosenToRemove = scan.nextLine();
                    product.removeFromCart(Integer.parseInt(chosenToRemove));
                    break;
                case 'c':
                    product.cartCheck();
                    scan.nextLine();
                    break;
                case 'd':
                    if (cosGol == true) {
                        System.out.println("Cosul este gol, nu ai nimic de plata");
                        System.out.println();
                    } else {
                        System.out.println("Ai ales sa platesti produsele din cos");
                        System.out.println("Introdu soldul disponibil si apasa tasta ENTER");
                        while (!scan.hasNextInt()) {
                            System.out.println("Soldul introdus nu este corect");
                            System.out.println("Introdu soldul disponibil si apasa tasta ENTER");
                            scan.next();
                        }
                        int sold = scan.nextInt();
                        product.pay(sold);
                    }
                    break;
                case 'e':
                    System.out.println("Pe curand!");
                    exit = true;
                    break;
            }
        }
    }
}

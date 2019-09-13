public class ShopListUtils {

    private String[] productName = new String[10];
    private int[] productPrice = new int[10];
    private String[] cart = new String[50];
    private int[] price = new int[50];
    private int contor = 0;
    private int notaDePlata = 0;

    void product(int pozitie) {
        productName[1] = "Mere";
        productName[2] = "Bere";
        productName[3] = "Paine";
        productName[4] = "Lapte";
        productName[5] = "Cola";
        productName[6] = "Biscuiti";
        productName[7] = "Cipsuri";
        productName[8] = "Apa";
        productName[9] = "Inghetata";
        productName[0] = "Banane";
        productPrice[1] = 4;
        productPrice[2] = 3;
        productPrice[3] = 2;
        productPrice[4] = 9;
        productPrice[5] = 5;
        productPrice[6] = 1;
        productPrice[7] = 2;
        productPrice[8] = 3;
        productPrice[9] = 2;
        productPrice[0] = 8;
        System.out.println("   " + pozitie + ". " + productName[pozitie - 1] + " " + productPrice[pozitie - 1] + " lei");
    }

    void printProductList() {
        System.out.println("--- Produse disponibile ---");
        for (int i = 1; i <= productName.length; i++) {
            product(i);
        }
        System.out.println();
    }

    void printOptions() {
        System.out.println("Alege ce vrei sa faci:");
        System.out.println("   a) adaug un produs in cos");
        System.out.println("   b) elimin un produs din cos");
        System.out.println("   c) verific  cosul de cumparaturi");
        System.out.println("   d) platesc cumparaturile");
        System.out.println("   e) renunt");
        System.out.println();
    }

    void addToCart(int product) {
        cart[contor] = productName[product - 1];
        price[contor] = productPrice[product - 1];
        contor++;
        System.out.println("Ati adaugat in cos " + productName[product - 1] + ", pret " + productPrice[product - 1] + " lei");
        notaDePlata += productPrice[product - 1];
        System.out.println("Total de plata: " + notaDePlata + " lei");
        System.out.println();
    }

    void removeFromCart(int product) {
        if (cart[product - 1] != null) {
            System.out.println("Ati eliminat " + cart[product - 1] + ", pret " + price[product - 1] + " lei");
            cart[product - 1] = null;
            notaDePlata -= price[product - 1];
            price[product - 1] = 0;
        }
        System.out.println();
    }

    void cartCheck() {
        System.out.println("- Produse in cos -");
        if (notaDePlata == 0) {
            System.out.println("Cosul este gol");
            System.out.println();
        } else {
            for (int i = 1; i <= contor; i++) {
                if (cart[i - 1] != null) {
                    System.out.println("   " + i + ". " + cart[i - 1] + " " + price[i - 1] + " lei");
                }
            }
            System.out.println("Total de plata: " + notaDePlata + " lei");
            System.out.println();
        }
    }

    void pay(int soldDisponibil) {
        if (notaDePlata != 0) {
            if (soldDisponibil < notaDePlata) {
                System.out.println("Sold disponibil insuficient");
                System.out.println();
            } else {
                notaDePlata = 0;
                System.out.println("Iti multumim pentru plata!");
                System.out.println();
                ShopingApp.cosGol = true;

            }
        } else {
            System.out.println("Cosul este gol, nu ai nimic de plata");
            System.out.println();
        }
    }
}

package nl.sogeti.petshop.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nl.sogeti.petshop.model.Account;
import nl.sogeti.petshop.model.Category;
import nl.sogeti.petshop.model.LoginCart;
import nl.sogeti.petshop.model.LoginCartItem;
import nl.sogeti.petshop.model.OrderProduct;
import nl.sogeti.petshop.model.PetShopOrder;
import nl.sogeti.petshop.model.Product;

@Startup
@Singleton
public class DataStore {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    void init() {

        List<Object> mockdata = new ArrayList<>();

        // Category mockdata
        HashMap<String, String> c1n = new HashMap<>();
        c1n.put("NL", "Hond");
        c1n.put("EN", "Dog");
        Category c1 = new Category(c1n);
        mockdata.add(c1);

        HashMap<String, String> c2n = new HashMap<>();
        c2n.put("NL", "Kat");
        c2n.put("EN", "Cat");
        Category c2 = new Category(c2n);
        mockdata.add(c2);

        HashMap<String, String> c3n = new HashMap<>();
        c3n.put("NL", "Vogel");
        c3n.put("EN", "Bird");
        Category c3 = new Category(c3n);
        mockdata.add(c3);

        // Product mockdata
        HashMap<String, String> p1n = new HashMap<>();
        p1n.put("NL", "Hondenhok");
        p1n.put("EN", "Doghouse");
        HashMap<String, String> p1d = new HashMap<>();
        p1d.put("NL", "Een Heel mooi hokje voor uw trouwe viervoeter.");
        p1d.put("EN", "A Very nice box for your four-legged friend.");
        HashMap<String, Double> p1p = new HashMap<>();
        p1p.put("EUR", 37.00);
        p1p.put("USD", 45.00);
        p1p.put("JPY", 999.00);
        Product p1 = new Product(p1n, p1d, p1p, c1, '0');
        mockdata.add(p1);

        HashMap<String, String> p2n = new HashMap<>();
        p2n.put("NL", "Kattenbrokken");
        p2n.put("EN", "Cat chunks");
        HashMap<String, String> p2d = new HashMap<>();
        p2d.put("NL", "Wat zal uw kat hiervan smullen.");
        p2d.put("EN", "What will feast your cat this.");
        HashMap<String, Double> p2p = new HashMap<>();
        p2p.put("EUR", 9.00);
        p2p.put("USD", 25.00);
        p2p.put("JPY", 450.00);
        Product p2 = new Product(p2n, p2d, p2p, c2, '0');
        mockdata.add(p2);

        HashMap<String, String> p3n = new HashMap<>();
        p3n.put("NL", "Zangzaad");
        p3n.put("EN", "Birdseed");
        HashMap<String, String> p3d = new HashMap<>();
        p3d.put("NL", "Laat al uw vogels zingen.");
        p3d.put("EN", " Let all your birds sing . ");
        HashMap<String, Double> p3p = new HashMap<>();
        p3p.put("EUR", 45.00);
        p3p.put("USD", 65.00);
        p3p.put("JPY", 1250.00);
        Product p3 = new Product(p3n, p3d, p3p, c3, '0');
        mockdata.add(p3);

        HashMap<String, String> p4n = new HashMap<>();
        p4n.put("NL", "Hondenbrokken");
        p4n.put("EN", "Dog chunks");
        HashMap<String, String> p4d = new HashMap<>();
        p4d.put("NL", "Lekker eten");
        p4d.put("EN", "Good food");
        HashMap<String, Double> p4p = new HashMap<>();
        p4p.put("EUR", 12.00);
        p4p.put("USD", 35.00);
        p4p.put("JPY", 750.00);
        Product p4 = new Product(p4n, p4d, p4p, c1, '0');
        mockdata.add(p4);

        HashMap<String, String> p5n = new HashMap<>();
        p5n.put("NL", "Kattekruid");
        p5n.put("EN", "Catnip");
        HashMap<String, String> p5d = new HashMap<>();
        p5d.put("NL", "Geef dit aan uw kat, niet aan uw Hond.");
        p5d.put("EN", "Give this to your cat , not your dog.");
        HashMap<String, Double> p5p = new HashMap<>();
        p5p.put("EUR", 23.00);
        p5p.put("USD", 40.00);
        p5p.put("JPY", 800.00);
        Product p5 = new Product(p5n, p5d, p5p, c2, '0');
        mockdata.add(p5);

        HashMap<String, String> p6n = new HashMap<>();
        p6n.put("NL", "Leeuwentemmer");
        p6n.put("EN", "Lion Tamer");
        HashMap<String, String> p6d = new HashMap<>();
        p6d.put("NL",
                "Een leeuwentemmer of dompteur is iemand die als beroep wilde dieren, in het bijzonder leeuwen, tijgers en andere grote katachtigen, africht, zodat ze in het circus hun kunstje kunnen doen.");
        p6d.put("EN",
                "Lion taming is the taming and training of lions, either for protection, or more commonly, entertainment, particularly in the circus.");
        HashMap<String, Double> p6p = new HashMap<>();
        p6p.put("EUR", 1990.00);
        p6p.put("USD", 2500.00);
        p6p.put("JPY", 1000000.00);
        Product p6 = new Product(p6n, p6d, p6p, c2, '0');
        mockdata.add(p6);

        HashMap<String, String> p7n = new HashMap<>();
        p7n.put("NL", "Mand");
        p7n.put("EN", "Basket");
        HashMap<String, String> p7d = new HashMap<>();
        p7d.put("NL", "Een mand voor je hond. Korter: Mand");
        p7d.put("EN", "A Dog Basket");
        HashMap<String, Double> p7p = new HashMap<>();
        p7p.put("EUR", 199.00);
        p7p.put("USD", 250.00);
        p7p.put("JPY", 10000.00);
        Product p7 = new Product(p7n, p7d, p7p, c2, '1');
        mockdata.add(p7);

        // Account mockdata
        Account a1 = new Account("admin", "admin", "admin", "", "admin", "admin", "1", "", "1111AA",
                "adminstein");
        a1.setActivated(true);
        a1.getRoles().add("admin");
        mockdata.add(a1);

        Account a2 = new Account("test@test.nl", "test", "test", "", "test", "test", "1", "", "1111AA", "test");
        a2.getRoles().add("customer");
        a2.setActivated(true);
        mockdata.add(a2);

        // Order mockdata
        PetShopOrder o1 = new PetShopOrder("Willem", "", "Hustinx", "Otto van Reesweg", "44", "", "4105AB", "Culemborg",
                "test");
        o1.addOrderProduct(new OrderProduct("Apennoten", 15.99, 3));
        o1.addOrderProduct(new OrderProduct("Olifanten Pinda's", 10.00, 5));
        mockdata.add(o1);

        // Login mockdata
        List<LoginCartItem> l1p = new ArrayList<>();
        l1p.add(new LoginCartItem(p1, 12));
        l1p.add(new LoginCartItem(p2, 3));
        LoginCart l1 = new LoginCart(a1, l1p);
        mockdata.add(l1);

        // Order mockdata
        PetShopOrder o2 = new PetShopOrder("Willem", "", "Hustinx", "Otto van Reesweg", "44", "", "4105AB", "Culemborg",
                "test");
        o2.addOrderProduct(new OrderProduct("Dingen", 20.55, 1));
        o2.addOrderProduct(new OrderProduct("More Stuff", 17.00, 1));
        mockdata.add(o2);

        for (Object o : mockdata) {
            em.persist(o);
        }
    }
}

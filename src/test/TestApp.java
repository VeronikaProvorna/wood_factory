package test;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.swing.JOptionPane;

import model.Cilinder;
import model.IWeight;
import model.Timber;
import model.Waste;
import store.ProductStore;
import store.WasteStore;
import store.WoodDirectory;
import threads.CilinderShop;
import threads.TimberShop;
import threads.WasteShop;
import threads.WoodLock;
import threads.WoodShop;
public class TestApp {

    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();
    private WasteStore ws = new WasteStore(3);
    private WoodLock wk = new WoodLock();

    public static void main(String[] args) {
        TestApp app = new TestApp();
        app.startApp();
    }

    private void startApp() {
        TimberShop shop1 = new TimberShop("timberShop", wd, ps, ws, wk, 3);
        CilinderShop shop2 = new CilinderShop("cilinderShop", wd, ps, ws, wk, 4);
        WasteShop shop3 = new WasteShop("wasteShop", ps, ws, wk, shop1, shop2);
        Thread tshop1 = new Thread(shop1);
        Thread tshop2 = new Thread(shop2);
        Thread tshop3 = new Thread(shop3);
        tshop1.start();
        tshop2.start();
        tshop3.start();
    }
}
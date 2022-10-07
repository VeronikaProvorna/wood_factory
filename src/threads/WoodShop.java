package threads;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import model.IWeight;
import store.ProductStore;
import store.WasteStore;
import store.WoodDirectory;
import view.DlgShop;

public abstract class WoodShop implements Runnable {
    String name;
    WoodDirectory wd;
    ProductStore ps;
    WasteStore ws;
    Random rnd = new Random();
    int n;//кількість мішків із залишками
    protected WoodLock wk;
    public WoodShop() {
        // just for fixing error at the WasteStore constructor
    }

    public WoodShop(String name, WoodDirectory wd, ProductStore s, WasteStore ws, WoodLock wk, int n) {
        this.name = name;
        this.wd = wd;
        this.ps = s;
        this.ws = ws;
        this.wk = wk;
        this.n = n;
    }

    public WoodShop(String name, WoodDirectory wd, ProductStore s, WasteStore ws, WoodLock wk, int n, int averageTime) {
        this.name = name;
        this.wd = wd;
        this.ps = s;
        this.ws = ws;
        this.wk = wk;
        this.n = n;
    }

    public String getName() {
        return name;
    }

    protected int getN() {
        return n;

    }

    protected abstract IWeight createProduct() throws Exception;

    public WoodShop(String name,WoodLock wk, WoodDirectory wd, ProductStore s, int n) {
        super();
        this.name = name;
        this.wd = wd;
        this.ps = s;
        this.wk=wk;
        this.n = n;
    }


    int fibo(int n) {
        if (n<2)
            return 1;
        return fibo(n-1)+fibo(n-2);
    }
public void run() {
        for(int i = 0;i<n;i++) {
            IWeight product = null;
            try {
                product = createProduct();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ps.add(product);
            wk.lock();
            if(DlgShop.getTextArea()!=null && wk.isLocked()==true)
                DlgShop.getTextArea().append(this.name+" is working\n");
        
            try {
                while(ws.getSize()>=ws.getMaxSize()) {
                    wk.isFull().await();
                    
                }
                ws.addWithPrint(this);
                wk.isEmpty().signal();
            }catch(InterruptedException e) {
                e.printStackTrace();
            }finally {
                wk.unlock();
                if(DlgShop.getTextArea()!=null && wk.isLocked()==false)
                    DlgShop.getTextArea().append(this.name+" stoped\n");        
            }
        }
    }
}
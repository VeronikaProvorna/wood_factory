package threads;

import java.time.LocalTime;

import model.IWeight;
import model.Waste;
import store.ProductStore;
import store.WasteStore;
import store.WoodDirectory;
import view.DlgShop;

public class WasteShop extends WoodShop{
    
	public WasteShop(String name, ProductStore s, WasteStore ws, WoodLock wk, TimberShop timberShop, CilinderShop cylinderShop) {
        this.n = timberShop.getN() + cylinderShop.getN();
        this.name = name;
        this.ps = s;
        this.ws = ws;
        this.wk = wk;
    }

    public WasteShop(String name, ProductStore s, WasteStore ws, WoodLock wk, WoodShop shop) {
        this.n = shop.getN();
        this.name = name;
        this.ps = s;
        this.ws = ws;
        this.wk = wk;
    }
    
	protected IWeight createProduct() {
        float weight = 25 + rnd.nextFloat() * 75;
        Waste waste = null;
        try {
            Thread.sleep(1500 + rnd.nextInt(1000));
            waste = new Waste(weight);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return waste;
    }

    @Override
    public void run() {
        for(int i = 0; i < n; i++) {
            wk.lock();
            if(DlgShop.getTextArea()!=null && wk.isLocked()==true)
                DlgShop.getTextArea().append("waste shop is working\n");        
            IWeight product = null;
            try {
                while(ws.getSize() == 0) { 
                        wk.isEmpty().await();
                        
                }

                product = createProduct();
                ws.removeWithPrint(this);
                wk.isFull().signal();
                ps.add(product);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                wk.unlock();
                if(DlgShop.getTextArea()!=null)
                    DlgShop.getTextArea().append("waste shop stoped\n");
            }

        }
    }

}
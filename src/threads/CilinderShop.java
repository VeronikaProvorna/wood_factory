package threads;

import model.Cilinder;
import model.IWeight;
import model.Wood;
import store.ProductStore;
import store.WasteStore;
import store.WoodDirectory;

public class CilinderShop extends WoodShop {
	public CilinderShop(String name, WoodDirectory wd, ProductStore s, WasteStore ws, WoodLock wk, int n) {
        super(name, wd, s, ws, wk, n);
    }
	  
	  protected IWeight createProduct() throws Exception {
	    int woodId = this.rnd.nextInt(3);
	    Wood wood = this.wd.get(woodId);
	    float length = 1.0F + this.rnd.nextFloat() * 10.0F;
	    float diameter = 0.1F + this.rnd.nextFloat();
	    Cilinder cilinder = new Cilinder(length, diameter, wood);
	    return (IWeight)cilinder;
	  }
	}

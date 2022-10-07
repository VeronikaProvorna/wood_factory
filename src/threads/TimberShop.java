package threads;

import java.util.Random;

import model.IWeight;
import model.Timber;
import model.Wood;
import store.ProductStore;
import store.WasteStore;
import store.WoodDirectory;

public class TimberShop extends WoodShop {
	public TimberShop(String name, WoodDirectory wd, ProductStore s, WasteStore ws, WoodLock wk, int n) {
		super(name, wd, s, ws, wk, n);
    }
	  
	  protected IWeight createProduct() throws Exception {
	    int woodId = this.rnd.nextInt(3);
	    Wood wood = this.wd.get(woodId);
	    float length = 1.0F + this.rnd.nextFloat() * 10.0F;
	    float height = 0.1F + this.rnd.nextFloat();
	    float width = 0.1F + this.rnd.nextFloat();
	    Timber timber = new Timber(wood, height,length, width);
	    return (IWeight)timber;
	  }
	}
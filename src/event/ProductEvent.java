package event;

import java.util.EventObject;

import model.IWeight;

public class ProductEvent extends EventObject{
    private IWeight product;
    private long time;
	public ProductEvent(Object source, IWeight product){
		super(source);
		this.product=product;
		this.time=System.currentTimeMillis();
	}
	public IWeight getProduct() {
		return product;
	}
	public long getTime() {
		return time;
	}
	@Override
	public String toString() {
		return time % 1000 + ": " + product;
	}
	

}

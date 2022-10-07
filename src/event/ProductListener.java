package event;

public class ProductListener implements IProductListener
{

	@Override
	public void onProductEvent(ProductEvent e) {
		System.out.println(e);
		
	}
    
}

package store;

import threads.WoodShop;
import view.DlgShop;

public class WasteStore {
    private int maxSize;
    private int size = 0;//кількість залишків
    WoodShop shop;
    
    @Override
	public String toString() {
		return "WasteStore [size=" + size + ", shop=" + shop + "]\n";
	}

	public WasteStore(int maxSize) {
        super();
        this.maxSize = maxSize;
    }

    public void addWithPrint(WoodShop shop) {
        size++;
        System.out.println(shop.getName() + " add 1, WasteShop size = " + size);
        if(DlgShop.getTextArea()!=null)
        DlgShop.getTextArea().append(shop.getName() + " add 1, WasteShop size = " + size+"\n");
    }

    public void removeWithPrint(WoodShop shop) {
        size--;
        System.out.println(shop.getName() + " remove 1, WasteShop size = " + size);
        if(DlgShop.getTextArea()!=null)
        	DlgShop.getTextArea().append(shop.getName() + " remove 1, WasteShop size = " + size+"\n");
    }

    public int getSize() {
        return size;
    }

    public int getMaxSize() {
        return maxSize;
    }

}
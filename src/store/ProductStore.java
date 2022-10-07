package store;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import model.AbstractForm;
import model.IWeight;
import model.Timber;
import model.Wood;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import event.IProductListener;
import event.ProductEvent;


public class ProductStore extends AbstractStore {
	private List<Object> list = new ArrayList<>();
	private Map<Object, Integer> map=new TreeMap<>(new Comparator<Object>() {
    
		@Override
		public int compare(Object o1, Object o2) {
			return ((IWeight)o1).toString().compareTo(((IWeight)o2).toString());
		}
		
	});
	//список з посиланнями на слухачів подій
	List<IProductListener> productListeners = new CopyOnWriteArrayList<>();
    //додавання посилання на слухача в список
	public void addProductListener(IProductListener listener) {
    	productListeners.add(listener);
    }
    //вилучення посилання на слухача в список
    public void removeProductListener(IProductListener listener) {
    	productListeners.remove(listener);
    }
    //метод сповізення слухачів про подію
    protected void fireProductEvent(ProductEvent obj) {
    	productListeners.forEach((lsn) -> lsn.onProductEvent(obj));
    }
	public void add(IWeight newProduct) {
		list.add(newProduct);
		fireProductEvent(new ProductEvent(this, newProduct));
	}
    public String toString() {
		StringBuilder sb=new StringBuilder(
				"\nThe list of timbers:\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		return sb.toString();
	}
    public Iterator<Object> iterator() {
		return list.iterator();
	}

	public ListIterator<Object> listiterator() {
		return list.listIterator();
	}


	public int getCount() {
		return list.size();
	}

	public Object[] getArr() {
		return list.toArray();
	}


	public float calcTotalWeight() {
		float fullWeight = 0;
		for (Object timber : list.toArray()) {
			fullWeight += ((IWeight) timber).weight();
		}
		return fullWeight;
	}

	public String sortedProdustStore() {
		StringBuilder sb = new StringBuilder("       Sorted  Product Store\n");
		Collections.sort(list, new Comparator<Object>() {
			@Override
			public int compare(Object firstObject, Object secondObject) {
				int comp = ((IWeight) firstObject).name().compareTo(((IWeight) secondObject).name());
				if (comp != 0)
					return comp;
				return (int) (((IWeight) firstObject).weight() - ((IWeight) secondObject).weight());
			}
		});
		for (int i = 0; i < list.size(); i++) {
			if (map.isEmpty() == false) {
				if (map.containsKey(list.get(i)) == true) {
					for (Map.Entry<Object, Integer> eSet : map.entrySet()) {
						if (eSet.getKey().equals(list.get(i))) {
							eSet.setValue(eSet.getValue() +1);
						}
					}
				} else {
					map.put((Object) list.get(i), 1);
				}
			} else {
				map.put((Object) list.get(i), 1);
			}
		}
		for (Map.Entry<Object, Integer> eSet : map.entrySet()) {
			Object obj = eSet.getKey();
			Integer count = eSet.getValue();
			sb.append(obj + " count = " + count).append("\n");
		}
		map.clear();
		return sb.toString();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(Collection<? extends Object> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}

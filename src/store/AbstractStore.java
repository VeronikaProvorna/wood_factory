package store;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

import model.AbstractForm;
import model.IWeight;
import model.Timber;
import model.Wood;

public abstract class AbstractStore implements Serializable, Iterable<Object>,Collection<Object>
{
	Collection<Object> coll=new ArrayList<>();
	public abstract Object[] getArr();
    public abstract int getCount();
    public boolean add(Object newProduct) {
		coll.add(newProduct);
		return true;
	}
    public String toString() {
		StringBuilder sb=new StringBuilder();
		//this це посилання на об'єкт що викликав метод
		for(Object obj: this) {
			sb.append(obj).append("\n");
		}
		return sb.toString();
	}
	public void remove(Predicate<Object> prd) {
		Iterator<Object> itr=this.iterator();
		while(itr.hasNext()) {
			Object obj=(Object)itr.next();
			if(prd.test(obj)) {
				itr.remove();
			}
		}
	}
	public void doForAll(Consumer<Object> cns) {
		Iterator<Object> itr = this.iterator();
		while(itr.hasNext()) {
			Object obj=(Object)itr.next();
			cns.accept(obj);
		}
	}
	public void doOnlyFor(Consumer<Object> cns, Predicate<Object> prd) {
		Iterator<Object> itr= this.iterator();
		while(itr.hasNext()) {
			Object obj= (Object) itr.next();
			if(prd.test(obj)) {
				cns.accept(obj);
			}
		}
	}
	public void doOnlyFor2(Consumer<Object> cns, Predicate<Object> prd) {
		Iterator<Object> itr = this.iterator();
		while (itr.hasNext()) {
			Object obj = (Object) itr.next();
			if (prd.test(obj)) {
				itr.remove();
			}else {
			 cns.accept(obj);
			}
		}
	}
}
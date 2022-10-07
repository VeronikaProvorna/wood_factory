package store;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.Wood;

public class WoodDirectory extends AbstractStore{
	private Map<Integer, Object> map=new HashMap<>();
	{
		map.put(0, new Wood("Larch",0,1000));
		map.put(1, new Wood("Birch",1,800));
		map.put(2, new Wood("Pine",2,750));
	}
	//choose the wood id
	public Wood get(int id) {
				return (Wood)map.get(id);
		}
	//add to the directory
	public boolean add(Wood newWood) {
		if(map.get(newWood.getId()) != null)
			return false;
		map.put(newWood.getId(), newWood);
		return true;
	}
	//display directory
	public String toString() {
		StringBuilder sb=new StringBuilder(
				"\nWood directory\n");
		for (int i = 0; i < map.size(); i++) {
			sb.append(map.values().toArray()[i]).append("\n");
		}
		return sb.toString();
	}
	public int maxId() {
		return map.size()-1;
	}
	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
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
	@Override
	public Object[] getArr() {
		return map.values().toArray();
	}
	@Override
	public int getCount() {
		return map.size();
	}
	
}

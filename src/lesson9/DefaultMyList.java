package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class DefaultMyList<E> implements MyList {
	private int DEFAULT_SIZE = 10;
	private int size;
	private Object[] list;
	private int cursor;
	private int lastelement = -1;
	
	public DefaultMyList() {
		this.list = new Object[DEFAULT_SIZE];
	}
	public DefaultMyList(int capacity) {
		if(capacity > 0) {
			this.list = new Object[capacity];
		} else if (capacity == 0) {
			this.list = new Object[] {};
		} else {
			throw new IllegalArgumentException("Illegal capacity - " + capacity);
		}
	}
	public void ensureCapacity(int minCapacity) {
		if(minCapacity - list.length > 0) {
			extendCapacity(minCapacity);
		}
	}
	public void extendCapacity(int minCapacity) {
		int oldCapacity = list.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if(newCapacity > 0 && newCapacity > oldCapacity) {
		} else {
			newCapacity = oldCapacity;
		}
		list = Arrays.copyOf(list, newCapacity);
	}
	

	@Override
	// appends the specified element to the end of this list
	public void add(Object e) {
		ensureCapacity(size + 1);
		list[size++] = e;

	}

	@Override
	// removes all of the elements from this list
	public void clear() {
		for(int i = 0; i < list.length; i++) {
			list[i] = null;
		}
		size = 0;

	}

	@Override
	// removes the first occurrence of the specified element from this list
	public boolean remove(Object o) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == o) {
				list[i] = null;
				break;
			}
		}
		return false;
	}

	@Override
	// returns an array containing all of the elements in this list in proper
	// sequence
	public Object[] toArray() {
		return Arrays.copyOf(list, size);
	}

	@Override
	// returns the number of elements in this list
	public int size() {
		return this.size;
	}

	@Override
	// returns true if this list contains the specified element.
	public boolean contains(Object o) {
		int index = IntStream.range(0, size).filter(i -> o.equals(get(i))).findFirst().orElse(-1);
		return index > -1 ? true : false;
	}
	
	public Object get(int index) {
		return (Object) list[index];
	}

	@Override
	// returns true if this list contains all of the elements of the specified list
	public boolean containsAll(MyList c) {
		boolean containElement = false;
		if (size() == 0) {
			return containElement;
		} else {
			@SuppressWarnings("unchecked")
			DefaultMyList<Object> someList = (DefaultMyList<Object>) c;
			for (int i = 0; i < c.size(); i++) {
				containElement = contains(someList.get(i));
			}
			
		}
		return containElement;
	}
	@Override
	// override toString as was supposed to
	public String toString() {
		StringBuilder str = new StringBuilder();
		if(list.length >0) str.append("{");
			else str.append("{}");
		
		for (Object o : list) {
			if (o != null) {
				str.append("["+ o + "], ");
				
			}else {
				break;
			}
		}
		String s = str.toString();
		return s.substring(0, str.length() -2) + "}";
//		return s;
	}
	public Iterator<Object> iterator(){
		return new IteratorImpl();
	}
	
	@SuppressWarnings("rawtypes")
	public ListIterator listIterator() {
		return new ListIteratorImpl();
	}

	private class IteratorImpl implements Iterator<Object>
	{
	public  boolean hasNext() {
		return cursor != size;
	}
	public Object next() {
		int i = cursor;
		if(i >= size) {
			throw new NoSuchElementException();
		}
		Object[] listIter = DefaultMyList.this.list;
		Object nextElement = listIter[lastelement = i];
		return nextElement;
	}
	public void remove() {
		if(lastelement < 0) {
			throw new IllegalStateException();
		} 
		DefaultMyList.this.remove((Object) list[lastelement]);
		cursor = lastelement;
		lastelement = -1;
	}
	}
	
	@SuppressWarnings("rawtypes")
	private class ListIteratorImpl extends IteratorImpl implements ListIterator {
		@Override
		public boolean hasPrevious() {
			return cursor !=0;
		}
		
		@Override
		public Object previous() {
			Object previous = null;
			if(hasPrevious()) {
				int i = cursor - 1;
				lastelement = i;
				cursor = i;
				previous = get(i);
				previous = list[lastelement];
			} else {
				throw new NoSuchElementException();
			}
			return previous;
		}

		@Override
		public void set(Object e) {
			if (lastelement == -1) {
				throw new NoSuchElementException();
			} else {
				list[lastelement] = e;
				lastelement = -1;
			}
			
		}
		
	}

}
	

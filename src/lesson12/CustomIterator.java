package lesson12;

import java.util.Iterator;
import java.util.Objects;

public final class CustomIterator<T> implements Iterator<T> {

	private final Iterator<T> iterator;
	private final Filter<T> filter;
	private boolean hasNext = true;
	private T next;

	public CustomIterator(final Iterator<T> iterator, final Filter<T> filter) {
		this.iterator = iterator;
		Objects.requireNonNull(iterator);
		this.filter = filter;
		this.findNext();
	}

	@Override
	public boolean hasNext() {
		return this.next != null;
	}

	@Override
	public T next() {
		T returnObject = this.next;
		this.findNext();
		return returnObject;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	private void findNext() {
		while (iterator.hasNext()) {
			this.next = iterator.next();
			if (this.filter.accept(this.next)) {
				return;
			}
		}
		this.next = null;
		this.hasNext = false;
	}


}

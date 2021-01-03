package application;

import java.util.ArrayList;

public class DataTableIterator implements Iterator {

	private ArrayList<DataTable> iterator;
	private int pos = 0;

	DataTableIterator(ArrayList<DataTable> arr) {
		iterator = arr;
	}

	@Override
	public boolean hasnext() {
		if (pos >= iterator.size()) {
			return false;
		} else
			return true;
	}

	@Override
	public DataTable next() {

		DataTable temp = iterator.get(pos);
		pos = pos + 1;
		return temp;
	}

}

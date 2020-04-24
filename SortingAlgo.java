

public class SortingAlgo<T>{
	
	private T[] merge(T[] data, int left, int right, Sorter<T> Comparator) {
		T[] toBeReturned = (T[]) new Object[right - left + 1];
    	int mid = (left + right)/2;
    	int i = left; int j = mid + 1;
    	int k = 0;
    	while(i <= mid && j <= right) {
    		if( Comparator.compare(data[i], data[j])<= 0){
    			toBeReturned[k++] = data[i++];
    		}
    		else {
    			toBeReturned[k++] = data[j++];
    		}
    	}
    	while(i <= mid) {
    		toBeReturned[k++] = data[i++];
    	}
    	while(j <= right) {
    		toBeReturned[k++] = data[j++];
    	}
    	for(int p = left; p <=right; p++) {
    		data[p] = toBeReturned[p - left];
    	}
    	return data;
	}
	
	private T[] mergesort(T[] data, int left, int right, Sorter<T> Comparator) {
		int mid = (left + right)/2;
    	if(left >= right ) return data;// do nothing!
    	else {
    		data = mergesort(data, left, mid, Comparator);
    		data = mergesort(data, mid+1, right, Comparator);
    		data = merge(data, left, right, Comparator);
    	}
    	return data;
	}
	public T[] mergeSort(T[] data, Sorter<T> Comparator) {
		data = mergesort(data, 0, data.length - 1, Comparator);
		return data;
	}
}
	
	
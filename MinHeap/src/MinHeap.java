
import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {
    private List<T> list;    

    public MinHeap() {
        list = new ArrayList<T>();        
    }

    public MinHeap(int max) {
        list = new ArrayList<T>(max);        
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    private boolean hasChildren(int index) {
        return  (2 * index) + 1 < list.size();
    }

    private int getParentIndex(int index) {
        int parentIndex;
        if(isEven(index)) parentIndex = (index / 2) - 1;
        else parentIndex = index / 2;
        return parentIndex;
    }

    private void swap(int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public void printList() {
        for(T element : list) System.out.print(element + " ");
        System.out.println();
    }

    private void swim(int index) {
        while(index > 0) {
            T currentValue = list.get(index);
            T parentValue = list.get(getParentIndex(index));
            if(currentValue.compareTo(parentValue) < 0) {
                swap(index, getParentIndex(index));
                index = getParentIndex(index);
            }
            else return;
        }
    }

    private int getSmallerChildIndex(int index) {
        if((2 * index) + 2 < list.size() && (list.get(2 * index + 2).compareTo(list.get(2 * index + 1)) < 0)) return 2 * index + 2;
        return 2 * index + 1;
    }

    private void sink(int index) {
        while(hasChildren(index)) {
            T currentValue = list.get(index);
            int smallerIndex = getSmallerChildIndex(index);            
            if(currentValue.compareTo(list.get(smallerIndex)) > 0) {
                swap(index, smallerIndex);
                index = smallerIndex;
            }
            else return;
        }        
    }

    public void insert(T value) {
        list.add(value);
        swim(list.size() - 1);
    }

    public T deleteMin() {
        T min = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        sink(0);
        return min;
    }

    public T getMin() {
        if(!list.isEmpty()) return list.get(0);
        return null;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }
}
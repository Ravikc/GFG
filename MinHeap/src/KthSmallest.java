
import java.util.Scanner;

public class KthSmallest {
    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<Integer>();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("1.Insert 2.Peek 3.Delete");
            switch(Integer.parseInt(scanner.nextLine())) {
                case 1: heap.insert(Integer.parseInt(scanner.nextLine()));
                    break;
                case 2: System.out.println(heap.getMin());
                    break;
                case 3: System.out.println(heap.deleteMin());
                    break;
                case 4: heap.printList();
                    break;
                default: return;
            }
        }
    }
}
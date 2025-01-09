import utils.SmallestBiggest;

public class Main {
    public static void main(String[] args) {
       SmallestBiggest<Integer> algorithm = new SmallestBiggest<>();
       Integer[] array = new Integer[] { 3, 1, 5, 42 };
       algorithm.find(array);

        System.out.println("biggest: " + algorithm.getBiggest());
        System.out.println("smallest: " + algorithm.getSmallest());
    }
}
package day3;

public class Main {
    public static void main(String[] args) {
        String fileName = "./src/day3/input.txt";
        MullItOver mit = new MullItOver();

        long sum = mit.getMulStatementsSum(fileName);
        System.out.println("total mul(*,*) sum is: " + sum);

        long doDontSum = mit.getDoDontMulStatementsSum(fileName);
        System.out.println("total do/dont mul(*,*) sum is: " + doDontSum);
    }
}

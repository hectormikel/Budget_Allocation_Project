import java.util.ArrayList;
import java.util.Scanner;

public class BudgetAllocationProject {
    public static void main(String[] args) {
        System.out.println("How much can you spend?");
        Scanner scan = new Scanner(System.in);
        double total = scan.nextDouble();
        double sum = 0; // must be <= 100
        int i = 0; // index number of array list
        // double value; // to store user input
        double cumulativeSum;
        double expense;

        ArrayList<Double> proportion = new ArrayList<Double>();
        System.out.println("Enter your proportion of various expenses.");
        System.out.println("The system stops if aggregate proportion reaches or exceeds 100%.");
        do {
            System.out.println("Your proportion of expense " + (i + 1) + ":");
            double value = scan.nextDouble();
            proportion.add(value);
            sum += proportion.get(i);
            i++;
        } while (sum <= 100);
        scan.close();
        if (sum>100) {
            cumulativeSum = 0.0;
            for (int j = 0; j < proportion.size() - 1; j++) {
                cumulativeSum += proportion.get(j);
            }
            proportion.set(proportion.size() - 1, 100 - cumulativeSum);
        }
        for (double value : proportion) {
            expense = value * total / 100.0;
            System.out.println("Your " + value + " % equals $" + expense);
        }
    }
}

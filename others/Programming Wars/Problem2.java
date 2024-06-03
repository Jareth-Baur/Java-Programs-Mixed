import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter series: ");
        String input = scan.nextLine();

        String[] series = input.split(",");
        ArrayList<String> newSeries = new ArrayList<>();
        for (int i = 0; i < series.length; i++) {
            if (!newSeries.contains(series[i])) {
                newSeries.add(series[i]);
            }
        }
        String[] arraySeries = new String[newSeries.size()];
        for (int i = 0; i < arraySeries.length; i++) {
            arraySeries[i] = newSeries.get(i);
        }
        Arrays.sort(arraySeries);
        boolean thereHasNoBeenDeleted = true;
        int count;
        for (int i = 0; i < arraySeries.length; i++) {
            count = 0;
            for (int j = 0; j < series.length; j++) {
                if (series[j].equalsIgnoreCase(arraySeries[i])) {
                    count++;
                }
            }
            if (count > 1) {
                System.out.println("Number " + arraySeries[i] + ": " + (count - 1) + " copies are deleted.");
                thereHasNoBeenDeleted = false;
            }
        }
        if (thereHasNoBeenDeleted) {
            System.out.println("No duplicate numbers.");
        }
        System.out.print("Result: ");
        for (int i = 0; i < newSeries.size(); i++) {
            String result = ((newSeries.size() - 1) == i) ? newSeries.get(i) : newSeries.get(i) + ",";
            System.out.print(result);
        }
        scan.close();
    }
}

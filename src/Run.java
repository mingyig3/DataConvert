import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println("筛选数据路径？");
        String ExampleInput = userInputScanner.nextLine();
        System.out.println("VIP数据路径？");
        String SearchInput = userInputScanner.nextLine();
        Import example = new Import();
        Import search = new Import();
        try {
            example.Run(ExampleInput);
            search.Run(SearchInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("VIP 限制？");
        double inputVIP = userInputScanner.nextDouble();
        System.out.println("A组数量？");
        int inputNumberOfA = userInputScanner.nextInt();
        System.out.println("B组数量？");
        int inputNumberOfB = userInputScanner.nextInt();
        ArrayList get = Search.FindPeak(search.getData(), inputVIP);
        ArrayList convert = Search.IsZero(get, example.getData());
        ArrayList last =  new ArrayList();
        last.add(convert.get(0));
        for (int i = 1; i < convert.size(); i++) {
            ArrayList eachCheck = (ArrayList) convert.get(i);
            if (Search.CheckT(eachCheck, inputNumberOfA, inputNumberOfB)) {
                last.add(eachCheck);
            }
        }
        System.out.println("筛选VIP后数据路径？");
        String SearchOutputPath = userInputScanner.next();
        System.out.println("筛选0后数据路径？");
        String ZeroOutputPath = userInputScanner.next();
        System.out.println("筛选t后数据路径？");
        String TOutputPath = userInputScanner.next();
        System.out.println("数据容量 "+example.getData().size());
        System.out.println("VIP筛选后数量 "+get.size());
        System.out.println("0筛选后数量 "+convert.size());
        System.out.println("t筛选后数量 "+last.size());
        try {
            Output.Run(get, SearchOutputPath);
            Output.Run(convert, ZeroOutputPath);
            Output.Run(last, TOutputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

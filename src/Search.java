import java.util.ArrayList;
import java.util.List;

public class Search {
    public static ArrayList FindPeak (ArrayList input, double check) {
        ArrayList output = new ArrayList();
        output.add(input.get(0));
        for (int i = 1; i < input.size(); i++) {
            ArrayList row = (ArrayList) input.get(i);
            if ((double) row.get(1) < check) {
                continue;
            }
            output.add(row);
        }
        return output;
    }
    public static ArrayList IsZero (ArrayList input, ArrayList check) {
        ArrayList output = new ArrayList();
        output.add(check.get(0));
        for (int i = 1; i < input.size(); i++) {
            ArrayList testArray = (ArrayList) input.get(i);
            double test = (double) testArray.get(0);
            for (int j = 1; j < check.size(); j++) {
                ArrayList checkRow = (ArrayList) check.get(j);
                if ((double) checkRow.get(0) != test) {
                    continue;
                } else if (checkRow.contains(0.0)) {
                    continue;
                } else {
                    output.add(checkRow);
                }
            }
        }
        return output;
    }
    private static double AverageMaker (List input) {
        double summer = 0.0;
        for (int i = 0; i < input.size(); i++) {
            summer += (double) input.get(i);
        }
        return summer/input.size();
    }
    private static double SSquare (List input, double average) {
        double summer = 0.0;
        for (int i = 0; i < input.size(); i++) {
            double each = (double) input.get(i);
            summer += Math.pow(each - average, 2);
        }
        return summer/input.size();
    }
    public static boolean CheckT (ArrayList input, int NumberOfA, int NumberOfB) {
        int dof = NumberOfA + NumberOfB - 2;
        List GroupOne = input.subList(3, 3 + NumberOfA);
        List GroupTwo = input.subList(3 + NumberOfA, 3+ NumberOfA + NumberOfB);
        double preCalculate = (GroupOne.size() - 1) * SSquare(GroupOne, AverageMaker(GroupOne)) + (GroupTwo.size()-1) * SSquare(GroupTwo, AverageMaker(GroupTwo));double tValue = (AverageMaker(GroupOne) - AverageMaker(GroupTwo)) / Math.sqrt(preCalculate / (GroupOne.size() + GroupTwo.size() - 2) * (1/GroupOne.size()+1/GroupTwo.size()));
        tValue = Math.abs(tValue);
        if (dof == 1) {
            return (tValue > 12.706);
        } else if (dof == 2) {
            return (tValue > 4.303);
        } else if (dof == 3) {
            return (tValue > 3.182);
        } else if (dof == 4) {
            return (tValue > 2.776);
        } else if (dof == 5) {
            return (tValue > 2.571);
        } else if (dof == 6) {
            return (tValue > 2.447);
        } else if (dof == 7) {
            return (tValue > 2.365);
        } else if (dof == 8) {
            return (tValue > 2.306);
        } else if (dof == 9) {
            return (tValue > 2.262);
        } else if (dof == 10) {
            return (tValue > 2.228);
        } else if (dof == 11) {
            return (tValue > 2.201);
        } else if (dof == 12) {
            return (tValue > 2.179);
        } else if (dof == 13) {
            return (tValue > 2.160);
        } else if (dof == 14) {
            return (tValue > 2.145);
        } else if (dof == 15) {
            return (tValue > 2.131);
        } else if (dof == 16) {
            return (tValue > 2.120);
        } else if (dof == 17) {
            return (tValue > 2.110);
        } else if (dof == 18) {
            return (tValue > 2.101);
        } else if (dof == 19) {
            return (tValue > 2.093);
        } else if (dof == 20) {
            return (tValue > 2.086);
        } else if (dof == 21) {
            return (tValue > 2.080);
        } else if (dof == 22) {
            return (tValue > 2.074);
        } else if (dof == 23) {
            return (tValue > 2.069);
        } else if (dof == 24) {
            return (tValue > 2.064);
        } else if (dof == 25) {
            return (tValue > 2.060);
        } else if (dof == 26) {
            return (tValue > 2.056);
        } else if (dof == 27) {
            return (tValue > 2.052);
        } else if (dof == 28) {
            return (tValue > 2.048);
        } else if (dof == 29) {
            return (tValue > 2.045);
        } else if (dof == 30) {
            return (tValue > 2.042);
        } else if (dof == 31) {
            return (tValue > 2.040);
        } else if (dof == 32) {
            return (tValue > 2.037);
        } else if (dof == 33) {
            return (tValue > 2.035);
        } else if (dof == 34) {
            return (tValue > 2.032);
        } else if (dof == 35) {
            return (tValue > 2.030);
        } else if (dof == 36) {
            return (tValue > 2.028);
        } else if (dof == 37) {
            return (tValue > 2.026);
        } else if (dof == 38) {
            return (tValue > 2.024);
        } else if (dof == 39) {
            return (tValue > 2.023);
        } else if (dof >= 1000) {
            return (tValue > 1.962);
        } else if (dof >= 500) {
            return (tValue > 1.965);
        } else if (dof >= 200) {
            return (tValue > 1.972);
        } else if (dof >= 100) {
            return (tValue > 1.984);
        } else if (dof >= 90) {
            return (tValue > 1.987);
        } else if (dof >= 80) {
            return (tValue > 1.990);
        } else if (dof >= 70) {
            return (tValue > 1.994);
        } else if (dof >= 60) {
            return (tValue > 2.000);
        } else if (dof >= 50) {
            return (tValue > 2.009);
        } else if (dof >= 40) {
            return (tValue > 2.021);
        } else {
            return false;
        }
    }
}

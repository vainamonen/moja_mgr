package pl.mgr.service;

import pl.mgr.constant.ConstantAlfa;
import pl.mgr.constant.RadiationType;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CalculationService {

    // tu metody liczące rozne rzeczy
    public int liczcos() {
        return ConstantAlfa.E * ConstantAlfa.E;
    }

    public void printResult() {

    }

    public double beta() {
        return Math.sqrt(ConstantAlfa.Ek * (ConstantAlfa.Ek + 2 * ConstantAlfa.M)) / (ConstantAlfa.Ek + ConstantAlfa.M);
    }

    public double gamma() {
        return 1 / Math.sqrt(1 - beta() * beta());

    }


    public double potencjal() {

        return 9.1 * ConstantAlfa.Z * (1 + (1.9 / Math.pow(ConstantAlfa.Z, 0.67))); //sredni potencjal jonizacji
    }

    public double Tmax() {
        return (2 * ConstantAlfa.mel * beta() * beta() * gamma() * gamma()) / (1 + 2 * gamma() * (ConstantAlfa.mel / ConstantAlfa.M) + (ConstantAlfa.mel / ConstantAlfa.M) * (ConstantAlfa.mel / ConstantAlfa.M));
    }


    public double BetheBloch() {

        return ConstantAlfa.dE = -ConstantAlfa.K * ConstantAlfa.ro * ConstantAlfa.z * ConstantAlfa.z * (ConstantAlfa.Z / ConstantAlfa.A) * (1 / (beta() * beta())) * (0.5 * Math.log((2 * ConstantAlfa.mel * ConstantAlfa.c * ConstantAlfa.c * beta() * beta() * gamma() * gamma() * Tmax()) / (potencjal() * potencjal())) - beta() * beta());


        //return;
    }

    public void calculate(RadiationType selectedRadiationType, double selectedEnergy, double selectedDx) {
        List<String> toPrint = new ArrayList<>();
        String startText = "Dane wejściowe calculate: " + selectedRadiationType + " " + selectedEnergy + " " + selectedDx;
        System.out.println(startText);
        toPrint.add(startText);

        double x = 0.0;             //position in mm
        double dE = 0.0;        //energy loss
        //double dx = 1.e-6;  	//1mm todo czy to to samo co selectedDx?
        double dEdx = 0.0;

        // double Ekin = 0.1;//todo czy to to samo co selectedEnergy?

        while (selectedEnergy > 0.0) {
//            plik << x << " , " << dEdx << endl;
            String stepText = x + " , " + dEdx;
            System.out.println(stepText);
            toPrint.add(stepText);
            dEdx = beta();
            dE = dEdx * selectedDx;     //units J/m*dx
            x = x + selectedDx;
            selectedEnergy = selectedEnergy - dE;
            if (dE < 0) {
                break;
            }
        }
        zapiszPlik("calculate.txt", toPrint);
    }

    private static void zapiszPlik(String nazwaPliku, List<String> toPrint) {
        try {
            final PrintWriter out = new PrintWriter(nazwaPliku);

            for (String line : toPrint) {
                out.println(line);
            }
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nie utworzono pliku");
        }
    }

    public static void zapiszPlik(String nazwaPliku) {
        try {
            PrintWriter out = new PrintWriter(nazwaPliku);

            out.println("raz");
            out.println("dwa");
            out.println("trzy");
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nie utworzono pliku");
        }
    }
}

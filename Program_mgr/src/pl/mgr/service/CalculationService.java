package pl.mgr.service;

import pl.mgr.constant.ConstantAlfa;
import pl.mgr.constant.RadiationType;

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
        System.out.println("Dane wejściowe calculate: " + selectedRadiationType + " " + selectedEnergy + " " + selectedDx);

        double x = 0.0;        	 //position in mm
        double dE = 0.0;     	//energy loss
        double dx = 1.e-6;  	//1mm todo czy to to samo co selectedDx?
        double dEdx = 0.0;

        double Ekin = 0.1;//todo czy to to samo co selectedEnergy?

        while(Ekin > 0.0){
//            plik << x << " , " << dEdx << endl;
            System.out.println(x + " , " + dEdx);
            dEdx = beta();
            dE = dEdx*dx;     //units J/m*dx
            x = x + dx;
            Ekin = Ekin - dE;
            if(dE < 0) {
                break;
            }
        }
    }
}

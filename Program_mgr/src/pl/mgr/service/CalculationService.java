package pl.mgr.service;

import pl.mgr.constant.ConstantAlfa;

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
}

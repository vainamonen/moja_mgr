package pl.mgr.ui;

import pl.mgr.constant.RadiationType;
import pl.mgr.service.CalculationService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_window {
    private JComboBox promieniowanie;
    private JTextField energia;
    private JTextField krok_dx;
    private JButton oblicz;

    private RadiationType selectedRadiationType = RadiationType.ALFA;
    private double selectedEnergy = 0;
    private double selectedDx = 0;

    private final CalculationService calculationService;



    public main_window(final CalculationService calculationService) {
        this.calculationService = calculationService;

        promieniowanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox source = (JComboBox) e.getSource();
                String selectedItem = (String) source.getSelectedItem();
                switch (selectedItem) {
                    case "alfa":
                        selectedRadiationType = RadiationType.ALFA;
                        break;
                    case "beta":
                        selectedRadiationType = RadiationType.BETA;
                        break;
                    case "gamma,X":
                        selectedRadiationType = RadiationType.GAMMA_X;
                        break;
                    case "neutronowe":
                        selectedRadiationType = RadiationType.NEUTRONOWE;
                        break;
                    default:
                        break;
                }
                System.out.println("Wybrano typ promieniowania: " + selectedRadiationType);
            }
        });

        oblicz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedEnergy = Double.parseDouble(energia.getText());
                selectedDx = Double.parseDouble(krok_dx.getText());
                System.out.println("Przycisk\nDane: " + selectedRadiationType + " " + selectedEnergy + " " + selectedDx);

                calculationService.calculate(selectedRadiationType, selectedEnergy, selectedDx);
            }
        });


    }


    public static void main(String[] args) {
        CalculationService calculationService = new CalculationService();
        int result = calculationService.liczcos();


        main_window mainWindow = new main_window(calculationService);

        JFrame frame = new JFrame("Aplikacja");
        JPanel jPanel = new JPanel();
        jPanel.add(mainWindow.promieniowanie);
        jPanel.add(mainWindow.energia);
        jPanel.add(mainWindow.krok_dx);
        jPanel.add(mainWindow.oblicz);

        frame.setContentPane(jPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        frame.setSize(500, 500);

        mainWindow.energia.setPreferredSize(new Dimension(100, 30));
        mainWindow.krok_dx.setPreferredSize(new Dimension(100, 30));
        mainWindow.oblicz.setPreferredSize(new Dimension(100, 30));

        System.out.println("wynik " + calculationService.Tmax());




        String nazwaPliku = "dane16.05.txt";
        CalculationService.zapiszPlik(nazwaPliku);
    }
}



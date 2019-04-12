package pl.mgr.ui;

import pl.mgr.service.CalculationService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class main_window {
    private JComboBox promieniowanie;
    private JSlider Energia;
    private JButton button1;

    public main_window(CalculationService calculationService) {


        promieniowanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        Energia.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                //zczytać z tego eventu wartosc z suwaka e.getComponent()
                calculationService.printResult();
                //printService.printResult(energia z suwaka, inne)
                super.componentResized(e);
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        jPanel.add(mainWindow.Energia);

        frame.setContentPane(jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame. setSize(500,500);

        System.out.println("wynik " + calculationService.Tmax());

    }
}



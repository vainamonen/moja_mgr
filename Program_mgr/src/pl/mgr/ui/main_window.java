package pl.mgr.ui;

import pl.mgr.service.CalculationService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class main_window {
    private JComboBox promieniowanie;
    private JTextField Energia;
    private JTextField krok_dx;
    private JButton button1;

    public main_window(CalculationService calculationService) {


        promieniowanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        Energia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               Energia.setSize(100,200);
                //Energia.setPreferredSize(new Dimension(100,20));
                Energia.setVisible(true);


            }
        });

        krok_dx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                krok_dx.setSize(100,200);
                krok_dx.setVisible(true);
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
        jPanel.add(mainWindow.krok_dx);



        frame.setContentPane(jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,500);

        System.out.println("wynik " + calculationService.Tmax());

    }
}



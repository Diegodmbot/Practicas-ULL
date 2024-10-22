package practica07;

import org.apache.batik.transcoder.TranscoderException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

public class GUI {
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel infoLabel;
    private JButton botonActualizar;
    private Observer observer;

    public GUI() throws IOException, TranscoderException {
        frame = new JFrame();
        mainPanel = new JPanel(new GridBagLayout());
        infoLabel = new JLabel("Se muestran estadísticas de los jugadores del Mundial de 2022", SwingConstants.CENTER);
        botonActualizar = new JButton("Actualizar");

        GridBagConstraints mainPanelConstraints = new GridBagConstraints();
        observer = new Observer();
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                observer.getPlayersFromData();
                observer.createScorersRaking();
                try {
                    mainPanel.add(observer.getRanking(), mainPanelConstraints);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        mainPanel.add(infoLabel, mainPanelConstraints);
        mainPanelConstraints.gridy = 1;
        mainPanel.add(observer.getRanking(), mainPanelConstraints);
        mainPanelConstraints.gridy = 2;
        mainPanel.add(botonActualizar, mainPanelConstraints);

        frame.add(mainPanel);
        frame.setSize(500,720);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws IOException, TranscoderException {
        GUI gui = new GUI();
    }
}
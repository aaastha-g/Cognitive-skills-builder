package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import java.awt.image.BufferedImage;

public class MazeGameStartGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Maze Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(626, 417);
        frame.setLocationRelativeTo(null);

        try {
            // Load background image from the "player" package
            InputStream backgroundStream = MazeGameStartGUI.class.getResourceAsStream("/player/spacebg.png");
            if (backgroundStream != null) {
                BufferedImage backgroundImage = ImageIO.read(backgroundStream);
                JPanel backgroundPanel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                    }
                };
                frame.setContentPane(backgroundPanel);
            } else {
                System.err.println("Background image not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel buttonPanel = new JPanel();
        JButton playButton = new JButton();

        try {
            // Load play button image from the "player" package
            InputStream playButtonStream = MazeGameStartGUI.class.getResourceAsStream("/player/playB.png");
            if (playButtonStream != null) {
                BufferedImage playButtonImage = ImageIO.read(playButtonStream);
                playButton.setIcon(new ImageIcon(playButtonImage));
                playButton.setPreferredSize(new Dimension(150, 73)); // Set the preferred size
            } else {
                System.err.println("Play button image not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonPanel.add(playButton);
        frame.add(buttonPanel, BorderLayout.CENTER);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Start your main class here
                // Replace MainClass with your actual main class
                main.main(new String[0]);
                frame.dispose(); // Close the start GUI when the game starts
            }
        });

        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainGUI {
    private static Gemi gemi1;
    private static Gemi gemi2;
    private static JLabel gemi1HealthLabel;
    private static JLabel gemi2HealthLabel;
    private static JTextArea logArea;
    private static List<Gemi> gemiListesi;

    public static void main(String[] args) {
        // Gemi listesi
        gemiListesi = Arrays.asList(
                new Ubot("Deniz Kurdu", "UB-01", Arrays.asList("Torpido", "Mayın")),
                new ZirhliGemi("Yıldırım", "ZG-77", Arrays.asList("Top", "Roket")),
                new UcakGemisi("Gökyüzü Hakimi", "UG-55", List.of("Jet")),
                new DevriyeBotu("Hızlı Balık", "DB-12", List.of("Hafif Top"))
        );

        Random rand = new Random();
        gemi1 = gemiListesi.get(rand.nextInt(gemiListesi.size()));
        gemi2 = gemiListesi.get(rand.nextInt(gemiListesi.size()));
        while (gemi1 == gemi2) {
            gemi2 = gemiListesi.get(rand.nextInt(gemiListesi.size()));
        }

        JFrame frame = new JFrame("Gemi Kapışması");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel healthPanel = new JPanel();
        healthPanel.setLayout(new GridLayout(2, 1));

        gemi1HealthLabel = new JLabel(gemi1.getGemiAdi() + " Sağlık: " + gemi1.saglik);
        gemi2HealthLabel = new JLabel(gemi2.getGemiAdi() + " Sağlık: " + gemi2.saglik);

        healthPanel.add(gemi1HealthLabel);
        healthPanel.add(gemi2HealthLabel);

        frame.add(healthPanel, BorderLayout.NORTH);

        logArea = new JTextArea(10, 50);
        logArea.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(logArea);
        frame.add(logScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton attackButton1 = new JButton("Saldır: " + gemi2.getGemiAdi());
        JButton attackButton2 = new JButton("Saldır: " + gemi1.getGemiAdi());
        JButton specialButton1 = new JButton("Özel Saldırı: " + gemi2.getGemiAdi());
        JButton specialButton2 = new JButton("Özel Saldırı: " + gemi1.getGemiAdi());

        buttonPanel.add(attackButton1);
        buttonPanel.add(attackButton2);
        buttonPanel.add(specialButton1);
        buttonPanel.add(specialButton2);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        attackButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gemi1.saldir(gemi2);
                updateHealthLabels();
                logArea.append(gemi1.getGemiAdi() + " " + gemi1.saglikDurumu() + " HP ile saldırdı.\n");
                checkGameOver();
            }
        });

        attackButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gemi2.saldir(gemi1);
                updateHealthLabels();
                logArea.append(gemi2.getGemiAdi() + " " + gemi2.saglikDurumu() + " HP ile saldırdı.\n");
                checkGameOver();
            }
        });

        specialButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gemi1.ozelSaldiri(gemi2);
                updateHealthLabels();
                logArea.append(gemi1.getGemiAdi() + " özel saldırısını kullandı!\n");
                checkGameOver();
            }
        });

        specialButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gemi2.ozelSaldiri(gemi1);
                updateHealthLabels();
                logArea.append(gemi2.getGemiAdi() + " özel saldırısını kullandı!\n");
                checkGameOver();
            }
        });

        frame.setVisible(true);
    }

    private static void updateHealthLabels() {
        gemi1HealthLabel.setText(gemi1.getGemiAdi() + " Sağlık: " + gemi1.saglik);
        gemi2HealthLabel.setText(gemi2.getGemiAdi() + " Sağlık: " + gemi2.saglik);
    }

    private static void checkGameOver() {
        if (gemi1.saglik <= 0) {
            logArea.append(gemi2.getGemiAdi() + " kazandı!\n");
            disableButtons();
            showNewGameButton();  // Yeni oyun butonunu göster
        } else if (gemi2.saglik <= 0) {
            logArea.append(gemi1.getGemiAdi() + " kazandı!\n");
            disableButtons();
            showNewGameButton();  // Yeni oyun butonunu göster
        }
    }

    private static void showNewGameButton() {

        JButton newGameButton = new JButton("Yeni Oyun");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();  // Yeni oyunu başlat
            }
        });

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(gemi1HealthLabel);
        JPanel buttonPanel = (JPanel) frame.getContentPane().getComponent(2);
        buttonPanel.add(newGameButton);
        frame.revalidate();
        frame.repaint();
    }

    private static void startNewGame() {

        gemi1.saglik = 500;
        gemi2.saglik = 500;

        Random rand = new Random();
        gemi1 = gemiListesi.get(rand.nextInt(gemiListesi.size()));
        gemi2 = gemiListesi.get(rand.nextInt(gemiListesi.size()));
        while (gemi1 == gemi2) {
            gemi2 = gemiListesi.get(rand.nextInt(gemiListesi.size()));
        }

        gemi1HealthLabel.setText(gemi1.getGemiAdi() + " Sağlık: " + gemi1.saglik);
        gemi2HealthLabel.setText(gemi2.getGemiAdi() + " Sağlık: " + gemi2.saglik);

        logArea.setText("");

        JPanel buttonPanel = (JPanel) ((JFrame) SwingUtilities.getWindowAncestor(gemi1HealthLabel)).getContentPane().getComponent(2);
        for (Component comp : buttonPanel.getComponents()) {
            comp.setEnabled(true);
        }

        for (Component comp : buttonPanel.getComponents()) {
            if (comp instanceof JButton && ((JButton) comp).getText().equals("Yeni Oyun")) {
                buttonPanel.remove(comp);
            }
        }
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    private static void disableButtons() {
        for (Component comp : ((JPanel) ((JFrame) SwingUtilities.getRoot(gemi1HealthLabel)).getContentPane().getComponent(2)).getComponents()) {
            comp.setEnabled(false);
        }
    }
}

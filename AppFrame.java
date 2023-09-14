package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;

import Com_decom.compressor;
import Com_decom.decompressor;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton = new JButton("Select file to compress");

        compressButton.setBounds(20, 100, 200, 30);

        compressButton.addActionListener((ActionListener) this);

        decompressButton = new JButton("Select file to decompress");

        decompressButton.setBounds(20, 100, 200, 30);

        decompressButton.addActionListener((ActionListener) this);
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000, 500);
        this.getContentPane().setBackground(Color.green);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    compressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee, ee.toString(), response);
                }
            }

        }

        if (e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    decompressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee, ee.toString(), response);
                }
            }
        }

    }

}

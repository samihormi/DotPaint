// https://docs.oracle.com/javase/tutorial/deployment/jar/build.html
// Put Runner and TextLineNumber in the same folder
// Run: javac *.java
// Run: jar cvf run.jar *.class

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Painter++") {
            @Override
            public boolean isMinimumSizeSet() {
                return true; //super.isMinimumSizeSet();
            }
            @Override
            public Dimension getMinimumSize() {
                Dimension dim = super.getMinimumSize();
                // adjust for insets if we are faking the isMinSet
                if (!super.isMinimumSizeSet() && !isDefaultLookAndFeelDecorated()) {
                    Insets insets = getInsets();
                    dim.width += insets.left + insets.right;
                    dim.height += insets.bottom + insets.top;
                }
                return dim;
            }
        };

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        String title = "Welcome to Painter++";
        String body = "Type your commands in the text box below and press run when you want to execute it.";

        JLabel label = new JLabel("<html><div style='text-align: center; font-size: 25px'>" + title + "</div>" +
                "<p style='text-align:center; font-size: 15px'>" + body +"</p>" +
                "</html>");

        JTextArea textArea = new JTextArea(25, 25);
        textArea.setFont(textArea.getFont().deriveFont(20f));
        JScrollPane scrollPane = new JScrollPane(textArea);
        TextLineNumber tln = new TextLineNumber(textArea);
        scrollPane.setRowHeaderView( tln );

        frame.add(label);
        frame.add(scrollPane);

        // Menu
        JMenuBar menubar = new JMenuBar();

        JMenu menu = new JMenu("File");
        JMenuItem run = new JMenuItem(new AbstractAction("Run Code") {
            public void actionPerformed(ActionEvent e) {
                String contents = textArea.getText();
                try {
                    FileWriter file = new FileWriter("input.txt");
                    BufferedWriter output = new BufferedWriter(file);
                    output.write(contents);
                    output.close();

                    Runtime rt = Runtime.getRuntime();
                    Process pr = rt.exec("java graphlang.Compiler input.txt");
                }
                catch (Exception err) {
                    err.getStackTrace();
                }
            }
        });
        run.setAccelerator(KeyStroke.getKeyStroke('R', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));

        JMenuItem new_file = new JMenuItem(new AbstractAction("New File") {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        new_file.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));


        menu.add(run);
        menu.add(new_file);

        JMenu info = new JMenu("About");
        JMenuItem help = new JMenuItem("Help");
        info.add(help);

        menubar.add(menu);
        menubar.add(info);
        frame.setJMenuBar(menubar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

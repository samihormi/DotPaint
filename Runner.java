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

    public static void showHelpFrame(){

        JFrame helpFrame = new JFrame("Help") {
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
        String title = "Painter++ User Guide";
        JLabel label = new JLabel("<html><div style='text-align: center; font-size: 25px'>" + title + "</div>" + "</p>" +
                "</html>");

//        JTextArea textArea = new JTextArea(25, 25);
//        textArea.setFont(textArea.getFont().deriveFont(20f));
//        TextLineNumber tln = new TextLineNumber(textArea);


        helpFrame.add(label);




//        helpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JTextArea textArea = new JTextArea();

        textArea.setText("Painter++ is a programming language for drawing. Drawing is done by issuing instructions to the cursor. The cursor draws lines and shapes as it moves, using various colors and styles.\n" +
                "If you ever run into any problems with Painter++, here's where you can find some help! If something is still not clear, or not working - let us know, by choosing \"Contact Us\" in the bottom-right corner. We'd love to hear your feedback, suggestions and bug reports. Thank you!\n" +
                "\n" +
                "In Painter++ you are a character moving around the map. As you move in different directions you can mark down certain positions where you want to draw. You do not need to create any complex shapes or write complicated code. All you do is move (up, down, left, right) and mark points with a color you like. Once you have the outline for your shape, you can call write \"connect\" and choose which color points you want to connect. \n" +
                "\n" +
                "MAKE: \n" +
                "\tMAKE <number>\n" +
                "Before diving straight into drawing, we need to define the size of our pane. It is done by saying \"MAKE\" and specifying the width and height in pixels such as \"MAKE 10\"\n" +
                "MOVE:\n" +
                "\tMOVE <direction> <number>\n" +
                "The pane is your space for freedom and exploration. You can move in one of the 4 directions (UP, DOWN, LEFT, RIGHT) and then specify how far you want to move. For example, you can say \"MOVE RIGHT 5\" and you are now 5 pixels to the right from where you started.\n" +
                "CHOOSE:\n" +
                "\tCHOOSE <color>\n" +
                "Figures are defined by their color. You can choose the color you want to draw with by saying something like \"CHOOSE RED\"\n" +
                "MARK:\n" +
                "\tMARK\n" +
                "When you move around the pane you can mark down certain locations. For example, to draw a circle you would mark 4 points and then connect them.\n" +
                "CONNECT:\n" +
                "\tCONNECT <color> <shape>\n" +
                "Once you have marked down some points on the pane, you are ready to connect them into all sort of creative shapes. For example, if you have made 4 blue points, you can either call \"CONNECT BLUE STRAIGHT\" to draw a rectangle, or \"CONNECT BLUE CURVED\" to get a shape similar to an oval.\n" +
                "CIRCLE:\n" +
                "\tCIRCLE <color> <number>\n" +
                "To make a nice circle, you need to mark a point where you want the center of your circle to be and specify the diameter of your circle. For example, \"CIRCLE RED 10\" would draw a red circle with a diameter of 10.\n" +
                "ERASE:\n" +
                "\tERASE <color>\n" +
                "If you have drawn a figure but it is not quite what you want, you don\'t need to change any code. Simply say \"ERASE RED\" after you have drawn a red shape.");

                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
//                textArea.setBackground(new Color());
//                textArea.

                textArea.setEditable(false);
//                JScrollPane scroll = new JScrollPane (textArea,
//                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//                JScrollPane scrollableTextArea = new JScrollPane(textArea);
//
//                scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//                scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//
//        helpFrame.getContentPane().add(scrollableTextArea);

//        helpFrame.add(scroll);
                helpFrame.add(textArea);

        JScrollPane scrollPane = new JScrollPane(textArea);

        helpFrame.add(scrollPane);


        helpFrame.pack();
        helpFrame.setVisible(true);
        helpFrame.setBounds(800,0,200,500);
        helpFrame.setSize(400,800);
//        helpFrame.setLayout(new BoxLayout(helpFrame.getContentPane(), BoxLayout.Y_AXIS));
        helpFrame.setResizable(true);


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Painter++(test)") {
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

//        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(800,800);
        String title = "Welcome to Painter++";
        String body = "Type your commands in the text box below and press run when you want to execute it.";

        JLabel label = new JLabel("<html><div style='text-align: center; font-size: 25px'>" + title + "</div>" +
                "<p style='text-align:center; font-size: 15px'>" + body +"</p>" +
                "</html>");

        JTextArea textArea = new JTextArea(25, 35);
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
        JMenuItem empty = new JMenuItem(new AbstractAction("New File") {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        menu.add(empty);
        menu.add(run);

        JMenu info = new JMenu("About");
        JMenuItem help = new JMenuItem(new AbstractAction("Help"){
            public void actionPerformed(ActionEvent e) {
                String contents = textArea.getText();
                try {

                    showHelpFrame();
//                    FileWriter file = new FileWriter("input.txt");
//                    BufferedWriter output = new BufferedWriter(file);
//                    output.write(contents);
//                    output.close();

//                    Runtime rt = Runtime.getRuntime();
//                    Process pr = rt.exec("java graphlang.Compiler input.txt");



                }
                catch (Exception err) {
                    err.getStackTrace();
                }
            }
        });

        info.add(help);

        menubar.add(menu);
        menubar.add(info);
        frame.setJMenuBar(menubar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

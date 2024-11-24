package it.unibo.mvc;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller c = new SimpleController();

    /**
 * Constructor of the class.
 * 
 */
    public SimpleGUI() {
        final JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);
        final JTextField field1 = new JTextField();
        panel.add(field1, BorderLayout.NORTH);
        final JTextArea area1 = new JTextArea();
        area1.setEnabled(false);
        panel.add(area1, BorderLayout.CENTER);
        final JButton buttonSave = new JButton("Print");
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.setNextString(field1.getText());
                c.printCurrentString();
            }
        });
        final JButton buttonHistory = new JButton("Show History");
        buttonHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                area1.setText("");
                for (final String s : c.getHistory()) {
                    area1.append(s);
                    area1.append("\n");
                }
            }
        });
        final JPanel southPanel = new JPanel(new FlowLayout());
        panel.add(southPanel, BorderLayout.SOUTH);
        southPanel.add(buttonSave);
        southPanel.add(buttonHistory);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
 * Make the frame fit the resolution.
 * 
 */
    void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        frame.pack();
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }
    /**
 * Main.
 * 
 * @param args ignore
 */
    public static void main(final String... args) {
        new SimpleGUI().display();
    }
}

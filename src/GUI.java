import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GUI {
    private JPanel JToolBar;
    private JButton sparaButton;
    private JButton öppnaButton;
    private JTextArea textArea1;
    private JButton hittaButton;
    private JButton nyttButton;

    public GUI() {
        sparaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = "text.txt";
                PrintWriter out = null;
                try {
                    out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
                } catch (IOException f) {
                    JOptionPane.showMessageDialog(null,"Failed to Save!");
                }
                out.println(textArea1.getText());
                out.flush();
                out.close();
            }
        });
        öppnaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = "info.txt";
                BufferedReader in = null;
                try {
                    in = new BufferedReader(new FileReader(filename));
                } catch (FileNotFoundException ex) {
                    textArea1.setText("");
                    return;
                }
                String nextLine = null;
                try {
                    nextLine = in.readLine();
                    while (nextLine != null) {
                        textArea1.append(nextLine +"\n");
                        nextLine = in.readLine();
                    }
                } catch (IOException ex) {
                    textArea1.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().JToolBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

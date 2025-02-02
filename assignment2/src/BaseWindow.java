import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BaseWindow extends JFrame {
    JFrame mainFrame;

    public BaseWindow() {
        mainFrame = new JFrame();
        mainFrame.setTitle("Four-Game");
        mainFrame.setSize(400, 300);
        mainFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                showExitConfirmation();
            }

        });
        mainFrame.setLocationRelativeTo(null);
    }

    private void showExitConfirmation() {
        int n = JOptionPane.showConfirmDialog(this, "Do you want to exit?",
                "Confirm exit", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            doUponExit();
        }
    }

    protected void doUponExit() {
        mainFrame.dispose();
        this.dispose();
    }


}

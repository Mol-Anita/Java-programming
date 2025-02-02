import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends BaseWindow{

    public GameGUI() {
            JButton button3x3 = new JButton("3x3");
            JButton button5x5 = new JButton("5x5");
            JButton button7x7 = new JButton("7x7");
            customizeButton(button3x3);
            customizeButton(button5x5);
            customizeButton(button7x7);
            button3x3.addActionListener(new startButtonListener(3, this));
            button5x5.addActionListener(new startButtonListener(5, this));
            button7x7.addActionListener(new startButtonListener(7, this));

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
            mainPanel.setBackground(Color.LIGHT_GRAY);

            JLabel titleLabel = new JLabel("Welcome to the Game!", JLabel.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
            titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

            JLabel instructionLabel = new JLabel("Pick a board size to start the game:", JLabel.CENTER);
            instructionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            instructionLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
            buttonPanel.setBackground(Color.LIGHT_GRAY);

            buttonPanel.add(button3x3);
            buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            buttonPanel.add(button5x5);
            buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            buttonPanel.add(button7x7);

            mainPanel.add(titleLabel, BorderLayout.NORTH);
            mainPanel.add(instructionLabel, BorderLayout.CENTER);
            mainPanel.add(buttonPanel, BorderLayout.SOUTH);

            mainFrame.getContentPane().add(mainPanel);
            mainFrame.setVisible(true);
        }

    private void customizeButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(200, 40));
    }

    static class startButtonListener implements ActionListener {
        private final int size;
        private final BaseWindow mainWindow;
        public startButtonListener(int size, BaseWindow mainWindow) {
            this.size = size;
            this.mainWindow = mainWindow;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            BoardGUI boardGUI = new BoardGUI(size, mainWindow);
            boardGUI.getBoardFrame().setVisible(true);
        }
    }

    @Override
    protected void doUponExit() {
        this.dispose();
        System.exit(0);
    }
}

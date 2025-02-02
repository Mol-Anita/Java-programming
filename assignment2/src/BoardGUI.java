import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BoardGUI extends BaseWindow{
    private final BaseWindow mainWindow;
    private final JButton[][] buttons;
    private final GameManager gameManager;
    private final JPanel boardPanel;
    private final JLabel playerIndicator;
    private final Color colorX;
    private final Color colorO;

    public BoardGUI(int boardSize, BaseWindow mainWindow) {
        gameManager = new GameManager(boardSize);
        this.mainWindow = mainWindow;
        JPanel topPanel = new JPanel();
        playerIndicator = new JLabel();
        updatePlayerLabel();
        topPanel.setSize(boardSize,2);
        topPanel.add(playerIndicator);

        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(topPanel, BorderLayout.NORTH);

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(boardSize, boardSize));

        buttons = new JButton[boardSize][boardSize];
        colorX = Color.GREEN;
        colorO = Color.RED;


        for (int i = 0; i < boardSize; ++i) {
            for (int j = 0; j < boardSize; ++j) {
                JButton button = new JButton("0");
                button.addActionListener(new ButtonListener(i, j));
                button.setPreferredSize(new Dimension(60, 50));
                buttons[i][j] = button;
                boardPanel.add(button);
            }
        }
        mainFrame.add(boardPanel, BorderLayout.CENTER);
        mainFrame.pack();
    }

    private void updatePlayerLabel() {
        playerIndicator.setText("Player's move: " + gameManager.getCurrentPlayer());
    }

    public void refresh(int x, int y, Player currentPlayer) {
        if (x < 0 || y < 0 || x >= gameManager.getBoardSize() || y >= gameManager.getBoardSize()) {
            return;
        }
        JButton button = buttons[x][y];
        Field field = gameManager.getField(x, y);
        Color color;
        if (currentPlayer == Player.X) {
            color = colorX;
        }
        else color = colorO;

        button.setText(String.valueOf(field.getNumber()));
        if(field.getNumber() == 4 && field.getColor() == null) {
            button.setBackground(color);
            field.setColor(color);
        }
    }


    class ButtonListener implements ActionListener {

        private final int x;
        private final int y;

        public ButtonListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (gameManager.getField(x, y).getNumber() < 4) {
                Player currentPlayer = gameManager.fieldSelected(x,y);
                refresh(x, y, currentPlayer);
                refresh(x-1, y, currentPlayer);
                refresh(x+1, y, currentPlayer);
                refresh(x, y-1, currentPlayer);
                refresh(x, y+1, currentPlayer);
                gameManager.nextPlayer();
                updatePlayerLabel();
                Player winner = gameManager.verifyWinner();
                if (winner != Player.NOBODY) {
                    JOptionPane.showMessageDialog(boardPanel, "Player: " + winner+" has won!","Congrats",
                            JOptionPane.PLAIN_MESSAGE);
                    newGame();
                }

            }
        }
    }
    private void newGame(){
        BoardGUI boardGUI = new BoardGUI(gameManager.getBoardSize(), this);
        boardGUI.getBoardFrame().setVisible(true);

        mainFrame.dispose();
        this.dispose();
    }

    public JFrame getBoardFrame(){
        return mainFrame;
    }

}

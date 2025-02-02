public class GameManager {
    private Player currentPlayer;
    private int playerXScore;
    private int playerOScore;
    private final int size;
    private final Board board;

    public GameManager(int size) {
        this.size = size;
        currentPlayer = Player.NOBODY;
        playerXScore = 0;
        playerOScore = 0;
        board = new Board(size);
    }

    public final int getBoardSize(){
        return size;
    }
    public final Player getCurrentPlayer(){
        return currentPlayer;
    }

    public Player fieldSelected(int i, int j){
        if(board.getField(i,j).getNumber() == 4)
            return currentPlayer;

        int score = board.fieldIncrease(i,j);
        if(currentPlayer == Player.X){
            playerXScore += score;
            return Player.O;
        }
        else{
            playerOScore += score;
            return Player.X;
        }
    }

    public Field getField(int i, int j){
        return board.getField(i,j);
    }

    public void nextPlayer(){
        if (currentPlayer == Player.X){
            currentPlayer = Player.O;
        }
        else{
            currentPlayer = Player.X;
        }
    }

    public Player verifyWinner() {
        if (playerXScore + playerOScore == size * size) {
            if (playerXScore > playerOScore) {
                return Player.X;
            } else if (playerOScore > playerXScore) {
                return Player.O;
            }
        }
        return Player.NOBODY;
    }


}

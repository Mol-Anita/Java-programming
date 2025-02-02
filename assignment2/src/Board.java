public class Board {
    private final int size;
    private final Field[][] table;
    private int score;

    public Board(int size) {
        if(size < 0)
            throw new IllegalArgumentException();
        this.size = size;
        table = new Field[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = new Field();
                table[i][j].setNumber(0);
            }
        }
    }

    public int fieldIncrease(int i, int j){
        score = 0;
        if (table[i][j].increaseNumber() == 4){
            score++;
        }
        verifyPoint(i-1,j);
        verifyPoint(i+1,j);
        verifyPoint(i,j-1);
        verifyPoint(i,j+1);

        return score;


    }

    private void verifyPoint(int i, int j){
        if (i < 0 || j < 0 || i >= size || j >= size) {
            return;

        }
        if (table[i][j].getNumber() < 4){
            if(table[i][j].increaseNumber() == 4){
                score++;
            }
        }
    }

    public Field getField(int i, int j){
        return table[i][j];
    }
}

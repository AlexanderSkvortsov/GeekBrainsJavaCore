package myException;

public class MyArrayDataException extends Exception {
    int row,col;

    public MyArrayDataException(String message,int row, int col) {
        super(message);
        this.col=col;
        this.row=row;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}

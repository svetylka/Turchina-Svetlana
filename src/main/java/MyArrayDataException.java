public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int row, int col, String value) {
        super(String.format("Неверные данные в ячейке [%d][%d]: '%s'", row, col, value));
    }
}

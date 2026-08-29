public class Lesson_2_5 {
    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(correctArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        String[][] wrongSizeArray = {
                {"1", "2"},
                {"3", "4"}
        };

        try {
            processArray(wrongSizeArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        }

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "error", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            processArray(wrongDataArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        try {
            int[] testArray = new int[2];
            int element = testArray[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Стандартное исключение: " + e);
        }

    }

    public static int processArray(String[][] arr) {
        if (arr.length != 4) {
            throw new MyArraySizeException("Размер массива неверен. Ожидается матрица 4x4.");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Размер массива неверен. Ожидается матрица 4x4.");
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }
            }
        }
        return sum;
    }
}

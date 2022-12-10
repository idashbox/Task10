package Classes;

import java.io.IOException;
import java.util.Arrays;

public class MainLogicTask {
    public static int[] runMainLogic(int[][] array){
        int[] answer = new int[4];
        answer = array[array.length-1];
        return answer;
    }
    public static int[][] getAnswer(int[][] array){
        int[][] arr = new int[array.length+1][4];
        int max_schet = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++){
            int schet = 0;
            for (int j = 1; j < array.length; j++){
                if ((array[(i+j)%array.length][0] <= array[i][0]) && (array[(i+j)%array.length][1] >= array[i][1]) && (array[(i+j)%array.length][2] >= array[i][2]) && (array[(i+j)%array.length][3] <= array[i][3])){
                    schet += 1;
                }
            }
            if (schet > max_schet){
                max_schet = schet;
                index = i;
            }
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < 4; j++){
                arr[i][j] = array[i][j];
            }
        }
        for(int i = 0; i < 4; i++){
            arr[arr.length-1][i] = array[index][i];
        }
        return arr;
    }
    public static String massivVStroki(int [][] array){
        StringBuilder answer = new StringBuilder();
        for (int [] mas : array){
            for (int znach : mas){
                answer.append(znach);
                answer.append(" ");
            }
            answer.append("\n");

        }
        return answer.toString();
    }
//    .\input.txt .\output.txt
    public static void readAndWriteMethod(InputArgs inputArgs) throws IOException {
        int[][] arr = ClassesForInAndOut.readFile(inputArgs.getInputFile());
        String answer = MainLogicTask.massivVStroki(MainLogicTask.getAnswer(arr));
        ClassesForInAndOut.writeFile(inputArgs.getOutputFile(),answer);
    }
    public static void printSuccessMessage(int num){
        if(num==0){
            System.out.println("Основная программа выполнена.");
        }else{
            System.out.println("Тест " + num + " выполнен успешно.");
        }
        System.out.println();
    }
}

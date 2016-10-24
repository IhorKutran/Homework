package lesson01;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class Homework1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = in.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("Please enter a password:");
        String pass = in.nextLine();
        System.out.println("You'd better change your password as soon as possible:");
        for (int i = pass.length() - 1; i >= 0; i--) {
            System.out.print(pass.charAt(i));
        }
        System.out.println();
        System.out.println("Or you can use random number: ");
        Random random = new Random();
        int randomNumber = random.nextInt(9999 - 1000) + 1000;
        System.out.println(randomNumber);
        String s = ""+randomNumber;
         for(int a=0; a<s.length(); a++){
            System.out.println(s.charAt(a));
         }
        System.out.println("Введите целые числа через пробел:");
        String numString = in.nextLine();//получим введеную строку
        Scanner holdString = new Scanner(numString);
        ArrayList<Integer> numArray = new ArrayList<>();//массив где будут хранится числа
        //проведем считывание каждого числа в строке
        while (holdString.hasNext()){
            String holdNumber = holdString.next();
            numArray.add(Integer.parseInt(String.valueOf(holdNumber)));//добавим число в массив
        }
        System.out.println(numString);
        ArrayList<Integer> numArrayForSum = new ArrayList<>();
        for (int i=0; i<numString.length();i++) {
            char c = numString.charAt(i);
            if (c>='0' && c<='9') {
                numArrayForSum.add(Integer.parseInt(String.valueOf(c)));
            }

        }
        int sum=0;
        for (int i=0;i<numArray.size();i++){
            sum+=numArray.get(i);
        }
        System.out.println("Сумма = "+sum);
        int sumSymbl=0;
        for (int i=0;i<numArrayForSum.size();i++){
            sumSymbl+=numArrayForSum.get(i);
        }
        System.out.println("Сумма цифр в строке = "+sumSymbl);

        String even = "";
        String odd = "";
        for (int i=0;i<numArray.size();i++){
            if (numArray.get(i)%2==0){
                even+= numArray.get(i)+" ";
            }
            else {
                odd += numArray.get(i)+" ";
                }
            }
        System.out.println("Even: "+even+" ");
        System.out.println("Odd: "+odd+" ");
        int min = numArray.get(0);
        int max = numArray.get(0);

        for (int i=0;i<numArray.size();i++){

            if (numArray.get(i)>max){
                max = numArray.get(i);
            }
            else if (numArray.get(i)<min){
                min = numArray.get(i);
            }

        }
        System.out.println("Max: "+max);
        System.out.println("Min: "+min);
        String division3or9 = "";
        for (int i=0;i<numArray.size();i++){
            if (numArray.get(i)%3==0||numArray.get(i)%9==0){
                division3or9+= numArray.get(i)+" ";
            }
        }
        if (division3or9.equals("")) {
            System.out.println("Нет значений которые делятся на 3 или на 9");
        }
        else {
            System.out.println("Делятся на 3 или на 9: " + division3or9);
        }
        String division5and7 = "";
        for (int i=0;i<numArray.size();i++){
            if (numArray.get(i)%5==0&&numArray.get(i)%7==0){
                division5and7+= numArray.get(i)+" ";
            }
        }
        if (division5and7.equals("")) {
            System.out.println("Нет значений которые делятся на 5 и на 7");
        }
        else {
            System.out.println("Делятся на 5 и на 7: " + division5and7);
        }
        //Все трехзначные числа, в десятичной записи которых нет одинаковых цифр
        String threeDigits = "";
        for (int x:numArray) {
            if (Integer.toString(x).length()==3){
                int digit1 = x/100;
                int digit2 = (x/10)%10;
                int digit3 =  x%10;
                if (digit1!=digit2&&digit2!=digit3&&digit1!=digit3){
                    threeDigits+= x+" ";
                }
            }

        }
        if (threeDigits.equals("")) {
            System.out.println("Нет трехзначного числа, в десятичной записи которого нет одинаковых цифр");
        }
        else {
            System.out.println("Трехзначные числа, в десятичной записи которых нет одинаковых цифр: " + threeDigits);
        }

        //«Счастливые» числа
        Collections.sort(numArray);
        ArrayList<Integer> luckyArray = new ArrayList<>();
        String luckyNumbers = "";
        for (int i=1; i<=numArray.get(numArray.size() - 1);i++){
            luckyArray.add(i);
        }

        //удалим четные числа
        for (int i = 1; i <= luckyArray.size() - 1; i++)
            luckyArray.remove(i);
        //-----
        int iterator = 2;
        while (iterator <luckyArray.size()) {
            int step = luckyArray.get(iterator - 1);
            if (step > luckyArray.size())
                break;
            for (int i = step - 1; i < luckyArray.size(); i += step - 1)
                luckyArray.remove(i);

            iterator++;
        }
        for (int x: numArray ) {
            for (int y:luckyArray) {
                if(x==y){
                    luckyNumbers+=y+" ";
                }
            }
        }
        System.out.println("«Счастливые» числа: "+ luckyNumbers);


        //Элементы, которые равны полусумме соседних элементов
        String halfSum = "";
        for ( int i= 1;i<numArray.size()-1;i++){
            if (numArray.get(i)==(numArray.get(i-1)+numArray.get(i+1))/2){
                halfSum+= numArray.get(i)+" ";
            }
        }
        if (halfSum.equals("")) {
            System.out.println("Нет значений которые равны полусумме соседних элементов");
        }
        else {
            System.out.println("Равны полусумме соседних элементов: " + halfSum);
        }

    }
}

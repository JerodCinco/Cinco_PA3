package com.company;
import java.security.SecureRandom;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static int make_difficulty(int difficulty) { //method to determine difficulty
        int diff = 0;
        switch (difficulty) {
            case 1:
                diff = 10;
                break;
            case 2:
                diff = 100;
                break;
            case 3:
                diff = 1000;
                break;
            case 4:
                diff = 10000;
                break;
        }
        return diff;
    }

    public static int make_question_type(int question_type) { //method for determine what type of questions
        int type = 0;
        switch (question_type) {
            case 1: //addition
                type = 1;
                break;
            case 2: //multiplication
                type = 2;
                break;
            case 3: //subtraction
                type = 3;
                break;
            case 4: //division
                type = 4;
                break;
            case 5: //mixed types
                type = 5;
                break;
        }
        return type;
    }

    public static int make_question_mixed () { //method for determine what type of questions
        SecureRandom sr = new SecureRandom();
        int mixed;
        mixed = sr.nextInt();
        return mixed;
    }

    public static int ask_question_add(int diff) { //method for addition, diff is x
        SecureRandom sr = new SecureRandom();
        int num1 = sr.nextInt(diff);
        int num2 = sr.nextInt(diff);
        System.out.println("How much is " + num1 + " plus " + num2 + " ?");
        int actual_num = num1 + num2;
        return actual_num;
    }

    public static int ask_question_mult(int diff) { //method for multiplication, diff is x
        SecureRandom sr = new SecureRandom();
        int num1 = sr.nextInt(diff);
        int num2 = sr.nextInt(diff);
        System.out.println("How much is " + num1 + " times " + num2 + " ?");
        int actual_num = num1 * num2;
        return actual_num;
    }

    public static int ask_question_sub(int diff) { //method for subtracton, diff is x
        SecureRandom sr = new SecureRandom();
        int num1 = sr.nextInt(diff);
        int num2 = sr.nextInt(diff);
        System.out.println("How much is " + num1 + " minus " + num2 + " ?");
        int actual_num = num1 - num2;
        return actual_num;
    }

    public static double ask_question_div(int diff) { //method for division, diff is x
        SecureRandom sr = new SecureRandom();
        double num1 = sr.nextInt(diff);
        double num2 = sr.nextInt(diff);
        System.out.printf("How much is " + num1 + " divided by " + num2 + " ? (round to the hundredths)\n");
        double actual_num = num1 / num2;
        return actual_num;
    }




    public static double response(double user_num, double actual_num, double total_correct) { // method for division
        SecureRandom sr = new SecureRandom();
        Scanner sc = new Scanner(System.in);
        int random_int = sr.nextInt(4) + 1;
        double value_check = (Math.abs(user_num - actual_num));
        if (value_check < 0.01) {
            total_correct = total_correct + 1.0;
            switch (random_int) {
                case 1:
                    System.out.println("Very Good!");
                    break;
                case 2:
                    System.out.println("Excellent!");
                    break;
                case 3:
                    System.out.println("Nice Work!");
                    break;
                case 4:
                    System.out.println("Keep up the good work!");
                    break;
            }
        } else {
            switch (random_int) {
                case 1:
                    System.out.println("No. Please try again.");
                    break;
                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 3:
                    System.out.println("Don’t give up!");
                    break;
                case 4:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }
        return total_correct;
    }


    public static void main(String[] args) {
        int quit_value = 0;
        do { //for quit value
        SecureRandom sr = new SecureRandom();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a difficulty level from 1-4");
        int difficulty = sc.nextInt();
        int diff = make_difficulty(difficulty); //pass value of difficulty to method make_difficulty to get value for diff

        System.out.println("Please select what type of questions to be asked");
        System.out.println("1 - addition only");
        System.out.println("2 - multiplication only");
        System.out.println("3 - subtraction only");
        System.out.println("4 - division only");
        System.out.println("5 - mixed (addition, multiplication, subtraction & division)");

        int question_type = sc.nextInt();
        int type = make_question_type(question_type); //sends value question_type to determine which type problem


        double total_correct = 0.0;
        switch (type) {
            case 1:
                for (int i = 0; i < 10; i++) { //to ask questions
                    double actual_num;
                    actual_num = ask_question_add(diff);

                    double user_num = sc.nextDouble();
                    total_correct = response(user_num, actual_num, total_correct); /*sends user input and correct answer to method
             and returns total_correct*/

                }
                break;
            case 2:
                for (int i = 0; i < 10; i++) { //to ask questions
                    double actual_num;
                    actual_num = ask_question_mult(diff);

                    double user_num = sc.nextDouble();
                    total_correct = response(user_num, actual_num, total_correct); /*sends user input and correct answer to method
             and returns total_correct*/
                }
                break;
            case 3:
                for (int i = 0; i < 10; i++) { //to ask questions
                    double actual_num;
                    actual_num = ask_question_sub(diff);

                    double user_num = sc.nextDouble();
                    total_correct = response(user_num, actual_num, total_correct); /*sends user input and correct answer to method
             and returns total_correct*/
                }
                break;
            case 4:
                for (int i = 0; i < 10; i++) { //to ask questions
                    double actual_num;
                    actual_num = ask_question_div(diff);

                    double user_num = sc.nextDouble();
                    total_correct = response(user_num, actual_num, total_correct); /*sends user input and correct answer to method
             and returns total_correct*/
                }
                break;
            case 5:
                for (int i = 0; i < 10;) { //to ask questions

                    //int type_mixed = make_question_mixed();
                    int type_mixed = sr.nextInt(4) + 1;

                    switch (type_mixed) {
                        case 1: {
                            double actual_num;
                            actual_num = ask_question_add(diff);

                            double user_num = sc.nextDouble();
                            total_correct = response(user_num, actual_num, total_correct);
                            i++;
                        }
                        case 2: {
                            double actual_num;
                            actual_num = ask_question_mult(diff);

                            double user_num = sc.nextDouble();
                            total_correct = response(user_num, actual_num, total_correct);
                            i++;
                        }
                        case 3: {
                            double actual_num;
                            actual_num = ask_question_sub(diff);

                            double user_num = sc.nextDouble();
                            total_correct = response(user_num, actual_num, total_correct);
                            i++;
                        }
                        case 4: {
                            double actual_num;
                            actual_num = ask_question_div(diff);

                            double user_num = sc.nextDouble();
                            total_correct = response(user_num, actual_num, total_correct);
                            i++;
                        }

                    }

                }
                break;
        }


        System.out.println("Your grade is: " + (total_correct / 10.0) * 100 + "%");
        if (((total_correct / 10.0) * 100) >= 75) {
            System.out.println("Congratulations, you are ready to go to the next level!");
        } else {
            System.out.println("Please ask your teacher for extra help.");
        }

        System.out.println("input -999 to quit or input any other key to retry");
        quit_value = sc.nextInt();
    } while (quit_value != -999);
        System.exit(0);
        }
        }





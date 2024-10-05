import java.util.Random;
import java.util.Scanner;

class Guess {
    public static void main(String[] args) {
        int score = 0;
        boolean guessed = false;
        int attempts = 0;
        
        Scanner myObj = new Scanner(System.in);
        
        System.out.print("Enter your name : ");
        String name = myObj.nextLine(); System.out.println();
        System.out.println("Welcome! " + name+" Good Luck!\n");
        
        System.out.println("1. Normal Play");
        System.out.println("2. Tournament");
        System.out.println("3. Difficulty Wise");
        System.out.print("Choose the number : ");
        int choice = myObj.nextInt();
        System.out.println();
        
        Random random = new Random();
        int actual_number = random.nextInt(100) + 1;
        
        if(choice < 1 || choice > 3) {
            System.out.println("Invalid Choice");
        }

        if (choice == 1) {
            normalPlay(name, actual_number, random, myObj, guessed, score);
        }

        // If Choice is 2 i.e. for Tournament
        else if (choice == 2) {
            Tournament(name, actual_number, random, myObj, guessed, score);
        }

        // If choice is 3 i.e. for Difficulty wise
        else if (choice == 3) {
            Difficulty_Wise(name, actual_number, random, myObj, guessed, score, attempts);
        }
    }


                                            // Normal Play

    static void normalPlay(String name, int actual_number, Random random, Scanner myObj, boolean guessed, int score) {
        System.out.println("Enter the number between 1 and 100");
        int input_value;
        while (!guessed) {
            System.out.print("Enter the Number : ");
            input_value = myObj.nextInt();
            System.out.println();

            if (input_value <= 0 || input_value > 100) {
                System.out.println("Please Enter the number between 1 and 100");
            } else if (input_value > actual_number) {
                System.out.println("The actual number is less than " + input_value);
                score++;
            } else if (input_value < actual_number) {
                System.out.println("The actual number is greater than " + input_value);
                score++;
            } else {
                System.out.println("Congratulations! " + name + " You won the game.");
                score++;
                System.out.println("Your Score is : " + score);
                guessed = true;
            }
        }
        System.out.println("\nThank You for Playing the game, Hope you like it.\n");
    }



                                            // Tournament

    static void Tournament(String name, int actual_number, Random random, Scanner myObj, boolean guessed, int score) {
        int round = 1;
        int input_value;
        int total_score = 0;
        System.out.println("\t\tTournament Mode");
        while(round <= 3) {
            System.out.println("\n\t\tRound " + round+"\n");
            actual_number = random.nextInt(100) + 1;
            System.out.println("The actual number is between 1 and 100");
            while (!guessed) {
                System.out.print("Enter the Number : ");
                input_value = myObj.nextInt();
                System.out.println();

                if (input_value <= 0 || input_value > 100) {
                    System.out.println("Please Enter the number between 1 and 100");
                } else if (input_value > actual_number) {
                    System.out.println("The actual number is less than " + input_value);
                    score++;
                } else if (input_value < actual_number) {
                    System.out.println("The actual number is greater than " + input_value);
                    score++;
                } else {
                    System.out.println("\t\tCongratulations! " + name + " You won the round "+round);
                    score++;
                    System.out.println("\t\tYour Score is " + score+" in round "+round);
                    guessed = true;
                }
            }
            round++;
            guessed = false;
            total_score += score;
            score = 0;
        }
        System.out.println("Your Total Score is : " + total_score+"\n");
        System.out.println("Thank You for Playing the game, Hope you like it.\n");
    }



                                            // Difficulty Wise

    static void Difficulty_Wise(String name, int actual_number, Random random, Scanner myObj, boolean guessed, int score, int attempts) {
        System.out.println("\t\tDifficulty Wise Game");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.print("Choose the number : ");
        int difficulty = myObj.nextInt();
        System.out.println();

        if(difficulty == 1) {
            Easy_Game(name, actual_number, random, myObj, guessed, score, attempts);
        }
        else if(difficulty == 2) {
            Medium_Game(name, actual_number, random, myObj, guessed, score, attempts);
        }
        else if(difficulty == 3) {
            Hard_Game(name, actual_number, random, myObj, guessed, score, attempts);
        }
        else {
            System.out.println("Invalid Choice\n");
        }
        System.out.println("\t\tThank You for Playing the game, Hope you like it.\n");
    }


                                            // Easy Game

    static void Easy_Game(String name, int actual_number, Random random, Scanner myObj, boolean guessed, int score, int attempts) {
        int input_value;
        System.out.println("\t\tEasy Game\n");
        actual_number = random.nextInt(8) + 1;
        System.out.println("The actual number is between 1 and 10\n");
        attempts = 0;
        System.out.println("You have only "+ (5 - attempts) +" Attempts");
        
        while (!guessed && attempts < 5 && attempts >= 0) {
            System.out.print("Enter the Number : ");
            input_value = myObj.nextInt();
            
            if (input_value <= 0 || input_value > 8) {
                System.out.println("Please Enter the number between 1 and 8"+"\n");
            } else if (input_value > actual_number) {
                System.out.println("The actual number is less than " + input_value+"\n");
                attempts++;
                System.out.println("Attempts left : " + (5 - attempts)+"\n");
            } else if (input_value < actual_number) {
                System.out.println("The actual number is greater than " + input_value+"\n");
                attempts++;
                System.out.println("Attempts left : " + (5 - attempts)+"\n");
            } else {
                System.out.println("\t\tCongratulations! "+ name + ", you wan the game.\n");
                attempts++;
                System.out.println("\t\tYou Cleared in "+ attempts + " attempts out of "+5+ " attempts");
                guessed = true;
            }
        }
        if(attempts == 5) {
            System.out.println("\t\tYou Lost the game");
            System.out.println("\t\tThe actual number is : " + actual_number);
        }
    }

    static void Medium_Game(String name, int actual_number, Random random, Scanner myObj, boolean guessed, int score, int attempts) {
        int input_value;
        System.out.println("\t\tMedium Game\n");
        actual_number = random.nextInt(50) + 1;
        System.out.println("The actual number is between 1 and 50\n");
        attempts = 0;
        System.out.println("You have only "+ (8-attempts) +" Attempts");
        while (!guessed && attempts < 8 && attempts >= 0) {
            System.out.print("Enter the Number : ");
            input_value = myObj.nextInt();
            System.out.println();
            if (input_value <= 0 || input_value > 50) {
                System.out.println("Please Enter the number between 1 and 50");
            } else if (input_value > actual_number) {
                System.out.println("The actual number is less than " + input_value+"\n");
                attempts++;
                System.out.println("Attempts left : " + (8 - attempts)+"\n");
            } else if (input_value < actual_number) {
                System.out.println("The actual number is greater than " + input_value+"\n");
                attempts++;
                System.out.println("Attempts left : " + (8 - attempts)+"\n");
            } else {
                System.out.println("\t\tCongratulations! " + name + " You won the game.");
                attempts++;
                System.out.println("\t\tYou Cleared in " + attempts + " attempts out of "+ 8 + " attempts");
                guessed = true;
            }
        }
        if(attempts == 8) {
            System.out.println("\t\tYou Lost the game");
            System.out.println("\t\tThe actual number is : " + actual_number);
        }
    }


                                            // Hard Game

    static void Hard_Game(String name, int actual_number, Random random, Scanner myObj, boolean guessed, int score, int attempts) {
        int input_value;
        System.out.println("\t\tHard Game\n");
        actual_number = random.nextInt(100) + 1;
        System.out.println("The actual number is between 1 and 100\n");
        attempts = 0;
        System.out.println("You have only "+ (8-attempts) +" Attempts");
        while (!guessed && attempts < 8 && attempts >= 0) {
            System.out.print("Enter the Number : ");
            input_value = myObj.nextInt();
            System.out.println();
            if (input_value <= 0 || input_value > 100) {
                System.out.println("Please Enter the number between 1 and 100");
            } else if (input_value > actual_number) {
                System.out.println("The actual number is less than " + input_value+"\n");
                attempts++;
                System.out.println("Attempts left : " + (8-attempts)+"\n");
            } else if (input_value < actual_number) {
                System.out.println("The actual number is greater than " + input_value+"\n");
                attempts++;
                System.out.println("Attempts left : " + (8-attempts)+"\n");
            } else {
                System.out.println("\t\tCongratulations! " + name + " You won the game.");
                attempts++;
                System.out.println("\t\tYou Cleared in " + attempts+ " attempts out of "+8+ " attempts");
                guessed = true;
            }
        }
        if(attempts == 8) {
            System.out.println("You Lost the game");
            System.out.println("The actual number is : " + actual_number);
        }
    }   
}
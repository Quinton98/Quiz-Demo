package finalproj;

import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class FinalProj {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        login();
    }

    public static String currentUsername;
    public static double score1;
    public static String correctAnswer;
    public static ArrayList<Double> scoresList = new ArrayList<>(); // List to store scores


    public static void login() throws FileNotFoundException, IOException {
        Scanner inputScanner = new Scanner(System.in);

        File usersFile = new File("/Users/quintonlott/Downloads/UsersInfo.txt");
        //Scanner userInfoSc = new Scanner(new File("/Users/quintonlott/Downloads/UsersInfo.txt"));
        Scanner inputSc = new Scanner(usersFile);

        HashMap <String, String> user_pass = new HashMap<String, String>();
        while (inputSc.hasNextLine()) {
            String line = inputSc.nextLine();
            String[] parts = line.split("\\s+");
            if (parts.length >= 2) {
                String storedUsername = parts[2];
                String storedPassword = parts[3];
                user_pass.put(storedUsername, storedPassword);                
            
            }
        }
                
                int MAX_ATTEMPTS = 3;
                int attempts = 0;
                String done = "done";
                String passWord;

        while (attempts < MAX_ATTEMPTS && true) {
        System.out.println("Please enter username (or type 'done' to exit):");
        String userName = inputScanner.nextLine();

        if (userName.equals(done)) {
            inputScanner.close();
            break;
        
        }
        System.out.println("Please enter password:");
        passWord = inputScanner.nextLine();
        
        if (passWord.equals(done)) {
            inputScanner.close();
            break;
        }

            if (userName.equals("odarwish") && (passWord.equals("AAAAAA"))){
             instructor();
            }
        else if (user_pass.containsKey(userName) && user_pass.containsValue(passWord)) {
            currentUsername = userName;
            quizStart();
        }
             
             else {
            attempts++;
            System.out.println("Invalid username or password");
        }
        
    }
                    if (attempts == MAX_ATTEMPTS) {
                        System.out.println("You have reached the maximum amount of login attempts");
                    }
                    

                
    
    
    }
    
    
   public static void instructor()throws FileNotFoundException, IOException {
       Scanner inputScanner = new Scanner(System.in);
       
       
      int attempts = 0;
      int Max_Attempts = 3; 
       
       
       
       System.out.println("Press 1 to register a new student: ");
       System.out.println("Press 2 to see the data: ");
       System.out.println("Press 3 to add a question: ");
       
       String input = inputScanner.nextLine();
        
      
               
       if (input.equals("1")){
           registerStudent();
          
       }
       else if(input.equals("2")){
           showStats();
           
       }
       else if(input.equals("3")){
           addQuestions();
          
       }
       
           
       
       }
     
   
   
      

   
       public static void registerStudent() throws FileNotFoundException, IOException{
       Scanner input = new Scanner(System.in);
       System.out.println("What is your first name: ");
       String name = input.nextLine();
       System.out.println("What is your Last name: ");
       String lastName = input.nextLine();
       System.out.println("What is your usename: ");
       String userName = input.nextLine();
       System.out.println("What is your password: ");
       String passWord = input.nextLine();
       System.out.println("What is your Role: ");
       String Role = input.nextLine();
       
       
       
       FileWriter printtofile = new FileWriter("/Users/quintonlott/Downloads/UsersInfo.txt", true);
       printtofile.write(name +  " " + lastName + " " + userName + " " + " " + passWord +  " " + Role);
       printtofile.close();
       }
       
       
      public static void showStats() {
    if (scoresList.isEmpty()) {
        System.out.println("There is no score");
        return;
    }

    double lowest = scoresList.get(0);
    for (int i = 0; i < scoresList.size(); i++) {
        double score = scoresList.get(i);
        if (score < lowest) {
            lowest = score;
        }
    }

    double highest = scoresList.get(0);
    for (int i = 0; i < scoresList.size(); i++) {
        double score = scoresList.get(i);
        if (score > highest) {
            highest = score;
        }
    }

    double sum = 0;
    for (int i = 0; i < scoresList.size(); i++) {
        sum += scoresList.get(i);
    }
    double average = sum / scoresList.size();

    System.out.println("Lowest Score: " + lowest);
    System.out.println("Highest Score: " + highest);
    System.out.println("Average Score: " + average);
}



       
       
       public static void addQuestions() throws IOException{
       Scanner input = new Scanner(System.in);
       
       
       
       System.out.println("Enter a question: ");
       String Ques = input.nextLine();
       System.out.println("Enter True or False: ");
       String Ans = input.nextLine();
       
       
       FileWriter printtofile = new FileWriter("/Users/quintonlott/Downloads/TestBank.txt", true);
       printtofile.write(Ques);
       printtofile.close();
       
       FileWriter printAns = new FileWriter("/Users/quintonlott/Downloads/Answers.txt", true);
       printAns.write(Ans);
       printAns.close();
       
       
       System.out.println("Your Questions and answers have been updated");
       
       

       }
           
    public static void quizStart() throws FileNotFoundException, IOException {

        System.out.println("Quiz Started (T/F only)");
        Scanner input = new Scanner(System.in);
        int score = 0;

        String[] questionsBankArr = new String[126];
        File testBankFile = new File("/Users/quintonlott/Downloads/TestBank.txt");
        Scanner testBankScanner = new Scanner(testBankFile);
        int x = 0;
        while (testBankScanner.hasNext()) {
            String line = testBankScanner.nextLine();
            questionsBankArr[x] = line;
            x++;
        }
        String[] answerArr = new String[126];
        File answersFile = new File("/Users/quintonlott/Downloads/Answers.txt");
        Scanner answerskScanner = new Scanner(answersFile);
        x = 0;
        while (answerskScanner.hasNext()) {
            String line = answerskScanner.nextLine();
            answerArr[x] = line;
            x++;

        }
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int randQuestNum = rand.nextInt(125);

            System.out.println("Question" + (i + 1) + ":" + questionsBankArr[randQuestNum]);
            String answer = input.nextLine().toUpperCase();

            char correctAns = answerArr[i].charAt(0);
            boolean isAcceptedAns = answer.equals("T") || answer.equals("F");

            if (!isAcceptedAns) {
                System.out.println("Answer needs to be T or F");
                answer = input.nextLine();
            }

            char answerCheck = answer.charAt(0);
            boolean isRightAnswer = correctAns == answerCheck;
            if (isRightAnswer) {
                score++;
                System.out.println("CORRECT");
            }
        }
        score1 = score;
        report();
    }

    public static void report() throws FileNotFoundException, IOException {
        File usersFile = new File("/Users/quintonlott/Downloads/UsersInfo.txt");
        Scanner inputSc = new Scanner(usersFile);

        String firstName = "";
        String lastName = "";
        
        
        

        while (inputSc.hasNextLine()) {
            String[] userInformation = inputSc.nextLine().split("\\s+");
            if (userInformation[2].equals(currentUsername)) {
                System.out.println("Match found!");
                firstName = userInformation[0];
                lastName = userInformation[1];               
                break;
            }
        }
        
        System.out.println(firstName + " " + lastName + " " + currentUsername + " " + score1);
        FileWriter printtofile = new FileWriter("/Users/quintonlott/NetBeansProjects/FinalProj/_CSCI_2493_Quiz");
        printtofile.write(firstName + " " + lastName + " " + score1);
        printtofile.close();
        
        scoresList.add(score1);

        
        login();
            
    }
           
        
        
        
        }
       
       
      
            
  
       
       
      
   
       
      
  
   
   
   
   
        
   
            
        
        
    


    
    
    
                        
                        
                        
                       
       

             
        
                   
                                
                    





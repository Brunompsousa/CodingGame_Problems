public class Main {

    /*
    *   Tom and Jerry are playing the game Guess The Number, and asks you to be the facilitator.
    *
    *   The game is very simple.
    *   There is a hidden number N, which is between 1 and 100, inclusive of 1 and 100.
    *   Each player takes turn to guess a number within the valid range, and is given one of three responses: Higher, Lower or Correct!.
    *   The valid range is then updated according to the response, and play continues till one player guesses the number correctly.
    *
    *   Tom starts first, then Jerry, and so on.
    *
    *   There is one catch: Tom, being the cheeky cat, wants to win. Hence, he asks you to adjust the number if Jerry guesses correctly, but still within the valid range. You agree reluctantly, and say that you will adjust the number one higher from the actual number if Jerry guesses correctly. If one higher is not possible, then you will do one lower. If you can neither do one higher nor one lower, then Jerry will win.
    *
    *   Tom agrees, and play begins, with you as the facilitator.
    *
    *   Given each line of Tom and Jerry's guesses (alternating with Tom first), output in each line the right responses for each guess, taking in mind the shifting target you agreed with Tom.
    *
    *   Example game:
    *   Target Number: 35
    *   Turn 1-Tom: 55 (Response: Lower. Valid range now 1 to 54)
    *   Turn 2-Jerry: 20 (Response: Higher. Valid range now 21 to 54)
    *   Turn 3-Tom: 36 (Response: Lower. Valid range now 21 to 35)
    *   Turn 4-Jerry: 35 (This is correct, you try to shift up to 36 first but not possible, so you shift down to 34. Response: Lower. Valid range now 21 to 34)
    *   Turn 5-Tom: 34 (Response: Correct!)
    *
    *   First number[0] = Correct number                                    (0<number<=100)
    *   Second number[1] = Number of times Tom and Jerry try to guess,      (0<number<=10)
    *   Remaining number[n] = Guess from Tom and Jerry.                     (0<number<=100)
    *
    */

    public static void main(String[] args) {

        //Test1
        int cNum1 = 50;
        int numbers1 = 5;
        int[] nT1 = {30,70,45,60,50};
        //Test2
        int cNum2 = 99;
        int numbers2 = 7;
        int[] nT2 = {60,70,80,90,91,99,100};
        //Test3
        int cNum3 = 30;
        int numbers3 = 9;
        int[] nT3 = {60,20,31,30,24,29,25,28,27};
        //Test4
        int cNum4 = 1;
        int numbers4 = 10;
        int[] nT4 = {50,30,20,10,8,1,5,2,4,3};

        System.out.println("Test 1");
        System.out.println("-----");
        Solution(cNum1,numbers1,nT1);
        System.out.println("-----\n");

        System.out.println("Test 2");
        System.out.println("-----");
        Solution(cNum2,numbers2,nT2);
        System.out.println("-----\n");

        System.out.println("Test 3");
        System.out.println("-----");
        Solution(cNum3,numbers3,nT3);
        System.out.println("-----\n");

        System.out.println("Test 4");
        System.out.println("-----");
        Solution(cNum4,numbers4,nT4);
        System.out.println("-----");
    }

    public static void Solution(int cNum, int nums, int[] numbers){

        int correctNum = cNum;
        int count = nums;

        //Solution development (variables)
        int plus = 0;
        int minus = 0;

        for(int i = 0; i < count;i++){

            //Solution development (Start)

            /* Verify if the number is lower and if is the correct number-1 */
            if(numbers[i] < correctNum) {
                if(numbers[i] == correctNum-1)
                    minus = 1;
                System.out.println("Lower");
            }
            /* Verify if the number is higher and if is the correct number+1 */
            else if(numbers[i] > correctNum) {
                if(numbers[i] == correctNum+1)
                    plus = 1;
                System.out.println("Higher");
            }
            /* If is the correct number and is Jerry, try to change the correct number */
                else if(i%2!=0){
                    if(plus==0){
                        correctNum+=1;
                        minus=1;
                        System.out.println("Lower");
                    }
                    else if(minus == 0){
                        correctNum -= 1;
                        System.out.println("Higher");
                    }
                    else
                        System.out.println("Jerry is correct!");
                    }
                /* If is the correct number and is Tom */
                else
                    System.out.println("Tom is correct!");

            //Solution development (End)
        }

    }

}


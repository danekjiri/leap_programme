package com.tesco.jiridanek1.challenges.operatorprecedence;

/**
 * TASK:
 * Step 1:  create a double variable with a value of 20.00.
 * Step 2:  create a second variable of type double with a value 80.00.
 * Step 3:  add both numbers together, then multiply by 100.00.
 * Step 4:  use the remainder operator, to figure out what the remainder from the result of the operation in step three, and 40.00, will be.
 * Step 5:  create a boolean variable that assigns the value true, if the remainder in step four is 0.00, or false if it's not zero.
 * Step 6:  output the boolean variable just to see what the result is.
 * Step 7:  write an if-then statement that displays a message, 'got some remainder', if the boolean in step five is not true.
 */

public class OperatorPrecedenceAndOperator {
    public static void main(String[] args) {
        ///  init variables
        double width = 21d;
        double secondVariable = 80d;

        ///  sum variables and multiply by 100.00
        double sum = width + secondVariable;

        /// reminder operator to sum and number 40.00
        double reminder = sum % 40d;

        /// flag if reminder is zero
        boolean isReminderZero = (reminder == 0d);

        /// output the flag `isReminderZero`
        System.out.printf("%b\n", isReminderZero);

        /// output a message if reminder is not zero
        if (!isReminderZero) {
            System.out.println("got some reminder");
        }
    }
}

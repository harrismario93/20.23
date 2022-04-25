import java.util.Scanner;
import java.util.Stack;

/**
 * *20.23 (Evaluate expression) Modify Listing 20.9 EvaluateExpression.java to
 * add operators ^ for exponent and % for modulus. Your program should prompt
 * the user to enter an expression. Here is a sample run of the program: Enter
 * an expression: (5 * 2 ^ 3 + 2 * 3 % 2) * 4 (5 * 2 ^ 3 + 2 * 3 % 2) * 4 = 160
 */

public class Sta {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.print("Enter ann expression: ");
	String expression = input.nextLine();
	// Big O Analysis display operation such as(5 * n ^ 3 + 2 * 3 % n) * 4
	try {
	    System.out.print(expression + " =");
	    System.out.print(evaluateExpression(expression));
	} catch (Exception ex) {
	    // Compute result of given operation like n= 2 listed above to plug 2 in which 2
	    // comes in
	    // Result = 160 but output list as wrong expression
	    System.out.println("Wrong expression: " + expression);

	}
    }
    // evaluate expression

    public static int evaluateExpression(String expression) { // beginning of method
	// Create operandStack to store operands
	Stack<Integer> operandStack = new Stack<>();
	// Create operatorStack to store operators
	Stack<Character> operatorStack = new Stack<>();

	// Pad following characters with space: (, ), +, -, /, *, ^ and %
	expression = insertBlanks(expression);
	// Extract operands and operators
	String[] tokens = expression.split(" ");

	// Big O Analysis for token 1 to determine to process in token to compute and
	// display results
	// scan tokens
	for (String token1 : tokens) {
	    if (token1.length() == 0)// blank space
		continue;

	}

	String token = null;
	if (token.charAt(0) == '^') {
	    operatorStack.push(token.charAt(0));
	} else if (token.charAt(0) == '+' || token.charAt(0) == '-') {

	    while (!operatorStack.isEmpty() && token.charAt(0) == '*' || token.charAt(0) == '/'
		    || token.charAt(0) == '%') {
		processAnOperator(operandStack, operatorStack);
	    }
	    operatorStack.push(token.charAt(0));

	} else if (token.trim().charAt(0) == '(') {
	    operatorStack.push('('); // Push '(' to stack
	} else if (token.trim().charAt(0) == ')') {
	    // Process all the operators in the stack until seeing '(
	    while (operatorStack.peek() != ')') {
		processAnOperator(operandStack, operatorStack);
	    }
	    operatorStack.pop(); // Pop the '(' symbol from the stack

	} else {
	    // Push the operand to stack
	    operandStack.push(new Integer(token));
	}

	// Phase 2: Process all operating operators in Stack
	// Checking if all methods will be able to process operation or not including
	// using charAt methods also
	// looping through operandStack and operator Stack to compute operation
	while (!operatorStack.isEmpty()) {
	    processAnOperator(operandStack, operatorStack);
	}
	// Return the result
	return operandStack.pop();
    }

    /**
     * *20.23 (Evaluate expression) of performing different operation of lets use 99
     * and 98 operators +, -, *, /, and % enter an expression. : Enter an
     * expression: * Enter an expression or expressions : (99 + 98), 99 - 98, 99 *
     * 98, 99/98, 99 % 98 Compute result listed wrong expression especially one
     * listed below previous expression (5 * 2 ^ 3 + 2 * 3 % 2) * 4 = 160
     */

    // process operators
    public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
	char op = operatorStack.pop();
	// Big O Analysis to execute given names with the following operations
	int op1 = operandStack.pop();
	int op2 = operandStack.pop();
	// Big O ( op1 *op2) 98 * 97 = 197
	if (op == '+')
	    operandStack.push(op2 + op1);
	else if (op == '-')
	    operandStack.push(op2 - op1);
	else if (op == '*')
	    operandStack.push(op2 * op1);
	else if (op == '/')
	    operandStack.push(op2 / op1);
	else if (op == '^')
	    operandStack.push((int) Math.pow(op2, op1)); // Exponent Operation
	else if (op == '%')
	    operandStack.push(op2 % op1);// Modulus operation

    }

    // Require loop and mathematical operations
    public static String insertBlanks(String s) {
	// Display Result
	String result = "";
	// Big O process here String s instructions
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-'
		    || s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '^' || s.charAt(i) == '%') // Check
													     // for
													     // exponent
													     // and
													     // modulus
													     // operands.
		result += " " + s.charAt(i) + " ";
	    else
		result += s.charAt(i);
	}

	// big o to display result and does displays message wrong expression but works
	// fign
	return result;

    }

}
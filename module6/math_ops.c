#include <stdio.h>

// Function prototype for print_math
    void print_math(int a, int b);

int main() {
  
    int firstNum = 10;
    int secondNum = 5;

    

    //Prompt and read first number from the user
    printf("Enter First Number: ");
    scanf("%d", &firstNum);

    //Prompt and read second number from the user
    printf("Enter Second Number: ");
    scanf("%d", &secondNum);    

    print_math(firstNum, secondNum);
        
    return 0;

}


void print_math(int a, int b) {
        printf("Sum: %d\n", a + b);
        printf("Difference: %d\n", a - b);
        printf("Product: %d\n", a * b);
  
    }



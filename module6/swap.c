#include <stdio.h>

// Function prototype for print_math
void swap(int *a, int *b);
void broken_swap(int a, int b); 

int main() {
  
    int firstNum = 10;
    int secondNum = 5;

    

    //Prompt and read first number from the user
    printf("Before Swap: x = %d, y = %d\n", firstNum, secondNum);
    broken_swap(firstNum, secondNum);
    printf("After Broken Swap: x = %d, y = %d\n", firstNum, secondNum);
    swap(&firstNum, &secondNum);
    printf("After Swap: x = %d, y = %d\n", firstNum, secondNum);

        
    return 0;

}

    void swap(int *a, int *b) {
        //This function swaps the values of a and b in the calling function by using pointers to modify the original values.
        int temp = *a;
        *a = *b;
        *b = temp;
    }

 void broken_swap(int a, int b) {
    //This function does not actually swap the values of a and b in the calling function because it only swaps the local copies of a and b. 
    //The original values in main remain unchanged.   
        int temp = a;
        a = b;
        b = temp;
    }

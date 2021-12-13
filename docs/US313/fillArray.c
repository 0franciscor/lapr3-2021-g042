#include <stdio.h>

void fillArray(char *lineSplit){

    for(int i = 0; i < 4; i++){
        printf("%s\n", *(lineSplit + i));
    }

}
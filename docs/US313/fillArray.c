#include <stdio.h>

void fillArray(char (*lineSplit)[25]){
    printf("\n\nComeça aqui o print\n\n");
    for(int i = 0; i < 4; i++){
        printf("%s\n", lineSplit[i]);
        //printf("\n");
    }
}

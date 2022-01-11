#include <stdio.h>
#include <stdlib.h>

#include "struct.h"

void allocateMemory(int maxX, int maxY, int maxZ, cMContainer ***containerArray){

    containerArray = (cMContainer ***) calloc(maxX, sizeof(cMContainer**));
    
    if(containerArray == NULL){
        printf("Error reserving memory(x).\n");
        exit (1);
    }

    for (int i = 0; i < maxY; i++){
        containerArray[i] = (cMContainer **) calloc(maxY , sizeof(cMContainer*)); 
        
        if(containerArray[i] == NULL){
            printf("Error reserving memory(y).\n");
            exit (1);
        }

        for(int k = 0; k < maxZ; k++){
            containerArray[i][k] = (cMContainer *) calloc (maxZ , sizeof(cMContainer)); 

            if(containerArray[i][k] == NULL){
                printf("Error reserving memory(z).\n");
                exit (1);
            }
        }
    }

}
#include <stdio.h>
#include <stdlib.h>

#include "containerStruct.h"
#include "printArray.h"
#include "readStructs.h"

cMContainer *containerArray;

int main(){

    char *containerFileName = "cMContainer.csv";
    FILE *containerFile = fopen(containerFileName, "r");
    
    if (!containerFile){ // Verifica se o ficheiro existe
        printf("No file found\n"); 
        exit(-1); 
    } 

    int maxX, maxY, maxZ, totalSlots;
    fscanf(containerFile, "%d,%d,%d", &maxX, &maxY, &maxZ);

    totalSlots = maxX * maxY * maxZ;
    containerArray = (cMContainer *) calloc(totalSlots, sizeof(cMContainer));

    readStructs(containerFile, containerArray);

    fclose(containerFile);

    printArray(totalSlots, containerArray);

    free(containerArray);
            
    return 0;
}
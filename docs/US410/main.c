#include <stdio.h>
#include <stdlib.h>

#include "containerStruct.h"
#include "readStructs.h"
#include "lineNumber.h"
#include "calculateEnergy.h"

int main(){

    cMContainer *containerArray;

    char *containerFileName = "cMContainer.csv";
    FILE *containerFile = fopen(containerFileName, "r");
    
    if (!containerFile){
        printf("No file found\n"); 
        exit(-1); 
    }

    short maxX, maxY, maxZ, totalSlots;
    fscanf(containerFile, "%hd,%hd,%hd", &maxX, &maxY, &maxZ);
    totalSlots = getNumberOfContainers(containerFileName);

    containerArray = (cMContainer *) calloc((totalSlots + 1), sizeof(cMContainer));

    readStructs(containerFile, containerArray);

    fclose(containerFile);

    calculateEnergy(containerArray, totalSlots);

    free(containerArray);
            
    return 0;
}
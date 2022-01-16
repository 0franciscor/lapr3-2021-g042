#include <stdio.h>
#include <stdlib.h>

#include "containerStruct.h"
#include "readStructs.h"
#include "lineNumber.h"
#include "calculateEnergy.h"
#include "printResult.h"

#define GENERATOR_OUTPUT 500000

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

    float generatorOutput = GENERATOR_OUTPUT;

    float requiredOutput = calculateEnergy(containerArray, totalSlots);

    if(generatorOutput < requiredOutput){
        float energyMissing = requiredOutput - generatorOutput;
        printResult(energyMissing);
    } else
        printResult(0);

    free(containerArray);
            
    return 0;
}
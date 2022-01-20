#include <stdio.h>
#include <stdlib.h>

#include "containerStruct.h"
#include "readStructs.h"
#include "lineNumber.h"
#include "calculateEnergy.h"
#include "printResult.h"

#define GENERATOR_OUTPUT 500000

int main(int argc,char *argv[]){

    cMContainer *containerArray;

    char *containerFileName1 = "cMContainer1.csv";
    FILE *containerFile1 = fopen(containerFileName1, "r");

    char *containerFileName2 = "cMContainer2.csv";
    FILE *containerFile2 = fopen(containerFileName2, "r");

    if (!containerFile1 || !containerFile2){
        printf("No file found\n"); 
        exit(0); 
    }

    short maxX, maxY, maxZ, totalSlots;
    fscanf(containerFile1, "%hd,%hd,%hd", &maxX, &maxY, &maxZ);
    totalSlots = getNumberOfContainers(containerFileName1);

    containerArray = (cMContainer *) calloc(totalSlots, sizeof(cMContainer));

    readStructs(containerFile1, containerArray, 1);
    readStructs(containerFile2, containerArray, 2);

    fclose(containerFile1);
    fclose(containerFile2);

    float generatorOutput = GENERATOR_OUTPUT;

    float externalTemp = atoi(argv[1]); 
    float desiredTemp = atoi(argv[2]);

    float requiredOutput = calculateEnergy(containerArray, totalSlots, externalTemp, desiredTemp);

    if(generatorOutput < requiredOutput){
        float energyMissing = requiredOutput - generatorOutput;
        printResult(energyMissing);
    } else
        printResult(0);

    free(containerArray);
            
    return 0;
}
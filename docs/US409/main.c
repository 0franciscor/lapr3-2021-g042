#include <stdio.h>
#include <stdlib.h>

//#include "zeroArray.h"
//#include "printArray.h"
#include "struct.h"
#include "allocateMemory.h"

cMContainer ***containerArray;

int main(){

    char *containerFileName = "cMContainer.csv";
    FILE *containerFile = fopen(containerFileName, "r");
    
    if (!containerFile){ // Verifica se o ficheiro existe
        printf("No file found\n"); 
        exit(-1); 
    } 

    int maxX, maxY, maxZ;
    fscanf(containerFile, "%d,%d,%d", &maxX, &maxY, &maxZ);

    printf("Tamanho: %ld\n", sizeof(cMContainer));

    
    //zeroArray(maxX, maxY, maxZ, containerArray);

    /*while(!feof(containerFile)){ //leitura de cada linha do ficheiro
        int x, y, z, containerID;

        fscanf(containerFile, "%d,%d,%d,%d", &containerID, &x, &y, &z);

        shipAllocation[x][y][z] = containerID;
    }*/

    fclose(containerFile);

    //printArray(maxX,maxY,maxZ, containerArray);
            
    return 0;
}
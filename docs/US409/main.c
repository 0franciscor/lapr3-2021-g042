#include <stdio.h>
#include <stdlib.h>

#include "zeroArray.h"
#include "printArray.h"

typedef struct { //define-se a estrutura cMContainer
    int cMLoadId;
    int containerId;
    int phasesId;
    int x;
    int y;
    int z;
    float grossContainer;
    int phases_cMLoadId;
    int cMUnloadI;
} cMContainer;

struct cmContainer ***containerArray;

int main(){

    char *containerFileName = "cMContainer.csv";
    FILE *containerFile = fopen(containerFileName, "r");
    
    if (!containerFile){ // Verifica se o ficheiro existe
        printf("No file found\n"); 
        exit(-1); 
    } 

    int maxX, maxY, maxZ;
    fscanf(containerFile, "%d,%d,%d", &maxX, &maxY, &maxZ);

    containerArray = (struct cmContainer ***) calloc(maxX, sizeof(struct cmContainer***));
    
    if(containerArray == NULL){
        printf("Error reserving memory(x).\n");
        exit (1);
    }

    for (int i = 0; i < maxY; i++){
        containerArray[i] = (struct cmContainer **) calloc(maxY , sizeof(struct cmContainer**)); 
        
        if(containerArray[i] == NULL){
            printf("Error reserving memory(y).\n");
            exit (1);
        }

        for(int k = 0; k < maxZ; k++){
            containerArray[i][k] = (struct cmContainer *) calloc (maxZ , sizeof(struct cmContainer*)); 

            if(containerArray[i][k] == NULL){
                printf("Error reserving memory(z).\n");
                exit (1);
            }
        }
    }

    zeroArray(maxX, maxY, maxZ, containerArray);

    /*while(!feof(containerFile)){ //leitura de cada linha do ficheiro
        int x, y, z, containerID;

        fscanf(containerFile, "%d,%d,%d,%d", &containerID, &x, &y, &z);

        shipAllocation[x][y][z] = containerID;
    }*/

    fclose(containerFile);

    //printArray(maxX,maxY,maxZ, containerArray);
            
    return 0;
}
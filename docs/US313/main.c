#include <stdio.h>
#include <stdlib.h>

#include "zeroArray.h"

int main(){

    char *fileName = "containers.csv";

    FILE *containerFile = fopen(fileName, "r");
    
    if (!containerFile){ // Verifica se o ficheiro existe
        printf("No file found\n"); 
        exit(-1); 
    } 

    int maxX, maxY, maxZ;
    fscanf(containerFile, "%d,%d,%d", &maxX, &maxY, &maxZ);
    int shipAllocation[maxX][maxY][maxZ];

    zeroArray(maxX, maxY, maxZ, shipAllocation);

    while(!feof(containerFile)){ //leitura de cada linha do ficheiro

        int x, y, z, containerID;

        fscanf(containerFile, "%d,%d,%d,%d", &containerID, &x, &y, &z);

        shipAllocation[x][y][z] = containerID;
    }

    fclose(containerFile);

    for(int i = 0; i < 18; i++)
        for(int j = 0; j < 26; j++)
            for(int k = 0; k < 10; k++)
                printf("x: %d y: %d z: %d tem contentor: %d\n", i, j, k, shipAllocation[i][j][k]);
            
    return 0;
}
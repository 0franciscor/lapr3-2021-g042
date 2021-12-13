#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "fillArray.h"

void importFile(char *fileName){

    int maxSize = 255;
    char string[maxSize];

    FILE *containerFile = fopen(fileName, "r");
    
    if (! containerFile ){ // Verifica se o ficheiro existe
        printf("No file found\n"); 
        exit(-1); 
    } 

    int line = 0;
    while(fgets(string, maxSize, containerFile)) { //leitura de cada linha do ficheiro

        if(line != 0){
            char *token = strtok(string, ",");
            
            int index = 0;
            char lineSplit[4][256];
            
            while (token != NULL){
                *lineSplit[index] = *token;
                token = strtok(NULL, ",");
                index++;
            }
            fillArray(lineSplit);
        }
        line++;
    }

    fclose(containerFile);
    
}
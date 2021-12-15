#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "fillArray.h"
#include "cleanArray.h"

void cleanArray(char (*lineSplit)[25]);

void importFile(char *fileName){

    int maxSize = 25;
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
            char lineSplit[4][maxSize];
            cleanArray(lineSplit);
            
            while (token != NULL){                
    
                int stringCounter = 0;
                while(*(token + stringCounter) != '\0'){
                    *(lineSplit[index] + stringCounter) = *(token + stringCounter);
                    stringCounter++;
                }

                token = strtok(NULL, ",");
                index++;
            }
            fillArray(lineSplit);
        }
        line++;
    }
    fclose(containerFile);
}
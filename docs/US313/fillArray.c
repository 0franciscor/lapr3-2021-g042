#include <stdlib.h>

void fillArray(char (*lineSplit)[25], char (*shipAllocation)[26][10][25]){

    char *shipCode = lineSplit[0];    
    int x = atoi(lineSplit[1]);
    int y = atoi(lineSplit[2]);
    int z = atoi(lineSplit[3]);

    int indiceString = 0;
    while(*(shipCode + indiceString) != '\0'){
        shipAllocation[x][y][z][indiceString] = *(shipCode + indiceString);
        indiceString++;
    }
}
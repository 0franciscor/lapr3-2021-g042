#include <stdio.h>
#include <stdlib.h>

void fillArray(char (*lineSplit)[25], char (*shipAllocation)[26][10][25]){

    char *shipCode = lineSplit[0];    
    int x = atoi(lineSplit[1]);
    int y = atoi(lineSplit[2]);
    int z = atoi(lineSplit[3]);
    
    printf("%d %d %d %s\n", x, y, z, shipCode);

    

    //shipAllocation[x][y][z] = 

}

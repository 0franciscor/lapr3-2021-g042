#include <stdio.h>
#include "importFile.h"

int main(){

    char shipAllocation [18][26][10][25];

    for(int i = 0; i < 18; i++){
        for(int j = 0; j < 26; j++){
            for(int k = 0; k < 10; k++){
                *shipAllocation[i][j][k] = '\0';
            }
        }
    }

    importFile("cargoManifest.csv", shipAllocation);

    for(int i = 0; i < 18; i++){
        for(int j = 0; j < 26; j++){
            for(int k = 0; k < 10; k++){
                if(shipAllocation[i][j][k] != '\0')
                    printf("x: %d y: %d z: %d tem contentor: %s\n", i, j, k, shipAllocation[i][j][k]);
            }
        }
    }

    return 0;
}
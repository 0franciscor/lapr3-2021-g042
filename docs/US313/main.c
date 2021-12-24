#include <stdio.h>
#include "importFile.h"

char shipAllocation [18][26][10][25];

int main(){

    //zeroArray();
    importFile("cargoManifestShort.csv", shipAllocation);

    //for(int i = 0; i < 18; i++){
        //for(int j = 0; j < 26; j++){
            //for(int k = 0; k < 10; k++){
                //printf("i: %d j: %d k: %d tem navio : %s\n", i, j, k, shipAllocation[i][j][k]);
            //}
        //}
    //}

    return 0;
}
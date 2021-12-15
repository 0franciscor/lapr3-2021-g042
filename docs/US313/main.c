#include <stdio.h>
#include "importFile.h"

char shipAllocation [18][26][10][255];

int main(){

    //zeroArray();
    importFile("cargoManifest.csv");

    return 0;
}
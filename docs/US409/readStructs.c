#include <stdio.h>

#include "containerStruct.h"

void readStructs(FILE *containerFile, cMContainer *containerArray){
    int index = 0;
    while(!feof(containerFile)){
        cMContainer container;

        fscanf(containerFile, "%d,%c,%d,%d,%d,%d,%f,%f,%f,%f,%f",
        &container.containerId, &container.isRefrigerated, &container.isoCode, &container.x, &container.y, &container.z, 
        &container.grossContainer, &container.maxWeight, &container.weight, &container.tare, &container.maxVolume);

        *(containerArray + index) = container;
        index++;
    }
}
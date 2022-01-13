#include <stdio.h>
#include <stdlib.h>

#include "containerStruct.h"

void printArray(short totalSlots, cMContainer *containerArray){
    
    char *outputFileName = "US409.csv";
    FILE *outputFile = fopen(outputFileName, "a");

    fprintf(outputFile, "The Containers info is the following:\n");
    for(int i = 0; i < totalSlots; i++){
        cMContainer container = *(containerArray + i);
        if(container.containerId != 0)
            fprintf(outputFile, "Contentor: %d está localizado na posição x: %d y: %d z: %d. ISO code: %d, Refrigeration: %c, Gross Container: %.2f, Max Weight: %.2f, Actual Weight: %.2f, Tare: %.2f, Max Volume: %.2f \n",
    	    container.containerId, container.x, container.y, container.z, container.isoCode, container.isRefrigerated, container.grossContainer, container.maxWeight, container.weight, container.tare, container.maxVolume);
    }

    fprintf(outputFile, "\n");

    fclose(outputFile);
}
#include "containerStruct.h"
#include "asm.h"
#include "printResult.h"

void calculateEnergy(cMContainer *containerArray, short totalSlots, float externalTemp, float desiredTemp){

    int x = 5, y = 11, z = 7;
    short refrigeration = isRefrigerated(containerArray, x, y, z, totalSlots);

    if(refrigeration == 0)
        return;
        
    cMContainer container = *containerArray;

    float area = 1, totalResistivity = 0;

    float outerThickness = container.outerThickness, outerCapacity = container.outerCapacity;
    float middleThickness = container.middleThickness, middleCapacity = container.middleCapacity;
    float innerThickness = container.innerThickness, innerCapacity = container.innerCapacity;

    totalResistivity += (outerThickness/(outerCapacity*area));
    totalResistivity += (middleThickness/(middleCapacity*area));
    totalResistivity += (innerThickness/(innerCapacity*area));

    float requiredEnergy = (((externalTemp - desiredTemp)/totalResistivity) * 3600);

    printResult(x, y, z, requiredEnergy);
}
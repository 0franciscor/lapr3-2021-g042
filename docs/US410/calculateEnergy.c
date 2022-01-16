#include "containerStruct.h"
#include "asm.h"
#include "printResult.h"

void calculateEnergy(cMContainer *containerArray, short totalSlots){

    int x = 8, y = 17, z = 3;
    short refrigeration = isRefrigerated(containerArray, x, y, z, totalSlots);

    if(refrigeration == 0)
        return;

    float requiredTemp = 7, externalTemp = 20;
    float area = 1;

    float outerThickness = 0.05, outerCapacity = 15;
    float middleThickness = 0.1, middleCapacity = 0.035;
    float innerThickness = 0.05, innerCapacity = 0.3;

    float totalResistivity = 0;

    totalResistivity += (outerThickness/(outerCapacity*area));
    totalResistivity += (middleThickness/(middleCapacity*area));
    totalResistivity += (innerThickness/(innerCapacity*area));

    float requiredEnergy = (((externalTemp - requiredTemp)/totalResistivity) * 3600);

    printResult(x, y, z, requiredEnergy);
}
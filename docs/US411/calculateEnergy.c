#include "containerStruct.h"
#include "printResult.h"

float calculateEnergy(cMContainer *containerArray, short totalSlots){

    float requiredTemp = 7, externalTemp = 20;
    float area = 1;

    float outerThickness = 0.05, outerCapacity = 15;
    float middleThickness = 0.1, middleCapacity = 0.035;
    float innerThickness = 0.05, innerCapacity = 0.3;
    
    float requiredEnergy = 0;
    
    for(short i = 0; i<totalSlots; i++){
        cMContainer container = *(containerArray + i);

        char isRefrigerated = container.isRefrigerated;

        if(isRefrigerated == 49){
            float totalResistivity = 0;

            totalResistivity += (outerThickness/(outerCapacity*area));
            totalResistivity += (middleThickness/(middleCapacity*area));
            totalResistivity += (innerThickness/(innerCapacity*area));

            requiredEnergy += (((externalTemp - requiredTemp)/totalResistivity) * 3600);
        }
    }
    
    return requiredEnergy;
}
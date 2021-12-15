void cleanArray(char (*lineSplit)[25]){
    for(int i = 0; i < 4; i++){
        for(int j = 0; j < 10; j++){
            lineSplit[i][j] = '\0';
        }
    }
}
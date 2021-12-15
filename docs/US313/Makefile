mainCompiled: importFile.o main.o fillArray.o cleanArray.o
	gcc -g -Wall importFile.o main.o fillArray.o cleanArray.o -o main

cleanArray.o: cleanArray.c
	gcc -g -Wall -c cleanArray.c -o cleanArray.o

fillArray.o: fillArray.c
	gcc -g -Wall -c fillArray.c -o fillArray.o

importFile.o: importFile.c
	gcc -g -Wall -c importFile.c -o importFile.o

main.o: main.c
	gcc -g -Wall -c main.c -o main.o

clean:
	rm -f *.o main

run: mainCompiled
	./main

mainCompiled: importFile.o main.o fillArray.o
	gcc -g -Wall importFile.o main.o fillArray.o -o main

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

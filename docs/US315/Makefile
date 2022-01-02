mainCompiled: main.o zeroArray.o asm.o
	gcc -g -Wall  main.o zeroArray.o asm.o -o main

asm.o: asm.s
	gcc -g -c -Wall asm.s -o asm.o

zeroArray.o: zeroArray.c
	gcc -g -c -Wall zeroArray.c -o zeroArray.o

main.o: main.c
	gcc -g -Wall -c main.c -o main.o

clean:
	rm -f *.o main

run: mainCompiled
	./main

debug: mainCompiled
	gdb -tui main

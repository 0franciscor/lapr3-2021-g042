.section .text
    .global checkArray

checkArray:
    movl $0, %ecx # numIteracoes
    movl $0, %r8d # numero de lugares livres
    movl $0, %r9d # numero de lugares ocupados

    jmp loop

loop:
    cmpl %ecx, %esi
    je end

    cmpl $0, (%rdi)
    jne slotOccupied
    je slotNotOccupied
    

nextIteration:
    addq $4, %rdi
    incl %ecx
    jmp loop

slotOccupied:
    incl %r9d
    jmp nextIteration

slotNotOccupied:
    incl %r8d
    jmp nextIteration

end:
    movq %r8, %rax
    shlq $32, %rax
    addq %r9, %rax
    ret

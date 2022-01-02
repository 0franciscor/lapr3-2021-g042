.section .data
    .global maxX
    .global maxY
    .global maxZ
    .global containerLocation

.section .text
    .global isContainerThere

isContainerThere:
    # x em %edi
    # y em %esi
    # z em %edx

    # Verifica Coordenadas

    movl maxX(%rip), %eax
    cmpl %eax, %edi
    jg noContainer

    movl maxY(%rip), %eax
    cmpl %eax, %esi
    jg noContainer

    movl maxZ(%rip), %ecx
    cmpl %eax, %edx
    jg noContainer


    # Memory Address
    imull %eax, %edi # x*maxY
    imull %ecx, %edi # x*maxY*maxZ

    imull %ecx, %esi # y*maxZ

    addl %edx, %esi # y*maxZ + z

    addl %esi, %edi # soma expressoes

    imull $4, %edi # bytes a adicionar
    
    movq containerLocation(%rip), %rax
    addq %rdi, %rax

    # Comparacao

    cmpl $0, (%rax)
    je noContainer
    jne hasContainer

hasContainer:
    movl $0, %eax
    movb $1, %al
    ret

noContainer:
    movl $0, %eax
    ret

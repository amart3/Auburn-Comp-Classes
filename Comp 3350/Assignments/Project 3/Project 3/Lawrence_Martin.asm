; Author: Lawrence "Alex" Martin
; Project 3 

; 10/9/2020

; last modified  10/9/20
; Program reads the values from an array, places the value in a seperate array 
; The value will shift to a vertain value number. 
; adds / subtracts the int values.

.386
.model flat, stdcall
.stack 4096

ExitProcess PROTO, dwExitCode:DWORD 
.data
	input byte 5,0Ah,3,6,0Ch ; Create byte element with the name input. the byte has 8 elements
	output byte LENGTHOF input DUP(?) ; Creates Byte array with "output" handle which has the same length as the "input"
	shift dword 3  ; Creates a shift that 

.code 

	; Loop is told where to start and what to read
	main PROC
	; Loop is told where to start and what to read
	mov eax, 0 
	mov ebx, 0
	mov ecx, shift

	movFirst:
		NEG ecx
		mov al, input[LENGTHOF input + ecx] ; value moves from input to al
		mov output[ebx], al ; value moves from al to output
		NEG ecx ; updates index
		INC ebx ; updates index
	loop movFirst

	; shift is iterated in the loop
	mov ecx, LENGTHOF input
	sub ecx, shift
	mov edx, 0

	movRest:
		mov al, input[edx] ; value moves from input to al 
		mov output[ebx], al ; al value moves to the output
		INC ebx ; increases the input 
		INC edx ; increases the output
	loop movRest

	invoke ExitProcess, 0

main endp
end main
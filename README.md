# StackCalculator
Stack based calculator using *Factory Method* pattern

## Description
A simple calculator that works with the following operations:
* *DEFINE \<VAR> \<N>* - sets variable VAR equals to N
* *PUSH \<X>* - pushes some number X to the stack
* *POP* - pops the top number from the stack
* *EXP \<some_expression>* - calculates the expression and pushes it into stack
* *\'+'* - sums up the top two numbers from the stack and puts the result back
* *\'-'* - subtracts the top two numbers from the stack and puts the result back
* *\'\*\'* - multiply
* *\'/\'* - divide
* *SQRT* - calculates square root of the number at the top of the stack
* *PRINT* - prints the result

## Example
```
PUSH 10
DEFINE X 25
PUSH X
SQRT
+
PRINT
```
```
15.0
```

```
DEFINE A 6
EXP (7+A)*3
PRINT
```
```
39.0
```

import random

def suma(a,b):
    return a + b

def multiplicacion(a,b):
    return a * b

def resta(a,b):
    return a - b

def division(a,b):
    if b == 0:
        raise ValueError("No se puede dividir entre cero")
    return a / b


if __name__ == "__main__":
    x =  random.randint(1, 99)
    y =  random.randint(1, 99)
    print(f"Valores aleatorios: x={x}, y={y}")
    print(f"Suma: {suma(x,y)}")
    print(f"Resta: {resta(x,y)}")
    print(f"Multiplicación: {multiplicacion(x,y)}")
    print(f"División: {division(x,y)}")
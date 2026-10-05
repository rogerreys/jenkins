import pytest

from app import suma, resta, multiplicacion, division


def test_suma():
    assert suma(2, 3) == 5
    assert suma(-1, 1) == 0


def test_resta():
    assert resta(5, 3) == 2
    assert resta(3, 5) == -2


def test_multiplicacion():
    assert multiplicacion(4, 3) == 12
    assert multiplicacion(-2, 3) == -6


def test_division():
    assert division(10, 2) == 5
    assert division(1, 4) == 0.25


def test_division_entre_cero():
    with pytest.raises(ValueError, match="No se puede dividir entre cero"):
        division(1, 0)

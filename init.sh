#! /bin/bash

# Crear el entorno virtual e instalar dependencias
python3 -m venv .venv
. .venv/bin/activate
pip install -r requirements.txt

# Ejecutar el programa
python app/app.py

# Ejecutar las pruebas (toma la config de pytest.ini: src/test)
# y generar los reportes JUnit (XML) y HTML en la carpeta report/
pytest -v --junitxml=report/report.xml --html=report/report.html --self-contained-html
echo "Pruebas ejecutadas correctamente. Reportes generados en la carpeta report/"
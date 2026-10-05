#! /bin/bash

if [ ! -d ".venv" ]; then
    echo "Creando entorno virtual..."
    python3 -m venv .venv
fi
# Activar el entorno virtual
if [ -f ".venv/bin/activate" ]; then
    echo "Activando entorno virtual..."
    . .venv/bin/activate
elif [ -f ".venv/Scripts/activate" ]; then
    echo "Activando entorno virtual..."
    . .venv/Scripts/activate
else
    echo "Error: No se pudo activar el entorno virtual. Asegúrate de que Python 3 esté instalado."
    exit 1
fi
# Instalar dependencias
pip install --upgrade pip
pip install -r requirements.txt

# Ejecutar las pruebas (toma la config de pytest.ini: src/test)
# y generar los reportes JUnit (XML) y HTML en la carpeta report/
pytest -v --junitxml=report/report.xml --html=report/report.html --self-contained-html
echo "Pruebas ejecutadas correctamente. Reportes generados en la carpeta report/"

# Ejecutar el programa
python app/app.py
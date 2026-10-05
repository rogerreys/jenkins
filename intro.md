# Descargar con docker
docker run -d  --name jenkins -p 8080:8080 -p 50000:50000 -v jenkins_home:/var/jenkins_home  jenkins/jenkins:lts 

# Credenciales 
Todo: admin

# Crear el entorno virtual (crea la carpeta .venv)
uv venv

# Activar el entorno (Linux/macOS)
source .venv/bin/activate

# Activar el entorno (Windows, PowerShell)
.venv\Scripts\Activate.ps1

# Activar el entorno (Windows, cmd)
.venv\Scripts\activate.bat

# Instalar dependencias desde requirements.txt
uv pip install -r requirements.txt


# Ejecutar en Jenkins (programa + pruebas)
El contenedor de Jenkins (Dockerfile) trae python3 y venv, pero no uv, por eso aquí se usa `python -m venv` y `pip`.

En el job: Configurar > Build Steps > Execute shell, y pegar:

```bash
# Crear el entorno virtual e instalar dependencias
python3 -m venv .venv
. .venv/bin/activate
pip install -r requirements.txt

# Ejecutar el programa
python app/app.py

# Ejecutar las pruebas (toma la config de pytest.ini: src/test)
# y generar los reportes JUnit (XML) y HTML en la carpeta report/
pytest -v --junitxml=report/report.xml --html=report/report.html --self-contained-html
```

Para ver los reportes en Jenkins, en Configurar > Post-build Actions:
- **Publish JUnit test result report**: Test report XMLs = `report/report.xml`
- **Publish HTML reports** (plugin *HTML Publisher*): directorio `report`, archivo `report.html`

Si alguna prueba falla, pytest termina con error y el build queda en rojo (FAILURE).

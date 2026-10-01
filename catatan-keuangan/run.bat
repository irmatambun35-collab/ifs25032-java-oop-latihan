@echo off
cd /d "%~dp0"
javac -d output -sourcepath src src/App.java || exit /b 1
if "%~1"=="" (java -cp output App) else (java -cp output App < "%~1")

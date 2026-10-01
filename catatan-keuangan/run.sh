#!/bin/bash
# Compile lalu jalankan aplikasi. Untuk uji test case: ./run.sh test-cases/TC-01.tc
cd "$(dirname "$0")"
javac -d output -sourcepath src src/App.java || exit 1
if [ -n "$1" ]; then java -cp output App < "$1"; else java -cp output App; fi

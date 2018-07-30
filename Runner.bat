prompt Rex:$g 
:label
cls
:: If your Java Path is not set then decomment the lower line by removing (::)
set path="C:\Program Files\Java\jdk-9.0.4\bin";
cd src
javac -d ../bin Executable.java -Xlint
cd ../bin
java Executable
pause
goto label
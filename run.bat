@echo off
:: SkyReserve Launcher for Windows

echo Starting SkyReserve...
call mvn clean compile exec:java -Dexec.mainClass="com.skyreserve.main.SkyReserveApplication"
pause

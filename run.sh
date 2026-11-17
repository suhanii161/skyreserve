#!/bin/bash
# SkyReserve Launcher for Ubuntu/Linux/macOS

echo "Starting SkyReserve..."
mvn clean compile exec:java -Dexec.mainClass="com.skyreserve.main.SkyReserveApplication"

# CSC1009 Project (IOT ATM)

## How to run
- scp the the javaproject folder to your raspberrypi by: ```scp -r <projectdirectory> pi@raspberrypi.local:javaproject```
- class file has already been compiled to run on the raspberry version or you can compile it by navigating to the java folder and typing: ```javac --release 8 Main.java```
- On your Rpi, navigate to the java folder where Main.java is located and run by: ```java Main```
- On you own device, run the myClient in the IOTClient folder by compiling: ```javac MyClient.java``` and then run by: ```java MyClient```

## Note
- Can only run if your device and Rpi connected to the same Wifi

## How to get directory tree
```On windows (in your targeted directory) type in: tree /a /f >DirectoryTree.txt
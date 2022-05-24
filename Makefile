- compile:
	javac config/*.java src/model/*.java src/controller/*.java src/view/*.java src/view/components/*.java ./Main.java
	jar cvmf MANIFEST.MF ./build/CarRace.jar config/*.class src/model/*.class src/controller/*.class src/view/*.class src/view/components/*.class Main.class
all: lein javac	run

run: 
	java -cp "src/crap/:target/crap.jinterop-0.1.0-SNAPSHOT-standalone.jar"  Turd

javac:
	javac -cp "src/crap:target/crap.jinterop-0.1.0-SNAPSHOT-standalone.jar"   src/crap/turd.java

lein:
	lein uberjar

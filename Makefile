VERSION=0.1.0-SNAPSHOT
UBERJAR=target/crap.jinterop-$(VERSION)-standalone.jar

.PHONY: all uberjar clean

all: $(UBERJAR) javac run

run:
	java -cp "src/crap/:target/crap.jinterop-0.1.0-SNAPSHOT-standalone.jar"  Turd

javac:
	javac -cp "src/crap:target/crap.jinterop-0.1.0-SNAPSHOT-standalone.jar"   src/crap/turd.java

uberjar: $(UBERJAR)

$(UBERJAR):
	lein uberjar

clean:
	lein clean
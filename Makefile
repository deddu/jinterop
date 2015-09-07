VERSION=0.1.0-SNAPSHOT
UBERJAR=target/crap.jinterop-$(VERSION)-standalone.jar

.PHONY: all uberjar run clean

all: $(UBERJAR) run

run: target/Turd.class
	java -cp "$(dir $<):$(UBERJAR)" Turd

target/Turd.class: src/java/crap/turd.java $(UBERJAR) $(wildcard src/**/*.java)
	javac -cp "$(dir $<):$(UBERJAR)" -d $(dir $@) $<

uberjar: $(UBERJAR)

$(UBERJAR): $(wildcard src/**/*.clj)
	lein uberjar

clean:
	#lein clean
	rm -rf target/

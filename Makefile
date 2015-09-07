VERSION=0.1.0-SNAPSHOT
UBERJAR=target/crap.jinterop-$(VERSION)-standalone.jar

.PHONY: all uberjar run clean

all: $(UBERJAR) run

run: java-Turd java-FootOnCrap java-FootOnTurd java-FootOnPoop

java-%: target/%.class
	java -cp "$(dir $<):$(UBERJAR)" $(shell basename $< .class)

target/%.class: src/java/crap/%.java $(UBERJAR) $(wildcard src/**/*.java)
	javac -cp "$(dir $<):$(UBERJAR)" -d $(dir $@) $<

uberjar: $(UBERJAR)

$(UBERJAR): $(wildcard src/**/*.clj)
	rm -f $@
	lein uberjar

clean:
	#lein clean
	rm -rf target/

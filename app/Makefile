GR = ./gradlew
COMMAND ?= -h


setup:
	$(GR) wrapper --gradle-version 8.11

clean:
	$(GR) clean

build:
	$(GR) build

clean-build: clean build

install:
	$(GR) clean install

run-dist:
	./build/install/java-project-71/bin/java-project-71 $(COMMAND)

run:
	$(GR) run

test:
	$(GR) test

update-deps:
	$(GR) refreshVersions
	# ./gradlew wrapper --gradle-version 9.0.0

build-run: build run

jar:
	$(GR) installDist

jar-dist: clean-build jar run-dist

report:
	$(GR) jacocoTestReport

say-hello:
	@echo "Hi, Sonar!"

.PHONY: build

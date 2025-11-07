GR = @./gradlew
FR ?= -h
F1 ?= file1.json
F2 ?= file2.json
BU-APP = @./build/install/app/bin/app
ST = "stylish"


setup:
	$(GR) wrapper --gradle-version 8.11

clean:
	$(GR) clean

build:
	$(GR) build

clean-build: clean build

install:
	$(GR) clean install

run:
	$(GR) run

run-dist:
	$(BU-APP) $(F1) $(F2)

run-h:
	$(BU-APP) -h

test:
	$(GR) test

update-deps:
	$(GR) refreshVersions
	# ./gradlew wrapper --gradle-version 9.0.0

build-run: build run

jar:
	$(GR) installDist

jar-dist: clean-build jar run-h

report:
	$(GR) jacocoTestReport

.PHONY: build

GR = @./gradlew
FR ?= -h
F1 ?= file1.json
F2 ?= file2.json


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
	@./build/install/app/bin/app $(F1) $(F2)

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

jar-dist: clean-build jar
	@./build/install/app/bin/app -h

report:
	$(GR) jacocoTestReport

.PHONY: build

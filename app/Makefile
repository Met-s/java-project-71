GR = ./gradlew
.DEFAULT_GOAL := build-run

setup:
	$(GR) wrapper --gradle-version 8.11

clean:
	$(GR) clean

build:
	$(GR) clean build

install:
	$(GR) clean install

run-dist:
	./build/install/app/bin/app

run:
	$(GR) run

test:
	$(GR) test

report:
	$(GR) jacocoTestReport

lint:
	$(GR) checkstyleMain

update-deps:
	$(GR) refreshVersions
	# ./gradlew wrapper --gradle-version 9.0.0

build-run: build run

jar:
	gradle installDist

.PHONY: build

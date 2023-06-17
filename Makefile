
build:
	./mvnw clean package -PbuildOnly

unit-tests:
	./mvnw clean package -Pdev

it-tests:
	./mvnw clean verify -Pit

docker-ms-build:
	DOCKERFILE_NAME=Dockerfile-multistage docker-compose build
	DOCKERFILE_NAME=Dockerfile-multistage docker-compose up

docker-simple-build:
	./mvnw clean package -PbuildOnly
	DOCKERFILE_NAME=Dockerfile-main docker-compose build
	DOCKERFILE_NAME=Dockerfile-main docker-compose up

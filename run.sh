./gradlew bootjar

docker build -f docker/Dockerfile -t prometheus-grafana-tutorial .
docker-compose -f docker/docker-compose.yml up

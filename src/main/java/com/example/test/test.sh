set -e
echo "Q. IMAGE_TAG?"
read IMAGE_TAG

sed -i 's/image:.*/image: docker.ust21.kr\/koos\/koos-system-auth-app:'"$IMAGE_TAG"'/' ./auth/docker-compose.yml
sed -i 's/image:.*/image: docker.ust21.kr\/koos\/koos-system-auth-app:'"$IMAGE_TAG"'/' ./auth/docker-compose.yml
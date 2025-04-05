deploy-app:
	./gradlew build
	cd infrastructure && cdk deploy

destroy-app:
	./gradlew build
	cd infrastructure && cdk destroy

test-app:
	ab -n 1000 -c 50 http://josh-load-balanced-1583087804.us-east-2.elb.amazonaws.com/


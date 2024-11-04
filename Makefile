deploy-app:
	./gradlew build
	cd infrastructure && cdk deploy

test-app:
	ab -n 1000 -c 50 http://josh-load-balanced-608032866.us-east-2.elb.amazonaws.com/


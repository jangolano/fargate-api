plugins {
    id("buildlogic.kotlin-application-conventions")
}

dependencies {
    implementation("software.amazon.awscdk:aws-cdk-lib:2.145.0")
}
application{
    mainClass = "AppKt"
}

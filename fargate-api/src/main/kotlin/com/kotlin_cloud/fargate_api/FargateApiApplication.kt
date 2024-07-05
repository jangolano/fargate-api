package com.kotlin_cloud.fargate_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FargateApiApplication

fun main(args: Array<String>) {
	runApplication<FargateApiApplication>(*args)
}

package com.kotlin_cloud.fargate_api.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class MyController {

    @GetMapping("/")
    fun  getData():String{
       return "Hello World"
    }
}
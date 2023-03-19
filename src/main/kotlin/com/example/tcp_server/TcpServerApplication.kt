package com.example.tcp_server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TcpServerApplication

fun main(args: Array<String>) {
    runApplication<TcpServerApplication>(*args)
}

package com.example.tcp_server.config

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.integration.ip.tcp.TcpInboundGateway

@Configuration
class StartConfig {

    @Autowired
    private lateinit var inboundChannelAdapter: TcpInboundGateway

    @PostConstruct
    fun startTcpServer() {
        inboundChannelAdapter.start()
        println("**TCP server start**")
    }
}
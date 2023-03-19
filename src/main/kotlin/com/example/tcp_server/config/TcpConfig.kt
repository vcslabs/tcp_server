package com.example.tcp_server.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.config.EnableIntegration
import org.springframework.integration.ip.tcp.TcpInboundGateway
import org.springframework.integration.ip.tcp.connection.TcpNioServerConnectionFactory
import org.springframework.integration.ip.tcp.serializer.TcpCodecs

@Configuration
@EnableIntegration
class TcpConfig {

    @Bean
    fun tcpServerFactory(): TcpNioServerConnectionFactory {
        return TcpNioServerConnectionFactory(1234)
    }

    @Bean
    fun inboundChannelAdapter(tcpServerFactory: TcpNioServerConnectionFactory): TcpInboundGateway {
        val adapter = TcpInboundGateway()
        adapter.setConnectionFactory(tcpServerFactory)
        adapter.setRequestChannel(requestChannel())
//        adapter.setRequestChannelName("requestChannel")
        return adapter
    }

    @Bean
    fun requestChannel(): DirectChannel {
        return DirectChannel()
    }

    @ServiceActivator(inputChannel = "requestChannel")
    fun handleRequest(request: String) {
        println("Received request: $request")
    }
}
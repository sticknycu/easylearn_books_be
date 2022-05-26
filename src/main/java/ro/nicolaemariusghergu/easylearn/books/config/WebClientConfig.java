package ro.nicolaemariusghergu.easylearn.books.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Slf4j
@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(@Value("${remote.server.host:localhost}") String host,
                               @Value("${wiremock.server.port:9092}") int port,
                               @Value("${global-timeout:5000}") int globalTimeout,
                               @Value("${request-timeout:1000}") int requestTimeout) {

        ClientHttpConnector connector = new ReactorClientHttpConnector(
                HttpClient
                        .create()
                        .responseTimeout(Duration.ofMillis(globalTimeout))
                        .doOnRequest((req, conn) -> {
                            log.debug("webClient - {}", req);
                            req.responseTimeout(Duration.ofMillis(requestTimeout));
                        })
        );
        return WebClient.builder()
                .baseUrl("http://" + host + ":" + port)
                .clientConnector(connector)
                .build();

    }
}

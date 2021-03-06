package com.webmuffins.rtsx.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:service-names.properties")
public class ApiGatewayConfiguration {

    @Value("${board-service.name}")
    private String boardService;

    @Value("${users-service.name}")
    private String securityService;

    @Value("${chat-service.name}")
    private String chatService;

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(boardTagsSpec -> boardTagsSpec.path("/tags/**").uri("lb://" + boardService))
                .route(boardBoardsSpec -> boardBoardsSpec.path("/boards/**").uri("lb://" + boardService))
                .route(boardTicketsSpec -> boardTicketsSpec.path("/tickets/**").uri("lb://" + boardService))
                .route(boardRowsSpec -> boardRowsSpec.path("/rows/**").uri("lb://" + boardService))

                .route(usersUserSpec -> usersUserSpec.path("/users/**").uri("lb://" + securityService))
                .route(usersUserSpec -> usersUserSpec.path("/auth/**").uri("lb://" + securityService))
                .route(usersTeamsSpec -> usersTeamsSpec.path("/teams/**").uri("lb://" + securityService))

                .route(chatMessageSpec -> chatMessageSpec.path("/chat-service/**").uri("lb://" + chatService))
                .build();
    }

}

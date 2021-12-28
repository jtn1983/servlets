package ru.tenilin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tenilin.controller.PostController;
import ru.tenilin.repository.PostRepository;
import ru.tenilin.service.PostService;

@Configuration
public class JavaConfig {
    @Bean
    public PostController postController() {
        return new PostController(postService());
    }

    @Bean
    public PostService postService() {
        return new PostService(postRepository());
    }

    @Bean
    public PostRepository postRepository() {
        return new PostRepository();
    }
}

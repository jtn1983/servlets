package ru.tenilin.repository;

import ru.tenilin.model.Post;

import java.util.*;

// Stub
public class PostRepository {
    private HashMap<Long, Post> postsList = new HashMap<>();
    private long idPost = 0;

    public PostRepository(){
        postsList.put(1L, new Post(1, "Hello1"));
        postsList.put(2L, new Post(2, "Hello2"));
    }

    public List<Post> all() {
        return new ArrayList<>(postsList.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(postsList.get(id));
    }

    public synchronized Post save(Post post) {
        if (post.getId() == 0) {
            Post newPost = new Post(++idPost, post.getContent());
            postsList.put(idPost, newPost);
            return newPost;
        } else {
            postsList.put(post.getId(), post);
        }
        return post;
    }

    public synchronized void removeById(long id) {
        postsList.remove(id);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class User {
    private int userId;
    private String username;
    private List<Post> posts;

    public User(int userId, String username) {
        this.userId = userId;
        this.username = username;
        this.posts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void createPost(String caption) {
        Post post = new Post(this, caption);
        posts.add(post);
        try {
            // Save the post to a file
            post.saveToFile();
        } catch (IOException e) {
            System.err.println("Error saving post to a file: " + e.getMessage());
        }
    }

    public void deletePost(int postId) throws PostNotFoundException {
        for (Post post : posts) {
            if (post.getPostId() == postId) {
                posts.remove(post);
                try {
                    // Delete the post file
                    post.deleteFile();
                } catch (IOException e) {
                    System.err.println("Error deleting post file: " + e.getMessage());
                }
                return;
            }
        }
        throw new PostNotFoundException("Post not found with ID: " + postId);
    }
}
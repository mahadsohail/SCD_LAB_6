/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab6;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class PostNotFoundException extends Exception {
    public PostNotFoundException(String message) {
        super(message);
    }
}




public class LAB6 {
    public static void main(String[] args) {
        try {
            // Create users
            User user1 = new User(1, "user1");
            User user2 = new User(2, "user2");

            // User 1 creates a post
            user1.createPost("T.");

            // User 2 comments on User 1's post
            Post post = user1.getPosts().get(0);
            Comment comment = new Comment(2, "N!");
            post.addComment(comment);

            // User 1 deletes the post
            int postIdToDelete = post.getPostId();
            user1.deletePost(postIdToDelete);

            // List all remaining posts
            List<Post> remainingPosts = user1.getPosts();
            for (Post p : remainingPosts) {
                System.out.println("User " + user1.getUsername() + "'s post: " + p.caption);
            }
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        } catch (PostNotFoundException e) {
            System.err.println("Post not found: " + e.getMessage());
        }
    }

    static class Comment {
        private int userId;
        private String text;

        public Comment(int userId, String text) {
            this.userId = userId;
            this.text = text;
        }
    }
}

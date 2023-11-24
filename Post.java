/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Post {
    private static int postIdCounter = 1;
    private int postId;
    private String caption;
    private User user;

    public Post(User user, String caption) {
        this.postId = postIdCounter++;
        this.user = user;
        this.caption = caption;
    }

    public int getPostId() {
        return postId;
    }

    public void saveToFile() throws IOException {
        // Save post data to a file (simplified for demonstration)
        String filename = "post_" + postId + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(caption);
        }
    }

    public void deleteFile() throws IOException {
        // Delete the post file (simplified for demonstration)
        String filename = "post_" + postId + ".txt";
        File file = new File(filename);
        if (file.exists()) {
            if (!file.delete()) {
                throw new IOException("Failed to delete the post file.");
            }
        }
    }
}

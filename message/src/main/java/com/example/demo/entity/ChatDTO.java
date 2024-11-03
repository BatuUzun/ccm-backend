package com.example.demo.entity;

public class ChatDTO {
    private Long id;
    private Long user1Id;
    private Long user2Id;
    private String user1ProfilePicture;
    private String user2ProfilePicture;
    private String user1Username;  // New field for user1's username
    private String user2Username;  // New field for user2's username

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(Long user1Id) {
        this.user1Id = user1Id;
    }

    public Long getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(Long user2Id) {
        this.user2Id = user2Id;
    }

    public String getUser1ProfilePicture() {
        return user1ProfilePicture;
    }

    public void setUser1ProfilePicture(String user1ProfilePicture) {
        this.user1ProfilePicture = user1ProfilePicture;
    }

    public String getUser2ProfilePicture() {
        return user2ProfilePicture;
    }

    public void setUser2ProfilePicture(String user2ProfilePicture) {
        this.user2ProfilePicture = user2ProfilePicture;
    }

    public String getUser1Username() {
        return user1Username;
    }

    public void setUser1Username(String user1Username) {
        this.user1Username = user1Username;
    }

    public String getUser2Username() {
        return user2Username;
    }

    public void setUser2Username(String user2Username) {
        this.user2Username = user2Username;
    }
}

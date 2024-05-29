import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Post {
    private int postId;
    private String postTitle;
    private String postBody;
    private String[] postTags;
    private String[] postType = {"Very Difficult", "Difficult", "Easy"};
    private String[] postEmergency = {"Immediately needed", "Highly Needed", "Ordinary"};
    private ArrayList<String> postComments = new ArrayList<>();

    // Getters and setters
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public String[] getPostTags() {
        return postTags;
    }

    public void setPostTags(String[] postTags) {
        this.postTags = postTags;
    }

    public String[] getPostType(){
        return postType;
    }

    public void setPostType(String[] postType){
        this.postType = postType;
    }

    public String[] getPostEmergency() {
        return postEmergency;
    }

    public void setPostEmergency(String[] postEmergency) {
        this.postEmergency = postEmergency;
    }
    public ArrayList<String> getComments() {
        return postComments;
    }
    public void setComments(ArrayList<String> postComments) {
        this.postComments = postComments;
    }

    public boolean addPost() {
        if (!isValidTitle()) {
            return false;
        }
        if (!isValidBody()) {
            return false;
        }
        if (!isValidTags()) {
            return false;
        }
        if (!isValidPostType()) {
            return false;
        }
        if (!isValidEmergencyStatus()) {
            return false;
        }
        return writePost();
    }

    public boolean isValidTitle() {
    //Title should have a min of 10 characters and max of 250
    if (postTitle.length() < 10 || postTitle.length() > 250) {
        return false;
    }
    //first five characters shouldn't be numbers and special characters
    for (int i = 0; i < 5; i++) {
        if (!Character.isLetter(postTitle.charAt(i))) {
            return false;
        }
    }
    
    return true;
}
    private boolean isValidBody() {
        if(postBody.length() < 250){
            return false;
        }
        return true;
    }

    private boolean isValidTags() {
        if (postTags.length < 2 || postTags.length > 5) {
            return false;
        }
        for (String tag : postTags) {
            if (tag.length() < 2 || tag.length() > 10 || !tag.equals(tag.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidPostType() {
        if (postType[0].equals("Easy") && postTags.length > 3) {
            return false;
        }
        if ((postType[0].equals("Difficult") || postType[0].equals("Very Difficult")) && postBody.length() < 300) {
            return false;
        }
        return true;
    }

    private boolean isValidEmergencyStatus() {
        if (postType[0].equals("Easy") && (postEmergency[0].equals("Immediately Needed") || postEmergency[0].equals("Highly Needed"))) {
            return false;
        }
        if ((postType[0].equals("Very Difficult") || postType[0].equals("Difficult")) && postEmergency[0].equals("Ordinary")) {
            return false;
        }
        return true;
    }
    public boolean writePost() {
        try (FileWriter postFile = new FileWriter("posts.txt", true)) {
            postFile.write("Post ID: " + postId + "\n");
            postFile.write("Title: " + postTitle + "\n");
            postFile.write("Body: " + postBody + "\n");
            postFile.write("Tags: " + String.join(", ", postTags) + "\n");
            postFile.write("Type: " + postType + "\n");
            postFile.write("Emergency: " + postEmergency + "\n");
            postFile.write("Comments: " + String.join(", ", postComments) + "\n");
            postFile.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addComment(String commentText) {
  // Condition 1: Comment length and first character
    String[] words = commentText.split(" ");
    if ((words.length < 4 || words.length > 10)) {
        return false;
    }
    if(!Character.isUpperCase(words[0].charAt(0))){
        return false;
    }
    // Condition 2: Maximum number of comments
    if(!isValidComment()){
        return false;
    }
        postComments.add(commentText);
        return writeComment(commentText);
    }

    public boolean isValidComment(){
        if (postComments.size() > 4){
            return false;
        }

        if(((postType[0].equals("Easy") || postEmergency[0].equals("Ordinary")) && postComments.size() > 2)){
            return false;
        }
    return true;
    }
    
    public boolean writeComment(String commentText){
    try (FileWriter commentFile = new FileWriter("comments.txt", true)) {
            commentFile.write("Post ID: " + postId + "\n");
            commentFile.write("Comment: " + commentText + "\n");
            commentFile.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    return true;
    }
}


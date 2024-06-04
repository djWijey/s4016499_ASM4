import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class addCommentTest {
    @Test
    /* Checking the requirements:
     * Comment text should have a minimum of 4 words and max of 10
     */
    void checkCommentWords() {
        Post cmt = new Post();
        assertEquals(false, cmt.addComment("Hey"));
    }
    @Test
    /* Checking whether or not it will print into document:
     * When true, it will input into comments.txt
     */
    void checkingValid(){
        Post valid = new Post();
        assertEquals(true, valid.addComment("The coding question looks hard."));
    }
    
    @Test
    /* Checking the requirements:
     * Checking if there can be multiple comments added in posts at once
     */
    void checkCommentQuantity(){
        Post cmtQuantity = new Post();
        assertEquals(true, cmtQuantity.addComment("Hello, I don't know what to enter"));
        assertEquals(true, cmtQuantity.addComment("Hello, I don't know what to enter"));
        assertEquals(true, cmtQuantity.addComment("Hello, I don't know what to enter"));
    }
    @Test
    /* Checking the requirements:
     * Each post should have 0-5 comments
     * 6th comment shouldn't post.
     */
    void checkCommentLength(){
        Post cmtLength = new Post();
        assertEquals(true, cmtLength.addComment("Hello my name is Anna."));
        assertEquals(true, cmtLength.addComment("Hello my name is Anna."));
        assertEquals(true, cmtLength.addComment("Hello my name is Anna."));
        assertEquals(true, cmtLength.addComment("Hello my name is Anna."));
        assertEquals(true, cmtLength.addComment("Hello my name is Anna."));
        assertEquals(false, cmtLength.addComment("Hello my name is Anna."));
    }
    @Test 
    /* Checking the requirements:
     * Posts that are "Easy" or "Ordinary" should have a max of 3 comments. 
     * This test should return false as there are more than 3 comments, hence 4th comment will not print inside comment.txt
     */
    void checkEasy_OrdinaryComments(){
        String[] postType = {"Easy"};
        String[] postEmergency = {"Ordinary"};
        Post cmtValid = new Post();
        cmtValid.setPostType(postType);
        cmtValid.setPostEmergency(postEmergency);
        assertEquals(true, cmtValid.addComment("Hello my name is Anna"));
        assertEquals(true, cmtValid.addComment("Hello my name is Anna"));
        assertEquals(true, cmtValid.addComment("Hello my name is Anna"));
        assertEquals(false, cmtValid.addComment("Hello my name is Anna"));
    }
    @Test
    /* Checking the requirments:
     * Comment statisfies all other requirements except for the length of the comment having more than 10 words. 
     */
    void checkComment(){
        Post checkcmt = new Post();
        assertEquals(false, checkcmt.addComment("Hello my name is anna. Hello my name is anna. Hello my name is anna"));
    }
}

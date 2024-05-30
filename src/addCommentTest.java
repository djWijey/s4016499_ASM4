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
    /* Checking the requirements:
     * First letter should be an uppercase letter
     */
    void checkUpperCase(){
        Post cmtUpper = new Post();
        assertEquals(false, cmtUpper.addComment("hey hello my nam ie hello"));
    }
    @Test
    /* Checking the requirements:
     * Checking if there can be multiple comments added in posts
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
     * Posts that are "Easy" or "Ordinary" should have a max of 3 comments
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
    /*Checking the requirments:
     * Comment is 4 words long but doesn't have upper case
     */
    void checkComment(){
        Post checkcmt = new Post();
        assertEquals(false, checkcmt.addComment("Hello my name is anna. Hello my name is anna. Hello my name is anna"));
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class addPostTest {
    @Test
    void testTitle() {
        String[] tags = {"tag1", "tag2"};
        String[] type = {"Difficult"};
        String[] sos = {"Highly Needed"};
        Post checkTitleLength = new Post();
        checkTitleLength.setPostId(1);
        checkTitleLength.setPostTitle("The");
        checkTitleLength.setPostBody("This is the post body. It needs to be at least 250 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 250 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 250 characters long. I hope this is enough characters.");
        checkTitleLength.setPostTags(tags);
        checkTitleLength.setPostType(type);
        checkTitleLength.setPostEmergency(sos);

        assertEquals(false, checkTitleLength.addPost());
    }
    @Test
    void testTitleSpecialCharacter(){
        String[] tags = {"tag1", "tag2"};
        String[] type = {"Difficult"};
        String[] sos = {"Highly Needed"};
        Post checkSpecialCharacter = new Post();
        checkSpecialCharacter.setPostId(2);
        checkSpecialCharacter.setPostTitle("@@Title is too long");
        checkSpecialCharacter.setPostBody("This is the post body. It needs to be at least 250 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 250 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 250 characters long. I hope this is enough characters.");
        checkSpecialCharacter.setPostTags(tags);
        checkSpecialCharacter.setPostType(type);
       checkSpecialCharacter.setPostEmergency(sos);

        assertEquals(false, checkSpecialCharacter.addPost());
    }
    @Test
    void checkPostBody(){
        String[] tags = {"tag1", "tag2"};
        String[] type = {"Difficult"};
        String[] sos = {"Highly Needed"};
        Post checkBody = new Post();
        checkBody.setPostId(3);
        checkBody.setPostTitle("Thetitle is long.");
        checkBody.setPostBody("This is the post body. Checking whether valid");
        checkBody.setPostTags(tags);
        checkBody.setPostType(type);
        checkBody.setPostEmergency(sos);

        assertEquals(false, checkBody.addPost());
    }
    @Test
    void checkTagsAmount(){
        String[] tags = {"tag1"};
        String[] type = {"Difficult"};
        String[] sos = {"Highly Needed"};
        Post checkTags = new Post();
        checkTags.setPostId(4);
        checkTags.setPostTitle("Thetitle is long.");
        checkTags.setPostBody("This is the post body. It needs to be at least 250 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 250 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 250 characters long. I hope this is enough characters.");
        checkTags.setPostTags(tags);
        checkTags.setPostType(type);
        checkTags.setPostEmergency(sos);

        assertEquals(false, checkTags .addPost());
    }

    @Test
    /* Checking the requirement:
    * Tags should have a minimum of 2 characters and a maximum of 10 characters.
    * Tags should not include any upper-case letters.
    */
    void checkTagsExtraCondition(){
        String[] tags = {"tAGssNotSatisfied"};
        String[] type = {"Difficult"};
        String[] sos = {"Highly Needed"};
        Post checkTags_extraCondition = new Post();
        checkTags_extraCondition.setPostId(5);
        checkTags_extraCondition.setPostTitle("Thetitle is long.");
        checkTags_extraCondition.setPostBody("This is the post body. It needs to be at least 250 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 250 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 250 characters long. I hope this is enough characters.");
        checkTags_extraCondition.setPostTags(tags);
        checkTags_extraCondition.setPostType(type);
        checkTags_extraCondition.setPostEmergency(sos);

        assertEquals(false, checkTags_extraCondition.addPost());

    }
    @Test
    /* Checking the requirements:
     * "Easy" posts should not have more than 3 tags
     */
    void checkingEasyPostType(){
        String[] tags = {"tag1", "tag2", "tag3", "tag4", "tag5"};
        String[] type = {"Easy"};
        String[] sos = {"Ordinary"};
        Post checkType_Easy= new Post();
        checkType_Easy.setPostId(6);
        checkType_Easy.setPostTitle("The title is long.");
        checkType_Easy.setPostBody("This is the post body. It needs to be at least 250 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 250 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 250 characters long. I hope this is enough characters.");
        checkType_Easy.setPostTags(tags);
        checkType_Easy.setPostType(type);
        checkType_Easy.setPostEmergency(sos);

        assertEquals(false, checkType_Easy.addPost());

    }
    @Test
    /* Checking the requirements:
     * "Very Difficult" & "Difficult" posts should have a minimum of 300 characters in body.
     */
    void checkOtherPostType(){
        // String[] tags = {"tag1", "tag2", "tag3", "tag4", "tag5"};
        // String[] type = {"Difficult", "Very Difficult"};
        // String[] sos = {"Highly Needed"};
        // Post checkType_Other= new Post();
        // checkType_Other.setPostId(7);
        // checkType_Other.setPostTitle("Thetitle is long.");
        // checkType_Other.setPostBody("This is the post body. It needs to be at least 300 characters long. I hope this is enough characters."
        //                     + " This is the post body. It needs to be at least 300 characters long. I hope this is enough characters.");
        // checkType_Other.setPostTags(tags);
        // checkType_Other.setPostType(type);
        // checkType_Other.setPostEmergency(sos);

        // assertEquals(false, checkType_Other.addPost());

        String[] tags = {"tag1", "tag2"};
        String[] type = {"Difficult"};
        String[] sos = {"Immediately Needed", "Highly Needed"};
        Post checkEmergency_Easy= new Post();
        checkEmergency_Easy.setPostId(8);
        checkEmergency_Easy.setPostTitle("Thetitle is long.");
        checkEmergency_Easy.setPostBody("This is the post body. It needs to be at least 300 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 300 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 300 characters long. I hope this is enough characters."
                            + "This is the post body. It needs to be at least 300 characters long. I hope this is enough characters.");
        checkEmergency_Easy.setPostTags(tags);
        checkEmergency_Easy.setPostType(type);
        checkEmergency_Easy.setPostEmergency(sos);
        assertEquals(true, checkEmergency_Easy.addPost());


    }
    @Test
    /* Checking the requirements:
     * "Easy" post Type should NOT have "Immediately Needed" & "Highly Needed" status
     */
    void checkEasyEmergency(){
        String[] tags = {"tag1", "tag2"};
        String[] type = {"Easy"};
        String[] sos = {"Immediately Needed", "Highly Needed"};
        Post checkEmergency_Easy= new Post();
        checkEmergency_Easy.setPostId(8);
        checkEmergency_Easy.setPostTitle("Thetitle is long.");
        checkEmergency_Easy.setPostBody("This is the post body. It needs to be at least 300 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 300 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 300 characters long. I hope this is enough characters."
                            + "This is the post body. It needs to be at least 300 characters long. I hope this is enough characters.");
        checkEmergency_Easy.setPostTags(tags);
        checkEmergency_Easy.setPostType(type);
        checkEmergency_Easy.setPostEmergency(sos);
        assertEquals(false, checkEmergency_Easy.addPost());
    }
    @Test
    /* Checking the requirements:
     * "Very Difficult" & "Difficult" posts should not have "Ordinary" status
     */
    void CheckOtherEmergency(){
        String[] tags = {"tag1", "tag2"};
        String[] type = {"Difficult", "Very Difficult"};
        String[] sos = { "Ordinary"};
        Post checkEmergency_Other= new Post();
        checkEmergency_Other.setPostId(9);
        checkEmergency_Other.setPostTitle("Title is long");
        checkEmergency_Other.setPostBody("This is the post body. It needs to be at least 300 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 300 characters long. I hope this is enough characters."
                            + " This is the post body. It needs to be at least 300 characters long. I hope this is enough characters."
                            + "This is the post body. It needs to be at least 300 characters long. I hope this is enough characters."
                            + "This is the post body. It needs to be at least 300 characters long. I hope this is enough characters."
                            + "This is the post body. It needs to be at least 300 characters long. I hope this is enough characters."
                            + "This is the post body. It needs to be at least 300 characters long. I hope this is enough characters."
                            + "This is the post body. It needs to be at least 300 characters long. I hope this is enough characters."
                            );
        checkEmergency_Other.setPostTags(tags);
        checkEmergency_Other.setPostType(type);
        checkEmergency_Other.setPostEmergency(sos);

        assertEquals(false, checkEmergency_Other.addPost());
    }
}

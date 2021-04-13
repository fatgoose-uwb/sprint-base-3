package Problem3Test;

import Problem3.StoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

// DO NOT REMOVE OR CHANGE ANYTHING

public class StoryBuilderTest {
    @Test
    public void testStoryBuilding() {
        StoryBuilder storyBuilder = new StoryBuilder();

        String expect = "";
        for (int i = 0; i < 5; i++) {
            String newSentence = "sentence " + i + ".";
            if (i == 0) {    // first sentence
                expect = newSentence;
            } else {
                expect = expect + StoryBuilder.CONNECTOR + newSentence;
            }

            storyBuilder.buildWithYesAnd(newSentence);
            String actual = storyBuilder.toString();
            assertEquals(expect, actual, "case " + i);
        }
    }

    @Test
    public void testTrimmingSentence() {
        String sentence1 = "   hello world.  ";
        String sentence2 = "  that's it.  ";

        StoryBuilder storyBuilder = new StoryBuilder();
        storyBuilder.buildWithYesAnd(sentence1);
        storyBuilder.buildWithYesAnd(sentence2);

        // white spaces around a sentence need to be trimmed away
        String expect = sentence1.trim() + StoryBuilder.CONNECTOR + sentence2.trim();

        String actual = storyBuilder.toString();

        assertEquals(expect, actual);
    }

    @Test
    public void testStoryTelling() {
        StoryBuilder storyBuilder = new StoryBuilder();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        String sentence1 = "hello world.";
        String sentence2 = "that's it.";
        storyBuilder.buildWithYesAnd(sentence1);
        storyBuilder.buildWithYesAnd(sentence2);

        String expect = sentence1 + "\n" + StoryBuilder.CONNECTOR + sentence2;

        storyBuilder.tellStory(ps);

        String actual = baos.toString();

        assertEquals(expect, actual);
    }
}
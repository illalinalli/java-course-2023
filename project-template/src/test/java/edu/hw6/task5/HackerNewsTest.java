package edu.hw6.task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HackerNewsTest {
    @Test
    public void hackerNewsTopStoriesTest() {
        long[] topStories = HackerNews.hackerNewsTopStories();
        assertTrue(topStories.length > 0, "Top stories array should not be empty.");
    }

    @Test
    public void newsTest() {
        String title = HackerNews.news(8863);
        assertEquals("My YC app: Dropbox - Throw away your USB drive", title);
    }

    @Test
    public void newsNotFoundTest() {
        String title = HackerNews.news(999999999);
        assertEquals("", title);
    }
}

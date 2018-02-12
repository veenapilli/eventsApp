package com.example.vee.eventsapp;

import com.example.vee.eventsapp.utils.ServerSettings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void checkIf_ServerIsSet() throws Exception{
        //fails if prodSever is not set in Config.java
        assertEquals("Server is set", ServerSettings.getInstance().getServer(), "https://s3-ap-southeast-2.amazonaws.com/");
    }
}
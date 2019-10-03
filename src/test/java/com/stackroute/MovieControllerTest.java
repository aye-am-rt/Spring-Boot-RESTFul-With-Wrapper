package com.stackroute;

import com.stakroute.MovieControllerIT;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MovieControllerTest {
    private static MovieControllerIT movieControllerIT;
    @Before
    public void allocate() {
        movieControllerIT = new MovieControllerIT();
    }
    @After
    public void deallocate() {
        movieControllerIT= null;
    }

    @Test
    public void constructor_Initialization() {
        assertNotNull(movieControllerIT.getV());
        assertEquals("passed s-out test case",
                "Hii this is constructor of Movie ControllerIT setting the msg field",
                movieControllerIT.getMsg());
    }
}

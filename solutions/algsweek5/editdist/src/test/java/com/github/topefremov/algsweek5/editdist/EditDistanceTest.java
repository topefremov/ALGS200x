package com.github.topefremov.algsweek5.editdist;

import org.junit.Test;

import static org.junit.Assert.*;

public class EditDistanceTest {

    @Test
    public void editDistanceSample1() {
        assertEquals(0, EditDistance.editDistance("ab", "ab"));
    }

    @Test
    public void editDistanceSample2() {
        assertEquals(3, EditDistance.editDistance("short", "ports"));
    }

    @Test
    public void editDistanceSample3() {
        assertEquals(5, EditDistance.editDistance("editing", "distance"));
    }
}
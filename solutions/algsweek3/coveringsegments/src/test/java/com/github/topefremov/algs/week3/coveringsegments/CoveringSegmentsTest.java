package com.github.topefremov.algs.week3.coveringsegments;

import org.junit.Test;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.*;

import static com.github.topefremov.algs.week3.coveringsegments.CoveringSegments.*;

public class CoveringSegmentsTest {

    @Test
    public void getMinEndPointSegmentAndSwapTest() {
        Segment s1 = new Segment(4, 7);
        Segment s2 = new Segment(1, 3);
        Segment s3 = new Segment(2, 5);
        Segment s4 = new Segment(5, 6);
        Segment[] segments = new Segment[] {s1,s2,s3,s4};
        Segment[] expectedSegments = new Segment[] {s2,s1,s3,s4};
        Segment minEndPointSegment = getMinEndPointSegmentAndSwap(segments, 0,0);
        assertEquals(s2, minEndPointSegment);
        assertArrayEquals(expectedSegments, segments);
    }

    @Test
    public void optimalPointsTest1() {
        Segment segment1 = new Segment(1, 3);
        Segment segment2 = new Segment(2, 5);
        Segment segment3 = new Segment(3, 6);
        int[] expectedPoints = new int[] {3};
        int[] optimalPoints = optimalPoints(new Segment[] {segment1, segment2, segment3});
        assertEquals(optimalPoints.length, 1);
        assertArrayEquals(expectedPoints, optimalPoints);
    }

    @Test
    public void optimalPointsTest2() {
        Segment segment1 = new Segment(4, 7);
        Segment segment2 = new Segment(1, 3);
        Segment segment3 = new Segment(2, 5);
        Segment segment4 = new Segment(5, 6);
        int[] expectedPoints = new int[] {3, 6};
        int[] optimalPoints = optimalPoints(new Segment[] {segment1, segment2, segment3, segment4});
        assertEquals(2, optimalPoints.length);
        assertArrayEquals(expectedPoints, optimalPoints);
    }
    @Test
    public void optimalPointsTest3() {
        Segment segment1 = new Segment(11, 25);
        Segment segment2 = new Segment(1, 12);
        Segment segment3 = new Segment(3, 4);
        Segment segment4 = new Segment(8, 10);
        int[] expectedPoints = new int[] {4, 10, 25};
        int[] optimalPoints = optimalPoints(new Segment[] {segment1, segment2, segment3, segment4});
        assertEquals(optimalPoints.length, 3);
        assertArrayEquals(expectedPoints, optimalPoints);
    }

    @Test
    public void optimalPointsTest4() {
        Segment segment1 = new Segment(0, 6);
        Segment segment2 = new Segment(3, 3);
        Segment segment3 = new Segment(8, 16);
        Segment segment4 = new Segment(4, 9);
        int[] expectedPoints = new int[] {3, 9};
        int[] optimalPoints = optimalPoints(new Segment[] {segment1, segment2, segment3, segment4});
        assertEquals(2, optimalPoints.length);
        assertArrayEquals(expectedPoints, optimalPoints);
    }

    @Test
    public void optimalPointsTest5() {
        Segment segment1 = new Segment(4, 13);
        Segment segment2 = new Segment(5, 10);
        Segment segment3 = new Segment(7, 11);
        int[] expectedPoints = new int[] {10};
        int[] optimalPoints = optimalPoints(new Segment[] {segment1, segment2, segment3});
        assertEquals(1, optimalPoints.length);
        assertArrayEquals(expectedPoints, optimalPoints);
    }
}

package com.github.topefremov.algs.week3.coveringsegments;

import java.util.*;

public class CoveringSegments {

    static Segment getMinEndPointSegmentAndSwap(Segment[] segments, int startWithIndex, int swapIndex) {
        int minEndPointSegmentIndx = startWithIndex;
        for (int i = startWithIndex; i < segments.length; i++ )
            if (segments[i].end < segments[minEndPointSegmentIndx].end)
                minEndPointSegmentIndx = i;
        Segment minEndPointSegment = segments[minEndPointSegmentIndx];
        segments[minEndPointSegmentIndx] = segments[swapIndex];
        segments[swapIndex] = minEndPointSegment;
        return minEndPointSegment;
    }

    private static int[] convertArrayInt(Collection<Integer> coll) {
        Iterator<Integer> iterator = coll.iterator();
        int[] arr = new int[coll.size()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = iterator.next();
        return arr;
    }

    static int[] optimalPoints(Segment[] segments) {
        Segment[] segmentsCopy = segments.clone();
        Segment minEndPointSegment = getMinEndPointSegmentAndSwap(segmentsCopy,0,0);
        List<Integer> points = new ArrayList<>();
        int currentPoint = minEndPointSegment.end;
        for(int i = 1; i < segments.length; i++) {
            Segment candidate = getMinEndPointSegmentAndSwap(segmentsCopy, i, i);
            if (candidate.start > currentPoint) {
                points.add(currentPoint);
                currentPoint = candidate.end;
            }
        }
        points.add(currentPoint);
        return convertArrayInt(points);
    }

    public static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getSegmentLength() {
            return Math.abs(end - start);
        }

        @Override
        public String toString() {
            return "Segment{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
//        printRandomDataset();
    }

    private static void printRandomDataset() {
        Random r = new Random();
        int n = r.nextInt(10);
        int maxValue = 10;
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start = r.nextInt(maxValue);
            int end = r.nextInt(maxValue) + start;
            segments[i] = new Segment(start, end);
        }

        for (Segment segment : segments)
            System.out.println(segment);
    }
}
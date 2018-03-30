package com.github.topefremov.algs.week3.coveringsegments;

import java.util.*;

public class CoveringSegments {

    static int[] optimalPoints(Segment[] segments) {
        Set<Segment> segmentsSet = new HashSet<>(Arrays.asList(segments));
        return null;
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Segment segment = (Segment) o;
            return start == segment.start &&
                    end == segment.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
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
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        Segment[] segments = new Segment[n];
//        for (int i = 0; i < n; i++) {
//            int start, end;
//            start = scanner.nextInt();
//            end = scanner.nextInt();
//            segments[i] = new Segment(start, end);
//        }
//        int[] points = optimalPoints(segments);
//        System.out.println(points.length);
//        for (int point : points) {
//            System.out.print(point + " ");
//        }
        printRandomDataset();
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
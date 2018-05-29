package com.github.topefremov.algsweek4.lottery;

import java.util.*;

public class PointsAndSegments {

    static List<Point> createListOfPoints(int[] starts, int[] ends, int[] points) {
        List<Point> pointsList = new ArrayList<>(starts.length + ends.length + points.length);
        Arrays.stream(starts)
                .mapToObj(start -> Point.newPointWithSign(start, Point.LEFT))
                .forEach(pointsList::add);
        Arrays.stream(ends)
                .mapToObj(end -> Point.newPointWithSign(end, Point.RIGHT))
                .forEach(pointsList::add);
        for (int i = 0; i < points.length; i++) {
            pointsList.add(Point.newPointWithIndex(points[i], i));
        }
        return pointsList;
    }

    static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        List<Point> pointsList = createListOfPoints(starts, ends, points);
        Collections.sort(pointsList);

        int countOfSeg = 0;
        int pointIndex = 0;
        for (Point point : pointsList) {
            if (point.getSign() == Point.LEFT) {
                countOfSeg++;
            } else if (point.getSign() == Point.POINT) {
                cnt[point.getIndex()] = countOfSeg;
            } else if (point.getSign() == Point.RIGHT) {
                countOfSeg--;
            }
        }
        return cnt;
    }

    static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
//        for (int x : cnt) {
//            System.out.print(x + " ");
//        }
        System.out.println(Arrays.stream(cnt).summaryStatistics().getSum());

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.printf("Memory used: " + usedMemoryAfter);
    }
}

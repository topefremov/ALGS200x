package com.github.topefremov.algsweek4.lottery;

class Point implements Comparable<Point> {

    public static final int LEFT = -1;
    public static final int POINT = 0;
    public static final int RIGHT = 1;

    private final int value;
    private final int sign;
    private final int index;

    private Point(int value, int sign, int index) {
        this.value = value;
        this.sign = sign;
        this.index = index;
    }

    public static Point newPointWithSign(int value, int sign) {
        if (sign != LEFT && sign != RIGHT) {
            throw new IllegalArgumentException("sign must be either -1 or 1");
        }
        return new Point(value, sign, -1);
    }

    public static Point newPointWithIndex(int value, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index must be greater or equal to zero");
        }
        return new Point(value, POINT, index);
    }

    public int getValue() {
        return value;
    }

    public int getSign() {
        return sign;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Point o) {
        int result = Integer.compare(value, o.getValue());
        if (result == 0) {
            result = Integer.compare(sign, o.getSign());
        }
        return result;
    }
}

package com.company.Shape;

import com.company.Main;
import java.util.Objects;

/**
 * Представление о треугольнике.
 * <p>
 * Треуго́льник (в евклидовом пространстве) — геометрическая
 * фигура, образованная тремя отрезками, которые соединяют
 * три точки, не лежащие на одной прямой. Указанные три
 * точки называются вершинами треугольника, а отрезки —
 * сторонами треугольника. Часть плоскости, ограниченная
 * сторонами, называется внутренностью треугольника: нередко
 * треугольник рассматривается вместе со своей внутренностью
 * (например, для определения понятия площади).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%A2%D1%80%D0%B5%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Треугольник</a>
 */
public class Triangle implements Polygon {

    float perimeter = -1;
    float area = -1;

    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;
    private final int rotation;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this(firstPoint, secondPoint, thirdPoint, 0);
    }

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint, int rotation) {
        if (isCorrectParams(firstPoint, secondPoint, thirdPoint, rotation)) {
            this.firstPoint = firstPoint;
            this.secondPoint = secondPoint;
            this.thirdPoint = thirdPoint;
            this.rotation = rotation;
        } else {
            throw new IllegalArgumentException("incorrect points for triangle");
        }
    }

    @Override
    public float getPerimeter() {
        if (perimeter == -1) {
            perimeter = (float) (getSideLength(firstPoint, secondPoint)
                    + getSideLength(secondPoint, thirdPoint) + getSideLength(thirdPoint, firstPoint)) ;
        }
        return perimeter;
    }

    @Override
    public float getArea() {
        if (area == -1) {
            final float halfPerimeter = getPerimeter() / 2;
            area = (float) Math.sqrt(halfPerimeter
                    * (halfPerimeter - getSideLength(firstPoint, secondPoint))
                    * (halfPerimeter - getSideLength(secondPoint, thirdPoint))
                    * (halfPerimeter - getSideLength(thirdPoint, firstPoint)));
        }
        return area;
    }

    @Override
    public int getRotation() {
        return rotation;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    private boolean isCorrectParams(Point firstPoint, Point secondPoint, Point thirdPoint, int rotation) {
        return rotation >= 0 && rotation <= 360
                && !(firstPoint.equals(secondPoint) || firstPoint.equals(thirdPoint) || secondPoint.equals(thirdPoint));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Math.abs(perimeter - triangle.perimeter) < Main.EPSILON &&
                Math.abs(area - triangle.area) < Main.EPSILON &&
                rotation == triangle.rotation &&
                firstPoint.equals(triangle.firstPoint) &&
                secondPoint.equals(triangle.secondPoint) &&
                thirdPoint.equals(triangle.thirdPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(perimeter, area, firstPoint, secondPoint, thirdPoint, rotation);
    }

    @Override
    public String toString() {
        return "Triangle : " +
                "\nperimeter = " + getPerimeter() +
                "\narea = " + getArea() +
                "\nfirstPoint = " + firstPoint +
                "\nsecondPoint = " + secondPoint +
                "\nthirdPoint = " + thirdPoint +
                "\nrotation = " + rotation;
    }

    /*
     * TODO: Реализовать класс 'Triangle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
}

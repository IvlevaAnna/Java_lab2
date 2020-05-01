package com.company.Shape;

import com.company.Main;
import java.util.Objects;

/**
 * Представление об окружности.
 * <p>
 * Окру́жность — замкнутая плоская кривая, которая состоит из
 * всех точек на плоскости, равноудалённых от заданной точки.
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9E%D0%BA%D1%80%D1%83%D0%B6%D0%BD%D0%BE%D1%81%D1%82%D1%8C">Окружность</a>
 */
public class Circle implements Ellipse {

    private float length = -1;
    private float area = -1;

    private final Point centre;
    private final float radius;

    public Circle(Point centre, float radius) {
        if (radius > 0) {
            this.centre = centre;
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("incorrect points for circle");
        }
    }

    @Override
    public float getLength() {
        if (length == -1) {
            length = (float) (2 * Math.PI * radius);
        }
        return length;
    }

    @Override
    public float getArea() {
        if (area == -1) {
            area = (float) (Math.PI * Math.pow(radius, 2));
        }
        return area;
    }

    public Point getCentre() {
        return centre;
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Math.abs(area - circle.area) < Main.EPSILON &&
                Math.abs(length - circle.length) < Main.EPSILON &&
                Math.abs(radius - circle.radius) < Main.EPSILON &&
                centre.equals(circle.centre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, area, centre, radius);
    }

    @Override
    public String toString() {
        return "Circle : " +
                "\ncentre = " + centre +
                "\nradius = " + radius +
                "\narea = " + getArea() +
                "\nlength = " + getLength();
    }

    /*
     * TODO: Реализовать класс 'Circle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
}

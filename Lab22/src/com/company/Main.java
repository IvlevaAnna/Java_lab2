package com.company;

import com.company.Shape.Circle;
import com.company.Shape.PointImpl;
import com.company.Shape.Rectangle;
import com.company.Shape.Shape;
import com.company.Shape.Triangle;

public class Main {

    public static final float EPSILON = 0.000001f;

    public static void main(String[] args) {
        try {
            Shape[] shapes = {
                    new Rectangle(
                            new PointImpl(0, 5),
                            new PointImpl(5, 0),
                            new PointImpl(0, -5),
                            new PointImpl(-5, 0)
                    ),
                    new Circle(
                            new PointImpl(0, 4.3f),
                            4.2345f
                    ),
                    new Triangle(
                            new PointImpl(3.2341f, 7),
                            new PointImpl(213.3456f, 0),
                            new PointImpl(-23412.3f, 234),
                            23
                    ),
                    new Rectangle(
                            new PointImpl(500, -123),
                            new PointImpl(1345, -123),
                            new PointImpl(1345, -500.234f),
                            new PointImpl(500, -500.234f)
                    ),
                    new Triangle(
                            new PointImpl(1343.441f, 237),
                            new PointImpl(13, 534),
                            new PointImpl(-1345, 325.23334f)
                    ),
                    new Rectangle(
                            new PointImpl(123, 423.3f),
                            new PointImpl(3456, 423.3f),
                            new PointImpl(3456, -123.234f),
                            new PointImpl(123, -123.234f),
                            345
                    ),
                    new Circle(
                            new PointImpl(-123, -45.543f),
                            4.2345f
                    ),
                    new Rectangle(
                            new PointImpl(-123.321f, -123),
                            new PointImpl(123.321f, -123),
                            new PointImpl(123.321f, -999.9f),
                            new PointImpl(-123.321f, -999.9f)
                    ),
                    new Triangle(
                            new PointImpl(-111.23421f, -23.7f),
                            new PointImpl(126, 654),
                            new PointImpl(-125, 325.23334f),
                            123
                    ),
                    new Triangle(
                            new PointImpl(-343.23441f, 7),
                            new PointImpl(2313, 5),
                            new PointImpl(-12345, 2345.234f),
                            123
                    ),
            };

            //getTriangle(shapes);
            System.out.println("shape with max area - " + getShapeByMaxArea(shapes).toString());
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }



        /*
         * TODO: Выполнить действия над массивом 'shapes'
         *
         * 1. Проинициализировать переменную 'shapes' массивом
         *    содержащим 10 произвольных фигур. Массив должен
         *    содержать экземпляры классов Circle, Rectangle
         *    и Triangle.
         *
         * 2. Найти в массиве 'shapes' фигуру с максимальной
         *    площадью. Для поиска фигуры необходимо создать
         *    статический метод в текущем классе (Main).
         */
    }

    private static Shape getShapeByMaxArea(Shape[] shapes) {
        if (shapes == null || shapes.length <= 0) return null;
        float maxArea = -1;
        Shape shapeWithMaxArea = null;
        for (Shape shape : shapes) {
            final float area = shape.getArea();
            if (area > maxArea) {
                maxArea = area;
                shapeWithMaxArea = shape;
            }
        }
        return shapeWithMaxArea;
    }
//    public static void  getTriangle(Shape[] shapes) {
//        for (Shape shape : shapes) {
//            if (shape instanceof Triangle)
//                System.out.println(shape.toString());
//        }
//    }
}


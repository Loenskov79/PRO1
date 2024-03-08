package Task5;

public class Rectangle {

    private double width = 1;
    private double height = 1;

    Rectangle() {

    }

    Rectangle(double newWidth, double newHeight) {
        width = newWidth;
        height = newHeight;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }

    public void printRectangle() {
        System.out.println("The width of the rectangle is: " + width);
        System.out.println("The height of the rectangle is " + height);
        System.out.println("The area of the rectangle is " + getArea());
        System.out.println("The perimeter of the rectangle is " + getPerimeter());
    }

    public String toString() {
        return getArea()+"";
    }
}

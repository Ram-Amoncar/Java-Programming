
public class Rectangle {

    private final int length = 8;
    private final int width = 4;
    private int area;
    private int perimeter;

    public void areaOfRect() {
        area = length * width;
    }

    public void perimeterOfRect() {
        perimeter = (length + width) * 2;
    }

    public void printArea() {
        System.out.println("The area of Rectangle is " + area);
    }

    public void printPerimeter() {
        System.out.println("The primeter of Rectangle is " + perimeter);
    }
}

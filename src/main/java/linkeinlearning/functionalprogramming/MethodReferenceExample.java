package linkeinlearning.functionalprogramming;

public class MethodReferenceExample {

	public static void main(String[] args) {
		Square s = new Square(4);

//		Shapes shapes = (Square square) -> {
//			return square.calculateArea();
//		};
		
		Shapes shapes = Square::calculateArea;		

		System.out.println("Area: " + shapes.getArea(s));
	}
}

@FunctionalInterface
interface Shapes {
	public abstract int getArea(Square s);
}

class Square {
	int sideLength;

	public Square(int sideLength) {
		this.sideLength = sideLength;
	}

	public int calculateArea() {
		return sideLength * sideLength;
	}
}
package db;

public class StupidJTableviewTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new JTableview("SELECT * FROM Customer");
			System.out.println("OK!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}

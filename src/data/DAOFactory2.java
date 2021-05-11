package data;

public class DAOFactory2 {

	public static TestDAO getTestDAO() {
		//TestDAO tDAO2 = new TestDAOText();
		TestDAO tDAO2 = new TestDAOBinary1();
		//TestDAO tDAO = new TestDAORandomAccess();
		//return tDAO;
		return tDAO2;
	}
}

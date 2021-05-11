package data;

public class DAOFactory {

	public static TestDAO getTestDAO() {
		//TestDAO tDAO = new TestDAOText();
		//TestDAO tDAO = new TestDAOBinary();
		TestDAO tDAO = new TestDAORandomAccess();
		//TestDAO tDAO = new TestDaoText1();
		//return tDAO;
		return tDAO;
	//	return tDAO1;
	}
}

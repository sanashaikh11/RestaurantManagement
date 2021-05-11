package data;

public class DAOFactory1 {

	public static TestDAO getTestDAO() {
		//TestDAO tDAO1 = new TestDaoText1();
		TestDAO tDAO1 = new TestDAOBinary();
		
		return tDAO1;
	}
}
package data;

public interface TestConstants {
	String FILENAME_TEXT = "review.txt";
	String FILENAME_TEXT1 = "resevation.txt";
	String FILENAME_BIN_FIXED="payroll.dat";
	String FILENAME_BIN = "review.data";
	String FILENAME_BIN2 = "resevation.data";
	String FIELD_SEP = "\t";
	
	int TEST_NAME_SIZE = 25;
	int MARKS_OBTAINED_SIZE = 8;
	int TOTAL_MARKS_SIZE = 8;
	int RECORD_SIZE = TEST_NAME_SIZE * 2 + MARKS_OBTAINED_SIZE + TOTAL_MARKS_SIZE;
}

package presentation;


	import javax.swing.JOptionPane;
	import javax.swing.text.JTextComponent;

	public class Validator {
		public static boolean isPresent(JTextComponent C, String title) {
			if(C.getText().length() == 0) {
				showMessage(C, title + " is a required field. \n Please Re-Enter");
				C.requestFocusInWindow();
				return false;
			}
			return true;
		}
		
		public static boolean isInteger(JTextComponent C, String title) {
			try {
				int i = Integer.parseInt(C.getText());
				return true;
			}
			catch (NumberFormatException e) {
				// TODO: handle exception
				showMessage(C, title + " must be a integer. \n Please Re-Enter");
				C.requestFocusInWindow();
				return false;
			}
		}
		public static boolean isDouble(JTextComponent C, String title) {
			try {
				double d = Double.parseDouble(C.getText());
				return true;
			}
			catch (NumberFormatException e) {
				// TODO: handle exception
				showMessage(C, title + " must be double value. \n Please Re-Enter");
				C.requestFocusInWindow();
				return false;
			}
		}

		private static void showMessage(JTextComponent c, String message) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(c, message, "Invalid Entry", JOptionPane.ERROR_MESSAGE);
		}
	}



 package business;

public class CProgram {
	private String pName,pPos;
	private int pPhn,pID;
	
	public int getpID() {
		return pID;
	}
	public void setpID(int pID) {
		this.pID=pID;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName=pName;
	}
	public String getpPos() {
		return pPos;
	}
	public void setpPos(String pPos) {
		this.pPos=pPos;
	}
	public int getpPhn() {
		return pPhn;
	}
	public void setpPhn(int pPhn) {
		this.pPhn=pPhn;
	}
	
	public CProgram() {}
	public CProgram(int pID, String pName,int pPhn, String pPos) {
		this.pID=pID;
		this.pName=pName;
		
		this.pPhn=pPhn;
		this.pPos=pPos;
	}
}
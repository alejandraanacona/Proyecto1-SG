package interfaz;

public class Persona {
	
	private String noRef;
	private String docId;
	private String name;
	private String date;
	private String descrip;
	private String amount;
	
	
	
	public Persona(String noRef, String docId, String name, String date, String descrip, String amount) {
		super();
		this.noRef = noRef;
		this.docId = docId;
		this.name = name;
		this.date = date;
		this.descrip = descrip;
		this.amount = amount;
	}
	public String getNoRef() {
		return noRef;
	}
	public void setNoRef(String noRef) {
		this.noRef = noRef;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}

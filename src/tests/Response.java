package tests;

import java.util.List;

public class Response {
	
	private List<String> ids;
	private float values;
	public Response(List<String> ids, float values) {
		this.ids = ids;
		this.values = values;
	}
	public List<String> getIds() {
		return ids;
	}
	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	public float getValues() {
		return values;
	}
	public void setValues(float values) {
		this.values = values;
	}
	@Override
	public String toString() {
		return "Response [ Los mejores productos que puedes adquirir son: " + ids + ", cuyo valor total es : " + values + "]";
	}
	
	
	
	

}

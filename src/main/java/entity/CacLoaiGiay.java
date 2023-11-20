package entity;

public class CacLoaiGiay {
	private String maloaigiayString;
	private String tenloaigiayString;
	private int tinhtrang;
	
	
	public CacLoaiGiay() {
		// TODO Auto-generated constructor stub
	}


	public CacLoaiGiay(String maloaigiayString, String tenloaigiayString, int tinhtrang) {
		super();
		this.maloaigiayString = maloaigiayString;
		this.tenloaigiayString = tenloaigiayString;
		this.tinhtrang = tinhtrang;
	}


	public String getMaloaigiayString() {
		return maloaigiayString;
	}


	public void setMaloaigiayString(String maloaigiayString) {
		this.maloaigiayString = maloaigiayString;
	}


	public String getTenloaigiayString() {
		return tenloaigiayString;
	}


	public void setTenloaigiayString(String tenloaigiayString) {
		this.tenloaigiayString = tenloaigiayString;
	}


	public int getTinhtrang() {
		return tinhtrang;
	}


	public void setTinhtrang(int tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	

}

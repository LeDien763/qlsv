package entity;

public class YeuCauXacNhan {

	private CacLoaiGiay cacLoaiGiay;
	private Giayxacnhan giayxacnhan;
	public YeuCauXacNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public YeuCauXacNhan(CacLoaiGiay cacLoaiGiay, Giayxacnhan giayxacnhan) {
		super();
		this.cacLoaiGiay = cacLoaiGiay;
		this.giayxacnhan = giayxacnhan;
	}
	public CacLoaiGiay getCacLoaiGiay() {
		return cacLoaiGiay;
	}
	public void setCacLoaiGiay(CacLoaiGiay cacLoaiGiay) {
		this.cacLoaiGiay = cacLoaiGiay;
	}
	public Giayxacnhan getGiayxacnhan() {
		return giayxacnhan;
	}
	public void setGiayxacnhan(Giayxacnhan giayxacnhan) {
		this.giayxacnhan = giayxacnhan;
	}
	
}

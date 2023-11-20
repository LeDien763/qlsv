package entity;

import java.time.LocalDate;

public class Giayxacnhan {
	private int id;
	private int MaSV;	
	private String NamHoc;
	private String HocKy;
	private LocalDate ThoiGianXin;
	private LocalDate ThoiGianNhan;
	private String LyDo;
	private int TrangThai;
	private String MaLoaiGiay;
	private int MaCV;
	private LocalDate ThoiGianDuyet;
	private int SL;
	
	public Giayxacnhan() {
		// TODO Auto-generated constructor stub
	}

	public Giayxacnhan(int id, int maSV, String namHoc, String hocKy, LocalDate thoiGianXin, LocalDate thoiGianNhan,
			String lyDo, int trangThai, String maLoaiGiay, int maCV, LocalDate thoiGianDuyet, int sL) {
		super();
		this.id = id;
		MaSV = maSV;
		NamHoc = namHoc;
		HocKy = hocKy;
		ThoiGianXin = thoiGianXin;
		ThoiGianNhan = thoiGianNhan;
		LyDo = lyDo;
		TrangThai = trangThai;
		MaLoaiGiay = maLoaiGiay;
		MaCV = maCV;
		ThoiGianDuyet = thoiGianDuyet;
		SL = sL;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaSV() {
		return MaSV;
	}

	public void setMaSV(int maSV) {
		MaSV = maSV;
	}

	public String getNamHoc() {
		return NamHoc;
	}

	public void setNamHoc(String namHoc) {
		NamHoc = namHoc;
	}

	public String getHocKy() {
		return HocKy;
	}

	public void setHocKy(String hocKy) {
		HocKy = hocKy;
	}

	public LocalDate getThoiGianXin() {
		return ThoiGianXin;
	}

	public void setThoiGianXin(LocalDate thoiGianXin) {
		ThoiGianXin = thoiGianXin;
	}

	public LocalDate getThoiGianNhan() {
		return ThoiGianNhan;
	}

	public void setThoiGianNhan(LocalDate thoiGianNhan) {
		ThoiGianNhan = thoiGianNhan;
	}

	public String getLyDo() {
		return LyDo;
	}

	public void setLyDo(String lyDo) {
		LyDo = lyDo;
	}

	public int getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(int trangThai) {
		TrangThai = trangThai;
	}

	public String getMaLoaiGiay() {
		return MaLoaiGiay;
	}

	public void setMaLoaiGiay(String maLoaiGiay) {
		MaLoaiGiay = maLoaiGiay;
	}

	public int getMaCV() {
		return MaCV;
	}

	public void setMaCV(int maCV) {
		MaCV = maCV;
	}

	public LocalDate getThoiGianDuyet() {
		return ThoiGianDuyet;
	}

	public void setThoiGianDuyet(LocalDate thoiGianDuyet) {
		ThoiGianDuyet = thoiGianDuyet;
	}

	public int getSL() {
		return SL;
	}

	public void setSL(int sL) {
		SL = sL;
	}
	
	
	


}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import entity.TaiKhoan;
import entity.YeuCauXacNhan;
import entity.CacLoaiGiay;
import entity.Giayxacnhan;
import entity.PhongCTSV;

import untils.JDBCUtils;

public class dao {
	private static final String SELECT_LOGIN = "SELECT * FROM TaiKhoan WHERE Username = ? AND Password = ? AND Role = ?;";

	private static final String SELECT_ALL_REQUESTS = "SELECT gx.id, clg.TenGiayXN AS TenGiay, gx.MaSV AS NguoiGui, gx.ThoiGianXin, gx.LyDo, gx.TrangThai, gx.SL\r\n"
			+ "FROM giayxacnhan gx\r\n"
			+ "JOIN cacloaigiay clg ON gx.MaLoaiGiay = clg.MaLoaiGiay;";

	private static final String SELECT_IDCTSV = "SELECT * FROM phongctsv WHERE MaCV = ?;";

	private static final String SELECT_ALLSV = "SELECT * FROM phongctsv;";

	private static final String UPDATE_GIAYXN = "UPDATE giayxacnhan\r\n"
			+ "SET MaCV = ? , TrangThai = ?, ThoiGianDuyet = CURRENT_TIMESTAMP\r\n" + "WHERE id = ?;";


		public void updateAllGiayXN(String maCV, int newTrangThai) throws SQLException {
		    try (Connection connection = JDBCUtils.getConnection();
		         Statement statement = connection.createStatement()) {

		        // Disable safe updates
		        statement.executeUpdate("SET SQL_SAFE_UPDATES = 0");

		        // Update giayxacnhan
		        String updateQuery = "UPDATE giayxacnhan " +
		                "SET MaCV = '" + maCV + "', TrangThai = " + newTrangThai + ", ThoiGianDuyet  = CURRENT_TIMESTAMP " +
		                "WHERE TrangThai = 1";
		        statement.executeUpdate(updateQuery);

		        // Enable safe updates
		        statement.executeUpdate("SET SQL_SAFE_UPDATES = 1");
		    }
		}
	public void UpdateGiayXN(String MaCV, int trangthai, String id) {
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_GIAYXN)) {
			preparedStatement.setString(1, MaCV);
			preparedStatement.setInt(2, trangthai);
			preparedStatement.setString(3, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<PhongCTSV> getAllCV() {
		List<PhongCTSV> CVList = new ArrayList<>();
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALLSV);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				String MaCV = resultSet.getString(1);
				String TenCV = resultSet.getString(2);
				String Email = resultSet.getString(3);
				String Sdt = resultSet.getString(4);
				String Diachi = resultSet.getString(5);
				LocalDate NgayBDLam = resultSet.getDate(6).toLocalDate();
				int TinhTrang = resultSet.getInt(7);

				CVList.add(new PhongCTSV(MaCV, TenCV, Email, Sdt, Diachi, NgayBDLam, TinhTrang));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return CVList;
	}

	// seach ID PhongCTCV
	public PhongCTSV getPhongCTCV(String id) {
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_IDCTSV)) {

			preparedStatement.setString(1, id);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					String MaCV = resultSet.getString(1);
					String TenCV = resultSet.getString(2);
					String Email = resultSet.getString(3);
					String Sdt = resultSet.getString(4);
					String Diachi = resultSet.getString(5);
					LocalDate NgayBDLam = resultSet.getDate(6).toLocalDate();
					int TinhTrang = resultSet.getInt(7);

					return new PhongCTSV(MaCV, TenCV, Email, Sdt, Diachi, NgayBDLam, TinhTrang);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	// select requests
	public List<YeuCauXacNhan> selectAllRequests() {
		List<YeuCauXacNhan> requests = new ArrayList<>();

		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REQUESTS)) {

			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String tenGiay = rs.getString(2);
				int nguoiGuii = rs.getInt(3);
				LocalDate thoiGianXin = rs.getDate(4).toLocalDate();
				
				String lyDo = rs.getString(5);
				int trangThai = rs.getInt(6);
				int soluong = rs.getInt(7);

				CacLoaiGiay cacLoaiGiay = new CacLoaiGiay();
				cacLoaiGiay.setTenloaigiayString(tenGiay);

				Giayxacnhan giayxacnhann = new Giayxacnhan();
				giayxacnhann.setId(id);
				giayxacnhann.setMaSV(nguoiGuii); // Set maSV instead of maCV
				giayxacnhann.setThoiGianXin(thoiGianXin);
				giayxacnhann.setLyDo(lyDo);
				giayxacnhann.setTrangThai(trangThai);
				giayxacnhann.setSL(soluong);

				requests.add(new YeuCauXacNhan(cacLoaiGiay, giayxacnhann));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return requests;
	}

	// Login
	public TaiKhoan login(String userString, String passString, String roleString) {
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOGIN)) {

			preparedStatement.setString(1, userString);
			preparedStatement.setString(2, passString);
			preparedStatement.setString(3, roleString);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					String user = resultSet.getString("Username");
					String pass = resultSet.getString("Password");
					String role = resultSet.getString("Role");
					int tinhTrang = resultSet.getInt("TinhTrang");

					// Now you have all the data, including TinhTrang
					return new TaiKhoan(user, pass, role, tinhTrang);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

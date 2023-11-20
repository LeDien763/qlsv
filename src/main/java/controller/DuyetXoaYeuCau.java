package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao;
import entity.TaiKhoan;

@WebServlet("/")
public class DuyetXoaYeuCau extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DuyetXoaYeuCau() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		try {
			switch (action) {
			case "/Duyet":
				updateDuyet(request, response);
				break;
			case "/TuChoi":
				xoaDuyet(request, response);
				break;
			case "/DuyetAll":
				UpdateAllDuyet(request, response);
				break;

			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void UpdateAllDuyet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		HttpSession session = request.getSession();
		TaiKhoan account = (TaiKhoan) session.getAttribute("acc");

		dao dao = new dao();
		dao.updateAllGiayXN(account.getUsernameString(), 2);  /// So 2 la duyet, 1 la xoa, mac dinh hien thi la 1
		response.sendRedirect("DuyetYeuCauSV");
	}

	private void xoaDuyet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		HttpSession session = request.getSession();
		String productId = request.getParameter("productId");
		TaiKhoan account = (TaiKhoan) session.getAttribute("acc");

		System.out.println(productId);
		System.out.println(account.getUsernameString());
		dao dao = new dao();
		dao.UpdateGiayXN(account.getUsernameString(), 0, productId);
		response.sendRedirect("DuyetYeuCauSV");
	}

	private void updateDuyet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		HttpSession session = request.getSession();
		String productId = request.getParameter("productId");
		TaiKhoan account = (TaiKhoan) session.getAttribute("acc");
		System.out.println(productId);
		System.out.println(account.getUsernameString());

		dao dao = new dao();
		dao.UpdateGiayXN(account.getUsernameString(), 2, productId);
		response.sendRedirect("DuyetYeuCauSV");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

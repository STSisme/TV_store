package tv_store.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import tv_store.DAO.ProductDAO;
import tv_store.model.Product;
import tv_store.utils.FileUploadUtil;

/**
 * Servlet implementation class AddProduct
 */
@MultipartConfig
@WebServlet(asyncSupported = true, urlPatterns = { "/AddProduct" })
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pageTitle", "Add Product");
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/addProduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name = request.getParameter("name");
		
		Part filePart = request.getPart("image");
		String fileName = filePart.getSubmittedFileName();
		
		float price = Float.parseFloat(request.getParameter("price"));
		String description = request.getParameter("description");

		InputStream fileContent = filePart.getInputStream();
		ServletContext servletContext = getServletContext();
		String imageFileName = FileUploadUtil.saveFile(fileContent, fileName, servletContext);
		

		Product product = new Product(name, imageFileName, price, description);

		ProductDAO.addProduct(product);

		response.sendRedirect("products");
	}

}

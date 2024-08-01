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
 * Servlet implementation class EditProduct
 */
@MultipartConfig
@WebServlet(asyncSupported = true, urlPatterns = { "/edit" })
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = ProductDAO.getProductById(id);
		request.setAttribute("pageTitle", "Edit Product");
		request.setAttribute("product", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/editProduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Part filePart = request.getPart("image");
		String fileName = filePart.getSubmittedFileName();
		float price = Float.parseFloat(request.getParameter("price"));
		String description = request.getParameter("description");
		
		ServletContext servletContext = getServletContext();

		String imageFileName;
		if (fileName.isEmpty()) {
			Product existingProduct = ProductDAO.getProductById(id);
			imageFileName = existingProduct.getImage();
		} else {
			InputStream fileContent = filePart.getInputStream();
			imageFileName = FileUploadUtil.saveFile(fileContent, fileName, servletContext);
		}

		Product product = new Product(id, name, imageFileName, price, description);

		ProductDAO.updateProduct(product);

		response.sendRedirect("products");
	}

}

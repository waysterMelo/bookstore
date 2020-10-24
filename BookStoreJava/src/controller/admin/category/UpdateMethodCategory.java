package controller.admin.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CategoryService;


@WebServlet("/admin/update_category")
public class UpdateMethodCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateMethodCategory() {
        super();
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryService categoryService = new CategoryService(request, response);
		categoryService.update();
	}

}

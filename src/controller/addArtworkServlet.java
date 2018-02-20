package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artwork;

/**
 * Servlet implementation class addArtworkServlet
 */
@WebServlet("/addArtworkServlet")
public class addArtworkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addArtworkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String artist = request.getParameter("artist");
		String media = request.getParameter("media");
		String year = request.getParameter("year");
		String value = request.getParameter("value");
		
		double valueDbl = Double.valueOf(value);
		
		Artwork toAdd = new Artwork(title, artist, media, year, valueDbl);
		ArtworkHelper dao = new ArtworkHelper();
		dao.insertArtwork(toAdd);
		
		getServletContext().getRequestDispatcher("/addArtwork.html").forward(request, response);
	}

}

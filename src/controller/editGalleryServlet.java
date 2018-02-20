package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artwork;

/**
 * Servlet implementation class editGalleryServlet
 */
@WebServlet("/editGalleryServlet")
public class editGalleryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editGalleryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArtworkHelper dao = new ArtworkHelper();
		String act = request.getParameter("doThisToItem");
		
		if(act == null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/viewAllGalleryServlet").forward(request, response);
		} else if (act.equals("Delete Selected Artwork")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Artwork artworkToDelete = dao.searchForArtworkById(tempId);
			dao.deleteArtwork(artworkToDelete);
			getServletContext().getRequestDispatcher("/viewAllGalleryServlet").forward(request, response);
		} else if (act.equals("Edit Selected Artwork")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Artwork artworkToEdit = dao.searchForArtworkById(tempId);
			request.setAttribute("artworkToEdit", artworkToEdit);		
			getServletContext().getRequestDispatcher("/editArtwork.jsp").forward(request, response);
		} else if (act.equals("Add New Artwork")) {
			getServletContext().getRequestDispatcher("/addArtwork.html").forward(request, response);
		}
	}
	}



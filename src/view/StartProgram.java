package view;

import java.util.List;

import java.util.Scanner;

import controller.ArtworkHelper;
import model.Artwork;


public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static ArtworkHelper ah = new ArtworkHelper();
	
	

	private static void addArtwork() {
		// TODO Auto-generated method stub
		System.out.print("Enter a title of the work: ");
		String title = in.nextLine();
		System.out.print("Enter the artist: ");
		String artist = in.nextLine();
		System.out.print("Enter the media: ");
		String media = in.nextLine();
		System.out.print("Enter the year the piece was created: ");
		String year = in.nextLine();
		System.out.print("Enter the value of the piece: ");
		double value = in.nextDouble();

		Artwork toAdd = new Artwork(title, artist, media, year, value);
		ah.insertArtwork(toAdd);

	}

	private static void deleteArtwork() {
		// TODO Auto-generated method stub
		System.out.print("Enter the artist to delete: ");
		String artist = in.nextLine();
		System.out.print("Enter the title to delete: ");
		String title = in.nextLine();

		Artwork toDelete = new Artwork(title, artist);
		ah.deleteArtwork(toDelete);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our art GALLERY! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an item");
			System.out.println("*  2 -- View the gallery");
			System.out.println("*  3 -- Edit arwork piece");
			System.out.println("*  4 -- Delete an item");
			System.out.println("*  5 -- Exit the gallery program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addArtwork();
			} else if (selection == 2) {
				viewTheGallery();
			} else if (selection == 3) {
				editArtwork();
			} else if (selection == 4) {
				deleteArtwork();
			} else {
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}

	}

	public static void viewTheGallery() {
		List<Artwork> allArtwork = ah.showAllArtwork();
		System.out.println("--------------------------------------------------");
		for (Artwork a : allArtwork) {
			System.out.println(a.returnArtworkDetails());
		}
		System.out.println("--------------------------------------------------");
	}
	
	private static void editArtwork() {
		// TODO Auto-generated method stub
		viewTheGallery();
		System.out.print("Which ID to edit: ");
		int idToEdit = in.nextInt();
		Artwork toEdit = ah.searchForArtworkById(idToEdit);
		System.out.println(toEdit.returnArtworkDetails());
		System.out.println("Enter which field you'd like to update: ");
		System.out.println("1 : Update Title");
		System.out.println("2 : Update Artist");
		System.out.println("3 : Update Media");
		System.out.println("4 : Update Creation Year");
		System.out.println("5 : Update Value");
		int update = in.nextInt();
		in.nextLine();

		if (update == 1) {
			System.out.print("Update Title: ");
			String newTitle = in.nextLine();
			toEdit.setTitle(newTitle);
		} else if (update == 2) {
			System.out.print("Update Artist: ");
			String newArtist = in.nextLine();
			toEdit.setArtist(newArtist);
		} else if (update == 3) {
			System.out.print("Update Media: ");
			String newMedia = in.nextLine();
			toEdit.setMedia(newMedia);
		} else if (update == 4) {
			System.out.print("Update Year Created: ");
			String newYear = in.nextLine();
			toEdit.setYear(newYear);
		} else if (update == 5) {
			System.out.print("Update Value of Piece: ");
			double newValue = in.nextDouble();
			toEdit.setValue(newValue);
		}
		ah.updateArtwork(toEdit);
		viewTheGallery();

	}

}

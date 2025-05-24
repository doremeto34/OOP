package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Store {

	// Max number of disc
	public static final int MAX_NUMBERS_STORED = 36;
	private List<Media> itemsStored = new ArrayList<Media>();

	// add media
	public void addMedia(Media media) {
		if(itemsStored.contains(media)) {
			System.out.println("Media already exists");
		}else {
			itemsStored.add(media);
			System.out.println("Media is added");
		}
	}
	// remove media
	public void removeMedia(Media media) {
		try {
            if (itemsStored.contains(media)) {
                itemsStored.remove(media);
                System.out.println("Media is removed");
            } else {
                System.out.println("No media was found");
            }
        } catch (RuntimeException e) {
            System.err.println("Error removing media: " + e.getMessage());
        }
	}
	// find title
	public Media findTitle(String title) {
		for(Media media: itemsStored) {
			if(media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}
	// play media
	public void playMedia(Media media) throws PlayerException {
		media.play();
	}
	
	public void sortByTitle() {
		try {
            Collections.sort(itemsStored, Media.COMPARE_BY_TITLE_COST);
        } catch (RuntimeException e) {
            System.err.println("Error sorting by title: " + e.getMessage());
        }	}
	public void sortByCost() {
		try {
            Collections.sort(itemsStored, Media.COMPARE_BY_COST_TITLE);
        } catch (RuntimeException e) {
            System.err.println("Error sorting by cost: " + e.getMessage());
        }
	}
	
	public void displayStore() {
		try {
            for (Media media : itemsStored) {
                System.out.println(media.toString());
            }
        } catch (RuntimeException e) {
            System.err.println("Error displaying store contents: " + e.getMessage());
        }
	}
	// for exercise
	public List<Media> getItemsInStore() {
		return itemsStored;
	}
}

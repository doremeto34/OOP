package hust.soict.hedspi.aims.cart;
import java.util.Collections;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.collections.ListChangeListener;

public class Cart {
	// Max number of disc
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	public FloatProperty totalCost = new SimpleFloatProperty(0f);
	
	public Cart() {
		itemsOrdered.addListener((ListChangeListener<Media>) change -> {
            try {
                while (change.next()) {
                    if (change.wasAdded()) {
                        for (Media media : change.getAddedSubList()) {
                            totalCost.set(totalCost.get() + media.getCost());
                        }
                    }
                    if (change.wasRemoved()) {
                        for (Media media : change.getRemoved()) {
                            totalCost.set(totalCost.get() - media.getCost());
                        }
                    }
                }
            } catch (RuntimeException e) {
                System.err.println("Error updating total cost: " + e.getMessage());
            }
        });
	}
	
	// add media
	public void addMedia(Media media) throws LimitExceededException {
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			if(itemsOrdered.contains(media)) {
				System.out.println("Media already exists");
			}else {
				itemsOrdered.add(media);
				System.out.println("Media is added");
			}
		} else {
			throw new LimitExceededException("ERROR: The number of media has reached its limit");
		}
	}
	// remove media
	public void removeMedia(Media media) {
		try {
            if (itemsOrdered.contains(media)) {
                itemsOrdered.remove(media);
                System.out.println("Media is removed");
            } else {
                System.out.println("No media was found");
            }
        } catch (RuntimeException e) {
            System.err.println("Failed to remove media: " + e.getMessage());
        }
	}
	// get cost
	public float totalCost() {
		float sum=0;
		for(int i=0;i<itemsOrdered.size();++i)
			sum+=itemsOrdered.get(i).getCost();
		return sum;
	}
	
	// print cart
	public void displayCart() {
		if(itemsOrdered.isEmpty())
			System.out.print("The cart is empty");
		else {
			System.out.println("***********************CART***********************");
			for(Media media: itemsOrdered) {
				System.out.println(media.toString());
			}
			System.out.println("Total cost: " + totalCost());
			System.out.println("**************************************************");
			
		}
	}
	
	// search by ID
	public void seachByID(int id) {
		if(itemsOrdered.isEmpty())
			System.out.print("The cart is empty");
		else {
			int mediaCnt = 0;
			for(Media media: itemsOrdered) {
				String mediaStr = Integer.toString(media.getId());
		        String idStr = Integer.toString(id);
		        if(mediaStr.contains(idStr)) {
					System.out.println(media.toString());
					++mediaCnt;
		        }
			}
			if(mediaCnt == 0)System.out.println("No Media with alike ID found");
		}
	}
	
	// search by title
	public void seachByTitle(String title) {
		if(itemsOrdered.isEmpty())
			System.out.print("The cart is empty");
		else {
			int mediaCnt = 0;
			for(Media media: itemsOrdered) {
				if(media.getTitle().toLowerCase().contains(title.toLowerCase())) {
					System.out.println(media.toString());
					++mediaCnt;
				}
			}
			if(mediaCnt == 0)System.out.println("No Media with alike title found");
		}
	}
	
	public void sortByTitle() {
		try {
			Collections.sort(itemsOrdered,Media.COMPARE_BY_TITLE_COST);
		} catch (RuntimeException e) {
			System.out.println("Error while sorting: "+e.getMessage());
		}
	}
	public void sortByCost() {
		try {
			Collections.sort(itemsOrdered,Media.COMPARE_BY_COST_TITLE);
		} catch (RuntimeException e) {
			System.out.println("Error while sorting: "+e.getMessage());
		}
	}
	public void emptyCart() {
		itemsOrdered.removeAll(itemsOrdered);
	}
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
}
 
 
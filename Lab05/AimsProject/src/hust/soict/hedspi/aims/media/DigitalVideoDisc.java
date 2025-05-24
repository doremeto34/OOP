package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
	
	public DigitalVideoDisc(int id,String title, String category, String director, int length, float cost) throws IllegalArgumentException {
		super();

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty.");
        }
        if (director == null || director.trim().isEmpty()) {
            throw new IllegalArgumentException("Director cannot be null or empty.");
        }
        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be negative.");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative.");
        }

        setId(id);
        setTitle(title);
        setCategory(category);
        setDirector(director);
        setLength(length);
        setCost(cost);
	}
	
	// Comparison
	public boolean isMatchID(int id) {
		if(getId() == id) return true;
		return false;
	}
	
	public boolean isMatchTitle(String title) {
		if (getTitle().toLowerCase().contains(title.toLowerCase()))
			return true;
		return false;
	}
	@Override
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		} else {
			throw new PlayerException("Error: DVD length is non-positive");
		}
	}
	
	@Override
	public String toString() {
		return "DigitalVideoDisc | id: " + getId() +
				" title: " + getTitle() +
				" category: " + getCategory() +
				" director: " + getDirector() +
				" length: " + getLength() +
				" cost: " + getCost();
	}
}
 
 
 
 
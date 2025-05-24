package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{

	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	
	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}

	public CompactDisc(int id,String title, String category, String director, int length, float cost) throws IllegalArgumentException {
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
	
	public void addTrack(Track track) {
		boolean flag = true;
		for (int i=0; i<tracks.size(); ++i) {
			if(tracks.get(i).equals(track)) {
				System.out.println("Track already exists");
				flag = false;
				break;
			}
		}
		if(flag)tracks.add(track);
		System.out.println("Track added");
	}
	public void removeTrack(Track track) {
		boolean flag = true;
		for (int i=0; i<tracks.size(); ++i) {
			if(tracks.get(i).equals(track)) {
				tracks.remove(i);
				System.out.println("Track removed");
				flag = false;
				break;
			}
		}
		if(flag)System.out.println("Track is not found");
	}
	
	// get sum of track length
	public int getLength() {
		int sum=0;
		for (int i=0; i<tracks.size(); ++i) {
			sum+=tracks.get(i).getLength();
		}
		return sum;
	}


	@Override
	public void play() throws PlayerException {
		// TODO Auto-generated method stub
		if(this.getLength() > 0) {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD length: " + this.getLength());
			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while(iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				} catch(PlayerException e) {
					System.out.println("Error when playing track: "+e.getMessage());
					throw e;
				}
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}
	
	@Override
	public String toString() {
		return "CompactDisc | id: " + getId() +
				" title: " + getTitle() +
				" category: " + getCategory() +
				" director: " + getDirector() +
				" length: " + getLength() +
				" cost: " + getCost();
	}
}

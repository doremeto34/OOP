package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {

	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public Track() {
		// TODO Auto-generated constructor stub
	}


	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	@Override
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			System.out.println("Playing Track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		} else {
			throw new PlayerException("Error: Track length is non-positive");
		}
	}
	
	boolean equals(Track track) {
		if(this.title.equals(track.getTitle()) &&
				this.length == track.length)return true;
		return false;
	}
}

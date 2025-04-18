package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create fuck new cart
		Cart cart = new Cart();
		
		// create dvd to add to fucking cart
		DigitalVideoDisc dvd1 =  new DigitalVideoDisc(1,"The Lion King","Animation","Roger Allers",87,19.95f);
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 =  new DigitalVideoDisc(2,"SW","SF","George Lucas",87,24.95f);
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 =  new DigitalVideoDisc(3,"Snow White","Animation","Disney",36,18.98f);
		cart.addDigitalVideoDisc(dvd3);
		
		cart.seachByTitle("white");
	}

}

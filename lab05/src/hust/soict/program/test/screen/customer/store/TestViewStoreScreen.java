package hust.soict.program.test.screen.customer.store;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
	private static Store store;
	private Cart cart;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		cart = new Cart();
		ViewStoreController viewStoreController = new ViewStoreController(store,cart);
		fxmlLoader.setController(viewStoreController);
		Parent root	= fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		store = new Store();
		Book book1 = new Book(1, "Effective Java", "Programming", 45.99f);
        Book book2 = new Book(2, "Clean Code", "Software Engineering", 39.99f);
        Book book3 = new Book(3, "The Pragmatic Programmer", "Development", 42.50f);

        // DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(4, "Inception", "Science Fiction", "Christopher Nolan", 148, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(5, "The Matrix", "Action", "Lana Wachowski", 136, 17.50f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(6, "The Social Network", "Biography", "David Fincher", 120, 16.99f);

        // CDs
        CompactDisc cd1 = new CompactDisc(7, "Abbey Road", "Music", "George Martin", 47, 14.99f);
        CompactDisc cd2 = new CompactDisc(8, "Thriller", "Pop", "Quincy Jones", 42, 13.50f);
        CompactDisc cd3 = new CompactDisc(9, "The Dark Side of the Moon", "Rock", "Pink Floyd", 43, 15.00f);
        CompactDisc cd4 = new CompactDisc(10, "50 shades of cyan", "Rock", "Pink Floyd", 43, 15.00f);

        // Add all media to store
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(cd4);
		launch(args);
	}
}

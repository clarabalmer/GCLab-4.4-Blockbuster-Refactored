
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;



class Tests {

	@Test
	void testDVDCreation() {
		DVD uhf = new DVD("UHF", "97 minutes", new ArrayList<String>(Arrays.asList("Weird Al does some stuff", "Movie concludes")));
		Assert.assertNotNull(uhf);
	}
	@Test
	void testDVDTitle() {
		DVD uhf = new DVD("UHF", "97 minutes", new ArrayList<String>(Arrays.asList("Weird Al does some stuff", "Movie concludes")));
		Assert.assertEquals(uhf.getTitle(), "UHF");
	}
	@Test
	void testDVDRunTime() {
		DVD uhf = new DVD("UHF", "97 minutes", new ArrayList<String>(Arrays.asList("Weird Al does some stuff", "Movie concludes")));
		Assert.assertEquals(uhf.getRunTime(), "97 minutes");
	}
	@Test
	void testVHSCreation() {
		VHS blairWitch = new VHS("The Blair Witch Project", "81 minutes", new ArrayList<String>(Arrays.asList("Into the woods", "Not out of them though")));
		Assert.assertNotNull(blairWitch);
	}
	@Test
	void testVHSTitle() {
		VHS blairWitch = new VHS("The Blair Witch Project", "81 minutes", new ArrayList<String>(Arrays.asList("Into the woods", "Not out of them though")));
		Assert.assertEquals(blairWitch.getTitle(), "The Blair Witch Project");
	}
	@Test
	void testVHSRunTime() {
		VHS blairWitch = new VHS("The Blair Witch Project", "81 minutes", new ArrayList<String>(Arrays.asList("Into the woods", "Not out of them though")));
		Assert.assertEquals(blairWitch.getRunTime(), "81 minutes");
	}
	@Test
	void testVHSCurrentTime() {
		VHS blairWitch = new VHS("The Blair Witch Project", "81 minutes", new ArrayList<String>(Arrays.asList("Into the woods", "Not out of them though")));
		Assert.assertEquals(blairWitch.getCurrentTime(), 0);
	}
	@Test
	void testVHSPlay() {
		VHS blairWitch = new VHS("The Blair Witch Project", "81 minutes", new ArrayList<String>(Arrays.asList("Into the woods", "Not out of them though")));
		blairWitch.play();
		Assert.assertEquals(blairWitch.getCurrentTime(), 1);
	}
	@Test
	void testVHSPlayIncrement() {
		VHS blairWitch = new VHS("The Blair Witch Project", "81 minutes", new ArrayList<String>(Arrays.asList("Into the woods", "Not out of them though", "End credits", "End credits scene?")));
		blairWitch.play();
		blairWitch.play();
		blairWitch.play();
		Assert.assertEquals(blairWitch.getCurrentTime(), 3);
	}
	@Test
	void testVHSRewind() {
		VHS blairWitch = new VHS("The Blair Witch Project", "81 minutes", new ArrayList<String>(Arrays.asList("Into the woods", "Not out of them though", "End credits", "End credits scene?")));
		blairWitch.play();
		blairWitch.play();
		blairWitch.rewind();
		Assert.assertEquals(blairWitch.getCurrentTime(), 0);
	}
	@Test //extended challenge
	void testPlayLastScene() {
		ArrayList<String> blairScenes = new ArrayList<>(Arrays.asList("Into the woods", "Not out of them though", "End credits", "End credits scene?"));
		VHS blairWitch = new VHS("The Blair Witch Project", "81 minutes", blairScenes);
		for (int i = 0; i <= blairScenes.size(); i++) {
			blairWitch.play();
		}
		Assert.assertEquals(blairWitch.getCurrentTime(), 0);
	}

}

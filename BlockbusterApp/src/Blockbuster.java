import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Blockbuster {
	
	public static ArrayList<VHS> tapes = new ArrayList<>();
	public static ArrayList<DVD> dvds = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		fillTapesAndDvds();
		
		System.out.println("Welcome to Blockbuster! We only have six movies now.");
		boolean repeatMovieChoice = true;
		
		//movie watching loop
		while (repeatMovieChoice) {
			displayMovieMenu();
			//user chooses movie, info prints
			int movieCode = numberMenu(scnr, 1, tapes.size() + dvds.size()) - 1;
			Movie movieChoice;
			if (movieCode < tapes.size()) {
				tapes.get(movieCode).printInfo();
				movieChoice = new Movie(tapes.get(movieCode));
			} else {
				dvds.get(movieCode - tapes.size()).printInfo();
				movieChoice = new Movie(dvds.get(movieCode - tapes.size()));
			}
			
			//scene watching loop
			System.out.print("\nDo you want to watch the movie? ");
			boolean repeatWatchScene = yesOrNo(scnr);
			while (repeatWatchScene) {
				
				if (movieCode < tapes.size()) {
					movieChoice.play(tapes.get(movieCode).getScenes());
				} else {
					movieChoice.play(dvds.get(movieCode - tapes.size()).getScenes());
				}
				
				System.out.print("\nWatch another scene? ");
				repeatWatchScene = yesOrNo(scnr);
			}
			
			System.out.print("\nWould you like to watch another movie?");
			repeatMovieChoice = yesOrNo(scnr);
		}
		System.out.println("Thanks for visiting!");

		scnr.close();
	}	
	public static void fillTapesAndDvds() {
		tapes.add(new VHS("Saw", "103 minutes", new ArrayList<String>(Arrays.asList("Two men and a dead body in a basement", "Murder traps by Jigsaw", "Detectives have a bad time", "Creepy orderly gets wrecked", "He was the dead body the whole time!"))));
		tapes.add(new VHS("The Lion King", "88 minutes", new ArrayList<String>(Arrays.asList("Lift a baby lion up", "Dance with zebras, mess with Zazu", "Elephant graveyard", "Mufasa dies, dang", "Simba meets Timon and Pumba; eats bugs", "Nala guilt trips Simba", "Mufasa in the clouds", "Hyenas goose step a little", "Simba beats Scar and then the Hyenas finish it"))));
		tapes.add(new VHS("Jumanji", "104 minutes", new ArrayList<String>(Arrays.asList("Kids play a game, one gets turned into sand and sucked in", "Orphans come to visit", "Lions, alligators, ...monkeys?", "Robin Williams is the best", "new timeline, no more orphans"))));
		dvds.add(new DVD("Divergent", "140 minutes", new ArrayList<String>(Arrays.asList("Sorting hat, but it's sci-fi", "Main character chooses the daredevil caste", "She fistfights boys and loses", "Psychedelic fear injection test", "Capture the flag and ziplining in post-apocalypse Chicago", "Daredevil faction gets brainwashed for fascist ends", "Main character fights brainwashed boyfriend", "Trainhopping"))));
		dvds.add(new DVD("Finding Nemo", "100 minutes", new ArrayList<String>(Arrays.asList("Nemo's mom dies", "Overprotective dad, Nemo's lucky fin", "Touching the Butt", "Marlin meets Dori", "Sharks", "Turtles", "Jellyfish", "Nemo conquers his fears, escapes through a drain", "Marlin unionizes a school of fish", "Marlin is less codependent now"))));
		dvds.add(new DVD("Pride and Prejudice", "127 minutes", new ArrayList<String>(Arrays.asList("New rich men in town, Darcy snubs Lizzy", "Mr. Collins will inherit and is also the worst", "Mr. Collins cringe fest. Lizzy says no way, Charlotte says ok", "Lizzy visits Charlotte, Darcy is there and weirdly attentive", "Darcy proposes and Lizzy says never", "Darcy writes a defensive letter", "Darcy's house is really really big", "Darcy is super nice now???", "Lydia is ruined, Lydia is married, Lydia spills the beans", "Lady Catherine calls Lizzy trash", "Darcy proposes again, Lizzy is psyched now"))));
	}
	public static void displayMovieMenu() {
		System.out.println();
		for (int i = 0; i < tapes.size(); i++) {
			System.out.println("  " + (i + 1) + ") " + tapes.get(i).getTitle());
		}
		for (int i = 0; i < dvds.size(); i++) {
			System.out.println("  " + (i + 1 + tapes.size()) + ") " + dvds.get(i).getTitle());
		}
		System.out.print("\nPlease select the movie you want to watch");
	}
	//number menu takes a min and max int, returns user choice within that range, tries again if out of range
	public static int numberMenu(Scanner scnr, int min, int max) {
		System.out.print(" (" + min + "-" + max + "): ");
		String response = scnr.nextLine();
		try {
			int result = Integer.parseInt(response);
			if (min <= result && result <= max) {
				return result;
			} else {
				System.out.print("Please enter a number in the proper range");
				return numberMenu(scnr, min, max);
			}
		} catch (NumberFormatException e) {
			System.out.print("Please enter a number");
			return numberMenu(scnr, min, max);
		}
	}
	public static boolean yesOrNo(Scanner scnr) {
		System.out.print(" y/n ");
		String response = scnr.nextLine();
		if (response.equalsIgnoreCase("y")) {
			return true;
		} else if (response.equalsIgnoreCase("n")) {
			return false;
		} else {
			System.out.print("I didn't understand. Please try again. ");
			return yesOrNo(scnr);
		}
	}
	
	
	
	
}

import java.util.ArrayList;
import java.util.Scanner;

public class DVD implements Play{
	//fields:
	private String title;
	private String runTime;
	private ArrayList<String> scenes;
	
	//constructor:
	public DVD(String title, String runTime, ArrayList<String> scenes) {
		setTitle(title);
		setRunTime(runTime);
		setScenes(scenes);
	}
	
	//methods
	public void play(ArrayList<String> scenes) {
		Scanner scnr = new Scanner(System.in);
		System.out.print("\nWhich scene of the DVD would you like to watch?");
		int sceneChoice = numberMenu(scnr, 0, scenes.size() - 1);
		System.out.println("\nScene " + (sceneChoice) + ": " + scenes.get(sceneChoice));
	}
	public void printInfo() {
		System.out.println("\nTitle: " + title);
		System.out.println("RunTime: " + runTime);
	}
	
	@Override
	public String toString() {
		return "Title: " + getTitle() + "; RunTime: " + getRunTime() + "; Scenes: " + scenes.toString();
	}
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
	//getters/setters:
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setScenes(ArrayList<String> scenes) {
		this.scenes = scenes;
	}
	public ArrayList<String> getScenes() {
		return scenes;
	}
}

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

public class KevinBacon {
	
	public static void main( String[] args ) throws FileNotFoundException {
		UndirectedGraph<String> graph = new UndirectedGraph<String>();
		Parser input = new Parser("imdb_top250.txt");
		while (input.hasNext()) {
			personFilmPair pair = input.next();
			String person = pair.getPerson();
			String film = pair.getFilm();
			
			if (!graph.containsVertex(person)) {
				graph.addVertex(person); }
			if (!graph.containsVertex(film) ) {
				graph.addVertex(film); }
			if (!graph.containsEdge(person, film) ) {
				graph.addEdge(person, film); }
			if (!graph.containsEdge(film, person) ) {
				graph.addEdge(film, person); }
		}
		
		boolean keep_searching = true;
		
		//input_string = JOptionPane.showInputDialog( "Do you want to find Bacon Numbers? (yes -> y , no -> n)");
		//if (input_string.equals("n")) { keep_searching = false; }
		
		boolean valid_entry = true;
		String start;
		String target;
		
		while (keep_searching) {
			if (keep_searching) {
				start = JOptionPane.showInputDialog("With whom/what do you want to start? (enter 'cancel' to exit)");
				if (start.equals("cancel")) { keep_searching = false; }
				else if ( !graph.containsVertex(start) ) { 
					valid_entry = false;
					System.out.println(start + " was not found");
				}
				else { System.out.println("\nStarting with " + start); }
				
				if (keep_searching && valid_entry) {
					target = JOptionPane.showInputDialog("Who/What is the target? (enter 'cancel' to exit)");
					if (target.equals( "cancel")) { keep_searching = false; }
					else {System.out.println("Searching for " + target); }
			
					if (keep_searching) {
						Dijkstra d = new Dijkstra(graph, start, target);
						d.start();
						boolean found = false;
						boolean failed = false;
						while ( failed != true && found != true) {
							if (d.isNext() != true) { failed = true; }
							else { found = d.checkNeighbors(d.popFront()); }
							if (found) {System.out.println("found");
							}
						}
						if (found) { d.traceRoute(target); }
						else { System.out.println(target + " has no known connection to " + start); }
					}
				}
			}
		}
	}
}
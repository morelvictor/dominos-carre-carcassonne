package view;

import model.*;

import java.util.Scanner;

public class Terminal {
	public static void launch() {
		GameDominos g = new GameDominos();
		Scanner sc = new Scanner(System.in);
		System.out.println("Voulez-vous ajouter un adversaire à Victor ? (Oui/Non) ");
		if(sc.next().equalsIgnoreCase("oui")) {
			System.out.println("Entrez son nom: ");
			Player p = new Player(sc.next());
			g.getPlayers().add(p);
			System.out.println("Voulez-vous que ce soit une IA ? (Oui/Non) ");
			if(sc.next().equalsIgnoreCase("oui")) {
				p.setAi(true);
			}
		}
		System.out.println("Les joueurs sont :");
		for(Player p : g.getPlayers()){
			System.out.println(p.getName());
		}
		while (g.getSac().size() > 0) {
			System.out.println(g.getPlateau());
			System.out.println("Pioche: \n" + g.getSac().peek());
			System.out.println("\n" + g.peekPlayer().getName() + " que voulez vous faire ?\n" +
					"D : Defausser\n" +
					"T : Tourner la tuile\n" +
					"P : Placer une tuile");
			String str = sc.next();
			if (str.equals("D")){
				g.defausser();
			}
			else if (str.equals("T"))
				g.getSac().peek().rotate();
			else {
				System.out.println("Ligne de la position:");
				int j = sc.nextInt();
				System.out.println("Colonne de la position:");
				int i = sc.nextInt();
				int b = g.getPlateau().isValid(new Coords(i, j), g.getSac().peek());
				if (b != -1) {
					g.place(new Coords(i, j));
					g.getSac().pop();
				} else {
					System.out.println("Déplacement non autorisé");
				}
				
			}
		}

		Player vainqueur = g.getPlayers().get(0);
		for (Player p : g.getPlayers()) {
			if (p.getPoints() > vainqueur.getPoints())
				vainqueur = p;
		}

		System.out.print("Le vainqueur est " + vainqueur.getName());
		sc.close();
	}
}

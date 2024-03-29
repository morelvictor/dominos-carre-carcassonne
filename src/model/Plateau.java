package model;

import java.util.HashMap;

public class Plateau extends HashMap<Coords, Tuile> {

	public int max_x = 0;
	public int max_y = 0;
	public int min_x = 0;
	public int min_y = 0;

	public Plateau() {
		super();
	}

	public Plateau(Tuile t) {
		super();
		put(new Coords(0, 0), t);
	}

	public int getMin_x() {
		return min_x;
	}

	public int getMax_x() {
		return max_x;
	}

	public int getMax_y() {
		return max_y;
	}

	public int getMin_y() {
		return min_y;
	}

	public String toString() {

		int[] tab = new int[3];
		tab[0] = 9;
		tab[1] = 9;
		tab[2] = 9;

		int l = min_y - 1;

		String acc = " ";
		String acc1 = "   ";
		String acc2 = "   ";
		String acc3;
		if (l < 0)
			acc3 = l + " ";
		else {
			acc3 = l + "  ";
		}

		String acc4 = "   ";
		String acc5 = "   ";

		for (int k = min_x - 1; k <= max_x + 1; k++) {
			acc += "     " + k + "    ";
		}
		System.out.println(acc);

		for (int j = min_y - 1; j <= max_y + 1; j++) {

			for (int i = min_x - 1; i <= max_x + 1; i++) {

				if (!isFree(new Coords(i, j))) {
					TuileDominos t = (TuileDominos) get(new Coords(i, j));

					SideDominos n = (SideDominos) t.getN();
					SideDominos w = (SideDominos) t.getW();
					SideDominos e = (SideDominos) t.getE();
					SideDominos s = (SideDominos) t.getS();

					acc1 += "\033[0;94mX-" + n.getTab()[0] + "-" + n.getTab()[1] + "-" + n.getTab()[2] + "-X\033[0m ";
					acc2 += "\033[0;94m" + w.getTab()[0] + "       " + e.getTab()[0] + " ";
					acc3 += "\033[0;94m" + w.getTab()[1] + "       " + e.getTab()[1] + " ";
					acc4 += "\033[0;94m" + w.getTab()[2] + "       " + e.getTab()[2] + " ";
					acc5 += "\033[0;94mX-" + s.getTab()[0] + "-" + s.getTab()[1] + "-" + s.getTab()[2] + "-X\033[0m ";
				} else {

					if (isReachable(new Coords(i, j))) {
						acc1 += "\033[0;32m*********\033[0m ";
						acc2 += "\033[0;32m*       *\033[0m ";
						acc4 += "\033[0;32m*       *\033[0m ";
						acc3 += "\033[0;32m*       *\033[0m ";
						acc5 += "\033[0;32m*********\033[0m ";
					}

					else {
						acc1 += "          ";
						acc2 += "          ";
						acc3 += "          ";
						acc4 += "          ";
						acc5 += "          ";
					}
				}

			}
			System.out.println(acc1);
			System.out.println(acc2);
			System.out.println(acc3);
			System.out.println(acc4);
			System.out.println(acc5);

			l++;

			acc = " ";
			acc1 = "   ";
			acc2 = "   ";
			if (l < 0)
				acc3 = l + " ";
			else {
				acc3 = l + "  ";
			}
			acc4 = "   ";
			acc5 = "   ";
		}
		return "";
	}

	public boolean isFree(Coords c) {
		return get(c) == null;
	}

	public Coords[] near(Coords c) {
		Coords[] cs = new Coords[4];
		cs[0] = new Coords(c.x - 1, c.y);
		cs[1] = new Coords(c.x + 1, c.y);
		cs[2] = new Coords(c.x, c.y - 1);
		cs[3] = new Coords(c.x, c.y + 1);
		return cs;
	}

	public Tuile getTuile(Coords c) {
		return get(c);
	}

	public boolean isReachable(Coords c) {
		for (Coords cs : near(c)) {
			if (!isFree(cs))
				return true;
		}
		return false;
	}

	public int isValid(Coords c, Tuile t) {
		if (!isReachable(c))
			return -1;

		if (get(c) != null)
			return -1;

		int points = 0;

		Tuile left = get(new Coords(c.x - 1, c.y));
		Tuile right = get(new Coords(c.x + 1, c.y));
		Tuile down = get(new Coords(c.x, c.y - 1));
		Tuile up = get(new Coords(c.x, c.y + 1));

		if (left != null) {
			int tmp = t.w.getPoints(left.e);
			if (tmp == -1)
				return -1;
			points += tmp;
		}
		if (right != null) {
			int tmp = t.e.getPoints(right.w);
			if (tmp == -1)
				return -1;
			points += tmp;
		}
		if (down != null) {
			int tmp = t.n.getPoints(down.s);
			if (tmp == -1)
				return -1;
			points += tmp;
		}
		if (up != null) {
			int tmp = t.s.getPoints(up.n);
			if (tmp == -1)
				return -1;
			points += tmp;
		}
		return points;
	}

	public int place(Coords c, Tuile t) {
		int v = isValid(c, t);
		if (v > -1) {
			put(c, t);
			if (c.x < min_x)
				min_x = c.x;
			if (c.x > max_x)
				max_x = c.x;
			if (c.y < min_y)
				min_y = c.y;
			if (c.y > max_y)
				max_y = c.y;
		}
		return v;
	}
}

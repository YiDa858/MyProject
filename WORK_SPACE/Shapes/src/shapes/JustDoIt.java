package shapes;

public class JustDoIt {
	public static void main(String[] args) 
	{
	       Picture pic = new Picture(600,400);
	       //j
	       Line l1 = new Line(40,20, 100, 20);
	       Line l2 = new Line(70,20, 70, 120);
	       Line l3 = new Line(40,120, 70, 120);
	       Line l4 = new Line(40,120, 40, 100);
	       //u
	       Line l5 = new Line(120,20, 120, 120);
	       Line l6 = new Line(120,120, 180, 120);
	       Line l7 = new Line(180,20, 180, 120);
	       //s
	       Line l8 = new Line(200,20, 260, 20);
	       Line l9 = new Line(200,70, 200, 20);
	       Line l10 = new Line(200,70, 260, 70);
	       Line l11 = new Line(260,70, 260, 120);
	       Line l12 = new Line(200,120, 260, 120);
	       //t
	       Line l13 = new Line(280,20, 340, 20);
	       Line l14 = new Line(310,20, 310, 120);
	       //i
	       Line l15 = new Line(200,220, 260, 220);
	       Line l16 = new Line(230,220, 230, 320);
	       Line l17 = new Line(200,320, 260, 320);
	       //t
	       Line l18 = new Line(280,220, 340, 220);
	       Line l19 = new Line(310,220, 310, 320);
	       //d
	       Line l20 = new Line(40,220, 40, 320);
	       Line l21 = new Line(80,220, 100,240);
	       Line l22 = new Line(100, 300, 80, 320);
	       Line l23 = new Line(100,240, 100, 300);
	       Line l24 = new Line(40,220, 80, 220);
	       Line l25 = new Line(40, 320,80, 320);
	       //o
	       Rectangle r1 = new Rectangle(120, 220, 60, 100);

	       pic.add(l1);
	       pic.add(l2);
	       pic.add(l3);
	       pic.add(l4);
	       pic.add(l5);
	       pic.add(l6);
	       pic.add(l7);
	       pic.add(l8);
	       pic.add(l9);
	       pic.add(l10);
	       pic.add(l11);
	       pic.add(l12);
	       pic.add(l13);
	       pic.add(l14);
	       pic.add(l15);
	       pic.add(l16);
	       pic.add(l17);
	       pic.add(l18);
	       pic.add(l19);
	       pic.add(l20);
	       pic.add(l21);
	       pic.add(l22);
	       pic.add(l23);
	       pic.add(l24);
	       pic.add(l25);
	       pic.add(r1);
	       pic.draw();
	}
}
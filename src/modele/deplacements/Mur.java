package modele.deplacements;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;


import modele.motifs.fixes.MotifFixeRectangle;
import modele.motifs.fixes.PtSkeleton;
import modele.motifs.fixes.Vecteur;

import vue.Toile;

public class Mur extends MotifFixeRectangle{
	
	

	private TypeMur typeDeMur;
	
	public Mur(ArrayList<PtSkeleton> listePoints, Color couleur, int largeur,
			int hauteur, TypeMur typeMur) {
		super(listePoints, couleur, largeur, hauteur);
		this.typeDeMur=typeMur;
		// TODO Auto-generated constructor stub
	}
	
	public TypeMur getTypeDeMur() {
		return this.typeDeMur;
	}
	
	
	public Vecteur transformationVecteurApresRebond(Vecteur v) {
		
		Vecteur vecteur = new Vecteur();
		
		if(this.typeDeMur==TypeMur.murGauche || this.typeDeMur==TypeMur.murDroit) {
			vecteur.setX1(v.getX1());
			vecteur.setY1(v.getY1());
			vecteur.setX2(-(v.getX2()));
			vecteur.setY2(v.getY2());
		} else { //si c'est un plafond ou un sol
			vecteur.setX1(v.getX1());
			vecteur.setY1(v.getY1());
			vecteur.setX2((v.getX2()));
			vecteur.setY2(-(v.getY2()));
		}
		
		
		return vecteur;
	}
	
	
}

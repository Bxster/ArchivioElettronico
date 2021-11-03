package main;

import java.util.*;

public class Esame {
	
	private String nomeEsame;
	private int creditiEsame;
	private int votoEsame;
	
	
	public Esame( String nomeEsame ,int creditiEsame ) 
	{
		this.nomeEsame = nomeEsame;
		this.creditiEsame = creditiEsame;
	}
	
	public Esame( String nomeEsame ,int creditiEsame , int votoEsame) 
	{
		this.nomeEsame = nomeEsame;
		this.creditiEsame = creditiEsame;
		this.votoEsame = votoEsame;
	}
	
	
	public String getNomeEsame() 
	{
		return this.nomeEsame;
	}
	
	
	public int getVoto() 
	{
		return this.votoEsame;
	}
	
	public void setVoto(int votoEsame) 
	{
	   votoEsame = this.votoEsame; 
	}
	
	public int getCrediti() 
	{
		return this.creditiEsame;
	}
	
	
	// Creare un piano di studio per uno studente , prima devo vedere se lo studente è gia iscritto
	// opppure no al corso di laurea
	public boolean checkPianoStudio(Studente s) 
	{
		if(s.listaEsami.isEmpty()) { return true; } // la lista è vuota ;
		else { s.listaEsami.clear(); return false; } // Se è piena la pulisco tutta per un nuovo piano di studi.
	}
	
	
	// Aggiungere un esame al piano di studi
	public boolean addEsame(Studente s , Esame e) 
	{
		for(int i=0 ; !s.listaEsami.isEmpty() ; i++) 
		{  // TODO LUCA : FINIRE IF , VEDERE SE L'ESAME AGGIUNTO SI TROVA O NO NEL PIANO DI STUDI
			if(!s.listaEsami.equals(e)) { s.listaEsami.add(e); return true; }
		}
		return false;
	}
	
	
	public boolean removeEsame(Studente s , Esame e) 
	{
		for(int i=0 ; !s.listaEsami.isEmpty() ; i++) 
		{
		// TODO LUCA : FINIRE IF , VEDERE SE L'ESAME RIMOSSO SI TROVA O NO NEL PIANO DI STUDI
			if(s.listaEsami.equals(e)) { s.listaEsami.remove(i); return true; }
		}
		return false;
	}
	
	
	public boolean findEsame(Studente s , String daCercare) 
	{
		for(int i=0 ; !s.listaEsami.isEmpty() ; i++) 
		{
			Esame b = new Esame(null , 0);
			b = (Esame) s.listaEsami.get(i);
			if(b.getNomeEsame().equals(daCercare)) { return true;}
		}
		return false;
	} 
	
	
	
}

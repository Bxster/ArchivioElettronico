package main;

import java.util.*;

public class CorsoLaurea {
	
	private String nomeCorso; 
	private final int MIN_CREDITI = 180;
	ArrayList<Studente> listaStudenti = new ArrayList<Studente>();
	
	public CorsoLaurea(String nomeCorso , final int MIN_CREDITI , ArrayList<Studente>listaStudenti) 
	{
		this.nomeCorso = nomeCorso;
		this.listaStudenti = listaStudenti;
	}
	
	
	public String getNomeCorso() 
	{
		return this.nomeCorso;
	}
	
	
//  Visualizzare gli studenti iscritti ad un corso di laurea 
	public ArrayList<Studente> getListaStudenti() 
	{
		return this.listaStudenti;
	}
	

//  cercare uno studente tra gli iscritti ad un corso di laurea
	public boolean trovaStudente(CorsoLaurea cl , String nomeDaCercare) 
	{
		for(int i=0 ; !cl.listaStudenti.isEmpty() ; i++) 
		{
			if(cl.listaStudenti.get(i).getNome().equals(nomeDaCercare)) return true;
		}
		return false;
	}
	

//  Ritirare uno studente da un corso di laurea
	public boolean removeStudente(CorsoLaurea cl , String studenteDaRimuovere) 
	{
		for(int i=0 ; !cl.listaStudenti.isEmpty() ; i++) 
		{
			if(cl.listaStudenti.get(i).getNome().equals(studenteDaRimuovere)) 
			{
				cl.listaStudenti.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
//  Laureare uno studente inscritto ad un corso di laurea , questo metodo controlla se ci sono persone che possono 
//  essere laureate
	public boolean promuoviStudente(CorsoLaurea cl) 
	{
		for(int i=0 ; !cl.listaStudenti.isEmpty() ; i++) 
		{
			if(cl.listaStudenti.get(i).getCreditiStudente() >= MIN_CREDITI) 
			{
				// Rimuovo la persona laureata dalla lista e ritorno true; 
				cl.listaStudenti.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
//   Visualizzare gli studenti laureati in un corso di laurea, questo metodo va in coppia con il Promuovi Studente
//   prima gli faccio visualizzare gli studenti che possono laurearsi e dopo gli chiedo se vuole farli laureare , 
//   ovvero se vuole definitvamente eliminarli dal corso di laurea. 
	 public ArrayList visualizzaLaureati(CorsoLaurea cl) 
	 {
		 ArrayList<Studente> laureati = new ArrayList<Studente>();
		 
		 for(int i=0 ; !cl.listaStudenti.isEmpty() ; i++) 
		 {
			 if(cl.listaStudenti.get(i).getCreditiStudente() >= MIN_CREDITI) 
			 {
				 laureati.add(i, cl.listaStudenti.get(i));
			 }
		 }
	//   Attenzione : questo metodo puo anche ritornare un laureati NULL se nessuno studente ha i crediti sufficienti
   //                 per laurearsi, bisogna tenerne conto nel MAIN !
		 return laureati ;
	     
	 }

}

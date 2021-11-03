package main;

import java.util.*;

public class Studente {

	private String nome;
	private static int NumeroUltimaMatricola = 1000;
	private int matricola;
    ArrayList<Esame> listaEsami = new ArrayList<Esame>();
    
    public Studente(String nome  , ArrayList<Esame> listaEsami) 
    {
    	this.nome = nome;
    	this.matricola = NumeroUltimaMatricola;
    	this.listaEsami = listaEsami;
    	NumeroUltimaMatricola++;
    }
    
    public String getNome() 
    {
    	return this.nome;
    }
    
    public int getMatricola() 
    {
    	return this.matricola;
    }
    
    
	public ArrayList Esame () 
    {
    	return listaEsami;
    }
    


    public ArrayList getInfo(Studente s) 
    {
    	ArrayList<String> info = new ArrayList<String>();
    	float media ;
    	int somma = 0 , crediti = 0 , k = 0 ,conta = 1;
    	for(int i=0 ; !s.listaEsami.isEmpty() ; i++) 
    	{
    		if(s.listaEsami.get(i).getVoto() >= 18) 
    		{
    			info.add(k, s.listaEsami.get(i).getNomeEsame());
    			somma += s.listaEsami.get(i).getVoto();
    			crediti += s.listaEsami.get(i).getCrediti();
    			conta++;
    		}
    	}
	   media = (float) somma / conta;
	   info.add(conta, String.valueOf(media));
	   info.add(conta+1, String.valueOf(crediti));

// L' ArrayList di String sarà così composto dai primi CONTA-1 (I) esami più CONTA MEDIA più CONTA+1 crediti totali
	   return info;
    }
    
    
    public boolean promuoviStudente(Studente s , String nomeEsame , int voto) 
    {
    	for(int i=0 ; !s.listaEsami.isEmpty() ; i++) 
    	{
    		if(s.listaEsami.get(i).getNomeEsame().equals(nomeEsame)) 
    		{
    			s.listaEsami.get(i).setVoto(voto);
    			return true;
    		}
    	}
    	return false;
    }
    
    
//  Restituisce i crediti dello studente solo se ha effetivamene superato quegli esami
    public int getCreditiStudente() 
    {
    	int contaCrediti = 0;
    	for(int i=0 ; !this.listaEsami.isEmpty() ; i++) 
    	{
    		if(this.listaEsami.get(i).getVoto() >= 18) contaCrediti += this.listaEsami.get(i).getCrediti();
    	}
    	return contaCrediti;
    }
}

package main;

import java.util.*;

// TODO LUCA : TRASFORMARE TUTTI I FOR IN FOR EACH !

public class GestioneArchivioElettronico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		Scanner input3 = new Scanner(System.in);
		Scanner input4 = new Scanner(System.in);
		
		CorsoLaurea cl;
		boolean exit = true;
		int scelta;
		ArrayList<Studente> s = new ArrayList();
		// vedere se fare l'array List per l'esame; 
		
		String nomeCorso ;
		System.out.println("Inesrire nome del corso di laurea: ");
	    nomeCorso = input1.nextLine();
	    
	    // Ora posso inizializzare il corso di laurea:
	    cl = new CorsoLaurea(nomeCorso, 180 , s);
	    
	    
	    do {              
	                                  // MENU:
	        System.out.println("1)  Per inserire uno studente ad un corso di laurea");
	        System.out.println("2)  Per cercare uno studente tra gli iscritti ad un corso di laurea");
	        System.out.println("3)  Per ritirare uno studente da un corso di laurea");
	        System.out.println("4)  Per visualizzare i laureati e eliminarli dal corso di laurea");
	        System.out.println("5)  Per visualizzare tutti gli studenti iscritti ad un corso di laurea");
	      // sono propri dello studente , li faccio in uno do-while e switch a parte 
            System.out.println("6) Per interagire con lo studente");
	        scelta = input2.nextInt();
	        
	        switch(scelta) 
	        {
	              case 1:
	            	     Studente ipotetico;
	            	     System.out.print("Inserire il nome dello studente: ");
	            	     String nomeStudente = input3.nextLine();
	            	     ipotetico = new Studente(nomeStudente , null);
	            	   
	            	     if(cl.AddStudenteCorsoLaurea(cl, ipotetico)) 
	            	       {
		            	     s.add(ipotetico); // SE LO ISCRIVO NON HA UN PIANO DI STUDIO	            	    	 
	            	    	 System.out.println("Studento aggiunto corretamente al pinao di studio");
	            	       }
	            	        else System.out.println("Studente gia iscritto al corso di laurea ! ");
	            	 
	            	     break;	            	     
	            
	              
	              case 2:
	            	     System.out.print("Inserisci il nome dello studente da ricercare: ");
	            	     String daCercare = input1.nextLine();
	            	     
	            	     if(cl.trovaStudente(cl, daCercare)) System.out.println("Studente trovato !");
	            	       else  System.out.println("Studente non trovato !");
	            	     
	            	     break;
	             
	              
	              case 3:
	            	     System.out.println("Inserisci il nome dello studente che vuoi ritirare: ");
	            	     String daRitirare = input2.nextLine();
	            	     
	            	     if(cl.removeStudente(cl, daRitirare)) System.out.println("Studente ritirato con successo !");
	            	        else System.out.println("Lo studente non risulta iscritto al pianodi studi"); 
	            	   
	            	     break;	            	     
	              
	              
	              case 4:
	            	     int conta = 1;
	            	     for(Studente local : cl.listaStudenti) 
	            	        {
	            	    	   if(local.getCreditiStudente() >=  180) 
	            	    		  System.out.println(local.getNome() + " CREDITI: " + local.getCreditiStudente());
	            	    	   else conta++;
	            	        }
	            	    	if(cl.listaStudenti.size() == conta)
	            	    		 System.out.println("Nessuno studente ha i requisiti per lauerarsi ! ");
	            	     
	            	     else 
	            	        {
	            	    	   System.out.println("Vuoi laureare ? ");
	            	    	   String risposta = input3.nextLine();
	            	    	   
	            	    	   switch(risposta) 
	            	    	        {
	            	    	          case  "si" , "SI" , "sì" :
	            	    	        	                       if(cl.promuoviStudente(cl)) 
	            	    	        	                         {
	            	    	        	                    	   System.out.println("Laureati rimossi !");
	            	    	        	                         }
	            	    	        	                        else System.out.println("Errore ");
	            	    	                                    break;
	            	    	          default:
	            	    	        	      System.out.println("Laureati non rimossi ! ");
	            	    	        	                       break;
	            	    	        }
	            	        }
	            	     break;	            	     
	             
	              // Dipende dal 4  
	              case 5:
	            	     for(Studente local : cl.listaStudenti) 
	            	        {
           	    		       System.out.println(local.getNome() + " CREDITI: " + local.getCreditiStudente());	            	    	  
	            	        }
	            	    	 
	            	     if(cl.listaStudenti.isEmpty()) System.out.println("La lista degli studenti è vuota");
	            	     
	            	     break;
	            	     
	              case 6:
	            	     boolean exitConc = true;
	            	     int sceltaConc;
	            	     do 
	            	      {
	            		   System.out.println("1) Per creare un piano di studio per uno studente");
	            		   System.out.println("2) Per aggiungere un esame al piano di studio");
	            		   System.out.println("3) Per rimuovere un esame dal piano di studio");
	            		   System.out.println("4) Per cercare un esame dal piano di studio");
	            		   System.out.println("5) Per promuovere uno studente ad un esame con un voto");
	            		   System.out.println("6) Per visualizzare gli esami effettuati ad uno studente ");	  
	            		   sceltaConc = input1.nextInt();
	            		   
	            		   switch(sceltaConc) 
	            		        {
	            		          case 1:
	            		        	  // Suppongo che lo studente sia ovviamente gia iscritto al corso di laurea 
	            		        	     System.out.println("Inserisci il nome dello studente: ");
	            		        	     String perPianoStudio = input3.nextLine();
	            		        	     int i=0 , conta1 = 1;
	            		        	     for(Studente ss : cl.listaStudenti) 
	            		        	        {
	            		        	    	   if(ss.getNome().equals(perPianoStudio)) 
	            		        	    	     {
	            		        	    		   if(ss.listaEsami.get(i).checkPianoStudio(ss))
	            		        	    		   {
	            		        	    			   // Creo un nuovo piano di studi a questo punto:
	            		        	    			cl.listaStudenti.get(i).listaEsami = new ArrayList<Esame>();;
	            		        	    		   }
	            		        	    			conta1++;
	            		        	    	     }
	            		        	    	   i++;
	            		        	        }
	            		        	     if(cl.listaStudenti.size() == conta1)
	            		        	    	System.out.println("Lo studente non compare nella lista");
	            		        	     break;
	            		          
	            		          case 2:
	            		        	     System.out.println("Nome esame: ");
	            		        	     String nomeEsame = input1.nextLine();
	            		        	     System.out.println("Crediti Esame: ");
	            		        	     int creditiEsame = input2.nextInt();
	            		        	     
	            		        	     int index = 1;
	            		        	     for(Studente s2: cl.listaStudenti) 
	            		        	        {
	            		        	    	int i1=0;
	            		        	    	for(Esame e : cl.listaStudenti.get(index).listaEsami) 
	            		        	    	   {
	            		        	    		 if(!cl.listaStudenti.get(index).listaEsami.get(i1).findEsame(cl.listaStudenti.get(index), nomeEsame))
	            		        	    		  {
	            		        	    			 Esame updateExam = new Esame(nomeEsame, creditiEsame);
	            		        	    			 cl.listaStudenti.get(index).listaEsami.add(updateExam);
	            		        	    		  }
	            		        	    		 i1++;
	            		        	    	   }
	            		        	    	 index++;
	            		        	        }
	            		        	     
	            		        	     break;
	            		        	     
	            		          case 3:
	            		        	     break;
	            		        	     
	            		          case 4:
	            		        	     break;
	            		        	     
	            		          case 5:
	            		        	     break;
	            		         
	            		          case 6:
	            		        	     break;
	            		          
	            		          default:
	            		        	      System.out.println("Inserisci solo i caratteri consentiti ! ");
	            		         
	            		        
	            		        }
	            	      }while(exitConc);
	            	     
	            	    	  break;
	              

	        }

	        System.out.println("");
	        System.out.println("");
	        System.out.println("");
	        
	      }while(exit);
	 }

}

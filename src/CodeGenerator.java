import java.util.*;

public class CodeGenerator {

	/*cognome in input prime tre consonanti in output(controlla quando non ho tre consonanti)
	Se le consonanti sono insufficienti, si prelevano anche le vocali (se sono sufficienti le consonanti si prelevano la prima, 
	la seconda e la terza consonante), sempre nel loro ordine e, comunque, le vocali vengono riportate dopo le consonanti 
	(per esempio: Rosi → RSO). Nel caso in cui un cognome abbia meno di tre lettere, la parte di codice viene completata 
	aggiungendo la lettera X (per esempio: Fo → FOX). 
	Per le donne, viene preso in considerazione il solo cognome da nubile*/
	
	
	
	public StringBuilder surname(String cognome) {  
			List<Character> surn=new ArrayList<Character>(); 
		for(int i=0;i<cognome.length();i++) {
			if ((cognome.charAt(i)!= 'A')&&
					(cognome.charAt(i)!= 'E')&&
						(cognome.charAt(i)!= 'I')&&
							(cognome.charAt(i)!= 'O')&&
								(cognome.charAt(i)!= 'U'))
													 surn.add(cognome.charAt(i));
											}
		if(surn.size()<3) {
			for(int i=0;i<cognome.length();i++) {
				if ((cognome.charAt(i)== 'A')||
						(cognome.charAt(i)== 'E')||
							(cognome.charAt(i)== 'I')||
								(cognome.charAt(i)== 'O')||
									(cognome.charAt(i)== 'U'))
										surn.add(cognome.charAt(i));
												}
						    }
		if(cognome.length()<3) {
			for(int i=0;i<cognome.length();i++) {
				surn.add(cognome.charAt(i));
												}
				surn.add(2,'X');
								}
		
		if(surn.size()>3) {
			surn=surn.subList(0, 3);
						  }
		
		StringBuilder sb=new StringBuilder();
		for(Character s:surn) {
			sb.append(s);
							   }
			return sb;
											   }

	
	
	
	public StringBuilder name(String nome) {  
		List<Character> name=new ArrayList<Character>(); 
	for(int i=0;i<nome.length();i++) {
		if ((nome.charAt(i)!= 'A')&&
				(nome.charAt(i)!= 'E')&&
					(nome.charAt(i)!= 'I')&&
						(nome.charAt(i)!= 'O')&&
							(nome.charAt(i)!= 'U'))
								name.add(nome.charAt(i));
									  }
	if(name.size()>3) {
		name.remove(1);
					   }
	
	if(name.size()<3) {
		for(int i=0;i<nome.length();i++) {
			if ((nome.charAt(i)== 'A')||
					(nome.charAt(i)== 'E')||
						(nome.charAt(i)== 'I')||
							(nome.charAt(i)== 'O')||
								(nome.charAt(i)== 'U'))
									name.add(nome.charAt(i));
										   }
					    }
	if(nome.length()<3) {
		for(int i=0;i<nome.length();i++) {
			name.add(nome.charAt(i));
										  }
			name.add(2,'X');
						}
	if(name.size()>3) {
		name=name.subList(0, 3);
					  }
	StringBuilder sb=new StringBuilder();
		for(Character s:name) {
			sb.append(s);
						       }
	return sb;
										   }
	
	
	//08/01/1998 e M mi ritorna 98 A 08 1)passo 1998 torna 98 2)passo 01 torna A 3)passo 08 torna 08 o 48 4)unisco
	
	
	public String annoNascita (String dataNascita) { //"1998-01-08"
		String anno=dataNascita.substring(2, 4);
		return anno;
	}
		
	
	
	
	public char meseNascita(String dataNascita) {
		String mese=dataNascita.substring(5, 7);
		char lettera=0;
		
		switch(mese) {
		
			case "01":	
				lettera='A';
				break;
			case "02":
				lettera='B';
				break;
			case "03": 
				lettera='C';
				break;
			case "04":	
				lettera='D';
				break;
			case "05":
				lettera='E';
				break;
			case "06": 
				lettera='H';
				break;
			case "07":	
				lettera='L';
				break;
			case "08":
				lettera='M';
				break;
			case "09": 
				lettera='P';
				break;
			case "10":	
				lettera='R';
				break;
			case "11":
				lettera='S';
				break;
			case "12": 
				lettera='T';
				break;
						}
		return lettera; 
		}


	
	public String giornoNascita(String dataNascita,String sex) {
	
		String giorno=dataNascita.substring(8, 10);
		int giornoNum = Integer.parseInt(giorno);
		
		if(sex.equalsIgnoreCase("F")){
			giornoNum=giornoNum+40;
									  }
		String def=String.valueOf(giornoNum);
	
		return def;
															}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//luogo nascita in  input codiceAlfanum in output corrispondente
	//lettera di controllo
	
	
	
	
	
	
	









































































































































}

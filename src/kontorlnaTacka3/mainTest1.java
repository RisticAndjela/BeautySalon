//package kontorlnaTacka3;
//
//import java.time.LocalDateTime;
//import java.time.Month;
//import java.util.ArrayList;
//
//import klase.KarticaLojalnosti;
//import klase.Klijent;
//import klase.Kontejneri;
//import klase.Kozmeticar;
//import klase.Menadzer;
//import klase.Recepcionar;
//import tretmani.TipTretmana;
//import tretmani.Tretman;
//import tretmani.ZakazanTretman;
//
//public class mainTest1 {
//
//	public static void main(String[] args)  {
//		Kontejneri kontejneri=new Kontejneri();
//		
//		Menadzer menadzer1=new Menadzer("Nikola","Nikolic","musko","09845610498","Dubrovnicka 72","nikola","nikola1","srednja skola","11 meseci",20,75000.0);
//		menadzer1.sacuvajMenadzera(kontejneri.menadzeri);
//		
//		Recepcionar recepcionar1=new Recepcionar(menadzer1,"Pera","Peric","musko","0654898564","Ivana Milutinovica 23","pera","pera1","fakultet","7 meseci",13,66000.0);
//		recepcionar1.sacuvajRecepcionara(menadzer1,kontejneri.recepcionari);
//		
//		ArrayList<TipTretmana> tretmaniKozmeticar1=new ArrayList<TipTretmana>();
//		
//		Kozmeticar kozmeticar1=new Kozmeticar(menadzer1,"Sima","Simic","musko","0654898564","Ivana Milutinovica 23","sima","sima1","fakultet","18 meseci",19,62000.0,tretmaniKozmeticar1);
//		kozmeticar1.sacuvajKozemticara(menadzer1,kontejneri.kozmeticari);
//		ArrayList<TipTretmana> tretmaniKozmeticar2=new ArrayList<TipTretmana>();
//		
//		Kozmeticar kozmeticar2=new Kozmeticar(menadzer1,"Zika","Zikic","musko","06984756120","Isak Njutn 91","zika","zika1","srednja skola","22 meseci",14,61000.0,tretmaniKozmeticar2);
//		kozmeticar2.sacuvajKozemticara(menadzer1,kontejneri.kozmeticari);
//		ArrayList<TipTretmana> tretmaniKozmeticar3=new ArrayList<TipTretmana>();
//		
//		Kozmeticar kozmeticar3=new Kozmeticar(menadzer1,"Jadranka","Jovanovic","zensko","0698456123","Galileo Galilej 13","jadranka","jadranka","fakultet","13 meseci",17,57000.0,tretmaniKozmeticar3);
//		kozmeticar3.sacuvajKozemticara(menadzer1,kontejneri.kozmeticari);
//		
//		Klijent klijent1=new Klijent("Milica","Milic","zensko","06298451665","Desanke Maksimovic 256","milica","milica1");
//		klijent1.sacuvajKlijenta(kontejneri.klijenti);
//		Klijent klijent2=new Klijent("Mika","Mikic","musko","0697845618","Ive Andrica 45","mika","mika1");
//		klijent2.sacuvajKlijenta(kontejneri.klijenti);
//		
//		kontejneri.prikaziSveKorisnike();
//		
//		Kozmeticar kozmeticar4=new Kozmeticar();
//		kozmeticar4=kozmeticar3;
//		kozmeticar4.setIme("Jovana");
//		kozmeticar3.izmeniKozmeticara(menadzer1,kozmeticar4, kontejneri.kozmeticari);
//	
//		
//		
//		kozmeticar2.obrisiKozemticara(menadzer1,kontejneri.kozmeticari);
//		
//		kontejneri.prikaziSveKorisnike();
//		
//		
//		
//		
//		TipTretmana tipTretmana1= new TipTretmana("masaza");
//		tipTretmana1.sacuvajTipTretmana(kontejneri.tipoviTretmana);
//		TipTretmana tipTretmana2= new TipTretmana("pedikir");
//		tipTretmana2.sacuvajTipTretmana(kontejneri.tipoviTretmana);
//		TipTretmana tipTretmana3= new TipTretmana("manikir");
//		tipTretmana3.sacuvajTipTretmana(kontejneri.tipoviTretmana);
//		
//		tretmaniKozmeticar1.add(tipTretmana1);
//		tretmaniKozmeticar1.add(tipTretmana3);
//		tretmaniKozmeticar2.add(tipTretmana2);
//		tretmaniKozmeticar3.add(tipTretmana3);
//		Kozmeticar kozmeticar5=kozmeticar1;
//		kozmeticar5.setKozmetickiTretmani(tretmaniKozmeticar1);
//		kozmeticar1.izmeniKozmeticara(menadzer1,kozmeticar5,kontejneri.kozmeticari);
////		Kozmeticar kozmeticar6=kozmeticar2;
////		kozmeticar6.setKozmetickiTretmani(tretmaniKozmeticar2); -----------------------------------------> vec je obrisan kozmeticar2
////		kozmeticar2.izmeniKozmeticara(kozmeticar6, kontejneri.kozmeticari);
//		Kozmeticar kozmeticar7=kozmeticar3;
//		kozmeticar7.setKozmetickiTretmani(tretmaniKozmeticar3);
//		kozmeticar3.izmeniKozmeticara(menadzer1,kozmeticar7, kontejneri.kozmeticari);
//		
//		kontejneri.prikaziSveKozmeticare();
//		
//		Tretman tretman1=new Tretman("Relaks masaza",45,tipTretmana1,2000.0);
//		tretman1.sacuvajTretman(kontejneri.tretmani,kontejneri.tipoviTretmana);
//		Tretman tretman2=new Tretman("Sportska masaza",75,tipTretmana1,2500.0);
//		tretman2.sacuvajTretman(kontejneri.tretmani,kontejneri.tipoviTretmana);
//		Tretman tretman3=new Tretman("Francuski manikir",50,tipTretmana3,1500.0);
//		tretman3.sacuvajTretman(kontejneri.tretmani,kontejneri.tipoviTretmana);
//		Tretman tretman4=new Tretman("Gel lak",80,tipTretmana3,1600.0);
//		tretman4.sacuvajTretman(kontejneri.tretmani,kontejneri.tipoviTretmana);
//		Tretman tretman5=new Tretman("Spa manikir",90,tipTretmana3,2000.0);
//		tretman5.sacuvajTretman(kontejneri.tretmani,kontejneri.tipoviTretmana);
//		Tretman tretman6=new Tretman("Spa pedikir",45,tipTretmana1,1600.0);
//		tretman6.sacuvajTretman(kontejneri.tretmani,kontejneri.tipoviTretmana);
//		
//		kontejneri.prikaziSveTretmane();
//		
//		Tretman tretman7=tretman3;
//		tretman7.setTrajanje(55);
//		tretman3.izmenaTretmana(tretman7,kontejneri.tretmani,kontejneri.tipoviTretmana);
//		Tretman tretman8=tretman6;
//		tretman8.setTip(tipTretmana2);
//		tretman6.izmenaTretmana(tretman8,kontejneri.tretmani,kontejneri.tipoviTretmana);
//		
//		kontejneri.prikaziSveTretmane();
//		
//		tipTretmana2.obrisiTipTretmana(kontejneri.tipoviTretmana, kontejneri.tretmani);
//		
//		kontejneri.prikaziSveTretmane();
//		
//		LocalDateTime datum1 = LocalDateTime.of(2023, Month.MAY, 3, 10, 37, 00);
//		LocalDateTime datum2 = LocalDateTime.of(2023, Month.MAY, 2, 12, 15, 00);
//		LocalDateTime datum3 = LocalDateTime.of(2023, Month.MAY, 1, 15, 30, 00);
//		
//		KarticaLojalnosti karticaLojalnosti=new KarticaLojalnosti(menadzer1,3500.0);//cp3
//		ZakazanTretman zakazan1=new ZakazanTretman(tretmani.Opcije.ZAKAZAN,datum1,kozmeticar1,tretman1,klijent1,karticaLojalnosti);
//		zakazan1.sacuvajZakazanTretman(kontejneri.zakazaniTretmani);
//		ZakazanTretman zakazan2=new ZakazanTretman(tretmani.Opcije.ZAKAZAN,datum2,kozmeticar1,tretman4,klijent2,karticaLojalnosti);
//		zakazan2.sacuvajZakazanTretman(kontejneri.zakazaniTretmani);
//		ZakazanTretman zakazan3=new ZakazanTretman(tretmani.Opcije.ZAKAZAN,datum3,kozmeticar3,tretman5,klijent2,karticaLojalnosti);
//		zakazan3.sacuvajZakazanTretman(kontejneri.zakazaniTretmani);
//		
//		kontejneri.prikaziSveZakazaneTretmane();
//		
//		ZakazanTretman zakazan4=zakazan2;
//		zakazan4.setUsluga(tretman3);
//		zakazan2.izmenaZakazanogTretmana(zakazan4,kontejneri.zakazaniTretmani);
//		
//		kontejneri.prikaziSveZakazaneTretmane();
//		
//		Tretman tretman9=tretman1;
//		tretman9.setCena(1700.0);
//		tretman1.izmenaTretmana(tretman9,kontejneri.tretmani,kontejneri.tipoviTretmana);
//		
//		
//	}
//
//}

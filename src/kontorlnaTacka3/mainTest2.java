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
//import klase.NovcanikSalona;
//import klase.Recepcionar;
//import tretmani.TipTretmana;
//import tretmani.Tretman;
//import tretmani.ZakazanTretman;
//
//public class mainTest2 {
//
//	public static void main(String[] args) {
//		Kontejneri kontejneri=new Kontejneri();
//		NovcanikSalona novcanikSalona=new NovcanikSalona();
//
////		TipTretmana tipTretmana1= new TipTretmana("masaza");
////		tipTretmana1.sacuvajTipTretmana(kontejneri.tipoviTretmana);
////		TipTretmana tipTretmana2= new TipTretmana("pedikir");
////		tipTretmana2.sacuvajTipTretmana(kontejneri.tipoviTretmana);
////		TipTretmana tipTretmana3= new TipTretmana("manikir");
////		tipTretmana3.sacuvajTipTretmana(kontejneri.tipoviTretmana);
////		
////		Menadzer menadzer1=new Menadzer("Nikola","Nikolic","musko","09845610498","Dubrovnicka 72","nikola","nikola1","srednja skola","11 meseci",0,47000.0);
////		menadzer1.sacuvajMenadzera(kontejneri.menadzeri);
////		
////		Recepcionar recepcionar1=new Recepcionar(menadzer1,"Pera","Peric","musko","0654898564","Ivana Milutinovica 23","pera","pera1","fakultet","7 meseci",0,45000.0);
////		recepcionar1.sacuvajRecepcionara(menadzer1,kontejneri.recepcionari);
////		
////		ArrayList<TipTretmana> tretmaniKozmeticar1=new ArrayList<TipTretmana>();
////		tretmaniKozmeticar1.add(tipTretmana1);
////		tretmaniKozmeticar1.add(tipTretmana3);
////		
////		Kozmeticar kozmeticar1=new Kozmeticar(menadzer1,"Sima","Simic","musko","0654898564","Ivana Milutinovica 23","sima","sima1","fakultet","18 meseci",0,42000.0,tretmaniKozmeticar1);
////		kozmeticar1.sacuvajKozemticara(menadzer1,kontejneri.kozmeticari);
////		ArrayList<TipTretmana> tretmaniKozmeticar2=new ArrayList<TipTretmana>();
////		tretmaniKozmeticar2.add(tipTretmana1);
////		tretmaniKozmeticar2.add(tipTretmana2);
////		tretmaniKozmeticar2.add(tipTretmana3);
////		Kozmeticar kozmeticar2=new Kozmeticar(menadzer1,"Zika","Zikic","musko","06984756120","Isak Njutn 91","zika","zika1","srednja skola","22 meseci",0,38000.0,tretmaniKozmeticar2);
////		kozmeticar2.sacuvajKozemticara(menadzer1,kontejneri.kozmeticari);
////		ArrayList<TipTretmana> tretmaniKozmeticar3=new ArrayList<TipTretmana>();
////		tretmaniKozmeticar3.add(tipTretmana3);
////		Kozmeticar kozmeticar3=new Kozmeticar(menadzer1,"Jovana","Jovanovic","zensko","0698456123","Galileo Galilej 13","jadranka","jadranka","fakultet","13 meseci",0,37000.0,tretmaniKozmeticar3);
////		kozmeticar3.sacuvajKozemticara(menadzer1,kontejneri.kozmeticari);
////		kontejneri.prikaziSveKozmeticare();
////		
////		Klijent klijent1=new Klijent("Milica","Milic","zensko","06298451665","Desanke Maksimovic 256","milica","milica1");
////		klijent1.sacuvajKlijenta(kontejneri.klijenti);
////		Klijent klijent2=new Klijent("Mika","Mikic","musko","0697845618","Ive Andrica 45","mika","mika1");
////		klijent2.sacuvajKlijenta(kontejneri.klijenti);
////		
////		
////		
////		
////	
////		
////		Tretman tretman1=new Tretman("Relaks masaza",45,tipTretmana1,2000.0);
////		tretman1.sacuvajTretman(kontejneri.tretmani,kontejneri.tipoviTretmana);
////		Tretman tretman2=new Tretman("Sportska masaza",75,tipTretmana1,2500.0);
////		tretman2.sacuvajTretman(kontejneri.tretmani,kontejneri.tipoviTretmana);
////		Tretman tretman3=new Tretman("Francuski manikir",50,tipTretmana3,1500.0);
////		tretman3.sacuvajTretman(kontejneri.tretmani,kontejneri.tipoviTretmana);
////		Tretman tretman4=new Tretman("Gel lak",80,tipTretmana3,1600.0);
////		tretman4.sacuvajTretman(kontejneri.tretmani,kontejneri.tipoviTretmana);
////		Tretman tretman5=new Tretman("Spa manikir",90,tipTretmana3,2000.0);
////		tretman5.sacuvajTretman(kontejneri.tretmani,kontejneri.tipoviTretmana);
////		Tretman tretman6=new Tretman("Spa pedikir",45,tipTretmana2,1600.0);
////		tretman6.sacuvajTretman(kontejneri.tretmani,kontejneri.tipoviTretmana);
////		
////		KarticaLojalnosti karticaLojalnosti=new KarticaLojalnosti(menadzer1,3500.0);
////		System.out.println(karticaLojalnosti.napraviString());
////		
////		//---------------------------funkcionalnost kp2
////		
////		LocalDateTime datum1 = LocalDateTime.of(2023, Month.JUNE, 10, 18, 00, 00);
////		LocalDateTime datum2 = LocalDateTime.of(2023, Month.JUNE, 11, 9, 00, 00);
////		LocalDateTime datum3 = LocalDateTime.of(2023, Month.JUNE, 12, 8, 00, 00);
////		LocalDateTime datum4 = LocalDateTime.of(2023, Month.JUNE, 13, 19, 00, 00);
////		
////		//Milica Milić vrši online zakazivanje francuskog manikira i bira kozmetičara 3 u terminu 10.6.2023, 18:00h. 
////		ZakazanTretman zakazan1=new ZakazanTretman(tretmani.Opcije.ONLINE_ZAKAZIVANJE,datum1,kozmeticar3,tretman3,klijent1,karticaLojalnosti);
////		zakazan1.sacuvajZakazanTretman(kontejneri.zakazaniTretmani);
////		
////		//Zatim, Milica Milić vrši zakazivanje spa pedikira preko recepcionera i bira kozmetičara 2 u terminu 11.06.2023, 09:00h. 
////		ZakazanTretman zakazan2=new ZakazanTretman(tretmani.Opcije.ZAKAZAN,datum2,kozmeticar2,tretman6,klijent1,karticaLojalnosti);
////		zakazan2.sacuvajZakazanTretman(kontejneri.zakazaniTretmani);
////		
////		//Mika Mikić vrši online zakazivanje sportske masaže i bira kozmetičara 1 u terminu 12.6.2023, 08:00h.
////		ZakazanTretman zakazan3=new ZakazanTretman(tretmani.Opcije.ONLINE_ZAKAZIVANJE,datum3,kozmeticar1,tretman2,klijent2,karticaLojalnosti);
////		zakazan3.sacuvajZakazanTretman(kontejneri.zakazaniTretmani);
////		
////		//Zatim, Mika vrši zakazivanje relaks masaže preko recepcionera i bira kozmetičara 2 u terminu 13.06.2023, 19:00h. 
////		ZakazanTretman zakazan4=new ZakazanTretman(tretmani.Opcije.ZAKAZAN,datum4,kozmeticar2,tretman1,klijent2,karticaLojalnosti);
////		zakazan4.sacuvajZakazanTretman(kontejneri.zakazaniTretmani);
////		
////		//Zatim Mika pokušava da izvrši zakazivanje francuskog manikira i bira kozmetičara 3 u terminu 10.6.2023, 18:00h, ali neuspešno jer je taj termin i kozmetičar nisu dostupni.
////		ZakazanTretman zakazan5=new ZakazanTretman(tretmani.Opcije.ONLINE_ZAKAZIVANJE,datum1,kozmeticar3,tretman3,klijent2,karticaLojalnosti);
////		zakazan5.sacuvajZakazanTretman(kontejneri.zakazaniTretmani);
////		kontejneri.prikaziSveZakazaneTretmane();
////		
////		kozmeticar2.rasporedKozmeticara(kontejneri.zakazaniTretmani);
////		
////		System.out.println();
////		
////		zakazan1.tretmanJeIzvrsen(kontejneri.zakazaniTretmani, novcanikSalona);
////		if(klijent1.pravoNaLojaltiKarticu(karticaLojalnosti)) {
////			System.out.println("Klijent: "+klijent1.getIme()+klijent1.getPrezime()+"ima pravo na lojalti karticu koja donosi 10% popusta, jer je potrosio "+klijent1.getPotrosioUSalonu());
////		}
////		//zakazan2.tretmanJeOtkazaoKljient(kontejneri.zakazaniTretmani, novcanikSalona);
////		//zakazan3.tretmanJeOtkazaoSalon(kontejneri.zakazaniTretmani,novcanikSalona);
////		//zakazan4.klijentSeNijePojavio(kontejneri.zakazaniTretmani, novcanikSalona);
////		
////		LocalDateTime datum5 = LocalDateTime.of(2023, Month.JUNE, 14, 9, 00, 00);
////		ZakazanTretman zakazan6=new ZakazanTretman(tretmani.Opcije.ONLINE_ZAKAZIVANJE,datum5,kozmeticar1,tretman4,klijent1,karticaLojalnosti);
////		zakazan6.sacuvajZakazanTretman(kontejneri.zakazaniTretmani);
////		
////		ArrayList<Kozmeticar> kozmeticariKopija=new ArrayList<Kozmeticar>();
////		kozmeticariKopija.addAll(kontejneri.kozmeticari);
////		Kozmeticar kozmeticarRandom= kontejneri.giveKozmeticarWithObuka(tretman4,datum5,kozmeticariKopija);
////		ZakazanTretman zakazan7=new ZakazanTretman(tretmani.Opcije.ONLINE_ZAKAZIVANJE,datum5,kozmeticarRandom,tretman4,klijent2,karticaLojalnosti);
////		zakazan7.sacuvajZakazanTretman(kontejneri.zakazaniTretmani);
////		
////		zakazan7.tretmanJeIzvrsen(kontejneri.zakazaniTretmani,novcanikSalona);
////		
////		
////		klijent2.kompletanPregled(karticaLojalnosti, kontejneri.zakazaniTretmani);
////		
////		
//		//novcanikSalona.sviPrihodiIRashodiUJM(Month.JUNE, kontejneri.kozmeticari, kontejneri.menadzeri, kontejneri.recepcionari);
//		for(String i:novcanikSalona.getRashodiLista()) {
//			System.out.println(i);
//		}
////		Kozmeticar kozmeticarizmena=kozmeticar2;
////		kozmeticarizmena.setBonus(10);
////		kozmeticar2.izmeniKozmeticara(menadzer1, kozmeticarizmena, kontejneri.kozmeticari);
////		
////		System.out.println("----------------PLATE I BONUSI-------------");
////		for(Menadzer menadzer:kontejneri.menadzeri) {
////			System.out.println("Menadzer "+menadzer.getIme()+" "+menadzer.getPrezime()+"ima bonus "+menadzer.getBonus()+"% i platu:"+menadzer.getKonacnaPlata());
////		}
////		for(Recepcionar recepcionar:kontejneri.recepcionari) {
////			System.out.println("Recepcionar "+recepcionar.getIme()+" "+recepcionar.getPrezime()+"ima bonus "+recepcionar.getBonus()+"% i platu:"+recepcionar.getKonacnaPlata());
////		}
////		for(Kozmeticar kozmeticar:kontejneri.kozmeticari) {
////			System.out.println("Kozmeticar "+kozmeticar.getIme()+" "+kozmeticar.getPrezime()+"ima bonus "+kozmeticar.getBonus()+"% i platu:"+kozmeticar.getKonacnaPlata());
////		}
////		
//	}
//
//}

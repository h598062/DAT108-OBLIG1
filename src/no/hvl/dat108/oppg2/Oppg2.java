package no.hvl.dat108.oppg2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Oppg2 {
	public static void main(String[] args) {
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt("Eren", "Akat", Kjonn.EREN, "dommer", 100000),
				new Ansatt("Kristian", "Bell", Kjonn.MANN, "sjef", 5),
				new Ansatt("Christopher", "Rojas", Kjonn.ANNET, "lærling", 122000),
				new Ansatt("Storm", "Sangolt", Kjonn.EREN, "uvær", 500000),
				new Ansatt("Bjørnar", "Helgeland", Kjonn.MANN, "nederst", 12),
				new Ansatt("Hollie", "Buchanan", Kjonn.ANNET, "profesjonell tigger", 6),
				new Ansatt("Robin", "Giskegjerdet", Kjonn.KVINNE, "boms", 1)
				);

		Consumer<Ansatt> prosentForMenn = ansatt -> {
			if (ansatt.getKjonn() == Kjonn.MANN) {
				ansatt.setAarslonn((int)(ansatt.getAarslonn() * 1.7));
			}
		};
		Consumer<Ansatt> kronetillegg = ansatt -> ansatt.setAarslonn(ansatt.getAarslonn() + 70000);

		Consumer<Ansatt> prosenttillegg = ansatt -> ansatt.setAarslonn((int)(ansatt.getAarslonn() * 1.05));

		Consumer<Ansatt> lavlonntillegg = ansatt -> {
			if (ansatt.getAarslonn() < 50000){
				ansatt.setAarslonn(ansatt.getAarslonn() + 1000);
			}
		};
		System.out.println(ansatte);
		System.out.println("Lavlønnstillegg:");
		lonnsoppgjor(ansatte, lavlonntillegg);
		System.out.println(ansatte);
		System.out.println("Legge til prosenter for menn:");
		lonnsoppgjor(ansatte, prosentForMenn);
		System.out.println(ansatte);
		System.out.println("Fast kronetillegg:");
		lonnsoppgjor(ansatte, kronetillegg);
		System.out.println(ansatte);
		System.out.println("Fast prosenttillegg:");
		lonnsoppgjor(ansatte, prosenttillegg);
		System.out.println(ansatte);
	}
	private static void lonnsoppgjor(List<Ansatt> ansatte, Consumer<Ansatt> metode){
		ansatte.forEach(metode);
	}
}

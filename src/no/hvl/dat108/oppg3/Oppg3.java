package no.hvl.dat108.oppg3;

import no.hvl.dat108.oppg2.Ansatt;
import no.hvl.dat108.oppg2.Kjonn;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Oppg3 {
	public static void main(String[] args) {
		List<Ansatt> ansatte = Arrays.asList(new Ansatt("Eren", "Akat", Kjonn.EREN, "dommer", 100000),
				new Ansatt("Kristian", "Bell", Kjonn.MANN, "sjef", 500), new Ansatt("Christopher", "Rojas", Kjonn.ANNET, "lærling", 122000),
				new Ansatt("Storm", "Sangolt", Kjonn.EREN, "uvær", 500000), new Ansatt("Bjørnar", "Helgeland", Kjonn.MANN, "nederst", 12),
				new Ansatt("Hollie", "Buchanan", Kjonn.ANNET, "profesjonell tigger", 6),
				new Ansatt("Robin", "Giskegjerdet", Kjonn.KVINNE, "boms", 1));

		// a
		List<String> etternavn = ansatte.stream()
		                                .map(Ansatt::getEtternavn)
		                                .toList();
		System.out.println(etternavn);

		// b
		long kvinner = ansatte.stream()
		                      .filter(a -> a.getKjonn() == Kjonn.KVINNE)
		                      .count();
		System.out.println("Antall kvinner: " + kvinner);

		// c
		OptionalDouble lonnKvinnerAvg = ansatte.stream()
		                                       .filter(a -> a.getKjonn() == Kjonn.KVINNE)
		                                       .map(Ansatt::getAarslonn)
		                                       .mapToInt(Integer::intValue)
		                                       .average();
		System.out.println(lonnKvinnerAvg.isPresent() ? "Kvinners gjennomsnitt lønn: " + lonnKvinnerAvg.getAsDouble()
		                                              : "Fant ingen gjennomsnittslønn for kvinner");

		// d
		ansatte.stream()
		       .filter(a -> a.getStilling()
		                     .equals("sjef"))
		       .forEach(a -> a.setAarslonn((int) (a.getAarslonn() * 1.07)));
		System.out.println(ansatte);

		// e
		boolean tjenerMerEnn800k = ansatte.stream()
		                                  .anyMatch(a -> a.getAarslonn() >= 800000);
		System.out.println("Er det noen som tjener mer enn 800k? " + (tjenerMerEnn800k ? "Ja" : "Nei"));

		// f
		ansatte.forEach(System.out::println);

		// g
		//Collections.sort(ansatte, (a, b) -> a.getAarslonn() - b.getAarslonn());
		Collections.sort(ansatte, Comparator.comparingInt(Ansatt::getAarslonn));
		System.out.println("Ansatt med minst lønn: " + ansatte.get(0));
		System.out.println("Alle ansatte sortert etter lønn, stigende rekkefølge:\n" + ansatte);

		// h
		int isum = IntStream.range(1, 1000)
		                    .filter(x -> x % 3 == 0 || x % 5 == 0)
		                    .sum();
		System.out.println("Sum av tall delelig med 3 og 5 mellom 1 og 1000: " + isum);

	}
}

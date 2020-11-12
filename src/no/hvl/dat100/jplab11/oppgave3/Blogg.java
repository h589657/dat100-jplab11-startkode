package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		int antall = 0;
		while (antall < innleggtabell.length && innleggtabell[antall] != null) {
			antall++;
		}
		return antall;

	}

	public Innlegg[] getSamling() {
		return innleggtabell;

	}

	public int finnInnlegg(Innlegg innlegg) {

		boolean funnet = false;
		int pos = 0;
		while (pos < nesteledig && !funnet) {
			if (innleggtabell[pos].erLik(innlegg))
				funnet = true;
			else
				pos++;
		}
		if (funnet)
			return pos;
		else
			return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		boolean finnes = false;
		for (int i = 0; i < getAntall(); i++) {
			if (innlegg.getId() == innleggtabell[i].getId()) {
				finnes = true;
				break;
			}
		}
		return finnes;
	}

	public boolean ledigPlass() {
		boolean ledig = true;
		if (getAntall() == innleggtabell.length)
			ledig = false;
		return ledig;

	}

	public boolean leggTil(Innlegg innlegg) {

		boolean ny = finnInnlegg(innlegg) == -1;
		if (ny && nesteledig < innleggtabell.length) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		} else
			return false;

	}

	public String toString() {

		String s = getAntall() + "\n";
		for (int i = 0; i < getAntall(); i++) {
			s += innleggtabell[i].toString();
		}
		return s;
	}

}

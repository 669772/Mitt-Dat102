package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start() {
        Film f1 = new Film(1,"dreamWorks","pus med støvler",2023,Sjanger.ACTION,"dreamWorks");
        Film f2 = new Film(2,"disney","laidy Og landstrykeren",1600,Sjanger.HISTORY,"disney");
        Film f3 = new Film(3,"pixar","nemo",2010,Sjanger.ACTION,"disney");
        Film f4 = new Film(4,"Pixar","the abc",2010,Sjanger.ACTION,"disney");
        Film f5 = new Film(5,"pixar","the abc",2010,Sjanger.ACTION,"disney");

        filmarkiv.leggTilFilm(f1);
        filmarkiv.leggTilFilm(f2);
        filmarkiv.leggTilFilm(f3);
        filmarkiv.leggTilFilm(f4);
        filmarkiv.leggTilFilm(f5);

        Filmarkiv filma = (Filmarkiv) filmarkiv;
        
        tekstgr.setArkiv(filma);
        
        tekstgr.skrivUtStatistikk(filmarkiv);
        Film valg = tekstgr.lesFilm();
        
        tekstgr.visFilm(valg);
    }
}
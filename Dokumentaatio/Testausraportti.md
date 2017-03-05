## Testausraportti

Ohjelma on pyritty testaamaan mahdollisimman kattavasit JUnit-testien ja PIT-raportin avulla, mutta satunnaismuuttujat aiheuttivat vaikeuksia erityisesti Asteroid- ja EventHandler-luokkien tapauksissa.

### Asteroid-luokka

Asteroid-luokassa on arvottu asteroideille nopeuden x- ja y-komponentit, pyörimisnopeus ja kaikkien näiden suunta. Nopeuksille on määritelty maksimi- ja minimiarvot, ja suunnissa hyödynnetään arvottua totuusarvoa. Nämä arvot on keksitty lähinnä kokeilemalla ajaa itse peliä.

### EventHandler-luokka

EventHandler-luokan testaamiseen vaikeuteen vaikuttaa asteroidien satunnaisgenerointi. Ne sijoitetaan satunnaisesit ympäri pelikenttää. Tässä käytetään kuitenkin apuna AsteroidSpawner-luokkaa, joka varmistaa, ettei asteroidi synny pelaajan aluksen päälle tai aivan viereen.
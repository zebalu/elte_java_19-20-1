# Egészségügy

A feladat során egy Egészségügyi rendszert fogunk fejleszteni.

## 1. Lexikon

Készíts egy `hc.knowledge.Lexicon` osztályt. A lexikonnak legyen egy `getCureFor` nevű statikus metódusa, mely egy `String` paramétert vár, és `String`-gel tér vissza. Legyen képes az alábbi válaszok megadására:

| input          | output       |
|----------------|--------------|
| headache       | aspirin      |
| sore throat    | warm tea     |
| sprained ankle | rest         |
| influenza      | no medicine  |
| running nose   | paper tissue |

Minden esetben, ha nem a felsorolt inputok egyikét küldik be a `getCureFor` metódusba, adja vissza a `No known cure` üzenetet.

Legyen egy `hasCure` statikus metódus ami egy `String`-et vár, és `true` értékkel tér vissza, ha a lexikonban van gyógymód az adott betegséghez. 

## 2. Orvos

Készíts egy `hc.doctor.Stamp` osztályt, ami egy orvosi bélyegzőt reprezentál. Legyen egy `registrationNumber` adattagja, ami egy rejtett, megváltoztathatatlan egész szám. A bélyegző `String`-é alakítva legyen: `rn: <registrationNumber>`. A `hc.doctor.Stamp` konstructora csak a `hc.doctor` package-ből legyen elérhető.

Készíts egy `hc.doctor.Doctor` osztályt, melyre az alábbiak iagazak:
* minden `hc.doctor.Doctor` rendelkezik egy rejtett, nem megváltoztatható `name` adattaggal, amit egy `String` reprezentál
* minden `hc.doctor.Doctor` rendelkezik, egy rejtett, nem megváltoztatható `stamp` adattaggal, amit egy `hc.doctor.Stamp` reprezentál
* a `Doctor` objektumok `String`-é alakítva tartalmazzák az orovos nevét és a bélyegzőjük `String` reprezentánsát egy szóközzel elválasztva. Például: `Dr. Ross Geller rn: 123`
* a `hc.doctor.Doctor` osztály konstruktora csak a leszármazottak számára legyen elérhető, és paraméterül várjon egy nevet és egy bélyegzőt (`name` és `stamp`) 
* A `Doctor` osztály rendelkezzen egy `canCure` metódussal, mely egy `String`-et vár bemenő paraméterül, és egy `boolean` értéket ad vissza, annak megfelelően, hogy az adott betegségre létezik-e gyógymód a `Lexicon`-ban
* a `Doctor` osztály rendelkezzen egy `cure` metódussal, mely két bemenő `String` paraméteret vár: a beteg neve és a betegség neve. A visszatérési értéke: `<beteg neve> should take: <gyógymód>\nsign: <name>\nstamp: <stamp>`. Ahol a `<beteg neve>` a paraméterül kapott beteg név, a `<gyógymód>` a Lexiconban található gyógymód a betegségre. A `\n` sortörést jelöl. A `<name>` mező az orvos neve, a `stamp` pedig a `Stamp` objektuk `String`-e alakítva. Pl.: 

      Peter Pan should take: aspirin
      sign: Dr. A. Kula
      rn: 66
      
amennyiben nincs ismert gyógymód a betegségre, a visszatérési érték legyen: `No known cure`

Készíts egy __nem ellenőrzött__ kivételt: `hc.doctor.RegistrationNumberIsAlreadyTakenException`, ami konstruktorában egy `Doctor`-t vár, és az üzenete `Registration number is already taken by: <Doctor>`, ahol a`<Doctor>` a pareméterül kapott orovos `String`-é alakítva.

Készíts egy `hc.doctor.DoctroNominator` osztályt, aminek egyetlen statikus metódusa legyen a `nominate` függvény, mely egy `Doctor` objektummal tér vissza, és bemenő paraméterként egy nevet (`String`), és egy regisztrációs számot vár.

A `nominate` metódus dobjon `RegistrationNumberIsAlreadyTakenException`-t, ha olyan regisztrációs számmal akarnak orvost létrehozni, amivel egyszer már hoztak létre egy orvost.

## 3. Kutató

Készítsd el a `hc.university.Researcher` interface-t. A `Researcher` egyetlen `findCure` metódussal rendelkezzen, mely `String`-et ad vissza, és egy `String`-et vár paraméterül.

Készíts egy `hc.doctor.ResearcherDoctor` nevű osztályt, mely a `hc.doctor.Doctor` osztályt terjeszti ki és a `hc.doctor.ResearcherDoctor` interfacet implementálja. A `ResearcherDoctor` tartsa számon hány gyógymódot fejlesztett eddig ki, amit tároljon egy rejtett `researchCounter` változóban. A `ResearcherDoctor` a `findCure` metódus ismert betegségekre adja vissza a `Lexicon`-ban található gyógymódot, ismeretlen betegségek esetén pedig:
* növelje eggyel a `researchCounter` értékét
* fejlesszen ki egy új gyógymódot (a viasszadott üzenet legyen `cure - <Doctor> - <researchCounter>`, ahol a `<Doctor>` az orvos `String` reprezentánsa, a `<researchCounter>` pedig a a kikutatott gyógymódok sorszáma. Pl.: `cure - Dr. Drake Ramore rn: 8128 - 1`
* az új gyógymódot jegyezze fel a `Lexicon`-ba. (Ehhez adj hozzá egy statikus `registerCure` metódust a `Lexicon` osztályhoz, ami két `String` paramétert vár (a betegség neve, és a gyógymód)).

A `ResearcherDoctor` minden esetben válaszoljon `true` értékkel, ha megkérdezik tőle, meg tud-e gyógyítani egy betegséget.

Egészíts ki a `hc.doctor.DoctorNominator` osztályt egy `nominateResearcher` metódussal, melyre ugyanazon szabályok vontakoznak, mint a `nominate` metódusra, de `ResearcherDoctor` típusú objektumokat gyárt. __Figyelem__: `ResearcherDoctor` -ok sem rendelkezhetnek ugyanazon pecséttel, mint egy sima `Doctor`.

Ha a `ResearcherDoctor`-on meghívják a `cure` metódust egy eddig ismeretlen betegséggel, akkor először kutassa ki a gyógymódot, majd járjon el úgy, mint a `Doctor` osztály.

## 4. Kórház

Készíts egy `hc.institute.Hospital` osztályt, mely egy generikus paraméterrel rendelkező osztály. Biztosítsd, hogy a generikus paraméternek csak a `Doctor` osztályt, vagy annak valamely leszármazottját lehessen beállítani. A `Hospital`-oknak legyen egy rejtett `doctors` adattagja, aminek a típusa legyen `java.util.List`, és az ott dolgozó orvosokat tartalmazza. A `doctors` lista generikus paramétere egyezzen meg a `Hospital` generikus paraméterével.

Az objectumoknak 2 metódusa legyen:
* `addDoctor` ami egy generikusnak megfelelő típusú objektumot vár paraméterül, és felveszi a `doctors` listába.
* `cure` mely egy beteg nevét és a betegség nevét várja paraméterül és egy `boolean` értékkel tér vissza, és keres egy olyan orovost a `doctors` listában, aki tudja gyógyítani a betegséget, meghívja rajta a `cure` metódust, majd visszatér `true` értékkel. Ha nem talál ilyen orvost, akkor térjen vissza `false` értékkel.

## 5. Kutató kórház

Készítsd el a `hc.institute.ResearchHospital` osztályt, ami a `Hospital` osztály speciális leszármazottja, nincs generikus paramétere, és csak `ResearcherDoctor`-okat lehet hozzáadni.
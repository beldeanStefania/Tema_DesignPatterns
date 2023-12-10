Tema proiect: Rest API
Am simulat call-uri de endpoint-uri rest demonstrand pattern-ul singleton si factory.
Singleton se observa prin faptul ca la fiecare call pentru entitatea logger, rezultatul va fi mereu acelasi si anume un singur logger, demonstrand unicitatea specifica designului.
Factory se realizeaza prin o entitate employee ce contine o alta entitate laptop. Utilizatorul va specifica tipul laptopului in body ul unui request de post iar in baza de date
se va salva un obiect de tipul respectiv prin ajutorul factory ului respectiv.

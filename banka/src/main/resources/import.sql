insert into valuta (id, drzava, naziv, skraceni_naziv) values (1, "Srbija", "Dinar", "RSD");
insert into valuta (id, drzava, naziv, skraceni_naziv) values (2, "Amerika", "Dolar", "USD");
insert into valuta (id, drzava, naziv, skraceni_naziv) values (3, "Hrvatska", "Kuna", "HRK");
insert into valuta (id, drzava, naziv, skraceni_naziv) values (4, "Velika Britanija", "Funta", "GBP");
insert into valuta (id, drzava, naziv, skraceni_naziv) values (5, "Nemacka", "Evro", "EUR");
insert into valuta (id, drzava, naziv, skraceni_naziv) values (6, "Svajcarska", "Franak", "CHF");


insert into delatnost (id, naziv, sifra) values (1, "poljoprivreda", "PD");
insert into delatnost (id, naziv, sifra) values (2, "informacione tehnologije", "IT");
insert into delatnost (id, naziv, sifra) values (3, "gradjevina", "GR");
insert into delatnost (id, naziv, sifra) values (4, "Elektronika", "EL");
insert into delatnost (id, naziv, sifra) values (5, "Student", "ST");

insert into banka (id, adresa, fax, naziv_banke, obracunski_racun, sifra_banke, swift_kod, telefon, web) values (1,"12 KRALJA PETRA, BEOGRAD", "011-3338-588", "NARODNA BANKA","160-6946203357436-CC", "160","NBSRRSBG","011-3338-000","www.nbs.rs");
insert into banka (id, adresa, fax, naziv_banke, obracunski_racun, sifra_banke, swift_kod, telefon, web) values (2,"Milentija Popovica 7 b, 11070 Novi Beograd ", "011-201-1207", "BANKA INTESA","160-3246601037432-CC","860","DBDBRSBG","011-201-1200","www.bancaintesa.rs");
insert into banka (id, adresa, fax, naziv_banke, obracunski_racun, sifra_banke, swift_kod, telefon, web) values (3,"Bulevar oslobodjenja 5, 21000 Novi Sad", "021-480-97008", "ERSTE BANKA","160-37246601037222-CC","340","GIBARS22","0080-0201201","www.erstebank.rs");
insert into banka (id, adresa, fax, naziv_banke, obracunski_racun, sifra_banke, swift_kod, telefon, web) values (4,"Svetog Save 14, 11000 Beograd", "011-344-1335", "KOMERCIJALNA BANKA","160-1236561987733-CC","840","KOBBRSBG","011-308-0100","www.kombank.com");
insert into banka (id, adresa, fax, naziv_banke, obracunski_racun, sifra_banke, swift_kod, telefon, web) values (5,"Milutina Milankovica 17, 11070 Novi Beograd", "011-207-7900", "PROCREDIT BANK","160-5642146747499-CC","780","PRCBRSBG","011-205-7000","www.procreditbank.rs");


/*
 NLB BANKA AD BEOGRAD
Adresa:	Bulevar Mihajla Pupina 165 v, 11070 Novi Beograd 
Telefon:	(381)11-222-5100,222-5118 
Fax:	(381)11-222-5194,313-9740 
Veb sajt:	www.nlb.rs 
SWIFT:	CONARS22 

 
  OTP BANKA SRBIJA AD NOVI SAD
Adresa:	Trg slobode 5, 21000 Novi Sad 
Telefon:	(381)21-480-0001,080-0232322 
Fax:	(381)21-480-0032 
Veb sajt:	www.otpbanka.rs 
SWIFT:	OTPVRS22 
    
    
  SBERBANK SRBIJA AD BEOGRAD
Adresa:	Bulevar Mihajla Pupina 165 g, 11070 Novi Beograd 
Telefon:	(381)11-225-7498,201-7098 
Fax:	(381)11-201-7056 
Veb sajt:	www.sberbank.rs 
SWIFT:	SABRRSBG   
*/


insert into klijent (id, adresa, email, fizicko_lice, ime, jmbg, prezime, telefon, delatnost_id) values (1,"Zeleznicka 12","user@gmail.com",0,"Zeljko","1111111111111","Zeljkovic","0648452981",5);
insert into klijent (id, adresa, email, fizicko_lice, ime, jmbg, prezime, telefon, delatnost_id) values (2,"Klisa 01","user@gmail.com",1,"Petar","2222222222222","Petrovic","0649269999",4);
insert into klijent (id, adresa, email, fizicko_lice, ime, jmbg, prezime, telefon, delatnost_id) values (3,"Savska 06","user@gmail.com",0,"Mirko","3333333333333","Zeljkovic","0648452252",5);
insert into klijent (id, adresa, email, fizicko_lice, ime, jmbg, prezime, telefon, delatnost_id) values (4,"Dobre Jovanovica 45","user@gmail.com",1,"Slavko","4444444444444","Nenadovic","0649275981",3);
insert into klijent (id, adresa, email, fizicko_lice, ime, jmbg, prezime, telefon, delatnost_id) values (5,"Futoska 89","user@gmail.com",0,"Nikola","5555555555555","Nikolic","0643269789",5);


insert into racun (id, aktivan, broj_racuna, datum_kreiranja, rezevisan_iznos, stanje_racuna, banka_id, klijent_id, valuta_id, odobren) values (1,true,"860-2781286591543-CC","2022-01-21",0,0,2,1,1,true,);
insert into racun (id, aktivan, broj_racuna, datum_kreiranja, rezevisan_iznos, stanje_racuna, banka_id, klijent_id, valuta_id, odobren) values (2,true,"340-7902760922375-CC","2022-01-21",0,0,3,2,1,true);
insert into racun (id, aktivan, broj_racuna, datum_kreiranja, rezevisan_iznos, stanje_racuna, banka_id, klijent_id, valuta_id, odobren) values (3,true,"840-7440544260342-CC","2022-01-21",0,0,4,3,1,true);
insert into racun (id, aktivan, broj_racuna, datum_kreiranja, rezevisan_iznos, stanje_racuna, banka_id, klijent_id, valuta_id, odobren) values (4,true,"780-4860276123465-CC","2022-01-21",0,0,5,4,1,true);
insert into racun (id, aktivan, broj_racuna, datum_kreiranja, rezevisan_iznos, stanje_racuna, banka_id, klijent_id, valuta_id, odobren) values (5,true,"160-7946603057135-CC","2022-01-21",0,0,1,5,1,true);

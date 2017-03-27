Sample story

Narrative:
In order to aby przetestować parametry w kalkulatorze
As a student
I want to użyje BDD do kalkulatora
					 
Scenario:  Dodawanie z parametrem
Given Mamy kalkulator
When Dodamy liczby 5 i 3
Then Wynik dodawania 8

Scenario:  Mnozenie z ujemnym parametrem
Given Mamy kalkulator
When Mnoze liczby 3 i -5
Then Wynik mnozenia -15

Scenario:  Mnozenie ujemnej z zerem
Given Mamy kalkulator
When Teraz mnoze liczbe -10 i liczbe 0
Then Mnozenie przez 0
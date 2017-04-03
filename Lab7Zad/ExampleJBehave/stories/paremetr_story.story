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

Scenario:  Scenariusz dodawania z parametrem
Given Mamy kalkulator
When Dodamy liczby <x> i <y>
Then Wynik dodawania <sum>

Examples:
|x|y|sum|
|1|2|3|
|7|5|12|
|4|2|6|
|8|7|15|
|-5|2|-3|

Scenario:  Scenariusz mnozenia z parametrem
Given Mamy kalkulator
When Mnoze liczby <x> i <y>
Then Wynik mnozenia <multiply>

Examples:
|x|y|multiply|
|1|2|2|
|7|5|35|
|4|2|8|
|-5|2|-10|
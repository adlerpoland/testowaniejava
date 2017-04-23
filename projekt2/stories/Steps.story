Scenario:  Ustawienie statku
Given Inicjujemy mape oraz statek z kierunkiem N w pozycji startowej
When Ustawimy pozycje statku na x=5,y=5
Then Statek bedzie w pozycji x=5,y=5

Scenario:  Obrocenie statku
Given Inicjujemy mape oraz statek z kierunkiem N w pozycji startowej
When Ustawiamy kierunek statku na E
Then Statek bedzie obrocony w kierunku E

Scenario:  Statek plynie do przodu
Given Inicjujemy mape oraz statek z kierunkiem N w pozycji startowej
When Poplyniemy statkiem do przodu
Then Statek bedzie w pozycji x=0,y=1

Scenario:  Statek plynie do tylu
Given Inicjujemy mape oraz statek z kierunkiem N w pozycji srodkowej
When Poplyniemy statkiem do tylu
Then Statek bedzie w pozycji x=8,y=7

Scenario:  Statek plynie i skreca w prawo
Given Inicjujemy mape oraz statek z kierunkiem N w pozycji startowej
When Poplyniemy statkiem do przodu skrecimy w prawo i poplyniemy
Then Statek bedzie w pozycji x=1,y=1
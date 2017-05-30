Scenario:  Nieudane logowanie
Given Mamy strone i przegladarke chrome
When Wprowadzamy zle dane i wysylamy
Then Jestesmy niezalogowani

Scenario:  Udane logowanie
Given Mamy strone i przegladarke chrome
When Wprowadzamy poprawne dane i wysylamy
Then Jestesmy zalogowani na konto

Scenario:  Udane logowanie
Given Mamy strone i przegladarke chrome
When Wprowadzamy inne poprawne dane i wysylamy
Then Jestesmy zalogowani na inne konto
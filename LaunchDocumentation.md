# Instrukcja uruchomienia aplikacji

**Szczegółowa instrukcja uruchomienia aplikacji znajduje się [tutaj](https://github.com/szymonpogwizd/spogwizd_jporeba_cantabo_manager/blob/main/LaunchDocumentation.pdf)**

## Wymagania wstępne
- InteliJ IDEA
- PostgreSQL i pgAdmin
- Node.js

## Instalacja
1. Pobierz projekt backendowy: [link do repozytorium](https://github.com/szymonpogwizd/spogwizd_jporeba_cantabo_manager)
2. Otwórz projekt w InteliJ IDEA
3. Ustaw wersję Java na 17
4. Uruchom projekt

## Konfiguracja bazy danych
1. Zainstaluj PostgreSQL i pgAdmin
2. Utwórz użytkownika 'cantaboAPI' o haśle 'cantaboAPI123!@#'
3. Utwórz nową bazę danych o nazwie 'cantabo' i ustaw 'cantaboAPI' jako właściciela

## Uruchomienie frontendu
1. Pobierz projekt frontendowy: [link do repozytorium](https://github.com/szymonpogwizd/spogwizd_jporeba_cantabo_manager_frontend)
2. Otwórz projekt w InteliJ IDEA
3. Zainstaluj zależności npm: `npm install`
4. Uruchom aplikację: `npm start`

Po wykonaniu powyższych kroków powinieneś być w stanie uruchomić aplikację. Dostępne są trzy konta do logowania:

- SUPER ADMINISTRATOR:
    - login: superadmin@cantabo.pl
    - hasło: qwQW12!@12

- ADMINISTRATOR:
    - login: admin@cantabo.pl
    - hasło: qwQW12!@12

- USER:
    - login: user@cantabo.pl
    - hasło: qwQW12!@12

W razie jakichkolwiek problemów skontaktuj się z autorami pracy:
- Szymon Pogwizd (szymonpogwizd12@gmail.com)
- Jakub Poręba (jakubporeba8@gmail.com)

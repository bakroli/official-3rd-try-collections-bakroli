# Alkatrész kezelő
## Bevezetés
Ebben a feladatban egy olyan metódust kell írnod ami két listát dolgoz fel és egy harmadikat ad vissza. 

Az alább meghatározott metódust a `componentadministrator` csomagban (package) előre elkészített `hu.nive.ujratervezes.componentadministrator.ComponentAdministrator` osztályban írd meg!

A `Main` osztály `main` metódusában próbálhatod ki a kódodat, illetve használd
az előre megírt teszteseteket az algoritmusod kipróbálására!

## Feladatleírás
A feldolgozandó listák egy-egy áramkör alkatrészienek neveit tartalmazzák `String`-ként. 
Adjuk vissza azoknak az alkatrészeknek a neveit egy listában amik mindkét áramkörben szerepelnek.
Fontos, hogy az általunk visszadot listában minden alkatrész csak egyszer szerepeljen.
Amennyiben a metodus valamelyik paramétere `null` Adjunk vissza üres listát. 

- a metódus neve: `collectCommonComponents` (közös alkatrészek gyüjtése)
- a metódus bemeneti paraméterei:
    - `firstCircuitComponents`, az első áramkör alkatrészeinek listája `List<String>`
    - `secondCircuitComponents`, a második áramkör alkatrészeinek listája `List<String>`
- visszatérési értéke:
  - egy új, a fent leírt módon előállított lista `List<String>`

## Test-ek

```java
@Test
    void test_collectCommonComponents() {
        List<String> expected = new ArrayList<>(){{
            add("resistor 50kOhm");
            add("resistor 10kOhm");
            add("capacitor 10nF");
        }};
        List<String> first = new ArrayList<>(){{
            add("resistor 50kOhm");
            add("resistor 10kOhm");
            add("capacitor 50nF");
            add("capacitor 10nF");
        }};
        List<String> second = new ArrayList<>(){{
            add("resistor 50kOhm");
            add("capacitor 100nF");
            add("resistor 10kOhm");
            add("capacitor 10nF");
        }};
        List<String> actual = new hu.nive.ujratervezes.componentadministrator.ComponentAdministrator().collectCommonComponents(first,second);
        assertThat(actual).hasSize(expected.size()).hasSameElementsAs(expected);
    }

    @Test
    void test_collectCommonComponents_firstParamNull() {
        List<String> expected = new ArrayList<>();
        List<String> first = null;
        List<String> second = new ArrayList<>(){{
            add("resistor 50kOhm");
            add("capacitor 100nF");
            add("resistor 10kOhm");
            add("capacitor 10nF");
        }};
        List<String> actual = new hu.nive.ujratervezes.componentadministrator.ComponentAdministrator().collectCommonComponents(first,second);
        assertThat(actual).hasSize(expected.size()).hasSameElementsAs(expected);
    }

    @Test
    void test_collectCommonComponents_secondParamNull() {
        List<String> expected = new ArrayList<>();
        List<String> first = new ArrayList<>(){{
            add("resistor 50kOhm");
            add("capacitor 100nF");
            add("resistor 10kOhm");
            add("capacitor 10nF");
        }};
        List<String> second = null;
        List<String> actual = new hu.nive.ujratervezes.componentadministrator.ComponentAdministrator().collectCommonComponents(first,second);
        assertThat(actual).hasSize(expected.size()).hasSameElementsAs(expected);
    }
    @Test
    void test_collectCommonComponents_emptyArray() {
        List<String> expected = new ArrayList<>();
        List<String> first = new ArrayList<>(){{
            add("resistor 50kOhm");
            add("capacitor 100nF");
            add("resistor 10kOhm");
            add("capacitor 10nF");
        }};
        List<String> second = new ArrayList<>();;
        List<String> actual = new hu.nive.ujratervezes.componentadministrator.ComponentAdministrator().collectCommonComponents(first,second);
        assertThat(actual).hasSize(expected.size()).hasSameElementsAs(expected);
    }

    @Test
    void test_collectCommonComponents_hasMultiplesInFirst() {
        List<String> expected = new ArrayList<>(){{
            add("resistor 50kOhm");
            add("resistor 10kOhm");
            add("capacitor 10nF");
        }};
        List<String> first = new ArrayList<>(){{
            add("resistor 50kOhm");
            add("resistor 50kOhm");
            add("resistor 50kOhm");
            add("resistor 10kOhm");
            add("capacitor 50nF");
            add("capacitor 50nF");
            add("capacitor 10nF");
        }};
        List<String> second = new ArrayList<>(){{
            add("resistor 50kOhm");
            add("capacitor 100nF");
            add("resistor 10kOhm");
            add("capacitor 10nF");
        }};
        List<String> actual = new hu.nive.ujratervezes.componentadministrator.ComponentAdministrator().collectCommonComponents(first,second);
        assertThat(actual).hasSize(expected.size()).hasSameElementsAs(expected);
    }

    @Test
    void test_collectCommonComponents_hasMultiplesInSecond() {
        List<String> expected = new ArrayList<>(){{
            add("resistor 50kOhm");
            add("resistor 10kOhm");
            add("capacitor 10nF");
        }};
        List<String> first = new ArrayList<>(){{
            add("resistor 50kOhm");
            add("resistor 10kOhm");
            add("capacitor 50nF");
            add("capacitor 10nF");
        }};
        List<String> second = new ArrayList<>(){{
            add("resistor 50kOhm");
            add("resistor 50kOhm");
            add("resistor 50kOhm");
            add("resistor 50kOhm");
            add("capacitor 100nF");
            add("capacitor 100nF");
            add("capacitor 100nF");
            add("resistor 10kOhm");
            add("capacitor 10nF");
        }};
        List<String> actual = new hu.nive.ujratervezes.componentadministrator.ComponentAdministrator().collectCommonComponents(first,second);
        assertThat(actual).hasSize(expected.size()).hasSameElementsAs(expected);
    }

    @Test
    void test_collectCommonComponents_hasMultiplesInBoth() {
        List<String> expected = new ArrayList<>(){{
            add("resistor 50kOhm");
            add("resistor 10kOhm");
            add("capacitor 10nF");
        }};
        List<String> first = new ArrayList<>(){{
            add("resistor 50kOhm");
            add("resistor 10kOhm");
            add("capacitor 50nF");
            add("capacitor 10nF");
        }};
        List<String> second = new ArrayList<>(){{
            add("resistor 50kOhm");
            add("capacitor 100nF");
            add("resistor 10kOhm");
            add("capacitor 10nF");
        }};
        List<String> actual = new hu.nive.ujratervezes.componentadministrator.ComponentAdministrator().collectCommonComponents(first,second);
        assertThat(actual).hasSize(expected.size()).hasSameElementsAs(expected);
    }
```

## Pontozás

A feladat 0 pontot ér, bármely alábbi esetben:
- le sem fordul az adott projekt.
- teszteset sem fut le sikeresen
- ha a forráskód olvashatatlan, nem felel meg a konvencióknak, nem követi a clean code alapelveket
- ha kielégíti a teszteseteket, de a szöveges követelményeknek nem felel meg

Clean code-ra adható pontok: max 10


test-ekre adható pontok:

| Teszt | Pont |
--- | ----
test_collectCommonComponents |                       1 pont
test_collectCommonComponents_firstParamNull |        1 pont
test_collectCommonComponents_secondParamNull|        1 pont
test_collectCommonComponents_emptyArray      |       1 pont
test_collectCommonComponents_hasMultiplesInFirst |   2 pont
test_collectCommonComponents_hasMultiplesInSecond |  2 pont
test_collectCommonComponents_hasMultiplesInBoth    | 2 pont

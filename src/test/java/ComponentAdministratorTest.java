import hu.nive.ujratervezes.componentadministrator.ComponentAdministrator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComponentAdministratorTest {

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
        List<String> actual = new ComponentAdministrator().collectCommonComponents(first,second);
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
        List<String> actual = new ComponentAdministrator().collectCommonComponents(first,second);
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
        List<String> actual = new ComponentAdministrator().collectCommonComponents(first,second);
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
        List<String> actual = new ComponentAdministrator().collectCommonComponents(first,second);
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
        List<String> actual = new ComponentAdministrator().collectCommonComponents(first,second);
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
        List<String> actual = new ComponentAdministrator().collectCommonComponents(first,second);
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
        List<String> actual = new ComponentAdministrator().collectCommonComponents(first,second);
        assertThat(actual).hasSize(expected.size()).hasSameElementsAs(expected);
    }
}
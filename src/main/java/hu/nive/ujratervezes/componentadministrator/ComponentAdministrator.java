package hu.nive.ujratervezes.componentadministrator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComponentAdministrator {

    public List<String> collectCommonComponents(List<String> firstCircuitComponents, List<String> secondCircuitComponents) {
        if (firstCircuitComponents == null || secondCircuitComponents == null) {
            return new ArrayList<>();
        }
        Set<String> resultSet = new HashSet<>();
        for (String firstCircuit : firstCircuitComponents) {
            for (String secondCircuit : secondCircuitComponents) {
                if (firstCircuit.equals(secondCircuit)) {
                    resultSet.add(firstCircuit);
                }
            }
        }
        List<String> result = new ArrayList<>();
        result.addAll(resultSet);
        return result;
    }

}

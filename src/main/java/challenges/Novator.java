package challenges;

import com.google.ortools.Loader;
import com.google.ortools.graph.MinCostFlow;
import problem.Obligation;
import problem.Party;
import problem.Problem;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class Novator {

    public static Collection<Obligation> novateObligations(Problem problem) {
        Loader.loadNativeLibraries();

        var indexToParty = problem.parties().stream().map(Party::name).toArray(String[]::new);
        var partyToIndex = mapPartyToIndex(indexToParty);
        var minCostFlow = initializeMinCostFlow(problem, indexToParty, partyToIndex);

        if (minCostFlow.solve() != MinCostFlow.Status.OPTIMAL) {
            throw new IllegalStateException("optimality not achieved");
        }

        return createNovatedObligations(indexToParty, minCostFlow);
    }

    private static LinkedList<Obligation> createNovatedObligations(String[] indexToParty, MinCostFlow minCostFlow) {
        var novatedObligations = new LinkedList<Obligation>();
        for (int i = 0; i < minCostFlow.getNumArcs(); ++i) {
            if(minCostFlow.getFlow(i) != 0L) {
                novatedObligations.add(new Obligation(indexToParty[minCostFlow.getTail(i)], indexToParty[minCostFlow.getHead(i)], minCostFlow.getFlow(i)));
            }
        }
        return novatedObligations;
    }

    private static MinCostFlow initializeMinCostFlow(Problem problem, String[] indexToParty, HashMap<String, Integer> partyToIndex) {
        MinCostFlow minCostFlow = new MinCostFlow();
        problem.parties()
                .forEach(party -> party.preferences()
                        .forEach(preference -> {
                            minCostFlow.addArcWithCapacityAndUnitCost(
                                    partyToIndex.get(preference.counterPartyName()),
                                    partyToIndex.get(party.name()),
                                    preference.maxExposure(),
                                    preference.quantifiedDisgust()
                            );
                        }));

        long[] supplies = calculateSupplies(problem, indexToParty, partyToIndex);
        for (int i = 0; i < indexToParty.length; i++) {
            minCostFlow.setNodeSupply(i, supplies[i]);
        }
        return minCostFlow;
    }

    private static HashMap<String, Integer> mapPartyToIndex(String[] indexToParty) {
        var partyToIndex = new HashMap<String, Integer>(indexToParty.length);
        for (int i = 0; i < indexToParty.length; i++) {
            partyToIndex.put(indexToParty[i], i);
        }
        return partyToIndex;
    }

    private static long[] calculateSupplies(Problem problem, String[] indexToParty, HashMap<String, Integer> partyToIndex) {
        var supplies = new long[indexToParty.length];
        problem.obligations().forEach(obligation -> {
            var fromIndex = partyToIndex.get(obligation.fromParty());
            var toIndex = partyToIndex.get(obligation.toParty());
            supplies[fromIndex] = supplies[fromIndex] + obligation.dollars();
            supplies[toIndex] = supplies[toIndex] - obligation.dollars();
        });
        return supplies;
    }
}

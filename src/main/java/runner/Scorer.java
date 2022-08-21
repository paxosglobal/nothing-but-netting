package runner;

import problem.Obligation;
import problem.Problem;

import java.util.Collection;

public class Scorer {
    public static long score(Collection<Obligation> resultObligations, Problem problem) {
        return resultObligations.stream().map(o -> scorePreference(o, problem)).reduce(0L, Long::sum);
    }

    private static long scorePreference(Obligation obligation, Problem problem) {
        final var toParty = problem.parties().stream().filter(party -> party.name().equals(obligation.toParty())).findFirst().orElseThrow();
        final var preference = toParty.preferences().stream().filter(pref -> pref.counterPartyName().equals(obligation.fromParty())).findFirst().orElseThrow();
        return obligation.dollars() * preference.aversion();
    }

}

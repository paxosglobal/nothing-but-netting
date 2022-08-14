package runner;

import problem.Obligation;
import problem.Party;
import problem.Problem;

import java.util.Collection;

public class Validator {
    public static void validate(Collection<Obligation> novatedObligations, Problem problem) {
        problem.parties().forEach(party -> {
                    validateNovation(novatedObligations, problem, party);
                    validateCounterpartyExposures(novatedObligations, party);
                }
        );
    }

    private static void validateNovation(Collection<Obligation> resultObligations, Problem problem, Party party) {
        final var originalEffect = calculateEffectOnParty(problem.obligations(), party.name());
        final var novationEffect = calculateEffectOnParty(resultObligations, party.name());
        if (originalEffect != novationEffect) {
            throw new IllegalStateException(String.format("Solution breaks the rules. Impact on %s before novation was %s. Now is %s", party.name(), originalEffect, novationEffect));
        }
    }

    private static void validateCounterpartyExposures(Collection<Obligation> resultObligations, Party party) {
        party.preferences().forEach(preference -> {
            final var prefTotal = resultObligations.stream()
                    .filter(o -> o.fromParty().equals(preference.counterPartyName()))
                    .filter(o -> o.toParty().equals(party.name()))
                    .map(Obligation::dollars).reduce(0L, Long::sum);
            if (prefTotal > preference.maxExposure()) {
                throw new IllegalStateException(String.format("Solution breaks the rules. Payment total of %s from %s to %s breaks the max exposure of %s", prefTotal,
                        preference.counterPartyName(), party.name(), preference.maxExposure()));
            }
        });
    }

    private static long calculateEffectOnParty(Collection<Obligation> obligations, String party) {
        final var credits = obligations.stream().filter(obligation -> obligation.toParty().equals(party)).map(Obligation::dollars).reduce(0L, Long::sum);
        final var debits = obligations.stream().filter(obligation -> obligation.fromParty().equals(party)).map(Obligation::dollars).reduce(0L, Long::sum);
        return credits - debits;
    }
}

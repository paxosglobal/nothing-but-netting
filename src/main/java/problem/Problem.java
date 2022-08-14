package problem;

import java.util.Collection;
import java.util.List;

public record Problem(Collection<Obligation> obligations, Collection<Party> parties) {
    private static final String ANN = "Ann";
    private static final String BETH = "Beth";
    private static final String COLE = "Cole";
    private static final String DAVE = "Dave";
    private static final String EVE = "Eve";
    private static final String FRAN = "Fran";
    private static final String GALE = "Gale";
    private static final String HANK = "Hank";

    public static Problem generateDefaultProblem() {
        return new Problem(generateDefaultObligations(), generateDefaultParties());
    }

    private static Collection<Obligation> generateDefaultObligations() {
        return List.of(
                new Obligation(BETH, ANN, 200L),
                new Obligation(BETH, ANN, 800L),
                new Obligation(COLE, ANN, 1000L),
                new Obligation(DAVE, ANN, 900L),
                new Obligation(DAVE, ANN, 100L),
                new Obligation(EVE, ANN, 250L),
                new Obligation(EVE, ANN, 750L),
                new Obligation(FRAN, ANN, 100L),
                new Obligation(FRAN, ANN, 900L),
                new Obligation(GALE, ANN, 1L),
                new Obligation(GALE, ANN, 999L),

                new Obligation(ANN, BETH, 1000L),
                new Obligation(DAVE, BETH, 900L),
                new Obligation(DAVE, BETH, 100L),
                new Obligation(EVE, BETH, 250L),
                new Obligation(EVE, BETH, 750L),
                new Obligation(FRAN, BETH, 100L),
                new Obligation(FRAN, BETH, 900L),
                new Obligation(GALE, BETH, 1L),
                new Obligation(GALE, BETH, 999L),
                new Obligation(HANK, BETH, 1000L),

                new Obligation(ANN, COLE, 1L),
                new Obligation(ANN, COLE, 999L),
                new Obligation(DAVE, COLE, 900L),
                new Obligation(DAVE, COLE, 30L),
                new Obligation(EVE, COLE, 250L),
                new Obligation(EVE, COLE, 750L),
                new Obligation(FRAN, COLE, 4L),
                new Obligation(FRAN, COLE, 900L),
                new Obligation(GALE, COLE, 1L),
                new Obligation(GALE, COLE, 999L),
                new Obligation(HANK, COLE, 1000L),

                new Obligation(ANN, DAVE, 1000L),
                new Obligation(BETH, DAVE, 900L),
                new Obligation(COLE, DAVE, 100L),
                new Obligation(EVE, DAVE, 250L),
                new Obligation(EVE, DAVE, 750L),
                new Obligation(FRAN, DAVE, 100L),
                new Obligation(FRAN, DAVE, 900L),
                new Obligation(GALE, DAVE, 1L),
                new Obligation(GALE, DAVE, 999L),
                new Obligation(HANK, DAVE, 90L),

                new Obligation(ANN, EVE, 1000L),
                new Obligation(BETH, EVE, 900L),
                new Obligation(COLE, EVE, 100L),
                new Obligation(DAVE, EVE, 2L),
                new Obligation(GALE, EVE, 1L),
                new Obligation(GALE, EVE, 299L),
                new Obligation(HANK, EVE, 90L),

                new Obligation(ANN, FRAN, 888L),
                new Obligation(BETH, FRAN, 900L),
                new Obligation(COLE, FRAN, 100L),
                new Obligation(DAVE, FRAN, 100L),
                new Obligation(DAVE, FRAN, 900L),
                new Obligation(GALE, FRAN, 1L),
                new Obligation(GALE, FRAN, 999L),
                new Obligation(HANK, FRAN, 90L),

                new Obligation(ANN, GALE, 1000L),
                new Obligation(BETH, GALE, 900L),
                new Obligation(COLE, GALE, 100L),
                new Obligation(DAVE, GALE, 1L),
                new Obligation(DAVE, GALE, 999L),
                new Obligation(EVE, GALE, 40L),
                new Obligation(FRAN, GALE, 100L),
                new Obligation(FRAN, GALE, 900L),
                new Obligation(HANK, GALE, 90L),

                new Obligation(BETH, HANK, 900L),
                new Obligation(COLE, HANK, 100L),
                new Obligation(DAVE, HANK, 1L),
                new Obligation(DAVE, HANK, 999L),
                new Obligation(EVE, HANK, 40L),
                new Obligation(FRAN, HANK, 100L),
                new Obligation(FRAN, HANK, 900L),
                new Obligation(GALE, HANK, 90L)
        );
    }

    private static Collection<Party> generateDefaultParties() {
        final var ann = new Party(ANN, List.of(
                new Party.Preference(BETH, 1000, 3),
                new Party.Preference(COLE, 1000, 3),
                new Party.Preference(DAVE, 1000, 3),
                new Party.Preference(EVE, 1000, 3),
                new Party.Preference(FRAN, 1000, 3),
                new Party.Preference(GALE, 1000, 3),
                new Party.Preference(HANK, 0, 100L)
        ));

        final var bill = new Party(BETH, List.of(
                new Party.Preference(ANN, 1000, 1),
                new Party.Preference(COLE, 0, 100L),
                new Party.Preference(DAVE, 1000, 3),
                new Party.Preference(EVE, 1000, 3),
                new Party.Preference(FRAN, 1000, 27),
                new Party.Preference(GALE, 1000, 3),
                new Party.Preference(HANK, 1000, 3)
        ));

        final var cole = new Party(COLE, List.of(
                new Party.Preference(ANN, 1000, 3),
                new Party.Preference(BETH, 0, 100L),
                new Party.Preference(DAVE, 1000, 3),
                new Party.Preference(EVE, 1000, 3),
                new Party.Preference(FRAN, 1000, 3),
                new Party.Preference(GALE, 1000, 3),
                new Party.Preference(HANK, 1000, 3)
        ));

        final var dave = new Party(DAVE, List.of(
                new Party.Preference(ANN, 1000, 3),
                new Party.Preference(BETH, 1000, 3),
                new Party.Preference(COLE, 1000, 3),
                new Party.Preference(EVE, 1000, 3),
                new Party.Preference(FRAN, 1000, 3),
                new Party.Preference(GALE, 1000, 3),
                new Party.Preference(HANK, 1000, 3)
        ));

        final var eve = new Party(EVE, List.of(
                new Party.Preference(ANN, 1000, 3),
                new Party.Preference(BETH, 1000, 3),
                new Party.Preference(COLE, 1000, 3),
                new Party.Preference(DAVE, 1000, 3),
                new Party.Preference(FRAN, 0, 100L),
                new Party.Preference(GALE, 300, 99),
                new Party.Preference(HANK, 1000, 3)
        ));

        final var fran = new Party(FRAN, List.of(
                new Party.Preference(ANN, 1000, 3),
                new Party.Preference(BETH, 1000, 50L),
                new Party.Preference(COLE, 1000, 3),
                new Party.Preference(DAVE, 1000, 3),
                new Party.Preference(EVE, 0, 100L),
                new Party.Preference(GALE, 1000, 3),
                new Party.Preference(HANK, 1000, 3)
        ));

        final var gale = new Party(GALE, List.of(
                new Party.Preference(ANN, 1000, 3),
                new Party.Preference(BETH, 1000, 3),
                new Party.Preference(COLE, 1000, 3),
                new Party.Preference(DAVE, 1000, 3),
                new Party.Preference(EVE, 40, 1),
                new Party.Preference(FRAN, 1000, 3),
                new Party.Preference(HANK, 1000, 3)
        ));

        final var hank = new Party(HANK, List.of(
                new Party.Preference(ANN, 0, 100L),
                new Party.Preference(BETH, 1000, 3),
                new Party.Preference(COLE, 1000, 3),
                new Party.Preference(DAVE, 1000, 3),
                new Party.Preference(EVE, 1000, 3),
                new Party.Preference(FRAN, 1000, 3),
                new Party.Preference(GALE, 1000, 3)
        ));

        final var parties = List.of(ann, bill, cole, dave, eve, fran, gale, hank);
        assert parties.stream().allMatch(Party::isValid);
        return parties;
    }
}

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
                new Obligation(BETH, ANN, 200),
                new Obligation(BETH, ANN, 800),
                new Obligation(COLE, ANN, 1000),
                new Obligation(DAVE, ANN, 900),
                new Obligation(DAVE, ANN, 100),
                new Obligation(EVE, ANN, 250),
                new Obligation(EVE, ANN, 750),
                new Obligation(FRAN, ANN, 100),
                new Obligation(FRAN, ANN, 900),
                new Obligation(GALE, ANN, 1),
                new Obligation(GALE, ANN, 999),

                new Obligation(ANN, BETH, 1000),
                new Obligation(DAVE, BETH, 900),
                new Obligation(DAVE, BETH, 100),
                new Obligation(EVE, BETH, 250),
                new Obligation(EVE, BETH, 750),
                new Obligation(FRAN, BETH, 100),
                new Obligation(FRAN, BETH, 900),
                new Obligation(GALE, BETH, 1),
                new Obligation(GALE, BETH, 999),
                new Obligation(HANK, BETH, 1000),

                new Obligation(ANN, COLE, 1),
                new Obligation(ANN, COLE, 999),
                new Obligation(DAVE, COLE, 900),
                new Obligation(DAVE, COLE, 30),
                new Obligation(EVE, COLE, 250),
                new Obligation(EVE, COLE, 750),
                new Obligation(FRAN, COLE, 4),
                new Obligation(FRAN, COLE, 900),
                new Obligation(GALE, COLE, 1),
                new Obligation(GALE, COLE, 999),
                new Obligation(HANK, COLE, 1000),

                new Obligation(ANN, DAVE, 1000),
                new Obligation(BETH, DAVE, 900),
                new Obligation(COLE, DAVE, 100),
                new Obligation(EVE, DAVE, 250),
                new Obligation(EVE, DAVE, 750),
                new Obligation(FRAN, DAVE, 100),
                new Obligation(FRAN, DAVE, 900),
                new Obligation(GALE, DAVE, 1),
                new Obligation(GALE, DAVE, 999),
                new Obligation(HANK, DAVE, 90),

                new Obligation(ANN, EVE, 1000),
                new Obligation(BETH, EVE, 900),
                new Obligation(COLE, EVE, 100),
                new Obligation(DAVE, EVE, 2),
                new Obligation(GALE, EVE, 1),
                new Obligation(GALE, EVE, 299),
                new Obligation(HANK, EVE, 90),

                new Obligation(ANN, FRAN, 888),
                new Obligation(BETH, FRAN, 900),
                new Obligation(COLE, FRAN, 100),
                new Obligation(DAVE, FRAN, 100),
                new Obligation(DAVE, FRAN, 900),
                new Obligation(GALE, FRAN, 1),
                new Obligation(GALE, FRAN, 999),
                new Obligation(HANK, FRAN, 90),

                new Obligation(ANN, GALE, 1000),
                new Obligation(BETH, GALE, 900),
                new Obligation(COLE, GALE, 100),
                new Obligation(DAVE, GALE, 1),
                new Obligation(DAVE, GALE, 999),
                new Obligation(EVE, GALE, 40),
                new Obligation(FRAN, GALE, 100),
                new Obligation(FRAN, GALE, 900),
                new Obligation(HANK, GALE, 90),

                new Obligation(BETH, HANK, 900),
                new Obligation(COLE, HANK, 100),
                new Obligation(DAVE, HANK, 1),
                new Obligation(DAVE, HANK, 999),
                new Obligation(EVE, HANK, 40),
                new Obligation(FRAN, HANK, 100),
                new Obligation(FRAN, HANK, 900),
                new Obligation(GALE, HANK, 90)
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
                new Party.Preference(HANK, 0, 100)
        ));

        final var bill = new Party(BETH, List.of(
                new Party.Preference(ANN, 1000, 1),
                new Party.Preference(COLE, 0, 100),
                new Party.Preference(DAVE, 1000, 3),
                new Party.Preference(EVE, 1000, 3),
                new Party.Preference(FRAN, 1000, 27),
                new Party.Preference(GALE, 1000, 3),
                new Party.Preference(HANK, 1000, 3)
        ));

        final var cole = new Party(COLE, List.of(
                new Party.Preference(ANN, 1000, 3),
                new Party.Preference(BETH, 0, 100),
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
                new Party.Preference(FRAN, 0, 100),
                new Party.Preference(GALE, 300, 99),
                new Party.Preference(HANK, 1000, 3)
        ));

        final var fran = new Party(FRAN, List.of(
                new Party.Preference(ANN, 1000, 3),
                new Party.Preference(BETH, 1000, 50),
                new Party.Preference(COLE, 1000, 3),
                new Party.Preference(DAVE, 1000, 3),
                new Party.Preference(EVE, 0, 100),
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
                new Party.Preference(ANN, 0, 100),
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

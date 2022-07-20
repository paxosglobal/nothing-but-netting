package runner;

import org.junit.jupiter.api.Test;
import problem.Obligation;
import problem.Party;
import problem.Problem;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScorerTest {
    private static final String A = "a";
    private static final String B = "b";

    @Test
    public void itScores() {
        final var problem = new Problem(List.of(), List.of(
                new Party(A, List.of(new Party.Preference(B, 30, 3))),
                new Party(B, List.of(new Party.Preference(A, 30, 5)))

        ));
        final var novated = List.of(new Obligation(B, A, 7));
        assertEquals(21, Scorer.score(novated, problem));
    }
}

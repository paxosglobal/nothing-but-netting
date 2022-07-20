package challenges;

import problem.Obligation;
import problem.Problem;

import java.util.Collection;

public class Novator {

    public static Collection<Obligation> novateObligations(Problem problem) {
        return problem.obligations();
    }
}

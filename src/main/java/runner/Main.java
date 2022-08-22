package runner;

import challenges.Novator;
import problem.Problem;

class Main {

    public static void main(String[] args) {
        final var problem = Problem.generateDefaultProblem();
        final var novatedObligations = Novator.novateObligations(problem);
        Validator.validate(novatedObligations, problem);
        final var totalCost = Scorer.score(novatedObligations, problem);
        novatedObligations.forEach(System.out::println);
        System.out.printf("\n>>>>> Your total cost was %s <<<<<", totalCost);
    }
}

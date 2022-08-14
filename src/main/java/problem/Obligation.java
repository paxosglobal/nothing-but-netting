package problem;

public record Obligation(String fromParty, String toParty, Long dollars) {
    public Obligation {
        assert !fromParty.equals(toParty);
        assert dollars > 0;
    }

    public Obligation plus(Obligation other) {
        assert getRelationship().equals(other.getRelationship());
        if (fromParty.equals(other.fromParty)) {
            return new Obligation(fromParty, toParty, dollars + other.dollars);
        } else if (dollars > other.dollars) {
            return new Obligation(fromParty, toParty, dollars - other.dollars);
        } else {
            return new Obligation(toParty, fromParty, dollars - other.dollars);
        }

    }

    public PartyPair getRelationship() {
        return new PartyPair(fromParty, toParty);
    }

    public boolean isNonZero() {
        return dollars > 0;
    }
}

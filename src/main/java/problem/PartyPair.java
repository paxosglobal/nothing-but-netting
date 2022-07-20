package problem;

import java.util.Objects;
import java.util.Set;

public class PartyPair {
    public final String partyA;
    public final String partyB;
    private final Set<String> partySet;

    public PartyPair(String partyA, String partyB) {
        this.partyA = partyA;
        this.partyB = partyB;
        this.partySet = Set.of(partyA, partyB);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartyPair that = (PartyPair) o;

        return Objects.equals(partySet, that.partySet);
    }

    @Override
    public int hashCode() {
        return partySet != null ? partySet.hashCode() : 0;
    }
}

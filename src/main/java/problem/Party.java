package problem;

import java.util.Collection;

public record Party(String name, Collection<Preference> preferences) {
    public boolean isValid() {
        return preferences.stream().map(preference -> preference.counterPartyName).distinct().count() == preferences.size();
    }

    public record Preference(String counterPartyName, long maxExposure, long quantifiedDisgust) {
    }
}

package challenge.configure;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
@Getter
public enum Role {
    QUOTE_READER("QUOTES.ROLE_READ"),
    QUOTE_WRITER("QUOTES.ROLE_WRITE");

    private final String policyName;

    private static final Map<String, Role> ROLE_MAP;

    static {
        Map<String, Role> map = new ConcurrentHashMap<>();
        for (Role instance : Role.values()) {
            map.put(instance.getPolicyName(), instance);
        }
        ROLE_MAP = Collections.unmodifiableMap(map);
    }
    public static Role get(String name) {
        return ROLE_MAP.get(name);
    }

}

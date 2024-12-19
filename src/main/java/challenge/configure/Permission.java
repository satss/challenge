package challenge.configure;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {

    QUOTE_READ("quote:read"),
    QUOTE_CREATE("quote:create");
    private final String permission;
}

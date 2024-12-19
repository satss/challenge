package challenge.configure;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static challenge.configure.Permission.QUOTE_CREATE;
import static challenge.configure.Permission.QUOTE_READ;

@Getter
@RequiredArgsConstructor
public enum Role {

    WRITER(
            Set.of(
                    QUOTE_READ,
                    QUOTE_CREATE
            )
    ),
    READER(Set.of(
            QUOTE_READ
    ));

    private final Set<Permission> permissions;


}

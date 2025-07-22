/*
 * DO NOT MAKE ANY CHANGES
 */

package Task3;

import java.util.Objects;

// DO NOT MAKE CHANGES
public class Vault {
    private final String password;
    private final Integer secretValue;

    public Vault(String password, Integer secretValue) {
        this.password = password;
        this.secretValue = secretValue;
    }

    public Integer challenge(String password) {
        if (Objects.equals(password, this.password)) {
            return secretValue;
        }
        return null;
    }
}

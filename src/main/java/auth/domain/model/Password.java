package auth.domain.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Password implements Serializable {

    private String password;


    public Password(String password)
    {
        this.password = password;
    }


    public boolean checkPassword(String pwd)
    {
        if (pwd.isEmpty())
            return false;
        return Arrays.equals(pwd.toCharArray(), this.password.toCharArray());
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 7 * hash + this.password.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        // Inspired in https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        Password obj = (Password) o;
        return Objects.equals(this.password, obj.password);
    }
}

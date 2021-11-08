package auth;


import auth.domain.mapper.UserRoleMapper;
import auth.domain.mapper.dto.UserRoleDTO;
import auth.domain.model.Email;
import auth.domain.model.User;
import java.util.Collections;
import java.util.List;


public class UserSession {

    private User user = null;

    public UserSession()
    {
        this.user = null;
    }

    public UserSession(User user)
    {
        if (user == null)
            throw new IllegalArgumentException("Argument cannot be null.");
        this.user = user;
    }

    public void doLogout()
    {
        this.user = null;
    }

    public boolean isLoggedIn()
    {
        return this.user != null;
    }

    public boolean isLoggedInWithRole(String roleId)
    {
        if (isLoggedIn())
        {
            return this.user.hasRole(roleId);
        }
        return false;
    }

    public String getUserName()
    {
        if (isLoggedIn())
            this.user.getName();
        return null;
    }
    public Email getEmail(){
        if (isLoggedIn())
            this.user.getId();
        return null;
    }

    public Email getUserId()
    {
        if (isLoggedIn())
            return this.user.getId();
        return null;
    }

    public List<UserRoleDTO> getUserRoles()
    {
        if (isLoggedIn()) {
            UserRoleMapper mapper = new UserRoleMapper();
            return mapper.toDTO(this.user.getRoles());
        }
        return Collections.EMPTY_LIST;
    }
}

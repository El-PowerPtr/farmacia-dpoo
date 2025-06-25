package aplicacion.logica.login;

import java.util.HashMap;

public class LoginIpl implements Login {
    private HashMap<String, String> credentials;

    public LoginIpl() {
        credentials = new HashMap<>();
    }

    public LoginIpl(HashMap<String, String> credentials) {
        this.credentials = credentials;
    }

    public HashMap<String, String> getCredentials() {
        return credentials;
    }

    public void setCredentials(HashMap<String, String> credentials) {
        this.credentials = credentials;
    }

    @Override
    public boolean isValidPassword(String user, String passWord) {
        String realPassword = credentials.get(user);
        return realPassword != null && realPassword == passWord;
    }
}

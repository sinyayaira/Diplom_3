package practikum;

import net.minidev.json.JSONObject;

public class ClientPOJO {
    protected String email;
    protected String name;
    protected String password;

    public ClientPOJO(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public ClientPOJO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String toJSON() {
        final JSONObject requestParams = new JSONObject();
        if (getEmail() != null) requestParams.put("email", getEmail());
        if (getPassword() != null) requestParams.put("password", getPassword());
        if (getName() != null) requestParams.put("name", getName());

        return requestParams.toJSONString();
    }
}

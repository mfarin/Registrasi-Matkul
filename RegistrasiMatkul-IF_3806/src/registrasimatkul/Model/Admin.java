package registrasimatkul.Model;

public class Admin extends Orang{
    private String UsernameAdm;
    private String PasswordAdm;

    public Admin(String UsernameAdm, String PasswordAdm, String nama) {
        super(nama);
        this.UsernameAdm = UsernameAdm;
        this.PasswordAdm = PasswordAdm;
    }

    public void setUsernameAdm(String UsernameAdm) {
        this.UsernameAdm = UsernameAdm;
    }

    public void setPasswordAdm(String PasswordAdm) {
        this.PasswordAdm = PasswordAdm;
    }

    public String getUsernameAdm() {
        return UsernameAdm;
    }

    public String getPasswordAdm() {
        return PasswordAdm;
    }
}


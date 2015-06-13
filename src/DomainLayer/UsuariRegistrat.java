package DomainLayer;

/**
 * Created by Miquel on 10/06/2015.
 */
public class UsuariRegistrat {
    private String nom;
    private String cognom;
    private String username;
    private String pwd;

    public UsuariRegistrat(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public UsuariRegistrat(String username, String pwd, String nom, String cognom) {
        this.username = username;
        this.pwd = pwd;
        this.nom = nom;
        this.cognom = cognom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNom() {

        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }
}

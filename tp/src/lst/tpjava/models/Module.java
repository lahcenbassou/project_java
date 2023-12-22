package lst.tpjava.models;

public class Module {
    private int id;
    private String intitule;
    private Enseignant chef;
    private Filiere filiere;

    public Module() {
    }

    public Module(String intitule, Enseignant chef, Filiere filiere) {
        this.intitule = intitule;
        this.chef = chef;
        this.filiere = filiere;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getChef() {
        return chef;
    }

    public void setChef(Enseignant chef) {
        this.chef = chef;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

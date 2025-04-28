package parte_medicinal;

import animal_e_dono.animal.Pet;

public class Vacina {
    private int id;
    private String nomeVacina;
    private String dataAplicacao;
    private Pet pet;

    public Vacina(int id, String nomeVacina, String dataAplicacao, Pet pet) {
        this.id = id;
        this.nomeVacina = nomeVacina;
        this.dataAplicacao = dataAplicacao;
        this.pet = pet;
    }


    public String consultarVacinas() {
        return "Vacina " + nomeVacina + " aplicada em " + pet.getNome() + " na data " + dataAplicacao.toString();
    }


    public int getId() {
        return id;
    }


    public String getNomeVacina() {
        return nomeVacina;
    }


    public String getDataAplicacao() {
        return dataAplicacao;
    }


    public Pet getPet() {
        return pet;
    }
    
}

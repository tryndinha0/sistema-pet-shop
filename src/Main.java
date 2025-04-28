import animal_e_dono.animal.Pet;
import animal_e_dono.dono.Dono;

public class Main {
     public static void main(String[] args) {
        Sistema sistema = new Sistema();

        Dono dono = new Dono(1, "Lucas Pereira", "99998888", "Rua das Palmeiras, 321");
        sistema.cadastrarDono(dono);

        Pet pet = new Pet(1, "Bidu", dono);
        sistema.cadastrarPet(pet);

        sistema.agendarConsulta(1, 1, "28/04/2025", "Dra. Carolina");
        sistema.administrarVacina(1, 1, "Antirrábica", "28/04/2025");

        // Salvar os dados no final
        sistema.salvarTodosOsDados();
    }
}

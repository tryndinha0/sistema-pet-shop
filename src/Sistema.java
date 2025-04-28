import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

import animal_e_dono.animal.Pet;
import animal_e_dono.dono.Dono;
import parte_medicinal.Consulta;
import parte_medicinal.Vacina;

public class Sistema {
    private List<Dono> donos;
    private List<Pet> pets;
    private List<Consulta> consultas;
    private List<Vacina> vacinas;

    public Sistema() {
        donos = new ArrayList<>();
        pets = new ArrayList<>();
        consultas = new ArrayList<>();
        vacinas = new ArrayList<>();
    }

    public void salvarPetsEmArquivo(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            for (Pet pet : pets) {
                writer.write("ID: " + pet.getId() +
                        ", Nome: " + pet.getNome() +
                        ", Dono: " + pet.getDono().getNome() + "\n");
            }
            System.out.println("Pets salvos no arquivo " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar pets: " + e.getMessage());
        }
    }

    public void salvarConsultasEmArquivo(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            for (Consulta consulta : consultas) {
                writer.write("ID Consulta: " + consulta.getId() +
                        ", Pet: " + consulta.getPet().getNome() +
                        ", Veterinário: " + consulta.getVeterinario() +
                        ", Data: " + consulta.getData() + "\n");
            }
            System.out.println("Consultas salvas no arquivo " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar consultas: " + e.getMessage());
        }
    }

    public void salvarVacinasEmArquivo(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            for (Vacina vacina : vacinas) {
                writer.write("ID Vacina: " + vacina.getId() +
                        ", Pet: " + vacina.getPet().getNome() +
                        ", Nome Vacina: " + vacina.getNomeVacina() +
                        ", Data: " + vacina.getDataAplicacao() + "\n");
            }
            System.out.println("Vacinas salvas no arquivo " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar vacinas: " + e.getMessage());
        }
    }
    public void salvarDonosEmArquivo(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            for (Dono dono : donos) {
                writer.write("ID Dono: " + dono.getId() +
                        ", Nome: " + dono.getNome() +
                        ", Telefone: " + dono.getTelefone() +
                        ", Endereço: " + dono.getEndereco() + 
                        ", Cpf: " + dono.getCpf() + "\n");
            }
            System.out.println("Donos salvos no arquivo " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar donos: " + e.getMessage());
        }
    }

    public void salvarTodosOsDados() {
        salvarPetsEmArquivo("pets.txt");
        salvarConsultasEmArquivo("consultas.txt");
        salvarVacinasEmArquivo("vacinas.txt");
        salvarDonosEmArquivo("donos.txt");
    }

    // Método para cadastrar dono no sistema
    public void cadastrarDono(Dono dono) {
        donos.add(dono);
        System.out.println("Dono " + dono.getNome() + " cadastrado com sucesso!");
    }

    // Método para cadastrar pet no sistema
    public void cadastrarPet(Pet pet) {
        pets.add(pet);
        System.out.println("Pet " + pet.getNome() + " cadastrado com sucesso!");
    }

    // Método para consultar dono por ID
    public String consultarDono(int id) {
        for (Dono dono : donos) {
            if (dono.getId() == id) {
                return dono.getNome();
            }
        }
        return null; // Retorna null se não encontrar o dono
    }

    // Método para consultar pet por ID
    public Pet consultarPet(int id) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        return null; // Retorna null se não encontrar o pet
    }
    public void agendarConsulta(int idConsulta, int idPet, String data, String veterinario, String diagnostico) {
        Pet pet = consultarPet(idPet);
        if (pet != null) {
            Consulta novaConsulta = new Consulta(idConsulta, data, pet, veterinario,diagnostico);
            consultas.add(novaConsulta);
            System.out.println("Consulta agendada para " + pet.getNome() + " com o veterinário " + veterinario);
        } else {
            System.out.println("Pet não encontrado. Consulta não agendada.");
        }
    }

    public void agendarConsulta(int idConsulta, int idPet, String data, String veterinario) {
        Pet pet = consultarPet(idPet);
        if (pet != null) {
            Consulta novaConsulta = new Consulta(idConsulta, data, pet, veterinario);
            consultas.add(novaConsulta);
            System.out.println("Consulta agendada para " + pet.getNome() + " com o veterinário " + veterinario);
        } else {
            System.out.println("Pet não encontrado. Consulta não agendada.");
        }
    }// caso a consulta nao tenha gerado algum diagnostico


    public void administrarVacina(int idVacina, int idPet, String nomeVacina, String dataAplicacao) {
        Pet pet = consultarPet(idPet);
        if (pet != null) {
            Vacina novaVacina = new Vacina(idVacina, nomeVacina, dataAplicacao, pet);
            vacinas.add(novaVacina);
            System.out.println("Vacina " + nomeVacina + " aplicada em " + pet.getNome());
        } else {
            System.out.println("Pet não encontrado. Vacina não aplicada.");
        }
    }
    public void listarConsultas() {
        System.out.println("=== Consultas Agendadas ===");
        for (Consulta consulta : consultas) {
            System.out.println(consulta.listarConsultas());
        }
    }

    
    public void listarVacinas() {
        System.out.println("=== Vacinas Aplicadas ===");
        for (Vacina vacina : vacinas) {
            System.out.println(vacina.consultarVacinas());
        }
    }
  
}

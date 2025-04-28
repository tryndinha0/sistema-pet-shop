import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
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
        try (FileWriter writer = new FileWriter(caminhoArquivo, true)) {
            for (Pet pet : pets) {
                if (!petJaSalvo(pet, caminhoArquivo)) {
                    writer.write("ID: " + pet.getId() +
                            ", Nome: " + pet.getNome() +
                            ", Dono: " + pet.getDono().getNome() + "\n");
                }else{
                    System.out.println("o pet " + pet.getNome() + " já foi cadastrado");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar pets: " + e.getMessage());
        }
    }

    private boolean petJaSalvo(Pet pet, String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.contains("ID: " + pet.getId() + ", Nome: " + pet.getNome())) {
                    return true; // Já existe no arquivo
                }
            }
        } catch (IOException e) {
            // Se der erro (tipo arquivo não existir ainda), assume que não está salvo
            return false;
        }
        return false;
    }

    public void salvarConsultasEmArquivo(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo, true)) {
            for (Consulta consulta : consultas) {
                if(!consultaJaSalvo(consulta, caminhoArquivo)){
                writer.write("ID Consulta: " + consulta.getId() +
                        ", Pet: " + consulta.getPet().getNome() +
                        ", Veterinário: " + consulta.getVeterinario() +
                        ", Data: " + consulta.getData() + "\n");
                }else{
                    System.out.println("Essa consulta já foi cadastrada");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar consultas: " + e.getMessage());
        }
    }

    private boolean consultaJaSalvo(Consulta consulta, String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.contains("ID Consulta: " + consulta.getId() + 
                                   ", Pet: " + consulta.getPet().getNome() + 
                                   ", Veterinário: " + consulta.getVeterinario() + 
                                   ", Data: " + consulta.getData())) {
                    return true; // Já existe no arquivo
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }

    public void salvarVacinasEmArquivo(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo, true)) {
            for (Vacina vacina : vacinas) {
                if(!vacinaJaSalvo(vacina, caminhoArquivo)){
                    writer.write("ID Vacina: " + vacina.getId() +
                        ", Pet: " + vacina.getPet().getNome() +
                        ", Nome Vacina: " + vacina.getNomeVacina() +
                        ", Data: " + vacina.getDataAplicacao() + "\n");
                }else{
                    System.out.println("Essa vacina já foi cadastrada!");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar vacinas: " + e.getMessage());
        }
    }

    private boolean vacinaJaSalvo(Vacina vacina, String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.contains("ID Vacina: " + vacina.getId() + 
                                   ", Pet: " + vacina.getPet().getNome() + 
                                   ", Nome Vacina: " + vacina.getNomeVacina() + 
                                   ", Data: " + vacina.getDataAplicacao())) {
                    return true; // Já existe no arquivo
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }

    public void salvarDonosEmArquivo(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo, true)) {
            for (Dono dono : donos) {
                if(!donoJaSalvo(dono, caminhoArquivo)){
                writer.write("ID Dono: " + dono.getId() +
                        ", Nome: " + dono.getNome() +
                        ", Telefone: " + dono.getTelefone() +
                        ", Endereço: " + dono.getEndereco() +
                        ", Cpf: " + dono.getCpf() + "\n");
                }else{
                    System.out.println("Esse dono já foi cadastrado!");
                }
            }
            
        } catch (IOException e) {
            System.out.println("Erro ao salvar donos: " + e.getMessage());
        }
    }
    private boolean donoJaSalvo(Dono dono, String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.contains("ID Dono: " + dono.getId() + 
                                   ", Nome: " + dono.getNome() + 
                                   ", Telefone: " + dono.getTelefone() + 
                                   ", Endereço: " + dono.getEndereco() + 
                                   ", Cpf: " + dono.getCpf())) {
                    return true; // Já existe no arquivo
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
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
        if(!donoJaSalvo(dono, "donos.txt")){
            System.out.println("Dono " + dono.getNome() + " cadastrado com sucesso!");
        };
    }

    // Método para cadastrar pet no sistema
    public void cadastrarPet(Pet pet) {
        pets.add(pet);
        if(!petJaSalvo(pet, "pets.txt")){
            System.out.println("Pet " + pet.getNome() + " cadastrado com sucesso!");
        }
        //
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
            Consulta novaConsulta = new Consulta(idConsulta, data, pet, veterinario, diagnostico);
            consultas.add(novaConsulta);
            if(!consultaJaSalvo(novaConsulta, diagnostico)){
                System.out.println("Consulta agendada para " + pet.getNome() + " com o veterinário " + veterinario);
            }
           
        } else {
            System.out.println("Pet não encontrado. Consulta não agendada.");
        }
    }

    public void agendarConsulta(int idConsulta, int idPet, String data, String veterinario) {
        Pet pet = consultarPet(idPet);
        if (pet != null) {
            Consulta novaConsulta = new Consulta(idConsulta, data, pet, veterinario);
            consultas.add(novaConsulta);
            if(!consultaJaSalvo(novaConsulta, "consultas.txt")){
                System.out.println("Consulta agendada para " + pet.getNome() + " com o veterinário " + veterinario);
            }
            //
        } else {
            System.out.println("Pet não encontrado. Consulta não agendada.");
        }
    }// caso a consulta nao tenha gerado algum diagnostico

    public void administrarVacina(int idVacina, int idPet, String nomeVacina, String dataAplicacao) {
        Pet pet = consultarPet(idPet);
        if (pet != null) {
            Vacina novaVacina = new Vacina(idVacina, nomeVacina, dataAplicacao, pet);
            vacinas.add(novaVacina);
            if(!vacinaJaSalvo(novaVacina, "vacinas.txt")){
                System.out.println("Vacina " + nomeVacina + " aplicada em " + pet.getNome());
            }
           
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

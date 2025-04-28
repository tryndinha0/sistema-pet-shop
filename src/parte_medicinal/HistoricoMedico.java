package parte_medicinal;

import java.util.ArrayList;
import java.util.List;

import animal_e_dono.animal.Pet;

public class HistoricoMedico {
    private Pet pet;
    private List<Consulta> consultas;
    private List<Vacina> vacinas;

    public HistoricoMedico(Pet pet) {
        this.pet = pet;
        this.consultas = new ArrayList<>();
        this.vacinas = new ArrayList<>();
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void adicionarVacina(Vacina vacina) {
        vacinas.add(vacina);
    }

    public String consultarHistoricoCompleto() {
        StringBuilder sb = new StringBuilder();
        sb.append("Histórico médico de ").append(pet.getNome()).append(":\n");

        sb.append("Consultas:\n");
        for (Consulta consulta : consultas) {
            sb.append(consulta.listarConsultas()).append("\n");
        }

        sb.append("Vacinas:\n");
        for (Vacina vacina : vacinas) {
            sb.append(vacina.consultarVacinas()).append("\n");
        }

        return sb.toString();
    }
}

package disciplina;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	private String nomeDaMateria;
	private String codigo;
	private int cargaHoraria;
	private List<Disciplina> preRequisitos;
	public Disciplina(String nomeDaMateria, String codigo, int cargaHoraria) {
		this.nomeDaMateria = nomeDaMateria;
		this.codigo = codigo;
		this.cargaHoraria = cargaHoraria;
		this.preRequisitos = new ArrayList<>();
	}
	public String getNomeDaMateria() {
		return nomeDaMateria;
	}
	public String getCodigo() {
		return codigo;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public List<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}
	public void setNomeDaMateria(String nomeDaMateria) {
		this.nomeDaMateria = nomeDaMateria;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public void setPreRequisitos(List<Disciplina> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}
	 public void adicionarPreRequisito(Disciplina a) {
	        if (!preRequisitos.contains(a)) {
	            preRequisitos.add(a);
	        }    
	}
	

}

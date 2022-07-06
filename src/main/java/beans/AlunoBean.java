package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import br.com.SistemaSimples.Aluno;
import br.com.dao.AlunoDAO;

@ManagedBean(name = "alunoBean")
@SessionScoped
public class AlunoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Aluno aluno;
	private List<Aluno> listaAlunos = new ArrayList<Aluno>();
	private AlunoDAO alunoDAO; 

	
	public AlunoBean() {
		aluno = new Aluno();
		alunoDAO = new AlunoDAO();
	}
	
	public void salvar() {
		listaAlunos.add(aluno);
		alunoDAO.salvar(aluno);
		aluno = new Aluno();
	}
	
	public void deletar(Aluno a) {
		alunoDAO.deletar(a.getId());
	}
	
	public void listarDoBanco() {
		listaAlunos = alunoDAO.buscar();
		
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public void setListaAlunos(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	

}

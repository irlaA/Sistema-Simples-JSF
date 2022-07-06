package br.com.dao;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import br.com.SistemaSimples.Aluno;
import br.com.util.FabricaConexao;

public class AlunoDAO {
	
	public void salvar(Aluno aluno) {
		try {
			Connection conexao =  FabricaConexao.getConexao();
			PreparedStatement ps = conexao.prepareCall("INSERT INTO public.alunos (matricula, nome, \"dataNascimento\", email) VALUES (?, ?, ?, ?);");
			ps.setString(1, aluno.getMatricula());
			ps.setString(2, aluno.getNome());
			ps.setDate(3, new Date(aluno.getDataNascimento().getTime()));
			ps.setString(4, aluno.getEmail());
			ps.execute();
			FabricaConexao.fecharConexao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(Integer idAluno) {
		try {
			Connection conexao = FabricaConexao.getConexao();
			PreparedStatement ps = conexao.prepareStatement("DELETE FROM public.alunos WHERE id=?");
			ps.setInt(1, idAluno);
			ps.execute();
			FabricaConexao.fecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Aluno> buscar() {
		try {
			Connection conexao = FabricaConexao.getConexao();
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM alunos;");
			ResultSet resultSet = ps.executeQuery();
			List<Aluno> listaDeAlunos = new ArrayList<Aluno>();
			
			while(resultSet.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(resultSet.getInt("id"));
				aluno.setMatricula(resultSet.getString("matricula"));
				aluno.setNome(resultSet.getString("nome"));
				aluno.setDataNascimento(resultSet.getDate("dataNascimento"));
				aluno.setEmail(resultSet.getString("email")); 
				listaDeAlunos.add(aluno);

			}
			FabricaConexao.fecharConexao();
			return listaDeAlunos;		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}

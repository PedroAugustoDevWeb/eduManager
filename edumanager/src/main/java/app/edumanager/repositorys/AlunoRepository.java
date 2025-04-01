package app.edumanager.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import app.edumanager.models.Aluno;


public interface AlunoRepository  extends JpaRepository<Aluno, Long>{
    
}

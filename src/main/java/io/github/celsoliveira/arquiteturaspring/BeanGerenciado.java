package io.github.celsoliveira.arquiteturaspring;

import io.github.celsoliveira.arquiteturaspring.todos.TodoEntity;
import io.github.celsoliveira.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanGerenciado {

    @Autowired // primeira forma de injetar componentes (por propriedade)
    private TodoValidator validator;

    // segunda forma de injetar componentes (por método setter)
    @Autowired
    public  void setValidator(TodoValidator validator){
        this.validator = validator;
    }

    // terceira forma de injetar componentes (por construtor)
    // @Autowired é opcional em injeção de dependencia por construtor
    // Esta é a maneira recomendada pelo spring framework
    public BeanGerenciado(TodoValidator validator){
        this.validator = validator;
    }

    public void utilizar(){
        validator.validar(new TodoEntity());
    }
}

package io.github.celsoliveira.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private final TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validar(TodoEntity todo){

        if (repository.existsByDescricao(todo.getDescricao())){
            throw new IllegalArgumentException("Já existe um TODO com esta descrição.");
        }
    }
}

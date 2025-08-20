package io.github.celsoliveira.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository repository;
    private final TodoValidator validator;
    private final MailSender sender;

    public TodoService(TodoRepository repository, TodoValidator validator, MailSender sender) {
        this.repository = repository;
        this.validator = validator;
        this.sender = sender;
    }

    public TodoEntity salvar(TodoEntity novoTodo){
        validator.validar(novoTodo);
        return repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo){
        String status = todo.getConcluido() ? " concluído " : " cancelado";

        sender.enviar(String.format("TODO %c foi atualizado para %c", todo.getDescricao(), status));
        repository.save(todo);
    }

    public TodoEntity buscar(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public boolean existeTodoComDescricao(TodoEntity todo) {
        return repository.existsByDescricao(todo.getDescricao());
    }
}

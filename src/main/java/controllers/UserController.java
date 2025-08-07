package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.UsuarioRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        usuario.setDataCadastro(LocalDate.now());
        return usuarioRepository.save(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario>
    buscar(@PathVariable Integer id) {
        return usuarioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario>
    atualizar(@PathVariable Integer id,
              @RequestBody Usuario atual) {
        return usuarioRepository.findById(id).map(usuario) {
            usuario.setNome(atual.getNome());
            usuario.setEmail(atual.getEmail());
            return ResponseEntity.ok(usuarioRepository.save(usuario));

            })or.Else(ResponseEntity.notFound().build());
    }

     @DeleteMapping("/{id})
public void deletar(@PathVariable Integer id) {
usuarioRepository.deleteById(id);
}
}

package com.gremio.controller;

import com.gremio.model.Contacto;
import com.gremio.repository.ContactoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactoController {

    private final ContactoRepository repo;

    public ContactoController(ContactoRepository repo) {
        this.repo = repo;
    }

    // READ: mostrar todos los contactos
    @GetMapping("/contactos")
    public String listar(Model model) {
        model.addAttribute("contactos", repo.findAll());
        return "contactos";
    }

    // CREATE: mostrar formulario nuevo
    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "nuevo";
    }

    // CREATE: guardar contacto
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Contacto contacto) {
        repo.save(contacto);
        return "redirect:/contactos";
    }

    // UPDATE: mostrar formulario de edición
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Contacto contacto = repo.findById(id).orElse(null);

        if (contacto == null) {
            return "redirect:/contactos";
        }

        model.addAttribute("contacto", contacto);
        return "editar";
    }

    // UPDATE: guardar los cambios
    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Contacto contacto) {
        if (contacto.getId() != null
                && repo.existsById(contacto.getId())) {
            repo.save(contacto);
        }

        return "redirect:/contactos";
    }

    // DELETE: eliminar contacto
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/contactos";
    }
}


package com.Butterfly.controller;

import com.Butterfly.domain.Nail;
import com.Butterfly.services.TipoService;
import com.Butterfly.services.NailService;
import com.Butterfly.services.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/nail")
public class NailController {

    @Autowired
    private NailService nailService;
    @Autowired
    private TipoService tipoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var nails = nailService.getNail(false);
        model.addAttribute("nails", nails);
        model.addAttribute("totalNails", nails.size());
        var tipos = tipoService.getTipo(false);

        model.addAttribute("tipos", tipos);
        return "/nail/listado";
    }
    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Nail nail,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            nailService.save(nail);
            String rutaImagen = firebaseStorageService.cargaImagen(imagenFile,
                    "nail", nail.getIdNail());
            nail.setRutaImagen(rutaImagen);
        }
        nailService.save(nail);
        return "redirect:/nail/listado";
    }

    @GetMapping("/eliminar/{idNail}")
    public String eliminar(Nail nail) {
        nailService.delete(nail);
        return "redirect:/nail/listado";
    }

    @GetMapping("/modificar/{idNail}")
    public String modificar(Nail nail, Model model) {
        nail = nailService.getNail(nail);
        model.addAttribute("nail", nail);
        var tipos = tipoService.getTipo(false);

        model.addAttribute("tipos", tipos);
        return "/nail/modifica";
    }
}

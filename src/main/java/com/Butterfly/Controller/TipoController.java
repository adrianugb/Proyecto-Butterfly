package com.Butterfly.Controller;
import com.Butterfly.domain.Tipo;
import com.Butterfly.services.TipoService;
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
@RequestMapping("/tipo")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = tipoService.getTipo(false);
        
        model.addAttribute("tipos", lista);
        model.addAttribute("totalTipos", lista.size());
        
        return "/tipo/listado";
    }
    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Tipo tipo,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            tipoService.save(tipo);
            String rutaImagen = firebaseStorageService.cargaImagen(imagenFile,
                    "tipo", tipo.getIdTipo());
            tipo.setRutaImagen(rutaImagen);
        }
        tipoService.save(tipo);
        return "redirect:/tipo/listado";
    }

    @GetMapping("/eliminar/{idTipo}")
    public String eliminar(Tipo tipo) {
        tipoService.delete(tipo);
        return "redirect:/tipo/listado";
    }
    @GetMapping("/modificar/{idTipo}")
    public String modificar(Tipo tipo, Model model) {
        tipo = tipoService.getTipo(tipo);
        model.addAttribute("tipo", tipo);
        return "/tipo/modifica";
    }
}

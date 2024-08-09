package com.Butterfly.Controller;

import com.Butterfly.domain.Tipo;
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
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private NailService nailService;
    @Autowired
    private TipoService tipoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var nails = nailService.getNail(false);
        model.addAttribute("nails", nails);
        
        var tipos = tipoService.getTipo(false);
        model.addAttribute("tipos", tipos);
        return "/pruebas/listado";
    }
    
    @GetMapping("/listado/{idTipo}")
    public String listado(Tipo tipo, Model model) {
        var nails = tipoService.getTipo(tipo).getNails();
        model.addAttribute("nails", nails);
        
        var tipos = tipoService.getTipo(false);
        model.addAttribute("tipos", tipos);
        return "/pruebas/listado";
    }
    
    @GetMapping("/listado2")
    public String listado2(Model model) {
        var nails = nailService.getNail(false);
        model.addAttribute("nails", nails);
        
        return "/pruebas/listado2";
    }
    
    @GetMapping("/consulta1")
    public String consulta1(
            @RequestParam(value="precioInf") double precioInf,
            @RequestParam(value="precioSup") double precioSup,
            Model model) {
        
        var nails = nailService.consulta1(precioInf, precioSup);
        model.addAttribute("nails", nails);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        
        return "/pruebas/listado2";
    }

    @GetMapping("/consulta2")
    public String consulta2(
            @RequestParam(value="precioInf") double precioInf,
            @RequestParam(value="precioSup") double precioSup,
            Model model) {
        
        var nails = nailService.consulta2(precioInf, precioSup);
        model.addAttribute("nails", nails);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        
        return "/pruebas/listado2";
    }

    @GetMapping("/consulta3")
    public String consulta3(
            @RequestParam(value="precioInf") double precioInf,
            @RequestParam(value="precioSup") double precioSup,
            Model model) {
        
        var nails = nailService.consulta3(precioInf, precioSup);
        model.addAttribute("nails", nails);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        
        return "/pruebas/listado2";
    }
}

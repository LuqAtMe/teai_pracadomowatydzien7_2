package home.application.teai_pracadomowatydzien7_2;

import home.application.teai_pracadomowatydzien7_2.dao.FactDao;
import home.application.teai_pracadomowatydzien7_2.model.AnimalFactDB;
import home.application.teai_pracadomowatydzien7_2.service.FactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FactController {

    private FactService factService;
    private FactDao factDao;

    @Autowired
    public FactController(FactService factService, FactDao factDao) {
        this.factService = factService;
        this.factDao = factDao;
    }

    @GetMapping("/facts")
    public String showFacts(Model model) {
        model.addAttribute("facts", factDao.getAllFacts());
        return "facts";
    }

    @GetMapping("/downloadFact")
    public String downloadFact() {
        factDao.createNewFactInDatabase(factService.getFact());
        return "redirect:/facts";
    }

    @GetMapping("/delete/{idFact}")
    public String delete(@PathVariable long idFact){
        factDao.delete(idFact);
        return "redirect:/facts";
    }

    @GetMapping("/fact-edit/{idFact}")
    public String factEdit(Model model, @PathVariable long idFact) {
        model.addAttribute("selectedFact", factDao.findFact(idFact));
        return "fact-edit";
    }

    @PostMapping("/saveFact")
    public String saveEditedFact(@ModelAttribute AnimalFactDB animalFactDB) {
        factDao.updateFact(animalFactDB);
        return "redirect:/facts";
    }

    @GetMapping ("/back")
    public String back(){
        return "redirect:/facts";
    }


}

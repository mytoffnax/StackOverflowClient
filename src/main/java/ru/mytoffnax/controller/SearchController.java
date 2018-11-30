package ru.mytoffnax.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import ru.mytoffnax.entities.SearchFilters;
import ru.mytoffnax.entities.StackExchangeResponse;
import ru.mytoffnax.services.SOService;

@Controller
@RequiredArgsConstructor
public class SearchController {
	
	private final SOService soService;
	
	Logger logger = LoggerFactory.getLogger(SearchController.class);
	
    @GetMapping("/")
    public String home(Model model) {
    	return fillingModel(new SearchFilters(), model);
    }
    
    @RequestMapping(value="/", method=RequestMethod.POST, params="action=search")
    public String search(@ModelAttribute SearchFilters filters, Model model) {
    	return fillingModel(filters, model);
    }
    
    @RequestMapping(value="/", method=RequestMethod.POST, params="action=clear")
    public String clear(Model model) {
    	return fillingModel(new SearchFilters(), model);
    }
    
    private String fillingModel(SearchFilters filters, Model model) {
    	StackExchangeResponse response = soService.search(filters);
    	if (response != null) {
    		logger.info("Поиск прошёл успешно. Наполнение модели");
            model.addAttribute("items", response.getItems());
            model.addAttribute("filters", filters);
            return "index";	
    	} else {
    		logger.info("При выполнении поиска произошла ошибка");
    		return "error";
    	}
    }
}

package br.com.fws.docker.app.controller;

import br.com.fws.docker.app.models.Product;
import br.com.fws.docker.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by nando on 06/05/17.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping(value = {"/", ""})
    public ModelAndView allProducts(){

        ModelAndView view = new ModelAndView("products");

        view.addObject("products", repository.findAll());

        return view;

    }


    @GetMapping(value = {"/new", "/{name}"})
    public ModelAndView form(@PathVariable("name") Optional<String> optionlName, Product product){

        if (optionlName.isPresent()){
            Optional<Product> productByName = repository.findProductByName(optionlName.get());

            return form(productByName);
        }


        return form(Optional.empty());
    }

    private ModelAndView form(Optional<Product> product){
        ModelAndView view = new ModelAndView("form");

        view.addObject("product", product.orElse(Product.empty()));

        return view;
    }


    @PostMapping(value = {"/", ""})
    @Transactional
    public ModelAndView saveProduct(@Valid  Product product, BindingResult result){
        ModelAndView view = new ModelAndView("redirect:/products");

        if (result.hasErrors()){
            return form(Optional.ofNullable(product));
        }

        repository.save(product);


        return view;
    }

}

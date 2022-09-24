package net.infortmation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppController {

	@Autowired
	private UsuarioDAO dao;
	@Autowired
	private ModoDAO daoModo;
	@Autowired
	private LugarDAO daoLugar;
	@Autowired
	private CosmeticoDAO daoCosmetico;
	@Autowired
	private ArmaDAO daoArma;
	@Autowired
	private RelacionDAO daoRelacion;

	@RequestMapping("/")
	public String ViewHomePage(Model model) {
		List<Usuario> listUsuario = dao.list();
		List<Modo> listModo = daoModo.list();
		List<Lugar> listLugar = daoLugar.list();
		List<Cosmetico> listCosmetico = daoCosmetico.list();
		List<Arma> listArma = daoArma.list();
		List<Relacion> listRelacion = daoRelacion.list();
		model.addAttribute("listUsuario", listUsuario);
		model.addAttribute("listModo", listModo);
		model.addAttribute("listLugar", listLugar);
		model.addAttribute("listCosmetico", listCosmetico);
		model.addAttribute("listArma", listArma);
		model.addAttribute("listRelacion", listRelacion);
		return "index";
	}

	@RequestMapping("/new")
	public String showNewForm(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);

		return "new_form";
	}

	@RequestMapping("/newModo")
	public String showNewFormModo(Model model) {
		Modo modo = new Modo();
		model.addAttribute("modo", modo);

		return "new_form_modo";
	}

	@RequestMapping("/newLugar")
	public String showNewFormLugar(Model model) {
		Lugar lugar = new Lugar();
		model.addAttribute("lugar", lugar);

		return "new_form_lugar";
	}

	@RequestMapping("/newCosmetico")
	public String showNewFormCosmetico(Model model) {
		Cosmetico cosmetico = new Cosmetico();
		model.addAttribute("cosmetico", cosmetico);

		return "new_form_cosmetico";
	}

	@RequestMapping("/newArma")
	public String showNewFormArma(Model model) {
		Arma arma = new Arma();
		model.addAttribute("arma", arma);

		return "new_form_arma";
	}

	@RequestMapping("/newRelacion")
	public String showNewFormRelacion(Model model) {
		Relacion relacion = new Relacion();
		model.addAttribute("relacion", relacion);

		return "new_form_relacion";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("usuario") Usuario usuario) {
		dao.save(usuario);

		return "redirect:/";
	}

	@RequestMapping(value = "/saveModo", method = RequestMethod.POST)
	public String saveModo(@ModelAttribute("modo") Modo modo) {
		daoModo.save(modo);

		return "redirect:/";
	}

	@RequestMapping(value = "/saveLugar", method = RequestMethod.POST)
	public String saveLugar(@ModelAttribute("lugar") Lugar lugar) {
		daoLugar.save(lugar);

		return "redirect:/";
	}

	@RequestMapping(value = "/saveCosmetico", method = RequestMethod.POST)
	public String saveCosmetico(@ModelAttribute("cosmetico") Cosmetico cosmetico) {
		daoCosmetico.save(cosmetico);

		return "redirect:/";
	}

	@RequestMapping(value = "/saveArma", method = RequestMethod.POST)
	public String saveArma(@ModelAttribute("arma") Arma arma) {
		daoArma.save(arma);

		return "redirect:/";
	}

	@RequestMapping(value = "/saveRelacion", method = RequestMethod.POST)
	public String saveRelacion(@ModelAttribute("relacion") Relacion relacion) {
		daoRelacion.save(relacion);

		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("edit_form");
		Usuario usuario = dao.get(id);
		mav.addObject("usuario", usuario);

		return mav;
	}

	@RequestMapping("/editModo/{id}")
	public ModelAndView showEditFormModo(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_form_modo");
		Modo modo = daoModo.get(id);
		mav.addObject("modo", modo);

		return mav;
	}

	@RequestMapping("/editLugar/{id}")
	public ModelAndView showEditFormLugar(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_form_lugar");
		Lugar lugar = daoLugar.get(id);
		mav.addObject("lugar", lugar);

		return mav;
	}

	@RequestMapping("/editCosmetico/{id}")
	public ModelAndView showEditFormCosmetico(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_form_cosmetico");
		Cosmetico cosmetico = daoCosmetico.get(id);
		mav.addObject("cosmetico", cosmetico);

		return mav;
	}

	@RequestMapping("/editArma/{id}")
	public ModelAndView showEditFormArma(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_form_arma");
		Arma arma = daoArma.get(id);
		mav.addObject("arma", arma);

		return mav;
	}

	@RequestMapping("/editRelacion/{id}")
	public ModelAndView showEditFormRelacion(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_form_relacion");
		Relacion relacion = daoRelacion.get(id);
		mav.addObject("relacion", relacion);

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("usuario") Usuario usuario) {
		dao.update(usuario);

		return "redirect:/";
	}

	@RequestMapping(value = "/updateModo", method = RequestMethod.POST)
	public String updateModo(@ModelAttribute("modo") Modo modo) {
		daoModo.update(modo);

		return "redirect:/";
	}

	@RequestMapping(value = "/updateLugar", method = RequestMethod.POST)
	public String updateLugar(@ModelAttribute("lugar") Lugar lugar) {
		daoLugar.update(lugar);

		return "redirect:/";
	}

	@RequestMapping(value = "/updateCosmetico", method = RequestMethod.POST)
	public String updateCosmetico(@ModelAttribute("cosmetico") Cosmetico cosmetico) {
		daoCosmetico.update(cosmetico);

		return "redirect:/";
	}

	@RequestMapping(value = "/updateArma", method = RequestMethod.POST)
	public String updateArma(@ModelAttribute("arma") Arma arma) {
		daoArma.update(arma);

		return "redirect:/";
	}

	@RequestMapping(value = "/updateRelacion", method = RequestMethod.POST)
	public String updateRelacion(@ModelAttribute("relacion") Relacion relacion) {
		daoRelacion.update(relacion);

		return "redirect:/";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") String id) {
		dao.delete(id);

		return "redirect:/";
	}

	@RequestMapping("/deleteModo/{id}")
	public String deleteModo(@PathVariable(name = "id") int id) {
		daoModo.delete(id);

		return "redirect:/";
	}

	@RequestMapping("/deleteLugar/{id}")
	public String deleteLugar(@PathVariable(name = "id") int id) {
		daoLugar.delete(id);

		return "redirect:/";
	}

	@RequestMapping("/deleteCosmetico/{id}")
	public String deleteCosmetico(@PathVariable(name = "id") int id) {
		daoCosmetico.delete(id);

		return "redirect:/";
	}

	@RequestMapping("/deleteArma/{id}")
	public String deleteArma(@PathVariable(name = "id") int id) {
		daoArma.delete(id);

		return "redirect:/";
	}

	@RequestMapping("/deleteRelacion/{id}")
	public String deleteRelacion(@PathVariable(name = "id") int id) {
		daoRelacion.delete(id);

		return "redirect:/";
	}

	@RequestMapping("/funcionRelacion/")
	public String funcionRelacion() {
		daoRelacion.funcion();

		return "redirect:/";
	}


}
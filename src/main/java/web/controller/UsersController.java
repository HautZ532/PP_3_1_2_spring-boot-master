package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
	private final UserService userService;

	public UsersController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping
	public String printAllUsers(Model model) {
		model.addAttribute("usersList", userService.getAllUsers());
		return "pages/users";
	}

	@GetMapping("/addUser")
	public String addUser(ModelMap model) {
		model.addAttribute("user", new User());
		return "pages/saveUser";
	}

	@PostMapping()
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:pages/users";
	}

	@GetMapping("/editUser")
	public String userEdit(@RequestParam(value = "id") long id, Model model) {
		model.addAttribute("user", userService.getUser(id));
		return "pages/userEdit";
	}

	@PatchMapping()
	public String userUpdate(@ModelAttribute("user") User user) {
		userService.editUser(user);
		return "redirect:pages/users";
	}

	@DeleteMapping()
	public String removeUser(@RequestParam("id") long id) {
		userService.removeUser(id);
		return "redirect:pages/users";
	}

}
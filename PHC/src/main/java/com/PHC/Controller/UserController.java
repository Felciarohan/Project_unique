package com.PHC.Controller;

import com.PHC.Entity.User;
import com.PHC.Repo.UserRepo;
import com.PHC.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/phc")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/signup")
    public String showSignUpForm() {
        return "signup";
    }

    @GetMapping("/signin")
    public String showSignInForm() {
        return "signin";
    }

    @PostMapping("/signup")
    public String processSignUp(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String passwd,
                                @RequestParam String role,
                                Model model) {
        User u = new User();
        u.setName(name);
        u.setEmail(email);
        u.setPasswd(passwd);
        u.setRole(role);
        userRepo.save(u);
        model.addAttribute("message", "Sign-up successful. Please sign in.");
        return "signin";
    }

    @PostMapping("/signin")
    public String processLogin(@RequestParam String email,
                               @RequestParam String passwd,
                               Model model) {
        // Correct way to call instance method
        User u = userRepo.findByEmail(email);
        if (u != null && u.getPasswd().equals(passwd)) {
            model.addAttribute("user", u);
            return "Home";
        } else {
            model.addAttribute("error", "Invalid Credentials");
            return "signup";
        }
    }
}

//@PostMapping("/ask")
//@ResponseBody
//public Map<String, String> askQuestion(@RequestParam("question") String question) {
//    if (question == null || question.trim().isEmpty()) {
//        return Map.of("error", "Question cannot be empty.");
//    }
//
//    try {
//        String answer = qnaService.getAnswer(question);
//        return Map.of("response", answer);
//    } catch (Exception e) {
//        return Map.of("error", "Error fetching response from AI.");
//    }
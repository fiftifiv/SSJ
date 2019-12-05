package com.shkiddi_school.controller;

import com.shkiddi_school.domain.User;
import com.shkiddi_school.domain.dto.CaptchResponseDto;
import com.shkiddi_school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private final static String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response%s";

    @Value("${recaptcha.secret}")
    private String secret;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @RequestParam("g-recaptcha-response") String captchaResponce,
            @Valid User user,
            BindingResult bindingResult,
            Model model) {

        String url = String.format(CAPTCHA_URL, secret, captchaResponce);
        Class<CaptchResponseDto> responseType = CaptchResponseDto.class;

        ResponseEntity<CaptchResponseDto> captchResponseDtoResponseEntity = restTemplate.postForEntity(url, Collections.emptyList(), responseType);

        if(!(captchResponseDtoResponseEntity.getBody().isSuccess())){
            model.addAttribute("captchaError","Fill captcha");
        }

        if (user.getPassword2() != null & !(user.getPassword().equals(user.getPassword2()))) {
            model.addAttribute("passwordError", "Passwords are different");
            return "registration";
        }

        if (  bindingResult.hasErrors() || captchResponseDtoResponseEntity.getBody().isSuccess()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "registration";
        }


        if (!userService.addUser(user)) {
            model.addAttribute("usernameError", "User exists!");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActived = userService.activateUser(code);

        if (isActived) {
            model.addAttribute("goodMessage", "User successfull activated");
        } else {
            model.addAttribute("badMessage", "Activation code is not found!");
        }
        return "login";
    }


}

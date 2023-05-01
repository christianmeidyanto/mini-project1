package com.miniproject.User;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    // Get All Data User
    @GetMapping("/user")
    public Iterable<User> index() {
        return userRepo.findAll();
    }

    // Login User
    @PostMapping("/api/login/")
    public User loginUser(@RequestBody LoginRequest user) {
        return userRepo.getUser(user.getUser(), user.getPassword());
    }

    // @GetMapping("/api/login/{username}")
    // public UserDetails getUserName(@PathVariable("username") String username,
    // HttpServletResponse response)
    // throws UsernameNotFoundException {
    // Cookie jwtTokenCookie = new Cookie("username", username);
    // jwtTokenCookie.setMaxAge(86400);
    // jwtTokenCookie.setSecure(true);
    // jwtTokenCookie.setHttpOnly(true);
    // response.addCookie(jwtTokenCookie);
    // User user = userRepo.findById(username)
    // .orElseThrow(() -> new UsernameNotFoundException("Username not found : " +
    // username));
    // return new
    // org.springframework.security.core.userdetails.User(user.getUsername(),
    // user.getPassword(),
    // new ArrayList<>());
    // }
}

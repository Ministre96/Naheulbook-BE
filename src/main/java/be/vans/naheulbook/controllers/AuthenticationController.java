package be.vans.naheulbook.controllers;

import be.vans.naheulbook.models.dtos.TokenDTO;
import be.vans.naheulbook.models.form.SignInForm;
import be.vans.naheulbook.utills.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class AuthenticationController {
    private final UserDetailsService userDetailsService;
    private final JwtHelper jwtHelper;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationController(UserDetailsService userDetailsService, JwtHelper jwtHelper, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;this.jwtHelper = jwtHelper;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(path = {"/login", "/sign-in"})
    public ResponseEntity<?> signInAction(
            @RequestBody SignInForm form
    ) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(form.getUsername());
        final String token = jwtHelper.generateToken(userDetails);

        return ResponseEntity.ok(new TokenDTO(token));
    }

}

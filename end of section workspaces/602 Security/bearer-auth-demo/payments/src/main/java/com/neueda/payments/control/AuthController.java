package com.neueda.payments.control;

import com.neueda.payments.security.bearer.AuthRequest;
import com.neueda.payments.security.bearer.AuthResponse;
import com.neueda.payments.security.bearer.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping
    public Map<String,String> test() {
        return Map.of("status", "ok");
    }


    private AuthResponse createNewTokens(String username) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String jwt = jwtUtils.generateToken(userDetails.getUsername(), userDetails.getAuthorities().stream().collect(Collectors.toList()));
        final String refreshJwt = jwtUtils.generateRefreshToken(userDetails.getUsername());
        return new AuthResponse(jwt, refreshJwt);
    }

    @PostMapping
    public AuthResponse authenticate(@RequestBody AuthRequest authenticationRequest)  {
        //TODO: this could be implemented using basic auth
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        return createNewTokens(authenticationRequest.getUsername());
    }

    @PostMapping("/refresh")
    public AuthResponse refresh(@RequestBody AuthRequest authenticationRequest) {
        final String refreshToken = authenticationRequest.getPassword();
        if (jwtUtils.validateToken(refreshToken, authenticationRequest.getUsername())) {
            return createNewTokens(authenticationRequest.getUsername());
        } else {
            throw new RuntimeException("Invalid refresh token");
        }
    }

}

package com.example.lamnghiep2.controller;

import com.example.lamnghiep2.model.LN_Account;
import com.example.lamnghiep2.payload.request.LoginRequest;
import com.example.lamnghiep2.payload.response.JwtResponse;
import com.example.lamnghiep2.payload.response.MessageResponse;
import com.example.lamnghiep2.repository.AccountRepository;
import com.example.lamnghiep2.security.jwt.JwtUtils;
import com.example.lamnghiep2.service.UserDetailsImpl;
import com.example.lamnghiep2.service.UserDetailsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  AccountRepository accountRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;
  @Autowired
  UserDetailsServiceImpl userService;
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Optional<LN_Account> lnAccount = userService.getByTaiKhoan(loginRequest.getUsername());
    if (!accountRepository.existsByUsername(loginRequest.getUsername())) {
      return new ResponseEntity<>(new MessageResponse("INVALID_USERNAME"), HttpStatus.BAD_REQUEST);
    }
    if (!encoder.matches(loginRequest.getPassword(), lnAccount.get().getPassword())) {
      return new ResponseEntity<>(new MessageResponse("INVALID_PASSWORD"), HttpStatus.BAD_REQUEST);
    }
    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(),
            userDetails.getUsername()));
  }

}

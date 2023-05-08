package com.example.jwt_from_amigoscode.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
@RequiredArgsConstructor
@Secured("ROLE_ADMIN")
@ResponseStatus(HttpStatus.OK)
public class DemoController {

    @GetMapping
    public ResponseEntity<String> sayHello(){
        var a = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(a);
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getCredentials());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getDetails());
        return ResponseEntity.ok("Hello from secured endpoint");
    }
}

package br.edu.ifpb.ifgram.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("users")
public class UsersController {

        @GetMapping
        public String getUser(){
            return "get user was called";
        }

        @PostMapping
    public String postUser(){
            return "chamei o endpoint como um POST";
        }

        @DeleteMapping
    public String deleteUser(){
            return "chamei o endpoint como um DELETE";
        }

        @PutMapping
    public String putUser(){
            return "chamei o endpoint como um PUT";
        }

        @PatchMapping
    public String patchUser(){
            return "chamei o endpoint como um PATCH";
        }
}

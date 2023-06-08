package com.teste.LeitorDeScripts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/executar")
public class Controller {


    public String aopaMundo(){
        return "Aopa mundo!";
    }

    @GetMapping
    public String executaArquivo() throws IOException {
        String caminhoScript = "src/main/resources/teste.sh";
        ProcessBuilder builder = new ProcessBuilder("bash", caminhoScript);
        InputStream inputStream = builder.start().getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String retorno = reader.readLine();

        return retorno;
    }

}

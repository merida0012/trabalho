package br.com.open.ai.cecg.OpenAI.http;

import br.com.open.ai.cecg.OpenAI.http.data.request.BooksRequestDTO;
import br.com.open.ai.cecg.OpenAI.http.data.request.SeriesRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.open.ai.cecg.OpenAI.http.data.request.ScienceFictionRequestDTO;

public interface OpenAIController {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    String generateScienceFiction(@RequestBody ScienceFictionRequestDTO requestDTO);

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    String generateSeries(@RequestBody SeriesRequestDTO requestDTO);

    @PostMapping(value = "/books")
    @ResponseStatus(HttpStatus.OK)
    String generateBooks(@RequestBody BooksRequestDTO requestDTO);
}

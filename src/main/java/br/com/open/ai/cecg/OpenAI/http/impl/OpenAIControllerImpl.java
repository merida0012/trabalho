package br.com.open.ai.cecg.OpenAI.http.impl;

import br.com.open.ai.cecg.OpenAI.http.OpenAIController;
import br.com.open.ai.cecg.OpenAI.http.data.request.BooksRequestDTO;
import br.com.open.ai.cecg.OpenAI.http.data.request.ScienceFictionRequestDTO;
import br.com.open.ai.cecg.OpenAI.http.data.request.SeriesRequestDTO;
import br.com.open.ai.cecg.OpenAI.service.CallOpenAiService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/openai-cecg")
public record OpenAIControllerImpl(CallOpenAiService service) implements OpenAIController {

    @Override
    @PostMapping(value = "/science-fiction")
    @ResponseStatus(HttpStatus.OK)
    public String generateScienceFiction(@RequestBody ScienceFictionRequestDTO requestDTO) {
        return service.generateScienceFiction(requestDTO);
    }

    @Override
    @PostMapping(value = "/series")
    @ResponseStatus(HttpStatus.OK)
    public String generateSeries(@RequestBody SeriesRequestDTO requestDTO) {
        return service.generateSeries(requestDTO);
    }


    @Override
    @PostMapping(value = "/books")
    @ResponseStatus(HttpStatus.OK)
    public String generateBooks(@RequestBody BooksRequestDTO requestDTO) {
        return service.generateBooks(requestDTO);
    }
}

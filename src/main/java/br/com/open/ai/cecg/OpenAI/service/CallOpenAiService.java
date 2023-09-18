package br.com.open.ai.cecg.OpenAI.service;

import br.com.open.ai.cecg.OpenAI.http.data.request.BooksRequestDTO;
import br.com.open.ai.cecg.OpenAI.http.data.request.ScienceFictionRequestDTO;
import br.com.open.ai.cecg.OpenAI.http.data.request.SeriesRequestDTO;

public interface CallOpenAiService {
    String generateScienceFiction(ScienceFictionRequestDTO requestDTO);
    String generateSeries(SeriesRequestDTO requestDTO);
    String generateBooks(BooksRequestDTO requestDTO);
}

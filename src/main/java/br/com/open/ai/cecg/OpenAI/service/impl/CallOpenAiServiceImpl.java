package br.com.open.ai.cecg.OpenAI.service.impl;

import br.com.open.ai.cecg.OpenAI.component.ChatStreamComponent;
import br.com.open.ai.cecg.OpenAI.http.data.request.BooksRequestDTO;
import br.com.open.ai.cecg.OpenAI.http.data.request.ScienceFictionRequestDTO;
import br.com.open.ai.cecg.OpenAI.http.data.request.SeriesRequestDTO;
import br.com.open.ai.cecg.OpenAI.service.CallOpenAiService;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record CallOpenAiServiceImpl(ChatStreamComponent streamComponent) implements CallOpenAiService {

    public static final String SCIENCE_FICTION_PROMPT_MESSAGE =
            "Gere uma estória de ficção científica de acordo com o " +
                    "seguinte cenário: %s";

    public static final String SERIES_PROMPT_MESSAGE =
            "Sugira para eu assistir series do gênero %s" +
                    "que tenha o ator %s";

    public static final String BOOKS_PROMPT_MESSAGE_PROMPT_MESSAGE =
            "Sugira para eu ler livros do gênero %s";


    @Override
    public String generateScienceFiction(ScienceFictionRequestDTO requestDTO) {
        ChatCompletionRequest chatCompletionRequest =
                streamComponent.createChatStreamRequest(List.of(
                        new ChatMessage(ChatMessageRole.SYSTEM.value(),
                                String.format(SCIENCE_FICTION_PROMPT_MESSAGE, requestDTO.scenario()))
                ));
        return streamComponent.getChatStreamResult(chatCompletionRequest);
    }

    @Override
    public String generateSeries(SeriesRequestDTO requestDTO) {
        ChatCompletionRequest chatCompletionRequest =
                streamComponent.createChatStreamRequest(List.of(
                        new ChatMessage(ChatMessageRole.SYSTEM.value(),
                                String.format(SERIES_PROMPT_MESSAGE, requestDTO.genre(), requestDTO.actor()))
                ));
        return streamComponent.getChatStreamResult(chatCompletionRequest);
    }

    @Override
    public String generateBooks(BooksRequestDTO requestDTO) {
        ChatCompletionRequest chatCompletionRequest =
                streamComponent.createChatStreamRequest(List.of(
                        new ChatMessage(ChatMessageRole.SYSTEM.value(),
                                String.format(BOOKS_PROMPT_MESSAGE_PROMPT_MESSAGE, requestDTO.genre()))
                ));
        return streamComponent.getChatStreamResult(chatCompletionRequest);
    }
}

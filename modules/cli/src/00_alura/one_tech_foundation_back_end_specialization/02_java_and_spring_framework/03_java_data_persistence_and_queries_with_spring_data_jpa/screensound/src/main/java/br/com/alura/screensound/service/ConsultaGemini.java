package br.com.alura.screensound.service;

import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class ConsultaGemini {

    public static String obterInformacao(String texto) {

        GoogleAiGeminiChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("GOOGLE_API_KEY"))
                .modelName("gemini-1.5-flash")
                .temperature(0.7)
                .build();

        String prompt = "Me fale sobre o artista: " + texto;

        String resposta = model.chat(prompt);

        return resposta;
    }
}

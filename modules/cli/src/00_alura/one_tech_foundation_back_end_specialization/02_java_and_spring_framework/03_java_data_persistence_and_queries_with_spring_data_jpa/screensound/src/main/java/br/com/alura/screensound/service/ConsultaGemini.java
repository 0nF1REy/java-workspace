package br.com.alura.screensound.service;

import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class ConsultaGemini {

    public static String obterInformacao(String texto) {

        GoogleAiGeminiChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("GOOGLE_API_KEY"))
                .modelName("gemini-1.5-flash")
                .temperature(0.7)
                .build();

        String prompt =
                "Quero uma análise detalhada e profunda sobre o artista: \"" + texto + "\".\n\n" +
                        "Por favor, responda seguindo exatamente esta estrutura:\n\n" +
                        "1. **Biografia e trajetória** — Conte a história do artista de maneira cronológica e introspectiva. Explique seu início, desenvolvimento da carreira, momentos importantes, mudanças de fase e evolução artística.\n\n" +
                        "2. **Estilo musical e identidade artística** — Analise o estilo, influências, elementos característicos, temas líricos e contribuições originais do artista.\n\n" +
                        "3. **Recepção pública e crítica** — Descreva como o artista foi recebido pelo público e pela crítica ao longo dos anos. Cite momentos de maior aclamação, polêmicas ou quedas de popularidade.\n\n" +
                        "4. **Gravadoras, produtores e colaborações relevantes** — Informe quais gravadoras o representaram, produtores importantes com quem trabalhou e colaborações significativas.\n\n" +
                        "5. **Formação da banda (se for artista de banda)** — Caso seja um artista que integrou uma banda, liste os integrantes, instrumentos, principais formações e mudanças ao longo do tempo.\n\n" +
                        "6. **Impacto cultural e legado** — Explique sua importância na música, na cultura e em gerações seguintes. Aborde inovações, movimentos culturais influenciados e sua relevância histórica.\n\n" +
                        "7. **Comentários de críticos e mídia especializada** — Traga análises reais ou representativas de veículos especializados da época. Evite inventar nomes ou citações se não encontrar.\n\n" +
                        "8. **Contexto histórico e musical do período** — Explique o que estava acontecendo no mundo e no cenário musical durante os momentos de maior atividade do artista.\n\n" +
                        "IMPORTANTE: Se houver qualquer informação incerta, especulativa ou inexistente, diga claramente que não conseguiu encontrar. Não invente dados e não preencha lacunas com especulação.";

        String resposta = model.chat(prompt);

        return resposta;
    }
}

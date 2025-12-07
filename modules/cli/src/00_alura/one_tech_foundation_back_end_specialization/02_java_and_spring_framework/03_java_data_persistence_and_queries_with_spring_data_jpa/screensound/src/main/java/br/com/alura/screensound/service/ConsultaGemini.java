package br.com.alura.screensound.service;

import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class ConsultaGemini {

    public static String obterInformacao(String texto) {

        String apiKey = System.getProperty("GEMINI_API_KEY");

        GoogleAiGeminiChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .temperature(0.7)
                .build();

        String prompt =
                "Quero uma análise extremamente detalhada, profunda e confiável sobre o artista: \"" + texto + "\".\n\n" +
                        "A resposta deve ser escrita INTEIRAMENTE em PARÁGRAFOS corridos — sem listas, sem tópicos, sem numeração e de forma narrativa.\n\n" +
                        "Desenvolva o texto cobrindo obrigatoriamente os seguintes pontos, mas de forma integrada e fluida, como um artigo jornalístico ou ensaio biográfico:\n\n" +
                        "- Biografia e trajetória: conte a história completa do artista, suas origens, desenvolvimento da carreira, fases artísticas e marcos importantes.\n" +
                        "- Estilo musical e identidade artística: explique as influências, características do som, temas líricos e contribuições originais.\n" +
                        "- Recepção pública e crítica: descreva como o artista foi recebido ao longo da carreira, momentos de maior aclamação, controvérsias e mudanças de popularidade.\n" +
                        "- Gravadoras, produtores e colaborações importantes: detalhe as parcerias e afiliações profissionais mais relevantes.\n" +
                        "- Caso o artista faça parte de banda(s): explique a formação, integrantes, funções, mudanças ao longo do tempo e impacto do grupo.\n" +
                        "- Impacto cultural e legado: discuta a importância histórica, influência em outros artistas e relevância cultural.\n" +
                        "- Comentários de críticos e mídia especializada: traga análises reais ou representativas da época, evitando inventar nomes ou citações.\n" +
                        "- Contexto histórico e musical: descreva o cenário cultural e musical mundial durante os períodos mais importantes da carreira.\n\n" +
                        "IMPORTANTE: Se qualquer informação não puder ser confirmada, diga claramente que não conseguiu encontrar. Não invente dados, não preencha lacunas e não produza conteúdo especulativo.\n\n" +
                        "Entregue tudo em um texto contínuo, bem estruturado, de tom jornalístico, introspectivo e narrativo.";

        String resposta = model.chat(prompt);

        return resposta;
    }
}

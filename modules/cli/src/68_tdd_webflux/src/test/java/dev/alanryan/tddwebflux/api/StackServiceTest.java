package dev.alanryan.tddwebflux.api;

import dev.alanryan.tddwebflux.api.model.Stack;
import dev.alanryan.tddwebflux.api.repository.StackRepository;
import dev.alanryan.tddwebflux.api.service.StackService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class StackServiceTest {

    @InjectMocks
    private StackService stackService;

    @Mock
    private StackRepository stackRepository;

    @Test
    @DisplayName("Deve criar uma stack com sucesso")
    public void deveCriarUmaStackComSucesso() {

        BDDMockito.when(stackRepository.save(ArgumentMatchers.any(Stack.class)))
                .thenReturn(Mono.just(StackMock.stackMock()));

        StepVerifier.create(stackService.salvarStack(StackMock.stackMock()))
                .expectSubscription()
                .expectNext(StackMock.stackMock())
                .verifyComplete();
    }

    @Test
    @DisplayName("Deve excluir uma stack pelo id com sucesso")
    public void deveExcluirUmaStackPeloIdComSucesso() {

        BDDMockito.when(stackRepository.findById(ArgumentMatchers.anyString()))
                .thenReturn(Mono.just(StackMock.stackMock()));

        BDDMockito.when(stackRepository.delete(ArgumentMatchers.any(Stack.class)))
                .thenReturn(Mono.empty());

        StepVerifier.create(stackService.excluirPeloId(StackMock.stackMock().id()))
                .expectSubscription()
                .verifyComplete();
    }

    @Test
    @DisplayName("Deve buscar uma stack pelo id com sucesso")
    public void deveBuscarUmaStackPeloIdComSucesso() {

        BDDMockito.when(stackRepository.findById(ArgumentMatchers.anyString()))
                .thenReturn(Mono.just(StackMock.stackMock()));

        StepVerifier.create(stackService.buscarPeloId("id"))
                .expectSubscription()
                .expectNext(StackMock.stackMock())
                .verifyComplete();
    }

    @Test
    @DisplayName("Deve buscar uma stack pelo id com erro")
    public void deveBuscarUmaStackPeloIdComErro() {

        BDDMockito.when(stackRepository.findById(ArgumentMatchers.anyString()))
                .thenReturn(Mono.empty());

        StepVerifier.create(stackService.buscarPeloId("id-inexistente"))
                .expectSubscription()
                .expectError(ResponseStatusException.class)
                .verify();
    }
}

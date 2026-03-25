package dev.alanryan.github.api.controller;

import dev.alanryan.github.api.client.GithubClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class GithubController {

    private final GithubClient githubClient;

    @Value("${github.token}")
    private String token;

    public GithubController(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    @GetMapping("/repos")
    public ResponseEntity<List<RepositoryResponse>> listRepos() {

        var repos = githubClient.listRepos(
                "Bearer " + token,
                null,
                null
        );

        return ResponseEntity.ok(repos);
    }
}

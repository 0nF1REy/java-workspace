package dev.alanryan.github.api.client;

import dev.alanryan.github.api.controller.RepositoryResponse;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface GithubClient {

    @GetExchange("/user/repos")
    List<RepositoryResponse> listRepos(
            @RequestHeader("Authorization") String token,
            @RequestHeader(
                    value = "X-GitHub-Api-Version",
                    defaultValue = "2026-03-10"
            ) String apiVersion,
            @RequestHeader(
                    value = "Accept",
                    defaultValue = "application/vnd.github+json"
            ) String accept
    );
}

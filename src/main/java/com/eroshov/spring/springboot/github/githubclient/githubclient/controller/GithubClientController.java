package com.eroshov.spring.springboot.github.githubclient.githubclient.controller;


import com.eroshov.spring.springboot.github.githubclient.githubclient.service.GithubService;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.event.DeletePayload;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class GithubClientController {

    @Autowired
    private GithubService githubService;

    @GetMapping("/repos")
    public List<Repository> getRepositories() throws IOException {
        return githubService.getRepositories();
    }

    @PostMapping("/repos")
    public Repository createRepo(@RequestBody Repository newRepo) throws IOException {
        return githubService.createRepository(newRepo);
    }

    @DeleteMapping("/repos/{owner}/{repo}")
    public DeletePayload deleteRepo(
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repoName) throws IOException {
        return githubService.deleteRepository(owner, repoName);
    }
}

package com.eroshov.spring.springboot.github.githubclient.githubclient.repository;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.event.DeletePayload;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface GithubRepository {
    @GET("user/repos")
    Call<List<Repository>> listRepositories(@Header("Authorization") String accessToken,
                                            @Header("Accept") String apiVersion);

    @DELETE("repos/{owner}/{repo}")
    Call<DeletePayload> deleteRepo(@Header("Authorization") String accessToken, @Header("Accept") String apiVersionSpec,
                                   @Path("repo") String repo, @Path("owner") String owner);

    @POST("user/repos")
    Call<Repository> createRepo(@Body Repository repo, @Header("Authorization") String accessToken,
                                @Header("Accept") String apiVersionSpec,
                                @Header("Content-Type") String contentType);
}

package com.andela.tomusange.javadevsnairobi.view.service;

import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class GithubServiceTest {

    GithubService service = new GithubService();

    @Test
    public void getAPI_returns_retrofit_instance() {
        assertThat(service.getAPI(), instanceOf(GithubAPI.class));

    }
}
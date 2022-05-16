package com.refactorizando.example.testing.quarkus.config;

import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class TestProfileCustom implements QuarkusTestProfile {

    @Override
    public Map<String, String> getConfigOverrides() {
        return Collections.singletonMap("quarkus.resteasy.path", "/custom");
    }

    @Override
    public Set<Class<?>> getEnabledAlternatives() {
        return Collections.singleton(TestCarRepository.class);
    }

    @Override
    public String getConfigProfile() {
        return "custom-profile";
    }

}

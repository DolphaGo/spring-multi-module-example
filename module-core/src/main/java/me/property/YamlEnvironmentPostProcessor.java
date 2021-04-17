package me.property;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Profiles;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import lombok.extern.slf4j.Slf4j;

/**
 * resources/META-INF/spring.factories에 YamlEnvironmentPostProcessor.class를 선언해줘야한다.
 */
@Slf4j
public class YamlEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private static final String[] propertyUris = { "classpath*:*.yml" };
    private static final String[] acceptsProfiles = { "h2", "mysql" };

    private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
    private final ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        // Set Default Profile
        boolean isNotValidProfileActive = !environment.acceptsProfiles(Profiles.of(acceptsProfiles));
        if (isNotValidProfileActive) {
            environment.setActiveProfiles("h2");
        }

        String[] activeProfiles = environment.getActiveProfiles();
        System.out.println(Arrays.toString(activeProfiles));

        // if you want to Load Custom *.yml, use this.
        try {
            List<Resource> resourceList = new ArrayList<>();
            for (String propertyUri : propertyUris) {
                resourceList.addAll(List.of(resourcePatternResolver.getResources(propertyUri)));
            }

            resourceList.stream().map(this::loadYaml).forEach(them -> {
                if (them != null) {
                    for (PropertySource<?> it : them) {
                        environment.getPropertySources().addLast(it);
                    }
                }
            });
        } catch (Exception e) {
            throw new BeanCreationException(e.getMessage(), e);
        }
    }

    private List<PropertySource<?>> loadYaml(Resource resource) {
        if (!resource.exists()) {
            throw new IllegalArgumentException("Resource " + resource + " does not exist");
        }
        try {
            System.out.println("resource : " + resource.getURL());
            return loader.load(resource.getURL().toString(), resource);
        } catch (IOException ex) {
            throw new IllegalStateException("Failed to load yaml configuration from " + resource, ex);
        }
    }
}

/*
기본적으로 전체 path에서
application-{profile}.yml을 찾는다.
그래서 어떤 path에 있더라도
profile이 mysql 일 경우
application-mysql.yml 을 알아서 읽는다.

만약
profile이 mysql 인데
application-mysql.yml이 없다면
이 상황이 문제인데

이 경우
resources/config에 application.yml가 존재하면
environment에 자동으로 등록이 된다 -ㅂ-
(= environment.getPropertySources()에 application.yml이 추가된다.)
이유는 모르겠다....


- org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration.Hikari.dataSource에서 90 line
브레이크 포인트 걸고 property 값 보면
으아으아 모르겠다 !!! ㅋㅋㅋ

어려운 스프링 ㅠ__ㅠ
 */
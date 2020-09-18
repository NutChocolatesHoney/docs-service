package com.docs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "cache")
public class CacheConfigProperties {

    private Duration entryTtl;

    private Map<String, Duration> cacheDefaults;

    CacheConfigProperties() {
        this.entryTtl = Duration.ofMinutes(30L);
        this.cacheDefaults = new HashMap<>();
    }

    Duration getEntryTtl() {
        return entryTtl;
    }

    void setEntryTtl(Duration entryTtl) {
        this.entryTtl = entryTtl;
    }

    Map<String, Duration> getCacheDefaults() {
        return cacheDefaults;
    }

    void setCacheDefaults(Map<String, Duration> cacheDefaults) {
        this.cacheDefaults = cacheDefaults;
    }
}

package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.naming.directory.SearchResult;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ProxyService {

    private static final Logger logger = LoggerFactory.getLogger(ProxyService.class);

    @Value("${service.instances}")
    private String[] serviceInstances;

    private AtomicInteger counter = new AtomicInteger(0);

    @GetMapping("/linearsearch")
    public SearchResult proxyLinearSearch(@RequestParam("list") String list, @RequestParam("value") String value) {
        String url = getNextServiceInstance() + "/linearsearch?list=" + list + "&value=" + value;
        RestTemplate restTemplate = new RestTemplate();
        try {
            logger.debug("Calling URL: {}", url);
            SearchResult result = restTemplate.getForObject(url, SearchResult.class);
            logger.debug("Received response: {}", result);
            return result;
        } catch (RestClientException e) {
            logger.error("Error calling linear search service at URL: {}", url, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error calling linear search service", e);
        }
    }

    @GetMapping("/binarysearch")
    public SearchResult proxyBinarySearch(@RequestParam("list") String list, @RequestParam("value") String value) {
        String url = getNextServiceInstance() + "/binarysearch?list=" + list + "&value=" + value;
        RestTemplate restTemplate = new RestTemplate();
        try {
            logger.debug("Calling URL: {}", url);
            SearchResult result = restTemplate.getForObject(url, SearchResult.class);
            logger.debug("Received response: {}", result);
            return result;
        } catch (RestClientException e) {
            logger.error("Error calling binary search service at URL: {}", url, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error calling binary search service", e);
        }
    }

    private String getNextServiceInstance() {
        int index = counter.getAndIncrement() % serviceInstances.length;
        return serviceInstances[index];
    }
}
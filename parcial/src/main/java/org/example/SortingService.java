package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortingService {

    @GetMapping("sorting/linearsearch")
    public SearchResult linearSearch(@RequestParam("list") String list, @RequestParam("value") String value) {
        String[] array = list.split(",");
        int index = linearSearch(array, value);
        return new SearchResult("linearSearch", list, value, index);
    }

    @GetMapping("sorting/binarysearch")
    public SearchResult binarySearch(@RequestParam("list") String list, @RequestParam("value") String value) {
        String[] array = list.split(",");
        int index = binarySearch(array, value, 0, array.length - 1);
        return new SearchResult("binarySearch", list, value, index);
    }

    private int linearSearch(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private int binarySearch(String[] array, String value, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid].equals(value)) {
                return mid;
            }
            if (array[mid].compareTo(value) > 0) {
                return binarySearch(array, value, left, mid - 1);
            }
            return binarySearch(array, value, mid + 1, right);
        }
        return -1;
    }
}
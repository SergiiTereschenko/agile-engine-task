package com.agileengine;


import com.agileengine.filters.ByPropertyFilter;
import com.agileengine.utils.DocumentUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DiffService {

    public String findDiffElementPath(String originFilePath, String diffFilePath, String targetElementId) {
        // For performance we get all link elements or can get all elements if desired element can be not link
        Elements diffElements = DocumentUtils.findLinks(diffFilePath);
        Element originButtonElement = DocumentUtils.findElementById(originFilePath, targetElementId);
        Optional<Element> element = findByFilters(diffElements, originButtonElement);
        return getPath(element);
    }

    private String getPath(Optional<Element> element) {
        List<String> tags = new ArrayList<>();
        element.ifPresent(e -> {
            List<String> tagNames = e.parents().stream()
                    .map(Element::tagName)
                    .collect(Collectors.toList());
            tags.addAll(tagNames);
        });
        Collections.reverse(tags);
        String path = String.join(" > ", tags);
        return path.length() == 0 ? "Element not found" : path + " < " + element.get().text() + " >";
    }

    private Optional<Element> findByFilters(Elements diffElementList, Element matchElement) {
        List<Element> filteredElements = diffElementList;
        List<Element> lastFilteredElements;
        for (ByPropertyFilter filter : ByPropertyFilter.filters()) {
            lastFilteredElements = filter.find(filteredElements, matchElement);
            if (lastFilteredElements.size() == 1) {
                return Optional.of(lastFilteredElements.get(0));
            }
            if (lastFilteredElements.size() > 1) {
                filteredElements = lastFilteredElements;
            }
        }
        return Optional.empty();
    }
}

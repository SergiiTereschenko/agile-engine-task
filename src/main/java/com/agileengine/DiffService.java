package com.agileengine;


import com.agileengine.filters.ByPropertyFilter;
import com.agileengine.utils.DocumentUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class DiffService {

    public String findDiffElementPath(String originFilePath, String diffFilePath, String targetElementId) {
        Elements diffElements = DocumentUtils.getAllElements(diffFilePath);
        Element originButtonElement = DocumentUtils.findElementById(originFilePath, targetElementId);
        Element element = findByFilters(diffElements, originButtonElement);
        return element == null ? "Element not found" : element.text();
    }


    private Element findByFilters(Elements diffElements, Element matchElement) {
        List<Element> filteredElements = diffElements;
        List<Element> lastFilteredElements;
        for (ByPropertyFilter filter : ByPropertyFilter.filters()) {
            lastFilteredElements = filter.find(filteredElements, matchElement);
            if (lastFilteredElements.size() == 1) {
                return lastFilteredElements.get(0);
            }
            if (lastFilteredElements.size() > 1) {
                filteredElements = lastFilteredElements;
            }
        }
        return null;
    }
}

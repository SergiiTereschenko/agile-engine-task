package com.agileengine.filters;


import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ByHrefFilter implements ByPropertyFilter {

    @Override
    public List<Element> find(List<Element> diffElements, Element matchElement) {
        List<Element> list = new ArrayList<>();
        String originAttr = matchElement.attr("href");

        for (Element diffElement : diffElements) {
            if (Objects.equals(diffElement.attr("href"), originAttr)) {
                list.add(diffElement);
            }
        }
        return list;
    }
}

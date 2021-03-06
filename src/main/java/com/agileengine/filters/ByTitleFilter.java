package com.agileengine.filters;


import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ByTitleFilter implements ByPropertyFilter {
    private static final String TITLE_ATTR_KEY = "title";

    @Override
    public List<Element> find(List<Element> diffElements, Element matchElement) {
        List<Element> list = new ArrayList<>();
        String originAttr = matchElement.attr(TITLE_ATTR_KEY);

        for (Element diffElement : diffElements) {
            if (Objects.equals(diffElement.attr(TITLE_ATTR_KEY), originAttr)) {
                list.add(diffElement);
            }
        }
        return list;
    }
}

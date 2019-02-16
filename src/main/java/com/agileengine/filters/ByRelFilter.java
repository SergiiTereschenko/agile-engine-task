package com.agileengine.filters;


import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ByRelFilter implements ByPropertyFilter {
    public static final String REL_ATTR_KEY = "rel";

    @Override
    public List<Element> find(List<Element> diffElements, Element matchElement) {
        List<Element> list = new ArrayList<>();
        String originAttr = matchElement.attr(REL_ATTR_KEY);

        for (Element diffElement : diffElements) {
            if (Objects.equals(diffElement.attr(REL_ATTR_KEY), originAttr)) {
                list.add(diffElement);
            }
        }
        return list;
    }
}

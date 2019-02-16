package com.agileengine.filters;


import org.jsoup.nodes.Element;

import java.util.Arrays;
import java.util.List;


public interface ByPropertyFilter {

    List<Element> find(List<Element> diffElements, Element matchElement);

    static List<ByPropertyFilter> filters() {
        return Arrays.asList(new ByClassFilter(), new ByTextFilter(), new ByTitleFilter());
    }
}

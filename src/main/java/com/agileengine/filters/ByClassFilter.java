package com.agileengine.filters;


import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ByClassFilter implements ByPropertyFilter {

    @Override
    public List<Element> find(List<Element> diffElements, Element matchElement) {
        List<Element> list = new ArrayList<>();
        Set<String> originClasses = matchElement.classNames();

        for (Element diffElement : diffElements) {
            Set<String> diffClasses = diffElement.classNames();
            if (diffClasses.containsAll(originClasses)) {
                list.add(diffElement);
            }
        }
        return list;
    }
}

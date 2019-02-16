package com.agileengine.filters;


import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ByTextFilter implements ByPropertyFilter {

    @Override
    public List<Element> find(List<Element> diffElements, Element matchElement) {
        List<Element> list = new ArrayList<>();
        String originText = matchElement.text();

        for (Element diffElement : diffElements) {
            if (Objects.equals(diffElement.text(), originText)) {
                list.add(diffElement);
            }
        }
        return list;
    }
}

package com.agileengine.utils;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class DocumentUtils {
    private static Logger LOGGER = LoggerFactory.getLogger(DocumentUtils.class);
    private static String CHARSET_NAME = "utf8";

    public static Document findDocument(String filePath) {
        File htmlFile = new File(filePath);
        try {
            Document doc = Jsoup.parse(
                    htmlFile,
                    CHARSET_NAME,
                    htmlFile.getAbsolutePath());
            return doc;
        } catch (IOException e) {
            LOGGER.error("Error reading [{}] file", htmlFile.getAbsolutePath(), e);
            throw new IllegalStateException(e);
        }
    }

    public static Element findElementById(String htmlFilePath, String targetElementId) {
        File htmlFile = new File(htmlFilePath);
        try {
            Document doc = Jsoup.parse(
                    htmlFile,
                    CHARSET_NAME,
                    htmlFile.getAbsolutePath());

            return doc.getElementById(targetElementId);
        } catch (IOException e) {
            LOGGER.error("Error reading [{}] file", htmlFile.getAbsolutePath(), e);
            throw new IllegalStateException(e);
        }
    }

    public static Optional<Elements> findElementsByQuery(Document doc, String cssQuery) {
        Elements select = doc.select(cssQuery);
        return Optional.of(select);
    }

    public static Elements getAllElements(String filePath) {
        Document doc = findDocument(filePath);
        Elements elements = doc.getAllElements();
        return elements;
    }
}

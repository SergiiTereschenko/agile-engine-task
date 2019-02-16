package com.agileengine.utils;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

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

            if (doc == null) throw new IllegalStateException("There is no file on the path: " + filePath);

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

            Element elementById = doc.getElementById(targetElementId);

            if (elementById == null) throw new IllegalStateException("There is no element with id: " + targetElementId);

            return elementById;
        } catch (IOException e) {
            LOGGER.error("Error reading [{}] file", htmlFile.getAbsolutePath(), e);
            throw new IllegalStateException(e);
        }
    }

    public static Elements findLinks(String filePath) {
        Document doc = findDocument(filePath);
//        Elements elements = doc.getAllElements();
        Elements elements = doc.select("a");
        return elements;
    }
}

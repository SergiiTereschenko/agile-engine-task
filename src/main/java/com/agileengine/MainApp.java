package com.agileengine;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp {
    private static Logger LOGGER = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {

        String targetElementId = "make-everything-ok-button";
        String originFilePath = "sample-0-origin.html";
        String diffFilePath1 = "sample-1-evil-gemini.html";
        String diffFilePath2 = "sample-2-container-and-clone.html";


        DiffService diffService  = new DiffService();
//        String path = diffService.findDiffElementPath(args[0], args[1], targetElementId);
        String path = diffService.findDiffElementPath(originFilePath, diffFilePath1, targetElementId);
        LOGGER.info(path);
        path = diffService.findDiffElementPath(originFilePath, diffFilePath2, targetElementId);
        LOGGER.info(path);
    }
}

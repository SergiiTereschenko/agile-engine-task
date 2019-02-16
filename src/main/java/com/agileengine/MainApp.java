package com.agileengine;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp {
    private static Logger LOGGER = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Arguments must contain at least 2 files paths. 1 - original 2 - corrupted.");
        }
        String targetElementId = args.length == 3 ? args[2] : "make-everything-ok-button";
//        String originFilePath = "sample-0-origin.html";
//        String diffFilePath1 = "sample-1-evil-gemini.html";
//        String diffFilePath2 = "sample-2-container-and-clone.html";
//        String diffFilePath3 = "sample-3-the-escape.html";
//        String diffFilePath4 = "sample-4-the-mash.html";

        DiffService diffService  = new DiffService();
        String path = diffService.findDiffElementPath(args[0], args[1], targetElementId);
        LOGGER.info(path);
//        String path = diffService.findDiffElementPath(originFilePath, diffFilePath1, targetElementId);
//        LOGGER.info(path);
//        path = diffService.findDiffElementPath(originFilePath, diffFilePath2, targetElementId);
//        LOGGER.info(path);
//        path = diffService.findDiffElementPath(originFilePath, diffFilePath3, targetElementId);
//        LOGGER.info(path);
//        path = diffService.findDiffElementPath(originFilePath, diffFilePath4, targetElementId);
//        LOGGER.info(path);
    }
}

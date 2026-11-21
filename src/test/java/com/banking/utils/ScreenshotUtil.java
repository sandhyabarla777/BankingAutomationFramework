package com.banking.utils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String folderPath = System.getProperty("user.dir") + "/screenshots/";

        String fileName = testName + "_" + System.currentTimeMillis() + ".png";

        Path destination = Paths.get(folderPath + fileName);

        try {
            Files.createDirectories(destination.getParent());

            Files.copy(source.toPath(), destination,
                    StandardCopyOption.REPLACE_EXISTING);

            return destination.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

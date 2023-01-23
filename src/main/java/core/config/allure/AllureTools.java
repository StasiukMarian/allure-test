package core.config.allure;

import io.qameta.allure.Attachment;

import java.io.*;

import static com.codeborne.selenide.Screenshots.takeScreenShotAsFile;
import static com.google.common.io.Files.toByteArray;

public class AllureTools {

    @SuppressWarnings({"UnusedReturnValue", "UnstableApiUsage"})
    @Attachment(value = "Page Screenshot", type = "image/png")
    public static byte[] attachScreenshot() {
        try {
            return toByteArray(takeScreenShotAsFile());
        } catch (IOException e) {
            return new byte[0];
        }
    }
}

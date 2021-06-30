package config;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeSetup {
    private ChromeOptions options = new ChromeOptions();

    public ChromeSetup() {
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
    }

    public ChromeOptions setup() {
        return options;
    }
}

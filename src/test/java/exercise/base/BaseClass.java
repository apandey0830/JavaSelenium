package exercise.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger log = LogManager.getLogger(BaseClass.class);
    public static WebDriverWait wait;
    public static String browser;

    @BeforeSuite
    public void setUp() {

        if (driver == null) {

            try {
                fis = new FileInputStream(
                        System.getProperty("user.dir") + "/src/test/resources/properties/Config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(fis);
                log.debug("Config file loaded !!!");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()){
                browser = System.getenv("browser");
            } else {
                browser = config.getProperty("browser");
            }

            config.setProperty("browser", browser);

            if (config.getProperty("browser").equals("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                log.debug("Chrome Launched !!!");
            }

            driver.get(config.getProperty("testsiteukurl"));
            driver.navigate().refresh();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

    }

    public void waitForEnterKey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

        log.debug("test execution completed !!!");
    }






}

package simple;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FirefoxDriverProfilesAndPrefs {

    @Test
    public void firefoxProfileDemo() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.addExtension(new File("C:\\Users\\Kirill_Petrov\\IdeaProjects\\321\\selenium-practical\\adblock_plus-3.0.2-an+fx.xpi"));
        org.openqa.selenium.firefox.FirefoxDriver driver = new org.openqa.selenium.firefox.FirefoxDriver((Capabilities) profile);
    }

    @Test
    public void storingAndCreatingProfile() {
        FirefoxProfile profile = new FirefoxProfile();
        String json="";
        try {
            profile.addExtension(new File("C:\\firebug-1.12.0-fx.xpi"));
            json = profile.toJson();
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            org.openqa.selenium.firefox.FirefoxDriver driver = new
                    org.openqa.selenium.firefox.FirefoxDriver((Capabilities) FirefoxProfile.fromJson(json));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void settingPreferences() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("general.useragent.override", "Mozilla/5.0 " +
                        "(iPhone; U; CPU iPhone OS 4_0 like Mac OS X; en-us) " +
                        "AppleWebKit/532.9 (KHTML, like Gecko) Version/4.0.5 " +
                "Mobile/8A293 Safari/6531.22.7");
        org.openqa.selenium.firefox.FirefoxDriver driver = new org.openqa.selenium.firefox.FirefoxDriver((Capabilities) profile);
        driver.get("http://www.google.com");
    }

    @Test
    public void sslCertificatesPrefs() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setAcceptUntrustedCertificates(false);
        org.openqa.selenium.firefox.FirefoxDriver driver = new org.openqa.selenium.firefox.FirefoxDriver((Capabilities) profile);
        driver.get("http://www.google.com");
    }
}

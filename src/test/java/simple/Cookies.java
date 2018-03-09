package simple;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;

public class Cookies {

    @Test
    public void storeCookieInfo() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://www.facebook.com");
        driver.findElement(By.name("email")).sendKeys("my email");
        driver.findElement(By.name("pass")).sendKeys("my password");
        driver.findElement(By.name("persistent")).click();
        driver.findElement(By.name("pass")).submit();

        File f = new File("browser.data");
        try {
            f.delete();
            f.createNewFile();
            FileWriter fos = new FileWriter(f);
            BufferedWriter bos = new BufferedWriter(fos);
            for (Cookie ck : driver.manage().getCookies()) {
                bos.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure()));
                bos.newLine();
            }
            bos.flush();
            bos.close();
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void loadCookiesInfo() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://www.facebook.com");
        try{
            File f = new File("browser.data");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line=br.readLine())!=null){
                StringTokenizer str = new StringTokenizer(line,";");
                while(str.hasMoreTokens()){
                    String name = str.nextToken();
                    String value = str.nextToken();
                    String domain = str.nextToken();
                    String path = str.nextToken();
                    Date expiry = null;
                    String dt;
                    if(!(dt=str.nextToken()).equals("null")){
                        expiry = new Date(dt);
                    }
                    boolean isSecure = new Boolean(str.nextToken()).
                            booleanValue();
                    Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
                    driver.manage().addCookie(ck);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.get("http://www.facebook.com");
    }
}

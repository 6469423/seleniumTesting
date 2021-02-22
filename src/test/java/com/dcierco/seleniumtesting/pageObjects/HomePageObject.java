package com.dcierco.seleniumtesting.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageObject {

    private WebDriver browser;

    public HomePageObject(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.navigate().to("https://www.dbserver.com.br/");
    }

    public String getUrl(){
        return browser.getCurrentUrl();
    }

    public String getEndereco(){ 
        return browser.findElement(By.xpath("//*[@id=\"footer\"]/div/div[1]/div[2]/div/ul/li[1]")).getText(); 
    }

    public String getEmail(){
        return browser.findElement(By.xpath("//*[@id='footer']/div/div[1]/div[2]/div/ul/li[2]/p/a")).getText();
    }

    public void close(){
        this.browser.close();
    }

}
package com.dcierco.seleniumtesting.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContatoPageObject {

    private final WebDriver browser;

    public ContatoPageObject(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.manage().window().maximize();
        this.browser.navigate().to("https://www.dbserver.com.br/contato.html");
    }

    public void inputContato(String nome, String email, String assunto, String mensagem){
        this.browser.findElement(By.xpath("//*[@id='main-contact-form']/div[1]/input")).sendKeys(nome);
        this.browser.findElement(By.xpath("//*[@id='main-contact-form']/div[2]/input")).sendKeys(email);
        this.browser.findElement(By.xpath("//*[@id='textAssunto']")).sendKeys(assunto);
        this.browser.findElement(By.xpath("//*[@id='message']")).sendKeys(mensagem);
    }

    public void submitContato(){
        this.browser.findElement(By.xpath("//*[@id=\"main-contact-form\"]/div[6]/input")).click();
    }

    public void close(){
        this.browser.close();
    }

    public String getUrl(){
        return browser.getCurrentUrl();
    }

    public String getEndereco(){
        return browser.findElement(By.xpath("//*[@id='voltarTopo']/div[7]/div/div[2]/ul/li[1]/p[1]")).getText();
    }


}
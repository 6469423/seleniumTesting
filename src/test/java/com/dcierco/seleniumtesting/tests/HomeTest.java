package com.dcierco.seleniumtesting.tests;

import com.dcierco.seleniumtesting.pageObjects.HomePageObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class HomeTest {

    private HomePageObject homePageObject;

    @BeforeMethod
    public void beforeEach(){
        this.homePageObject = new HomePageObject();
    }

    @AfterMethod
    public void afterEach(){
        homePageObject.close();
    }

    @Test
    public void deveriaSerURLHome(){
        Assert.assertEquals(homePageObject.getUrl(), "https://www.dbserver.com.br/");
    }

    @Test
    public void deveriaTerEndereco(){
        String endereco =  "Endereço: Av. Ipiranga, 6681 - Tecnopuc - Prédio 99 A - 5º Andar | CEP 90619-900 | Bairro Partenon | Porto Alegre | RS | Brasil"; //para corrigir problema de encoding UTF-8
        try {
            byte[] b = endereco.getBytes("UTF-8");
            endereco = new String(b, "UTF-8");
        } catch (Exception e) {
            //TODO: handle exception
        }
        Assert.assertEquals(homePageObject.getEndereco(), endereco);
    }

    @Test
    public void deveriaTerEmail(){
        Assert.assertEquals(homePageObject.getEmail(), "info@dbserver.com.br");
    }

}
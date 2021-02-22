package com.dcierco.seleniumtesting.tests;

import com.dcierco.seleniumtesting.pageObjects.HomePageObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class HomePageTest{

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
        Assert.assertEquals(homePageObject.getEndereco(), "Endereço: Av. Ipiranga, 6681 - Tecnopuc - Prédio 99 A - 5º Andar | CEP 90619-900 | Bairro Partenon | Porto Alegre | RS | Brasil");
    }

    @Test
    public void deveriaTerEmail(){
        Assert.assertEquals(homePageObject.getEmail(), "info@dbserver.com.br");
    }

}
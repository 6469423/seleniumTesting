package com.dcierco.seleniumtesting.tests;

import com.dcierco.seleniumtesting.pageObjects.ContatoPageObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContatoTest {
    private ContatoPageObject contatoPageObject;

    @BeforeMethod
    public void beforeEach(){
        this.contatoPageObject = new ContatoPageObject();
    }

    @AfterMethod
    public void afterEach(){
        contatoPageObject.close();
    }

    @Test
    public void deveriaSerURLContato(){
        Assert.assertEquals(contatoPageObject.getUrl(), "https://www.dbserver.com.br/contato");
    }

    @Test
    public void deveriaTerEndereco(){
        Assert.assertEquals(contatoPageObject.getEndereco(), " Av. Ipiranga, 6681 - Tecnopuc - Prédio 99A - 5º Andar | CEP 90619-900 | Bairro Partenon | RS | Porto Alegre | Brasil |");
    }

    @Test
    public void deveriaEnviarForm(){
        contatoPageObject.inputContato("Teste", "teste@test.com", "Teste de Pagina Web", "Esse email é apenas um teste");
        contatoPageObject.submitContato();
        Assert.assertEquals(contatoPageObject.getUrl(), "https://www.dbserver.com.br/sendemail.php");
    }
}

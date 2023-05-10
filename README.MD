# Product Search API
**Library for searching for products on online stores**

## Getting started

### Importing the library
In order to use this library you first need to add the maven dependency
on your project.

You can do it by adding this in your projects `pom.xml`
```xml
<dependency>
  <groupId>pt.brunojesus</groupId>
  <artifactId>product-search-api</artifactId>
  <version>1.1.1</version>
</dependency>
```

The dependency listed above is not on maven central, so you need to make
sure you add the repository to your project's `pom.xml` as well.
```xml
    <repositories>
        <repository>
            <id>mvn-brunojesus</id>
            <name>Bruno Jesus MVN Repo</name>
            <url>https://mvn.brunojesus.pt/releases</url>
        </repository>
    </repositories>
```

### Code example
The following example searches for a product named **Favaios** on **Pingo Doce**,
which is the only supported store at the moment.

```java
import pt.brunojesus.productsearch.api.ProductSearch;
import pt.brunojesus.productsearch.api.model.Store;
import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;

public class Main {

    public static void main(String[] args) throws ProductFetchException, NoSuchStoreException {
        ProductSearch productSearch = new ProductSearch();

        productSearch.search(Store.PINGO_DOCE, "Favaios")
                .forEach(product -> {
                    System.out.println("Name: " + product.getName());
                    System.out.println("Brand: " + product.getBrand());
                    System.out.println("SKU: " + product.getSku());
                    System.out.println("EAN: " + String.join(", ", product.getEan()));
                    System.out.printf("Price: %f %s%n", product.getCurrentPrice(), product.getCurrency());
                    System.out.println("Link: " + product.getUrl());
                    System.out.println("-----------------------------");
                });
    }
}
```

This code will output something similar to this:
```text
Name: Aperitivo Moscatel Favaios Douro
Brand: Favaios
SKU: 654238
EAN: 2089000182464, 5601752080026
Price: 5.990000 EUR
Link: https://mercadao.pt/store/pingo-doce/product/aperitivo-moscatel-favaios-douro-75-cl
-----------------------------
Name: Vinho Moscatel Douro Mural Favaios
Brand: Mural
SKU: 432212
EAN: 5604242000665
Price: 5.990000 EUR
Link: https://mercadao.pt/store/pingo-doce/product/vinho-moscatel-douro-mural-favaios-75-cl
-----------------------------
Name: Favas Congeladas Iglo
Brand: Iglo
SKU: 767770
EAN: 5000116109982
Price: 3.990000 EUR
Link: https://mercadao.pt/store/pingo-doce/product/favas-congeladas-iglo-700-g
-----------------------------
Name: Favas Congeladas Pingo Doce
Brand: Pingo Doce
SKU: 753013
EAN: 5601009971107
Price: 1.290000 EUR
Link: https://mercadao.pt/store/pingo-doce/product/favas-congeladas-pingo-doce-750-g
-----------------------------
Name: Favas - Unidade 0.5 Kg
Brand: Legumes
SKU: 46409
EAN: 2606088000000, 2613413000000
Price: 2.290000 EUR
Link: https://mercadao.pt/store/pingo-doce/product/favas-unidade-05-kg-1
-----------------------------
Name: Favas de Soja Edamane Bonduelle
Brand: Bonduelle
SKU: 876584
EAN: 3083681079647
Price: 2.740000 EUR
Link: https://mercadao.pt/store/pingo-doce/product/favas-de-soja-edamane-bonduelle-2x80-g
-----------------------------
Name: Aperitivo Moscatel do Douro Favaíto
Brand: Favaios
SKU: 470927
EAN: 5601752061025
Price: 6.650000 EUR
Link: https://mercadao.pt/store/pingo-doce/product/aperitivo-moscatel-do-douro-favaito-75-cl
-----------------------------
Name: Aperitivo Moscatel do Douro Favaíto - Pack 10
Brand: Favaios
SKU: 609721
EAN: 5601752061049, 5601752061056
Price: 7.750000 EUR
Link: https://mercadao.pt/store/pingo-doce/product/aperitivo-moscatel-do-douro-favaito-pack-10-10x55-cl
-----------------------------
Name: Fava Frita com Sal Frutorra
Brand: Frutorra
SKU: 908138
EAN: 2000003579327, 5602586130116
Price: 1.140000 EUR
Link: https://mercadao.pt/store/pingo-doce/product/fava-frita-com-sal-frutorra-150-g
-----------------------------
Name: Fava Frita com Sal Pingo Doce
Brand: Pingo Doce
SKU: 721199
EAN: 2000002215301, 5601009936410, 5607047008355
Price: 0.950000 EUR
Link: https://mercadao.pt/store/pingo-doce/product/fava-frita-com-sal-pingo-doce-150-g
-----------------------------
```
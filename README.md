# AmazonScraper
This is the project for amazon search result data scraping  Developed using JAVA, Selenium, TestNG, maven, POM


# setup need to do before execution:
1)
src/test/java/PageObject
> scrapePageObject.java
At line 31 set your scraped data folder path:
“String csvPath="C:\\Users\\VINAY SINGH\\eclipse-workspace\\amazonArtID\\output\\";
(project will save scraped data in csv format in this path)
2_
src/test/java/testCases
>login.java 
At line 20 and 21 give usename and password for amanzon login
3)
>scrapeInfo.java
Pass product Name to search 
pass range for price
4)
Find The dependencies in POM.xml file






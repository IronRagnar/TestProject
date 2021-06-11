package Tools;

import org.openqa.selenium.By;

public class Element {
        //class created for ease of locator creation

        public enum QueryType {Css, XPath};
        public By Query;

        private QueryType queryType;
        public String Locator;

        public Element(String locator, QueryType query) {
            Locator = locator;
            queryType = query;
            switch (queryType) {
                case Css: {
                    Query = By.cssSelector(Locator);
                    break;
                }
                case XPath: {
                    Query = By.xpath(Locator);
                    break;
                }
            }
        }

}


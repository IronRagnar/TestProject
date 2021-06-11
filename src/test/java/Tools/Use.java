package Tools;

public class Use {
    //support class for Element

    public static Element xPath(String locator)
    {
        return new Element(locator, Element.QueryType.XPath);
    }

    public static Element css(String locator)
    {
        return new Element(locator, Element.QueryType.Css);
    }
}

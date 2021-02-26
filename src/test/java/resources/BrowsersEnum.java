package resources;


public enum BrowsersEnum
{
    CHROME("chrome"),
    FIREFOX("firefox"),
    PHANTOMJS("phantomjs");

    protected String value;

    BrowsersEnum(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return this.value;
    }
}

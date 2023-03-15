package pageUIs.jQuery;

public class HomePageUI2 {
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th[text()='%s']/preceding-sibling::th";
	public static final String ROW_TEXTBOX_BY_COLUMN_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String COUNTRY_DROPDOWN_BY_ROW_INDEX = "xpath=//tbody/tr[%s]/td[4]/div/select";
	public static final String NPO_CHECKBOX_BY_ROW_INDEX = "xpath=//tbody/tr[%s]/td[5]/label/input";
	public static final String ICON_BY_TITLE_AND_BY_ROW_INDEX ="xpath=//div[@class='field has-addons']//button[@title='%s' and @data-unique-index='%s' ]";

}

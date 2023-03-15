package pageUIs.liveTechPanda;

public class HomePageUI {
	public static final String CLOSE_BUTTON = "xpath=//a[@title='close']";
	public static final String FILTER_ACTION_BY_NAME = "xpath=//td[@class='filter-actions a-right']/button[@title='%s']";
	public static final String ACTION_DROPDOWN = "xpath=//select[@id='customerGrid_massaction-select']";
	public static final String SUBMIT_BUTTON = "xpath=//button[@title='Submit']";
	public static final String ANY_YES_NO_FILTER_DROPDOWN = "xpath=//select[@id='customerGrid_filter_massaction']";
	public static final String ID_FILTER_FROM_TEXTBOX = "xpath=//div[@class='range']/div[@class='range-line']/span/following-sibling::input[@name='entity_id[from]']";
	public static final String ID_FILTER_TO_TEXTBOX = "xpath=//div[@class='range']/div[@class='range-line']/span/following-sibling::input[@name='entity_id[to]']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//span[text()='%s']//ancestor::th//preceding-sibling::th";
	public static final String FILTER_TEXTBOX_BY_COLUMN_INDEX = "xpath=//tr[@class='filter']/th[%s]/div[@class='field-100']/input";
	public static final String FILTER_DROPDOWN_BY_COLUMN_INDEX = "xpath=//tr[@class='filter']/th[%s]/select";
	public static final String SELECT_RECORD_CHECKBOX_BY_ID = "xpath=//input[@type='checkbox' and @value='%s']";
	public static final String ACTION_GROUP_DROPDOWN = "xpath=//span[@class='outer-span']//select[@name='group']";
	public static final String GROUP_NAME_BY_ID = "xpath=//td/input[@value='%s']/ancestor::tr//td[5]";
	public static final String SELECT_UNSELECT_TYPE_BY_NAME ="xpath=//td/a[text()='%s']";
	public static final String VALUE_ROW_BY_ID ="//input[@value='%s']//parent::td//parent::tr";

}

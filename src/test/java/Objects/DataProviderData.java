package Objects;

import org.testng.annotations.DataProvider;

// page_url = about:blank
public class DataProviderData {
    @DataProvider(name="setValue")

    public static Object[][] getDataProviderData() {
        Object[][] setValue = new Object[7][2];
        setValue[0][0]="user[login]";
        setValue[0][1]="Monument";
        setValue[1][0]="user[password]";
        setValue[1][1]="duRation34";
        setValue[2][0]="user[password_confirmation]";
        setValue[2][1]="duRation34";
        setValue[3][0]="user[firstname]";
        setValue[3][1]="Dmitri";
        setValue[4][0]="user[lastname]";
        setValue[4][1]="Kravchenko";
        setValue[5][0]="user[mail]";
        setValue[5][1]="email";
        setValue[6][0]="user[custom_field_values][3]";
        setValue[6][1]="Moon";
        return setValue;
    }
}
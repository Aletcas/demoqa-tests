package aletca.first.tasks;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successPracticeFormTest()  {
        open("/automation-practice-form");
        $x("//*[@id ='firstName']").setValue("Max");
        $x("//*[@id ='lastName']").setValue("Maximov");
        $x("//input[@placeholder='name@example.com']").setValue("Max@mail.ru");
        $x("//*[text() = 'Other']").click();
        $x("//input[@placeholder='Mobile Number']").setValue("1234567890");
        $x("//*[@id ='dateOfBirthInput']").click();
        $x("//*[@class='react-datepicker__month-select']").selectOption("March");
        $x("//*[@class='react-datepicker__year-select']").selectOption("1988");
        $x("//*[@class='react-datepicker__day react-datepicker__day--015']").click();
        $x("//*[@id ='subjectsInput']").setValue("Hindi").pressEnter();
        $x("//*[text() = 'Music']").click();
        $x("//*[@id ='uploadPicture']").uploadFromClasspath("test.jpg");
        $x("//*[text() = 'Other']").click();
        $x("//*[@id ='currentAddress']").setValue("Москва");
        $x("//*[@id='state']").click();
        $x("//*[text() = 'NCR']").click();
        $x("//*[@id ='city']").click();
        $x("//*[text() ='Delhi']").click();
        $x("//*[text() = 'Submit']").click();
        $x("//*[@class ='modal-header']").shouldHave(text("Thanks for submitting the form"));
        $x("//*[@class='table-responsive']").shouldHave(text("Student Name Max Maximov"), text("Student Email Max@mail.ru"),
                text("Gender Other"), text("Mobile 1234567890"), text("Date of Birth 15 March,1988"),
                text("Subjects Hindi"), text("Hobbies Music"), text("Picture"),
                text("Address Москва"), text("State and City NCR Delhi"));
    }
}

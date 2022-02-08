package aletca.first.tasks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {
    private Selenide element;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void successPracticeFormTest() throws IOException, URISyntaxException {

        open("/automation-practice-form");
        $x("//*[@id ='firstName']").setValue("Max");
        $x("//*[@id ='lastName']").setValue("Maximov");
        $x("//input[@placeholder='name@example.com']").setValue("Max@mail.ru");
        $x("//*[text() = 'Other']").click();
        $x("//input[@placeholder='Mobile Number']").setValue("1234567890");
        $x("//*[@id ='dateOfBirthInput']").click();
        $x("//*[@class='react-datepicker__month-select']").selectOption("March");
        $x("//*[@class='react-datepicker__year-select']").scrollTo().selectOption("1988");
        $x("//*[@class='react-datepicker__day react-datepicker__day--015']").click();
        $x("//*[@id ='subjectsInput']").setValue("Hindi").pressEnter();
        $x("//*[text() = 'Music']").click();
        File report = element.download("https://www.google.com/search?q=%D1%84%D0%BE%D1%82%D0%BE+%D0%BF%D1%80%D0%B8%D1%80%D0%BE%D0%B4%D1%8B+%D1%81%D0%BA%D0%B0%D1%87%D0%B0%D1%82%D1%8C&sxsrf=APq-WBsgZ2I7NN0iV3Uz-haDQkzxvxEKkA:1644324027530&tbm=isch&source=iu&ictx=1&vet=1&fir=sbqtyOl0tLNAtM%252CdA2BkdjkWsl2sM%252C_%253BvEUQG248FSXWRM%252Cb3OpQmKd4-xGQM%252C_%253B3AoI3z1SGpvyHM%252CQVPprdeFhrL4yM%252C_%253B2n5RDnKnTCm0_M%252CwC2Mx_Ksx8J4hM%252C_%253B-3nGMa7XIuKwfM%252CQoaFx14SGXyBLM%252C_%253B0uxBq9_Ey22G7M%252C6V5rX3g4cdSK7M%252C_%253B1BDCFgRIaKV76M%252CaHA8LIHc1qcCJM%252C_%253BJmUSDqCFU23GgM%252CbaoarV_jPZgUfM%252C_%253B0QE2T1dm4lBTeM%252CBrmNT95HGLNMAM%252C_%253BBD0-l-2f-8Ut8M%252ClHaLJxu8JAoh5M%252C_%253Bk3s2gHujpQp6UM%252CtENcjV4QRdXyCM%252C_%253BLmvg-GS9LxSEOM%252CWi4IlQXdVmwACM%252C_%253B-5cBIOQLrK-zEM%252CQVPprdeFhrL4yM%252C_%253BFbx0ck9PGp01HM%252CPdN6qwWwHuddLM%252C_&usg=AI4_-kQnTBPjZU4aJzvxbFUzHknjK1ujyQ&sa=X&ved=2ahUKEwjgl7mskPD1AhWxtYsKHfLCAXAQ9QF6BAgVEAE#imgrc=2n5RDnKnTCm0_M");
        $x("//*[text() = 'Other']").click();
        $x("//*[@id ='currentAddress']").setValue("Москва");
        $x("(//*[@class=' css-2b097c-container'])[2]").click();
        $x("//*[text() = 'NCR']").hover().click();
        $x("//*[@id ='city']").click();
        $x("//*[text() ='Delhi']").hover().click();

        $x("//*[text() = 'Submit']").click();

        $x("//*[@class ='modal-header']").shouldHave(text("Thanks for submitting the form"));
    }
}

package stepdef.web.notifLogin;

import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;
import pages.web.notifLogin.MessagePages;

public class MessageStepDef {

    private final MessagePages messagePages;

    public MessageStepDef(){
        messagePages = new MessagePages();
    }


    @Given("message login {string}")
    public void messageLogin(String message) {
        messagePages.wrongUsername(message);

        String actualMessage = messagePages.messageError(message);
         Assertions.assertEquals(actualMessage, message, "message not actual");
    }
}

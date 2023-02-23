package tests;

import model.Contact;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase {
    @BeforeMethod
    public void preCondition()
    {
        if (!app.getHelperUser().isLogged())
        {
            app.getHelperUser().login(User.builder().email("koshka1@mail.ru").password("Kotic14025$").build());
        }
    }

    @Test
    public void addContactSuccessAllFields() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("Dosha" + i)
                .lastName("Koshka")
                .address("B7")
                .phone("114111111" + i)
                .email("dosha" + i + "@mail.ru")
                .description("The best friend").build();

        System.out.println(contact.toString());
        logger.info("Tests start with data : " + contact.toString());

        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().submitContactForm();
        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().isContactAddedByPhone(contact.getPhone()));
        Assert.assertTrue(app.helperContact().isContactAddedByEmail(contact.getEmail()));

    }

    @Test
    public void addContactSuccessRequiredFields() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("Dosha" + i)
                .lastName("Koshka")
                .address("B7")
                .phone("114111111" + i)
                .email("dosha" + i + "@mail.ru")
                .build();

        System.out.println(contact.toString());
        logger.info("Tests start with data : " + contact.toString());

        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().submitContactForm();
        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().isContactAddedByPhone(contact.getPhone()));
        Assert.assertTrue(app.helperContact().isContactAddedByEmail(contact.getEmail()));
    }

    @Test
    public void addContactWrongName()
    {
        Contact contact = Contact.builder()
                .name("")
                .lastName("Koshka")
                .address("B7")
                .phone("114111111")
                .email("dosh@mail.ru")
                .description("wrong name")
                .build();

        System.out.println(contact.toString());
        logger.info("Tests start with data : " + contact.toString());

//        Contact contact1 = Contact.builder()
//
//                .lastName("Koshka")
//                .address("B7")
//                .phone("114111111")
//                .email("doshach@mail.ru")
//                .description("wrong name")
//                .build();
//        System.out.println(contact1.toString());
//
//        System.out.println(contact.equals(contact1));

        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().submitContactForm();
        Assert.assertTrue(app.helperContact().isAddPageStillDisplayed());

    }

   @Test
   public void addContactWrongAddress()
   {
       Contact contact = Contact.builder()
               .name("Doshka")
               .lastName("Koshka")
               .address("")
               .phone("114111111")
               .email("doshach@mail.ru")
               .description("wrong address")
               .build();

       System.out.println(contact.toString());
       logger.info("Tests start with data : " + contact.toString());

       app.helperContact().openContactForm();
       app.helperContact().fillContactForm(contact);
       app.helperContact().submitContactForm();
       Assert.assertTrue(app.helperContact().isAddPageStillDisplayed());
   }
    @Test
    public void addContactWrongLastName()
    {
        Contact contact = Contact.builder()

                .name("Doshka")
                .lastName("")
                .address("B7")
                .phone("114111111")
                .email("dosha@mail.ru")
                .description("wrong Last name")
                .build();

        System.out.println(contact.toString());
        logger.info("Tests start with data : " + contact.toString());

        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().submitContactForm();
        Assert.assertTrue(app.helperContact().isAddPageStillDisplayed());
    }

        @Test
        public void addContactWrongPhone()
        {
            Contact contact = Contact.builder()

                    .name("Doshka")
                    .lastName("Koshka")
                    .address("B7")
                    .phone("")
                    .email("dosha@mail.ru")
                    .description("wrong Phone")
                    .build();

            System.out.println(contact.toString());
            logger.info("Tests start with data : " + contact.toString());

            app.helperContact().openContactForm();
            app.helperContact().fillContactForm(contact);
            app.helperContact().submitContactForm();
            Assert.assertTrue(app.helperContact().isAddPageStillDisplayed());
            Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Phone not valid: Phone number must contain only digits! And length min 10, max 15"));
        }

    @Test
    public void addContactWrongEmail()
    {
        Contact contact = Contact.builder()

                .name("Doshka")
                .lastName("Koshka")
                .address("B7")
                .phone("485886369693")
                .email("doshamail.ru")
                .description("wrong Email")
                .build();

        System.out.println(contact.toString());
        logger.info("Tests start with data : " + contact.toString());

        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().submitContactForm();
        Assert.assertTrue(app.helperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Email not valid: must be a well-formed email address"));
    }






}

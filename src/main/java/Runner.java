import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.MailService;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml");

        MailService mailService = context.getBean("mailService", MailService.class);

        String from = "polak.mariola@gmail.com";
        String to = "marjola3@poczta.onet.pl";
        String subcject = "subcject";
        String text = "message";

        boolean czyWysłany = mailService.sendEMail(from, to, subcject, text);

        System.out.println("Czy wysłano e-mail? " + czyWysłany);




    }
}
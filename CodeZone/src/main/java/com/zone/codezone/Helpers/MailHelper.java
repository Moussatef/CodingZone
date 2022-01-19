package com.zone.codezone.Helpers;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

public class MailHelper {

    public static void sendEmail(String toEmail, String subject, String body){
        try
        {

            final String fromEmail = "youcode.quiz@gmail.com"; //requires valid gmail id
            final String password = "youcodesafi2019"; // correct password for gmail id

            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);

            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("youcode.quiz@gmail.com", "Youcode Safi"));

            msg.setReplyTo(InternetAddress.parse("youcode.quiz@gmail.com", false));

            msg.setSubject(subject, "UTF-8");


            String sb = "<head>" +
                    "<style type=\"text/css\">" +
                    "  .red { color: #f00; }" +
                    "</style>" +
                    "</head>" +
                    "<h1 class=\"red\">" + msg.getSubject() + "</h1>" +
                    "<p>" +
                    "Lorem ipsum dolor sit amet, <em>consectetur</em> adipisicing elit, " +
                    "sed do eiusmod tempor incididunt ut labore et dolore magna <strong>" +
                    "aliqua</strong>.</p>";
            msg.setContent(scoreMail(body), "text/html; charset=utf-8");
            msg.saveChanges();

            //msg.setText(body, "Html");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  static String  scoreMail(String score){

        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\n" +
                "<head>\n" +
                "    <title></title>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "    <style type=\"text/css\">\n" +
                "        @media screen {\n" +
                "            @font-face {\n" +
                "                font-family: 'Lato';\n" +
                "                font-style: normal;\n" +
                "                font-weight: 400;\n" +
                "                src: local('Lato Regular'), local('Lato-Regular'), url(https://fonts.gstatic.com/s/lato/v11/qIIYRU-oROkIk8vfvxw6QvesZW2xOQ-xsNqO47m55DA.woff) format('woff');\n" +
                "            }\n" +
                "\n" +
                "            @font-face {\n" +
                "                font-family: 'Lato';\n" +
                "                font-style: normal;\n" +
                "                font-weight: 700;\n" +
                "                src: local('Lato Bold'), local('Lato-Bold'), url(https://fonts.gstatic.com/s/lato/v11/qdgUG4U09HnJwhYI-uK18wLUuEpTyoUstqEm5AMlJo4.woff) format('woff');\n" +
                "            }\n" +
                "\n" +
                "            @font-face {\n" +
                "                font-family: 'Lato';\n" +
                "                font-style: italic;\n" +
                "                font-weight: 400;\n" +
                "                src: local('Lato Italic'), local('Lato-Italic'), url(https://fonts.gstatic.com/s/lato/v11/RYyZNoeFgb0l7W3Vu1aSWOvvDin1pK8aKteLpeZ5c0A.woff) format('woff');\n" +
                "            }\n" +
                "\n" +
                "            @font-face {\n" +
                "                font-family: 'Lato';\n" +
                "                font-style: italic;\n" +
                "                font-weight: 700;\n" +
                "                src: local('Lato Bold Italic'), local('Lato-BoldItalic'), url(https://fonts.gstatic.com/s/lato/v11/HkF_qI1x_noxlxhrhMQYELO3LdcAZYWl9Si6vvxL-qU.woff) format('woff');\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        /* CLIENT-SPECIFIC STYLES */\n" +
                "        body,\n" +
                "        table,\n" +
                "        td,\n" +
                "        a {\n" +
                "            -webkit-text-size-adjust: 100%;\n" +
                "            -ms-text-size-adjust: 100%;\n" +
                "        }\n" +
                "\n" +
                "        table,\n" +
                "        td {\n" +
                "            mso-table-lspace: 0pt;\n" +
                "            mso-table-rspace: 0pt;\n" +
                "        }\n" +
                "\n" +
                "        img {\n" +
                "            -ms-interpolation-mode: bicubic;\n" +
                "        }\n" +
                "\n" +
                "        /* RESET STYLES */\n" +
                "        img {\n" +
                "            border: 0;\n" +
                "            height: auto;\n" +
                "            line-height: 100%;\n" +
                "            outline: none;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "\n" +
                "        table {\n" +
                "            border-collapse: collapse !important;\n" +
                "        }\n" +
                "\n" +
                "        body {\n" +
                "            height: 100% !important;\n" +
                "            margin: 0 !important;\n" +
                "            padding: 0 !important;\n" +
                "            width: 100% !important;\n" +
                "        }\n" +
                "\n" +
                "        /* iOS BLUE LINKS */\n" +
                "        a[x-apple-data-detectors] {\n" +
                "            color: inherit !important;\n" +
                "            text-decoration: none !important;\n" +
                "            font-size: inherit !important;\n" +
                "            font-family: inherit !important;\n" +
                "            font-weight: inherit !important;\n" +
                "            line-height: inherit !important;\n" +
                "        }\n" +
                "\n" +
                "        /* MOBILE STYLES */\n" +
                "        @media screen and (max-width:600px) {\n" +
                "            h1 {\n" +
                "                font-size: 32px !important;\n" +
                "                line-height: 32px !important;\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        /* ANDROID CENTER FIX */\n" +
                "        div[style*=\"margin: 16px 0;\"] {\n" +
                "            margin: 0 !important;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "\n" +
                "<body style=\"background-color: #f4f4f4; margin: 0 !important; padding: 0 !important;\">\n" +
                "    <!-- HIDDEN PREHEADER TEXT -->\n" +
                "    <div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: 'Lato', Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\"> We're thrilled to have you here! Get ready to dive into your new account. </div>\n" +
                "    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "        <!-- LOGO -->\n" +
                "        <tr>\n" +
                "            <td bgcolor=\"#6eb5f0\" align=\"center\">\n" +
                "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n" +
                "                    <tr>\n" +
                "                        <td align=\"center\" valign=\"top\" style=\"padding: 40px 10px 40px 10px;\"> </td>\n" +
                "                    </tr>\n" +
                "                </table>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td bgcolor=\"#6eb5f0\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\n" +
                "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n" +
                "                    <tr>\n" +
                "                        <td bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" style=\"padding: 40px 20px 20px 20px; border-radius: 4px 4px 0px 0px; color: #111111; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; letter-spacing: 4px; line-height: 48px;\">\n" +
                "                            <h1 style=\"font-size: 48px; font-weight: 400; margin: 2;\">Your Test Score!</h1> <img src=\"https://simplon.co/storage/36009/logo-youcode-ma.png\" width=\"125\" height=\"120\" style=\"display: block; border: 0px;\" />\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </table>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td bgcolor=\"#f4f4f4\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\n" +
                "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n" +
                "                    <tr>\n" +
                "                        <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 20px 30px 40px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\n" +
                "                            <p style=\"margin: 0;\">Your test score is :</p>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td bgcolor=\"#ffffff\" align=\"left\">\n" +
                "                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                <tr>\n" +
                "                                    <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 20px 30px 60px 30px;\">\n" +
                "                                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                            <tr>\n" +
                "                                                <td align=\"center\" style=\"border-radius: 3px;\" bgcolor=\"#6eb5f0\"><a href=\"#\" target=\"_blank\" style=\"font-size: 20px; font-family: Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; color: #ffffff; text-decoration: none; padding: 15px 25px; border-radius: 2px; border: 1px solid #6eb5f0; display: inline-block;\">"+score+"</a></td>\n" +
                "                                            </tr>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </table>\n" +
                "                        </td>\n" +
                "                    </tr> <!-- COPY -->\n" +
                "    </table>\n" +
                "</body>\n" +
                "\n" +
                "</html>";

    }

}

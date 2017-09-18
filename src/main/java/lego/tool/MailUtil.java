package lego.tool;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 * 邮件工具类
 */
public class MailUtil {
    /**
     * 发送邮件
     * @param to 给谁发
     * @param text 发送内容
     */
    public static void send_mail(String to,String userId,Integer h) throws MessagingException {
        //创建连接对象 连接到邮件服务器
        Properties properties = new Properties();
        //设置发送邮件的基本参数
        //发送邮件服务器
        properties.put("mail.smtp.host", "smtp.163.com");
        //发送端口
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.auth", "true");
        //设置发送邮件的账号和密码
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //两个参数分别是发送邮件的账户和密码
                return new PasswordAuthentication("erha123456789@163.com","wang123987");
            }
        });

        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人
        message.setFrom(new InternetAddress("erha123456789@163.com"));
        //设置收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("erha123456789@163.com"));
        //抄送
        message.setRecipient(Message.RecipientType.CC,new InternetAddress(to));
        //设置主题
        message.setSubject("注册成功，请进行邮箱验证");
        //设置邮件正文  第二个参数是邮件发送的类型
        String s = "欢迎注册乐购商城，点击按钮进行账户验证</br>  <a href=\"http://localhost:8090/Email?userId="+userId+"&h="+h+"\"><button type=\"button\" style=\"color:blue\">点击完成验证</button></a>";
//        message.setContent(s, "text/html;charset=gbk");
        message.setContent(s,"text/html;charset=UTF-8");
        //发送一封邮件
        Transport.send(message);
    }
}
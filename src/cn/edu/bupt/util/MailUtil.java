package cn.edu.bupt.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	public static boolean sendEmail(String sendTo,String from, String theme, String content){
		
		//����������Ϣ
		Properties properties = new Properties();
		properties.setProperty("mail.debug", "true");
		properties.setProperty("mail.smtp", "auth");
		properties.setProperty("mail.host", "smtp.163.com");
		properties.setProperty("mail.debug", "true");
		properties.setProperty("mail.transport.protocol", "smtp");
		
		//���û�����Ϣ
		Session session = Session.getInstance(properties);
		Transport transport = null;
		//�����ʼ�����
		Message msg = new MimeMessage(session);
		
		try {
			msg.setSubject(theme);
			msg.setText(content);
			msg.setFrom(new InternetAddress(from));
			transport = session.getTransport();
			transport.connect("liukeang", "capsule03");
			transport.sendMessage(msg, new Address[]{new InternetAddress(sendTo)});
			System.out.println("�ɹ������ʼ���459127552@qq.com");
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			if(transport != null && transport.isConnected()){
				try {
					transport.close();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		
		
		return true;
	}
}

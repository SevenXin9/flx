package com.email;
 
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

 
public class EmailUtil{
    //�����˵�ַ
    private static String senderAddress = "2580619995@qq.com";
    //�ռ��˵�ַ
    private static String recipientAddress;
    //�������˻���
    private static String senderAccount = "2580619995@qq.com";
    //�������˻�����
    private static String senderPassword = "jzavrznowdszecaf";
    
    private static int num;
    
    public static int eamil(String Address){
    	recipientAddress = Address;
    	System.out.println("�����˵�ַ:"+recipientAddress);
        //1�������ʼ��������Ĳ�������
        Properties props = new Properties();
        //�����û�����֤��ʽ
        props.setProperty("mail.smtp.auth", "true");
        //���ô���Э��
        props.setProperty("mail.transport.protocol", "smtp");
        //���÷����˵�SMTP��������ַ
        props.setProperty("mail.smtp.host", "smtp.qq.com");
        //2��������������Ӧ�ó�������Ļ�����Ϣ�� Session ����
        Session session = Session.getInstance(props);
        //���õ�����Ϣ�ڿ���̨��ӡ����
        session.setDebug(true);
        num = myRandom();
        //3�������ʼ���ʵ������
        try{
        Message msg = getMimeMessage(session);
        //4������session�����ȡ�ʼ��������Transport
        Transport transport = session.getTransport();
        
        //���÷����˵��˻���������
        transport.connect(senderAccount, senderPassword);
        //�����ʼ��������͵������ռ��˵�ַ��message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
        transport.sendMessage(msg,msg.getAllRecipients());
         
        //���ֻ�뷢�͸�ָ�����ˣ���������д��
        //transport.sendMessage(msg, new Address[]{new InternetAddress("xxx@qq.com")});
        //5���ر��ʼ�����
        transport.close();
        }catch (Exception e) {
			e.printStackTrace();
		}
        return num;
    }
     
    /**
     * ��ô���һ���ʼ���ʵ������
     * @param session
     * @return
     * @throws MessagingException 
     * @throws AddressException 
     */
    public static MimeMessage getMimeMessage(Session session) throws Exception{
        //����һ���ʼ���ʵ������
        MimeMessage msg = new MimeMessage(session);
        //���÷����˵�ַ
        msg.setFrom(new InternetAddress(senderAddress));
        /**
         * �����ռ��˵�ַ���������Ӷ���ռ��ˡ����͡����ͣ�����������һ�д�����д����
         * MimeMessage.RecipientType.TO:����
         * MimeMessage.RecipientType.CC������
         * MimeMessage.RecipientType.BCC������
         */
        msg.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(recipientAddress));
        //�����ʼ�����
        msg.setSubject("ע����֤��","UTF-8");
        //�����ʼ�����
        msg.setContent(num+"", "text/html;charset=UTF-8");
        //�����ʼ��ķ���ʱ��,Ĭ����������
        msg.setSentDate(new Date());
         
        return msg;
    }
    
    public static int myRandom(){
    	int ran2 = (int)Math.floor(Math.random()*10000); 
    	System.out.println(ran2);
		return ran2;
    }
    
    public static void main(String[] args) {
		int a =eamil("2560379327@qq.com");
		System.out.println(a);
	}
 
}
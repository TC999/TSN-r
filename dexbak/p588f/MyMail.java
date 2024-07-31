package p588f;

import java.util.Date;
import java.util.Properties;
import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/* renamed from: f.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MyMail extends Authenticator {

    /* renamed from: a */
    private String f40116a;

    /* renamed from: b */
    private String f40117b;

    /* renamed from: c */
    private String[] f40118c;

    /* renamed from: d */
    private String f40119d;

    /* renamed from: e */
    private String f40120e;

    /* renamed from: f */
    private String f40121f;

    /* renamed from: g */
    private String f40122g;

    /* renamed from: h */
    private String f40123h;

    /* renamed from: i */
    private String f40124i;

    /* renamed from: j */
    private boolean f40125j;

    /* renamed from: k */
    private boolean f40126k;

    /* renamed from: l */
    private Multipart f40127l;

    public MyMail() {
        this.f40122g = "smtp.qq.com";
        this.f40120e = "587";
        this.f40121f = "587";
        this.f40116a = "";
        this.f40117b = "";
        this.f40119d = "";
        this.f40123h = "";
        this.f40124i = "";
        this.f40126k = false;
        this.f40125j = true;
        this.f40127l = new MimeMultipart();
        MailcapCommandMap mailcapCommandMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        mailcapCommandMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
        mailcapCommandMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
        mailcapCommandMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
        mailcapCommandMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
        mailcapCommandMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
        CommandMap.setDefaultCommandMap(mailcapCommandMap);
    }

    /* renamed from: a */
    private Properties m12807a() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", this.f40122g);
        if (this.f40126k) {
            properties.put("mail.debug", "true");
        }
        if (this.f40125j) {
            properties.put("mail.smtp.auth", "true");
        }
        properties.put("mail.smtp.port", this.f40120e);
        properties.put("mail.password", "dylanandroid2dev");
        properties.put("mail.smtp.socketFactory.port", this.f40121f);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        return properties;
    }

    /* renamed from: A */
    public void m12810A(String str) {
        this.f40123h = str;
    }

    /* renamed from: B */
    public void m12809B(String[] strArr) {
        this.f40118c = strArr;
    }

    /* renamed from: C */
    public void m12808C(String str) {
        this.f40116a = str;
    }

    /* renamed from: b */
    public void m12806b(String str) throws Exception {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setDataHandler(new DataHandler(new FileDataSource(str)));
        String[] split = str.split("/");
        mimeBodyPart.setFileName(split[split.length - 1]);
        this.f40127l.addBodyPart(mimeBodyPart);
    }

    /* renamed from: c */
    public String m12805c() {
        return this.f40124i;
    }

    /* renamed from: d */
    public String m12804d() {
        return this.f40124i;
    }

    /* renamed from: e */
    public String m12803e() {
        return this.f40119d;
    }

    /* renamed from: f */
    public String m12802f() {
        return this.f40122g;
    }

    /* renamed from: g */
    public Multipart m12801g() {
        return this.f40127l;
    }

    @Override // javax.mail.Authenticator
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.f40116a, this.f40117b);
    }

    /* renamed from: h */
    public String m12800h() {
        return this.f40117b;
    }

    /* renamed from: i */
    public String m12799i() {
        return this.f40120e;
    }

    /* renamed from: j */
    public String m12798j() {
        return this.f40121f;
    }

    /* renamed from: k */
    public String m12797k() {
        return this.f40123h;
    }

    /* renamed from: l */
    public String[] m12796l() {
        return this.f40118c;
    }

    /* renamed from: m */
    public String m12795m() {
        return this.f40116a;
    }

    /* renamed from: n */
    public boolean m12794n() {
        return this.f40125j;
    }

    /* renamed from: o */
    public boolean m12793o() {
        return this.f40126k;
    }

    /* renamed from: p */
    public boolean m12792p() throws Exception {
        Properties m12807a = m12807a();
        if (this.f40116a.equals("") || this.f40117b.equals("") || this.f40118c.length <= 0 || this.f40119d.equals("") || this.f40123h.equals("") || this.f40124i.equals("")) {
            return false;
        }
        MimeMessage mimeMessage = new MimeMessage(Session.getInstance(m12807a, this));
        mimeMessage.setFrom(new InternetAddress(this.f40119d));
        InternetAddress[] internetAddressArr = new InternetAddress[this.f40118c.length];
        for (int i = 0; i < this.f40118c.length; i++) {
            internetAddressArr[i] = new InternetAddress(this.f40118c[i]);
        }
        mimeMessage.setRecipients(Message.RecipientType.f40788TO, internetAddressArr);
        mimeMessage.setSubject(this.f40123h);
        mimeMessage.setSentDate(new Date());
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText(this.f40124i);
        this.f40127l.addBodyPart(mimeBodyPart);
        mimeMessage.setContent(this.f40127l);
        Transport.send(mimeMessage);
        return true;
    }

    /* renamed from: q */
    public void m12791q(String str) {
        this.f40124i = str;
    }

    /* renamed from: r */
    public void m12790r(boolean z) {
        this.f40125j = z;
    }

    /* renamed from: s */
    public void m12789s(String str) {
        this.f40124i = str;
    }

    /* renamed from: t */
    public void m12788t(boolean z) {
        this.f40126k = z;
    }

    /* renamed from: u */
    public void m12787u(String str) {
        this.f40119d = str;
    }

    /* renamed from: v */
    public void m12786v(String str) {
        this.f40122g = str;
    }

    /* renamed from: w */
    public void m12785w(Multipart multipart) {
        this.f40127l = multipart;
    }

    /* renamed from: x */
    public void m12784x(String str) {
        this.f40117b = str;
    }

    /* renamed from: y */
    public void m12783y(String str) {
        this.f40120e = str;
    }

    /* renamed from: z */
    public void m12782z(String str) {
        this.f40121f = str;
    }

    public MyMail(String str, String str2) {
        this();
        this.f40116a = str;
        this.f40117b = str2;
    }
}

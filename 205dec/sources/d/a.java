package d;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MyMail.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a extends Authenticator {

    /* renamed from: a  reason: collision with root package name */
    private String f54607a;

    /* renamed from: b  reason: collision with root package name */
    private String f54608b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f54609c;

    /* renamed from: d  reason: collision with root package name */
    private String f54610d;

    /* renamed from: e  reason: collision with root package name */
    private String f54611e;

    /* renamed from: f  reason: collision with root package name */
    private String f54612f;

    /* renamed from: g  reason: collision with root package name */
    private String f54613g;

    /* renamed from: h  reason: collision with root package name */
    private String f54614h;

    /* renamed from: i  reason: collision with root package name */
    private String f54615i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f54616j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f54617k;

    /* renamed from: l  reason: collision with root package name */
    private Multipart f54618l;

    public a() {
        this.f54613g = "smtp.qq.com";
        this.f54611e = "587";
        this.f54612f = "587";
        this.f54607a = "";
        this.f54608b = "";
        this.f54610d = "";
        this.f54614h = "";
        this.f54615i = "";
        this.f54617k = false;
        this.f54616j = true;
        this.f54618l = new MimeMultipart();
        MailcapCommandMap mailcapCommandMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        mailcapCommandMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
        mailcapCommandMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
        mailcapCommandMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
        mailcapCommandMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
        mailcapCommandMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
        CommandMap.setDefaultCommandMap(mailcapCommandMap);
    }

    private Properties a() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", this.f54613g);
        if (this.f54617k) {
            properties.put("mail.debug", "true");
        }
        if (this.f54616j) {
            properties.put("mail.smtp.auth", "true");
        }
        properties.put("mail.smtp.port", this.f54611e);
        properties.put("mail.password", "dylanandroid2dev");
        properties.put("mail.smtp.socketFactory.port", this.f54612f);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        return properties;
    }

    public void A(String str) {
        this.f54614h = str;
    }

    public void B(String[] strArr) {
        this.f54609c = strArr;
    }

    public void C(String str) {
        this.f54607a = str;
    }

    public void b(String str) throws Exception {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setDataHandler(new DataHandler(new FileDataSource(str)));
        String[] split = str.split(TTPathConst.sSeparator);
        mimeBodyPart.setFileName(split[split.length - 1]);
        this.f54618l.addBodyPart(mimeBodyPart);
    }

    public String c() {
        return this.f54615i;
    }

    public String d() {
        return this.f54615i;
    }

    public String e() {
        return this.f54610d;
    }

    public String f() {
        return this.f54613g;
    }

    public Multipart g() {
        return this.f54618l;
    }

    @Override // javax.mail.Authenticator
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.f54607a, this.f54608b);
    }

    public String h() {
        return this.f54608b;
    }

    public String i() {
        return this.f54611e;
    }

    public String j() {
        return this.f54612f;
    }

    public String k() {
        return this.f54614h;
    }

    public String[] l() {
        return this.f54609c;
    }

    public String m() {
        return this.f54607a;
    }

    public boolean n() {
        return this.f54616j;
    }

    public boolean o() {
        return this.f54617k;
    }

    public boolean p() throws Exception {
        Properties a4 = a();
        if (this.f54607a.equals("") || this.f54608b.equals("") || this.f54609c.length <= 0 || this.f54610d.equals("") || this.f54614h.equals("") || this.f54615i.equals("")) {
            return false;
        }
        MimeMessage mimeMessage = new MimeMessage(Session.getInstance(a4, this));
        mimeMessage.setFrom(new InternetAddress(this.f54610d));
        InternetAddress[] internetAddressArr = new InternetAddress[this.f54609c.length];
        for (int i4 = 0; i4 < this.f54609c.length; i4++) {
            internetAddressArr[i4] = new InternetAddress(this.f54609c[i4]);
        }
        mimeMessage.setRecipients(Message.RecipientType.TO, internetAddressArr);
        mimeMessage.setSubject(this.f54614h);
        mimeMessage.setSentDate(new Date());
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText(this.f54615i);
        this.f54618l.addBodyPart(mimeBodyPart);
        mimeMessage.setContent(this.f54618l);
        Transport.send(mimeMessage);
        return true;
    }

    public void q(String str) {
        this.f54615i = str;
    }

    public void r(boolean z3) {
        this.f54616j = z3;
    }

    public void s(String str) {
        this.f54615i = str;
    }

    public void t(boolean z3) {
        this.f54617k = z3;
    }

    public void u(String str) {
        this.f54610d = str;
    }

    public void v(String str) {
        this.f54613g = str;
    }

    public void w(Multipart multipart) {
        this.f54618l = multipart;
    }

    public void x(String str) {
        this.f54608b = str;
    }

    public void y(String str) {
        this.f54611e = str;
    }

    public void z(String str) {
        this.f54612f = str;
    }

    public a(String str, String str2) {
        this();
        this.f54607a = str;
        this.f54608b = str2;
    }
}

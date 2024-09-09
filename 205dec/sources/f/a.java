package f;

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
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MyMail.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a extends Authenticator {

    /* renamed from: a  reason: collision with root package name */
    private String f54646a;

    /* renamed from: b  reason: collision with root package name */
    private String f54647b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f54648c;

    /* renamed from: d  reason: collision with root package name */
    private String f54649d;

    /* renamed from: e  reason: collision with root package name */
    private String f54650e;

    /* renamed from: f  reason: collision with root package name */
    private String f54651f;

    /* renamed from: g  reason: collision with root package name */
    private String f54652g;

    /* renamed from: h  reason: collision with root package name */
    private String f54653h;

    /* renamed from: i  reason: collision with root package name */
    private String f54654i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f54655j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f54656k;

    /* renamed from: l  reason: collision with root package name */
    private Multipart f54657l;

    public a() {
        this.f54652g = "smtp.qq.com";
        this.f54650e = "587";
        this.f54651f = "587";
        this.f54646a = "";
        this.f54647b = "";
        this.f54649d = "";
        this.f54653h = "";
        this.f54654i = "";
        this.f54656k = false;
        this.f54655j = true;
        this.f54657l = new MimeMultipart();
        MailcapCommandMap mailcapCommandMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        mailcapCommandMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
        mailcapCommandMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
        mailcapCommandMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
        mailcapCommandMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
        mailcapCommandMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
        CommandMap.setDefaultCommandMap(mailcapCommandMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Properties a() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", this.f54652g);
        if (this.f54656k) {
            properties.put("mail.debug", "true");
        }
        if (this.f54655j) {
            properties.put("mail.smtp.auth", "true");
        }
        properties.put("mail.smtp.port", this.f54650e);
        properties.put("mail.password", "dylanandroid2dev");
        properties.put("mail.smtp.socketFactory.port", this.f54651f);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        return properties;
    }

    public void A(String str) {
        this.f54653h = str;
    }

    public void B(String[] strArr) {
        this.f54648c = strArr;
    }

    public void C(String str) {
        this.f54646a = str;
    }

    public void b(String str) throws Exception {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setDataHandler(new DataHandler(new FileDataSource(str)));
        String[] split = str.split(TTPathConst.sSeparator);
        mimeBodyPart.setFileName(split[split.length - 1]);
        this.f54657l.addBodyPart(mimeBodyPart);
    }

    public String c() {
        return this.f54654i;
    }

    public String d() {
        return this.f54654i;
    }

    public String e() {
        return this.f54649d;
    }

    public String f() {
        return this.f54652g;
    }

    public Multipart g() {
        return this.f54657l;
    }

    @Override // javax.mail.Authenticator
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.f54646a, this.f54647b);
    }

    public String h() {
        return this.f54647b;
    }

    public String i() {
        return this.f54650e;
    }

    public String j() {
        return this.f54651f;
    }

    public String k() {
        return this.f54653h;
    }

    public String[] l() {
        return this.f54648c;
    }

    public String m() {
        return this.f54646a;
    }

    public boolean n() {
        return this.f54655j;
    }

    public boolean o() {
        return this.f54656k;
    }

    public boolean p() throws Exception {
        Properties a4 = a();
        if (this.f54646a.equals("") || this.f54647b.equals("") || this.f54648c.length <= 0 || this.f54649d.equals("") || this.f54653h.equals("") || this.f54654i.equals("")) {
            return false;
        }
        MimeMessage mimeMessage = new MimeMessage(Session.getInstance(a4, this));
        mimeMessage.setFrom(new InternetAddress(this.f54649d));
        InternetAddress[] internetAddressArr = new InternetAddress[this.f54648c.length];
        for (int i4 = 0; i4 < this.f54648c.length; i4++) {
            internetAddressArr[i4] = new InternetAddress(this.f54648c[i4]);
        }
        mimeMessage.setRecipients(Message.RecipientType.TO, internetAddressArr);
        mimeMessage.setSubject(this.f54653h);
        mimeMessage.setSentDate(new Date());
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText(this.f54654i);
        this.f54657l.addBodyPart(mimeBodyPart);
        mimeMessage.setContent(this.f54657l);
        Transport.send(mimeMessage);
        return true;
    }

    public void q(String str) {
        this.f54654i = str;
    }

    public void r(boolean z3) {
        this.f54655j = z3;
    }

    public void s(String str) {
        this.f54654i = str;
    }

    public void t(boolean z3) {
        this.f54656k = z3;
    }

    public void u(String str) {
        this.f54649d = str;
    }

    public void v(String str) {
        this.f54652g = str;
    }

    public void w(Multipart multipart) {
        this.f54657l = multipart;
    }

    public void x(String str) {
        this.f54647b = str;
    }

    public void y(String str) {
        this.f54650e = str;
    }

    public void z(String str) {
        this.f54651f = str;
    }

    public a(String str, String str2) {
        this();
        this.f54646a = str;
        this.f54647b = str2;
    }
}

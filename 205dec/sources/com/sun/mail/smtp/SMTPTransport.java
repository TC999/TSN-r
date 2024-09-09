package com.sun.mail.smtp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimePart;
import javax.mail.internet.ParseException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SMTPTransport extends Transport {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String UNKNOWN = "UNKNOWN";
    private Address[] addresses;
    private SMTPOutputStream dataStream;
    private int defaultPort;
    private MessagingException exception;
    private Hashtable extMap;
    private Address[] invalidAddr;
    private boolean isSSL;
    private int lastReturnCode;
    private String lastServerResponse;
    private LineInputStream lineInputStream;
    private String localHostName;
    private DigestMD5 md5support;
    private MimeMessage message;
    private String name;
    private PrintStream out;
    private boolean quitWait;
    private boolean reportSuccess;
    private String saslRealm;
    private boolean sendPartiallyFailed;
    private BufferedInputStream serverInput;
    private OutputStream serverOutput;
    private Socket serverSocket;
    private boolean useRset;
    private boolean useStartTLS;
    private Address[] validSentAddr;
    private Address[] validUnsentAddr;
    private static final String[] ignoreList = {"Bcc", "Content-Length"};
    private static final byte[] CRLF = {13, 10};
    private static char[] hexchar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public SMTPTransport(Session session, URLName uRLName) {
        this(session, uRLName, "smtp", 25, false);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.OutputStream, java.net.Socket, java.io.BufferedInputStream, com.sun.mail.util.LineInputStream] */
    private void closeConnection() throws MessagingException {
        try {
            try {
                Socket socket = this.serverSocket;
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e4) {
                throw new MessagingException("Server Close Failed", e4);
            }
        } finally {
            this.serverSocket = null;
            this.serverOutput = null;
            this.serverInput = null;
            this.lineInputStream = null;
            if (super.isConnected()) {
                super.close();
            }
        }
    }

    private boolean convertTo8Bit(MimePart mimePart) {
        boolean z3 = false;
        z3 = false;
        z3 = false;
        z3 = false;
        z3 = false;
        try {
            if (mimePart.isMimeType("text/*")) {
                String encoding = mimePart.getEncoding();
                if (encoding != null && ((encoding.equalsIgnoreCase("quoted-printable") || encoding.equalsIgnoreCase("base64")) && is8Bit(mimePart.getInputStream()))) {
                    mimePart.setContent(mimePart.getContent(), mimePart.getContentType());
                    mimePart.setHeader("Content-Transfer-Encoding", "8bit");
                    z3 = true;
                }
            } else if (mimePart.isMimeType("multipart/*")) {
                MimeMultipart mimeMultipart = (MimeMultipart) mimePart.getContent();
                int count = mimeMultipart.getCount();
                boolean z4 = false;
                for (int i4 = 0; i4 < count; i4++) {
                    try {
                        if (convertTo8Bit((MimePart) mimeMultipart.getBodyPart(i4))) {
                            z4 = true;
                        }
                    } catch (IOException | MessagingException unused) {
                    }
                }
                z3 = z4;
            }
        } catch (IOException | MessagingException unused2) {
        }
        return z3;
    }

    private void expandGroups() {
        Vector vector = null;
        int i4 = 0;
        while (true) {
            Address[] addressArr = this.addresses;
            if (i4 >= addressArr.length) {
                break;
            }
            InternetAddress internetAddress = (InternetAddress) addressArr[i4];
            if (internetAddress.isGroup()) {
                if (vector == null) {
                    Vector vector2 = new Vector();
                    for (int i5 = 0; i5 < i4; i5++) {
                        vector2.addElement(this.addresses[i5]);
                    }
                    vector = vector2;
                }
                try {
                    InternetAddress[] group = internetAddress.getGroup(true);
                    if (group != null) {
                        for (InternetAddress internetAddress2 : group) {
                            vector.addElement(internetAddress2);
                        }
                    } else {
                        vector.addElement(internetAddress);
                    }
                } catch (ParseException unused) {
                    vector.addElement(internetAddress);
                }
            } else if (vector != null) {
                vector.addElement(internetAddress);
            }
            i4++;
        }
        if (vector != null) {
            InternetAddress[] internetAddressArr = new InternetAddress[vector.size()];
            vector.copyInto(internetAddressArr);
            this.addresses = internetAddressArr;
        }
    }

    private synchronized DigestMD5 getMD5() {
        if (this.md5support == null) {
            this.md5support = new DigestMD5(this.debug ? this.out : null);
        }
        return this.md5support;
    }

    private void initStreams() throws IOException {
        Properties properties = this.session.getProperties();
        PrintStream debugOut = this.session.getDebugOut();
        boolean debug = this.session.getDebug();
        String property = properties.getProperty("mail.debug.quote");
        boolean z3 = property != null && property.equalsIgnoreCase("true");
        TraceInputStream traceInputStream = new TraceInputStream(this.serverSocket.getInputStream(), debugOut);
        traceInputStream.setTrace(debug);
        traceInputStream.setQuote(z3);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.serverSocket.getOutputStream(), debugOut);
        traceOutputStream.setTrace(debug);
        traceOutputStream.setQuote(z3);
        this.serverOutput = new BufferedOutputStream(traceOutputStream);
        this.serverInput = new BufferedInputStream(traceInputStream);
        this.lineInputStream = new LineInputStream(this.serverInput);
    }

    private boolean is8Bit(InputStream inputStream) {
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            try {
                int read = inputStream.read();
                if (read < 0) {
                    if (this.debug && z3) {
                        this.out.println("DEBUG SMTP: found an 8bit part");
                    }
                    return z3;
                }
                int i5 = read & 255;
                if (i5 == 13 || i5 == 10) {
                    i4 = 0;
                } else if (i5 == 0 || (i4 = i4 + 1) > 998) {
                    return false;
                }
                if (i5 > 127) {
                    z3 = true;
                }
            } catch (IOException unused) {
                return false;
            }
        }
    }

    private boolean isNotLastLine(String str) {
        return str != null && str.length() >= 4 && str.charAt(3) == '-';
    }

    private void issueSendCommand(String str, int i4) throws MessagingException {
        sendCommand(str);
        int readServerResponse = readServerResponse();
        if (readServerResponse != i4) {
            Address[] addressArr = this.validSentAddr;
            int length = addressArr == null ? 0 : addressArr.length;
            Address[] addressArr2 = this.validUnsentAddr;
            int length2 = addressArr2 == null ? 0 : addressArr2.length;
            Address[] addressArr3 = new Address[length + length2];
            if (length > 0) {
                System.arraycopy(addressArr, 0, addressArr3, 0, length);
            }
            if (length2 > 0) {
                System.arraycopy(this.validUnsentAddr, 0, addressArr3, length, length2);
            }
            this.validSentAddr = null;
            this.validUnsentAddr = addressArr3;
            if (this.debug) {
                PrintStream printStream = this.out;
                printStream.println("DEBUG SMTP: got response code " + readServerResponse + ", with response: " + this.lastServerResponse);
            }
            String str2 = this.lastServerResponse;
            int i5 = this.lastReturnCode;
            if (this.serverSocket != null) {
                issueCommand("RSET", 250);
            }
            this.lastServerResponse = str2;
            this.lastReturnCode = i5;
            throw new SMTPSendFailedException(str, readServerResponse, this.lastServerResponse, this.exception, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
        }
    }

    private String normalizeAddress(String str) {
        if (str.startsWith("<") || str.endsWith(">")) {
            return str;
        }
        return "<" + str + ">";
    }

    private void openServer(String str, int i4) throws MessagingException {
        if (this.debug) {
            PrintStream printStream = this.out;
            printStream.println("DEBUG SMTP: trying to connect to host \"" + str + "\", port " + i4 + ", isSSL " + this.isSSL);
        }
        try {
            Properties properties = this.session.getProperties();
            Socket socket = SocketFetcher.getSocket(str, i4, properties, "mail." + this.name, this.isSSL);
            this.serverSocket = socket;
            int port = socket.getPort();
            initStreams();
            int readServerResponse = readServerResponse();
            if (readServerResponse != 220) {
                this.serverSocket.close();
                this.serverSocket = null;
                this.serverOutput = null;
                this.serverInput = null;
                this.lineInputStream = null;
                if (this.debug) {
                    PrintStream printStream2 = this.out;
                    printStream2.println("DEBUG SMTP: could not connect to host \"" + str + "\", port: " + port + ", response: " + readServerResponse + "\n");
                }
                throw new MessagingException("Could not connect to SMTP host: " + str + ", port: " + port + ", response: " + readServerResponse);
            } else if (this.debug) {
                PrintStream printStream3 = this.out;
                printStream3.println("DEBUG SMTP: connected to host \"" + str + "\", port: " + port + "\n");
            }
        } catch (UnknownHostException e4) {
            throw new MessagingException("Unknown SMTP host: " + str, e4);
        } catch (IOException e5) {
            throw new MessagingException("Could not connect to SMTP host: " + str + ", port: " + i4, e5);
        }
    }

    protected static String xtext(String str) {
        StringBuffer stringBuffer = null;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (charAt >= '\u0080') {
                throw new IllegalArgumentException("Non-ASCII character in SMTP submitter: " + str);
            }
            if (charAt < '!' || charAt > '~' || charAt == '+' || charAt == '=') {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(str.length() + 4);
                    stringBuffer.append(str.substring(0, i4));
                }
                stringBuffer.append('+');
                stringBuffer.append(hexchar[(charAt & '\u00f0') >> 4]);
                stringBuffer.append(hexchar[charAt & 15]);
            } else if (stringBuffer != null) {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer != null ? stringBuffer.toString() : str;
    }

    protected void checkConnected() {
        if (!super.isConnected()) {
            throw new IllegalStateException("Not connected");
        }
    }

    @Override // javax.mail.Service
    public synchronized void close() throws MessagingException {
        int readServerResponse;
        if (super.isConnected()) {
            if (this.serverSocket != null) {
                sendCommand("QUIT");
                if (this.quitWait && (readServerResponse = readServerResponse()) != 221 && readServerResponse != -1) {
                    PrintStream printStream = this.out;
                    printStream.println("DEBUG SMTP: QUIT failed with " + readServerResponse);
                }
            }
            closeConnection();
        }
    }

    public synchronized void connect(Socket socket) throws MessagingException {
        this.serverSocket = socket;
        super.connect();
    }

    protected OutputStream data() throws MessagingException {
        issueSendCommand("DATA", MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY);
        SMTPOutputStream sMTPOutputStream = new SMTPOutputStream(this.serverOutput);
        this.dataStream = sMTPOutputStream;
        return sMTPOutputStream;
    }

    protected boolean ehlo(String str) throws MessagingException {
        String str2;
        if (str != null) {
            str2 = "EHLO " + str;
        } else {
            str2 = "EHLO";
        }
        sendCommand(str2);
        int readServerResponse = readServerResponse();
        if (readServerResponse == 250) {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(this.lastServerResponse));
            this.extMap = new Hashtable();
            boolean z3 = true;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (z3) {
                        z3 = false;
                    } else if (readLine.length() >= 5) {
                        String substring = readLine.substring(4);
                        int indexOf = substring.indexOf(32);
                        String str3 = "";
                        if (indexOf > 0) {
                            str3 = substring.substring(indexOf + 1);
                            substring = substring.substring(0, indexOf);
                        }
                        if (this.debug) {
                            this.out.println("DEBUG SMTP: Found extension \"" + substring + "\", arg \"" + str3 + "\"");
                        }
                        this.extMap.put(substring.toUpperCase(Locale.ENGLISH), str3);
                    }
                } catch (IOException unused) {
                }
            }
        }
        return readServerResponse == 250;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.Service
    public void finalize() throws Throwable {
        super.finalize();
        try {
            closeConnection();
        } catch (MessagingException unused) {
        }
    }

    protected void finishData() throws IOException, MessagingException {
        this.dataStream.ensureAtBOL();
        issueSendCommand(".", 250);
    }

    public String getExtensionParameter(String str) {
        Hashtable hashtable = this.extMap;
        if (hashtable == null) {
            return null;
        }
        return (String) hashtable.get(str.toUpperCase(Locale.ENGLISH));
    }

    public synchronized int getLastReturnCode() {
        return this.lastReturnCode;
    }

    public synchronized String getLastServerResponse() {
        return this.lastServerResponse;
    }

    public synchronized String getLocalHost() {
        try {
            String str = this.localHostName;
            if (str == null || str.length() <= 0) {
                Session session = this.session;
                this.localHostName = session.getProperty("mail." + this.name + ".localhost");
            }
            String str2 = this.localHostName;
            if (str2 == null || str2.length() <= 0) {
                Session session2 = this.session;
                this.localHostName = session2.getProperty("mail." + this.name + ".localaddress");
            }
            String str3 = this.localHostName;
            if (str3 == null || str3.length() <= 0) {
                InetAddress localHost = InetAddress.getLocalHost();
                String hostName = localHost.getHostName();
                this.localHostName = hostName;
                if (hostName == null) {
                    this.localHostName = "[" + localHost.getHostAddress() + "]";
                }
            }
        } catch (UnknownHostException unused) {
        }
        return this.localHostName;
    }

    public synchronized boolean getReportSuccess() {
        return this.reportSuccess;
    }

    public synchronized String getSASLRealm() {
        if (this.saslRealm == "UNKNOWN") {
            Session session = this.session;
            String property = session.getProperty("mail." + this.name + ".sasl.realm");
            this.saslRealm = property;
            if (property == null) {
                Session session2 = this.session;
                this.saslRealm = session2.getProperty("mail." + this.name + ".saslrealm");
            }
        }
        return this.saslRealm;
    }

    public synchronized boolean getStartTLS() {
        return this.useStartTLS;
    }

    public synchronized boolean getUseRset() {
        return this.useRset;
    }

    protected void helo(String str) throws MessagingException {
        if (str != null) {
            issueCommand("HELO " + str, 250);
            return;
        }
        issueCommand("HELO", 250);
    }

    @Override // javax.mail.Service
    public synchronized boolean isConnected() {
        if (super.isConnected()) {
            try {
                try {
                    if (this.useRset) {
                        sendCommand("RSET");
                    } else {
                        sendCommand("NOOP");
                    }
                    int readServerResponse = readServerResponse();
                    if (readServerResponse < 0 || readServerResponse == 421) {
                        try {
                            closeConnection();
                        } catch (MessagingException unused) {
                        }
                        return false;
                    }
                    return true;
                } catch (MessagingException unused2) {
                    return false;
                }
            } catch (Exception unused3) {
                closeConnection();
                return false;
            }
        }
        return false;
    }

    public synchronized void issueCommand(String str, int i4) throws MessagingException {
        sendCommand(str);
        if (readServerResponse() != i4) {
            throw new MessagingException(this.lastServerResponse);
        }
    }

    protected void mailFrom() throws MessagingException {
        InternetAddress localAddress;
        Address[] from;
        MimeMessage mimeMessage = this.message;
        String envelopeFrom = mimeMessage instanceof SMTPMessage ? ((SMTPMessage) mimeMessage).getEnvelopeFrom() : null;
        if (envelopeFrom == null || envelopeFrom.length() <= 0) {
            envelopeFrom = this.session.getProperty("mail." + this.name + ".from");
        }
        if (envelopeFrom == null || envelopeFrom.length() <= 0) {
            MimeMessage mimeMessage2 = this.message;
            if (mimeMessage2 != null && (from = mimeMessage2.getFrom()) != null && from.length > 0) {
                localAddress = from[0];
            } else {
                localAddress = InternetAddress.getLocalAddress(this.session);
            }
            if (localAddress != null) {
                envelopeFrom = localAddress.getAddress();
            } else {
                throw new MessagingException("can't determine local email address");
            }
        }
        String str = "MAIL FROM:" + normalizeAddress(envelopeFrom);
        if (supportsExtension("DSN")) {
            MimeMessage mimeMessage3 = this.message;
            String dSNRet = mimeMessage3 instanceof SMTPMessage ? ((SMTPMessage) mimeMessage3).getDSNRet() : null;
            if (dSNRet == null) {
                dSNRet = this.session.getProperty("mail." + this.name + ".dsn.ret");
            }
            if (dSNRet != null) {
                str = String.valueOf(str) + " RET=" + dSNRet;
            }
        }
        if (supportsExtension("AUTH")) {
            MimeMessage mimeMessage4 = this.message;
            String submitter = mimeMessage4 instanceof SMTPMessage ? ((SMTPMessage) mimeMessage4).getSubmitter() : null;
            if (submitter == null) {
                submitter = this.session.getProperty("mail." + this.name + ".submitter");
            }
            if (submitter != null) {
                try {
                    str = String.valueOf(str) + " AUTH=" + xtext(submitter);
                } catch (IllegalArgumentException e4) {
                    if (this.debug) {
                        this.out.println("DEBUG SMTP: ignoring invalid submitter: " + submitter + ", Exception: " + e4);
                    }
                }
            }
        }
        MimeMessage mimeMessage5 = this.message;
        String mailExtension = mimeMessage5 instanceof SMTPMessage ? ((SMTPMessage) mimeMessage5).getMailExtension() : null;
        if (mailExtension == null) {
            mailExtension = this.session.getProperty("mail." + this.name + ".mailextension");
        }
        if (mailExtension != null && mailExtension.length() > 0) {
            str = String.valueOf(str) + " " + mailExtension;
        }
        issueSendCommand(str, 250);
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01e2  */
    @Override // javax.mail.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean protocolConnect(java.lang.String r15, int r16, java.lang.String r17, java.lang.String r18) throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 581
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.protocolConnect(java.lang.String, int, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x00a1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void rcptTo() throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 790
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.rcptTo():void");
    }

    protected int readServerResponse() throws MessagingException {
        String readLine;
        int i4;
        StringBuffer stringBuffer = new StringBuffer(100);
        do {
            try {
                readLine = this.lineInputStream.readLine();
                if (readLine == null) {
                    String stringBuffer2 = stringBuffer.toString();
                    if (stringBuffer2.length() == 0) {
                        stringBuffer2 = "[EOF]";
                    }
                    this.lastServerResponse = stringBuffer2;
                    this.lastReturnCode = -1;
                    if (this.debug) {
                        PrintStream printStream = this.out;
                        printStream.println("DEBUG SMTP: EOF: " + stringBuffer2);
                    }
                    return -1;
                }
                stringBuffer.append(readLine);
                stringBuffer.append("\n");
            } catch (IOException e4) {
                if (this.debug) {
                    PrintStream printStream2 = this.out;
                    printStream2.println("DEBUG SMTP: exception reading response: " + e4);
                }
                this.lastServerResponse = "";
                this.lastReturnCode = 0;
                throw new MessagingException("Exception reading response", e4);
            }
        } while (isNotLastLine(readLine));
        String stringBuffer3 = stringBuffer.toString();
        if (stringBuffer3 != null && stringBuffer3.length() >= 3) {
            try {
                try {
                    try {
                        i4 = Integer.parseInt(stringBuffer3.substring(0, 3));
                    } catch (NumberFormatException unused) {
                        close();
                    } catch (StringIndexOutOfBoundsException unused2) {
                        close();
                    }
                } catch (MessagingException e5) {
                    if (this.debug) {
                        e5.printStackTrace(this.out);
                    }
                }
            } catch (MessagingException e6) {
                if (this.debug) {
                    e6.printStackTrace(this.out);
                }
            }
            if (i4 == -1 && this.debug) {
                PrintStream printStream3 = this.out;
                printStream3.println("DEBUG SMTP: bad server response: " + stringBuffer3);
            }
            this.lastServerResponse = stringBuffer3;
            this.lastReturnCode = i4;
            return i4;
        }
        i4 = -1;
        if (i4 == -1) {
            PrintStream printStream32 = this.out;
            printStream32.println("DEBUG SMTP: bad server response: " + stringBuffer3);
        }
        this.lastServerResponse = stringBuffer3;
        this.lastReturnCode = i4;
        return i4;
    }

    protected void sendCommand(String str) throws MessagingException {
        sendCommand(ASCIIUtility.getBytes(str));
    }

    @Override // javax.mail.Transport
    public synchronized void sendMessage(Message message, Address[] addressArr) throws MessagingException, SendFailedException {
        checkConnected();
        if (!(message instanceof MimeMessage)) {
            if (this.debug) {
                this.out.println("DEBUG SMTP: Can only send RFC822 msgs");
            }
            throw new MessagingException("SMTP can only send RFC822 messages");
        }
        for (int i4 = 0; i4 < addressArr.length; i4++) {
            if (!(addressArr[i4] instanceof InternetAddress)) {
                throw new MessagingException(addressArr[i4] + " is not an InternetAddress");
            }
        }
        this.message = (MimeMessage) message;
        this.addresses = addressArr;
        this.validUnsentAddr = addressArr;
        expandGroups();
        boolean allow8bitMIME = message instanceof SMTPMessage ? ((SMTPMessage) message).getAllow8bitMIME() : false;
        if (!allow8bitMIME) {
            Session session = this.session;
            String property = session.getProperty("mail." + this.name + ".allow8bitmime");
            allow8bitMIME = property != null && property.equalsIgnoreCase("true");
        }
        if (this.debug) {
            PrintStream printStream = this.out;
            printStream.println("DEBUG SMTP: use8bit " + allow8bitMIME);
        }
        if (allow8bitMIME && supportsExtension("8BITMIME") && convertTo8Bit(this.message)) {
            try {
                this.message.saveChanges();
            } catch (MessagingException unused) {
            }
        }
        try {
            mailFrom();
            rcptTo();
            this.message.writeTo(data(), ignoreList);
            finishData();
            if (this.sendPartiallyFailed) {
                if (this.debug) {
                    this.out.println("DEBUG SMTP: Sending partially failed because of invalid destination addresses");
                }
                notifyTransportListeners(3, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                throw new SMTPSendFailedException(".", this.lastReturnCode, this.lastServerResponse, this.exception, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
            }
            notifyTransportListeners(1, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
            this.invalidAddr = null;
            this.validUnsentAddr = null;
            this.validSentAddr = null;
            this.addresses = null;
            this.message = null;
            this.exception = null;
            this.sendPartiallyFailed = false;
        } catch (IOException e4) {
            if (this.debug) {
                e4.printStackTrace(this.out);
            }
            try {
                closeConnection();
            } catch (MessagingException unused2) {
            }
            notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
            throw new MessagingException("IOException while sending message", e4);
        } catch (MessagingException e5) {
            if (this.debug) {
                e5.printStackTrace(this.out);
            }
            notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
            throw e5;
        }
    }

    public synchronized void setLocalHost(String str) {
        this.localHostName = str;
    }

    public synchronized void setReportSuccess(boolean z3) {
        this.reportSuccess = z3;
    }

    public synchronized void setSASLRealm(String str) {
        this.saslRealm = str;
    }

    public synchronized void setStartTLS(boolean z3) {
        this.useStartTLS = z3;
    }

    public synchronized void setUseRset(boolean z3) {
        this.useRset = z3;
    }

    public synchronized int simpleCommand(String str) throws MessagingException {
        sendCommand(str);
        return readServerResponse();
    }

    protected void startTLS() throws MessagingException {
        issueCommand("STARTTLS", MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM);
        try {
            Socket socket = this.serverSocket;
            Properties properties = this.session.getProperties();
            this.serverSocket = SocketFetcher.startTLS(socket, properties, "mail." + this.name);
            initStreams();
        } catch (IOException e4) {
            closeConnection();
            throw new MessagingException("Could not convert socket to TLS", e4);
        }
    }

    protected boolean supportsAuthentication(String str) {
        String str2;
        Hashtable hashtable = this.extMap;
        if (hashtable == null || (str2 = (String) hashtable.get("AUTH")) == null) {
            return false;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str2);
        while (stringTokenizer.hasMoreTokens()) {
            if (stringTokenizer.nextToken().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean supportsExtension(String str) {
        Hashtable hashtable = this.extMap;
        return (hashtable == null || hashtable.get(str.toUpperCase(Locale.ENGLISH)) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SMTPTransport(Session session, URLName uRLName, String str, int i4, boolean z3) {
        super(session, uRLName);
        this.name = "smtp";
        this.defaultPort = 25;
        boolean z4 = false;
        this.isSSL = false;
        this.sendPartiallyFailed = false;
        this.quitWait = false;
        this.saslRealm = "UNKNOWN";
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.name = str;
        this.defaultPort = i4;
        this.isSSL = z3;
        this.out = session.getDebugOut();
        String property = session.getProperty("mail." + str + ".quitwait");
        this.quitWait = property == null || property.equalsIgnoreCase("true");
        String property2 = session.getProperty("mail." + str + ".reportsuccess");
        this.reportSuccess = property2 != null && property2.equalsIgnoreCase("true");
        String property3 = session.getProperty("mail." + str + ".starttls.enable");
        this.useStartTLS = property3 != null && property3.equalsIgnoreCase("true");
        String property4 = session.getProperty("mail." + str + ".userset");
        if (property4 != null && property4.equalsIgnoreCase("true")) {
            z4 = true;
        }
        this.useRset = z4;
    }

    private void sendCommand(byte[] bArr) throws MessagingException {
        try {
            this.serverOutput.write(bArr);
            this.serverOutput.write(CRLF);
            this.serverOutput.flush();
        } catch (IOException e4) {
            throw new MessagingException("Can't send command to SMTP host", e4);
        }
    }

    protected int simpleCommand(byte[] bArr) throws MessagingException {
        sendCommand(bArr);
        return readServerResponse();
    }

    private void openServer() throws MessagingException {
        try {
            int port = this.serverSocket.getPort();
            String hostName = this.serverSocket.getInetAddress().getHostName();
            if (this.debug) {
                PrintStream printStream = this.out;
                printStream.println("DEBUG SMTP: starting protocol to host \"" + hostName + "\", port " + port);
            }
            initStreams();
            int readServerResponse = readServerResponse();
            if (readServerResponse != 220) {
                this.serverSocket.close();
                this.serverSocket = null;
                this.serverOutput = null;
                this.serverInput = null;
                this.lineInputStream = null;
                if (this.debug) {
                    PrintStream printStream2 = this.out;
                    printStream2.println("DEBUG SMTP: got bad greeting from host \"" + hostName + "\", port: " + port + ", response: " + readServerResponse + "\n");
                }
                throw new MessagingException("Got bad greeting from SMTP host: " + hostName + ", port: " + port + ", response: " + readServerResponse);
            } else if (this.debug) {
                PrintStream printStream3 = this.out;
                printStream3.println("DEBUG SMTP: protocol started to host \"" + hostName + "\", port: " + port + "\n");
            }
        } catch (IOException e4) {
            throw new MessagingException("Could not start protocol to SMTP host: UNKNOWN, port: -1", e4);
        }
    }
}

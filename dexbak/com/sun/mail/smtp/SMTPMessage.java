package com.sun.mail.smtp;

import io.netty.util.internal.StringUtil;
import java.io.InputStream;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SMTPMessage extends MimeMessage {
    public static final int NOTIFY_DELAY = 4;
    public static final int NOTIFY_FAILURE = 2;
    public static final int NOTIFY_NEVER = -1;
    public static final int NOTIFY_SUCCESS = 1;
    public static final int RETURN_FULL = 1;
    public static final int RETURN_HDRS = 2;
    private static final String[] returnOptionString;
    private boolean allow8bitMIME;
    private String envelopeFrom;
    private String extension;
    private int notifyOptions;
    private int returnOption;
    private boolean sendPartial;
    private String submitter;

    static {
        String[] strArr = new String[3];
        strArr[1] = "FULL";
        strArr[2] = "HDRS";
        returnOptionString = strArr;
    }

    public SMTPMessage(Session session) {
        super(session);
        this.notifyOptions = 0;
        this.returnOption = 0;
        this.sendPartial = false;
        this.allow8bitMIME = false;
        this.submitter = null;
        this.extension = null;
    }

    public boolean getAllow8bitMIME() {
        return this.allow8bitMIME;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDSNNotify() {
        int i = this.notifyOptions;
        if (i == 0) {
            return null;
        }
        if (i == -1) {
            return "NEVER";
        }
        StringBuffer stringBuffer = new StringBuffer();
        if ((this.notifyOptions & 1) != 0) {
            stringBuffer.append("SUCCESS");
        }
        if ((this.notifyOptions & 2) != 0) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(StringUtil.COMMA);
            }
            stringBuffer.append("FAILURE");
        }
        if ((this.notifyOptions & 4) != 0) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(StringUtil.COMMA);
            }
            stringBuffer.append("DELAY");
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDSNRet() {
        return returnOptionString[this.returnOption];
    }

    public String getEnvelopeFrom() {
        return this.envelopeFrom;
    }

    public String getMailExtension() {
        return this.extension;
    }

    public int getNotifyOptions() {
        return this.notifyOptions;
    }

    public int getReturnOption() {
        return this.returnOption;
    }

    public boolean getSendPartial() {
        return this.sendPartial;
    }

    public String getSubmitter() {
        return this.submitter;
    }

    public void setAllow8bitMIME(boolean z) {
        this.allow8bitMIME = z;
    }

    public void setEnvelopeFrom(String str) {
        this.envelopeFrom = str;
    }

    public void setMailExtension(String str) {
        this.extension = str;
    }

    public void setNotifyOptions(int i) {
        if (i >= -1 && i < 8) {
            this.notifyOptions = i;
            return;
        }
        throw new IllegalArgumentException("Bad return option");
    }

    public void setReturnOption(int i) {
        if (i >= 0 && i <= 2) {
            this.returnOption = i;
            return;
        }
        throw new IllegalArgumentException("Bad return option");
    }

    public void setSendPartial(boolean z) {
        this.sendPartial = z;
    }

    public void setSubmitter(String str) {
        this.submitter = str;
    }

    public SMTPMessage(Session session, InputStream inputStream) throws MessagingException {
        super(session, inputStream);
        this.notifyOptions = 0;
        this.returnOption = 0;
        this.sendPartial = false;
        this.allow8bitMIME = false;
        this.submitter = null;
        this.extension = null;
    }

    public SMTPMessage(MimeMessage mimeMessage) throws MessagingException {
        super(mimeMessage);
        this.notifyOptions = 0;
        this.returnOption = 0;
        this.sendPartial = false;
        this.allow8bitMIME = false;
        this.submitter = null;
        this.extension = null;
    }
}

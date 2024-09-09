package io.netty.handler.codec.smtp;

import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class SmtpRequests {
    private static final SmtpRequest DATA = new DefaultSmtpRequest(SmtpCommand.DATA);
    private static final SmtpRequest NOOP = new DefaultSmtpRequest(SmtpCommand.NOOP);
    private static final SmtpRequest RSET = new DefaultSmtpRequest(SmtpCommand.RSET);
    private static final SmtpRequest HELP_NO_ARG = new DefaultSmtpRequest(SmtpCommand.HELP);
    private static final SmtpRequest QUIT = new DefaultSmtpRequest(SmtpCommand.QUIT);
    private static final AsciiString FROM_NULL_SENDER = AsciiString.cached("FROM:<>");

    private SmtpRequests() {
    }

    public static SmtpRequest data() {
        return DATA;
    }

    public static SmtpRequest ehlo(CharSequence charSequence) {
        return new DefaultSmtpRequest(SmtpCommand.EHLO, charSequence);
    }

    public static SmtpRequest expn(CharSequence charSequence) {
        return new DefaultSmtpRequest(SmtpCommand.EXPN, (CharSequence) ObjectUtil.checkNotNull(charSequence, "mailingList"));
    }

    public static SmtpRequest helo(CharSequence charSequence) {
        return new DefaultSmtpRequest(SmtpCommand.HELO, charSequence);
    }

    public static SmtpRequest help(String str) {
        return str == null ? HELP_NO_ARG : new DefaultSmtpRequest(SmtpCommand.HELP, str);
    }

    public static SmtpRequest mail(CharSequence charSequence, CharSequence... charSequenceArr) {
        CharSequence charSequence2;
        CharSequence charSequence3;
        if (charSequenceArr != null && charSequenceArr.length != 0) {
            ArrayList arrayList = new ArrayList(charSequenceArr.length + 1);
            if (charSequence != null) {
                charSequence3 = "FROM:<" + ((Object) charSequence) + '>';
            } else {
                charSequence3 = FROM_NULL_SENDER;
            }
            arrayList.add(charSequence3);
            Collections.addAll(arrayList, charSequenceArr);
            return new DefaultSmtpRequest(SmtpCommand.MAIL, arrayList);
        }
        SmtpCommand smtpCommand = SmtpCommand.MAIL;
        CharSequence[] charSequenceArr2 = new CharSequence[1];
        if (charSequence != null) {
            charSequence2 = "FROM:<" + ((Object) charSequence) + '>';
        } else {
            charSequence2 = FROM_NULL_SENDER;
        }
        charSequenceArr2[0] = charSequence2;
        return new DefaultSmtpRequest(smtpCommand, charSequenceArr2);
    }

    public static SmtpRequest noop() {
        return NOOP;
    }

    public static SmtpRequest quit() {
        return QUIT;
    }

    public static SmtpRequest rcpt(CharSequence charSequence, CharSequence... charSequenceArr) {
        ObjectUtil.checkNotNull(charSequence, "recipient");
        if (charSequenceArr != null && charSequenceArr.length != 0) {
            ArrayList arrayList = new ArrayList(charSequenceArr.length + 1);
            arrayList.add("TO:<" + ((Object) charSequence) + '>');
            Collections.addAll(arrayList, charSequenceArr);
            return new DefaultSmtpRequest(SmtpCommand.RCPT, arrayList);
        }
        SmtpCommand smtpCommand = SmtpCommand.RCPT;
        return new DefaultSmtpRequest(smtpCommand, "TO:<" + ((Object) charSequence) + '>');
    }

    public static SmtpRequest rset() {
        return RSET;
    }

    public static SmtpRequest vrfy(CharSequence charSequence) {
        return new DefaultSmtpRequest(SmtpCommand.VRFY, (CharSequence) ObjectUtil.checkNotNull(charSequence, "user"));
    }
}

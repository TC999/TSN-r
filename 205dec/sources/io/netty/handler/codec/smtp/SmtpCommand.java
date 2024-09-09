package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class SmtpCommand {
    private static final Map<String, SmtpCommand> COMMANDS;
    public static final SmtpCommand DATA;
    public static final SmtpCommand EHLO;
    public static final SmtpCommand EXPN;
    public static final SmtpCommand HELO;
    public static final SmtpCommand HELP;
    public static final SmtpCommand MAIL;
    public static final SmtpCommand NOOP;
    public static final SmtpCommand QUIT;
    public static final SmtpCommand RCPT;
    public static final SmtpCommand RSET;
    public static final SmtpCommand VRFY;
    private final AsciiString name;

    static {
        SmtpCommand smtpCommand = new SmtpCommand(AsciiString.cached("EHLO"));
        EHLO = smtpCommand;
        SmtpCommand smtpCommand2 = new SmtpCommand(AsciiString.cached("HELO"));
        HELO = smtpCommand2;
        SmtpCommand smtpCommand3 = new SmtpCommand(AsciiString.cached("MAIL"));
        MAIL = smtpCommand3;
        SmtpCommand smtpCommand4 = new SmtpCommand(AsciiString.cached("RCPT"));
        RCPT = smtpCommand4;
        SmtpCommand smtpCommand5 = new SmtpCommand(AsciiString.cached("DATA"));
        DATA = smtpCommand5;
        SmtpCommand smtpCommand6 = new SmtpCommand(AsciiString.cached("NOOP"));
        NOOP = smtpCommand6;
        SmtpCommand smtpCommand7 = new SmtpCommand(AsciiString.cached("RSET"));
        RSET = smtpCommand7;
        SmtpCommand smtpCommand8 = new SmtpCommand(AsciiString.cached("EXPN"));
        EXPN = smtpCommand8;
        SmtpCommand smtpCommand9 = new SmtpCommand(AsciiString.cached("VRFY"));
        VRFY = smtpCommand9;
        SmtpCommand smtpCommand10 = new SmtpCommand(AsciiString.cached("HELP"));
        HELP = smtpCommand10;
        SmtpCommand smtpCommand11 = new SmtpCommand(AsciiString.cached("QUIT"));
        QUIT = smtpCommand11;
        HashMap hashMap = new HashMap();
        COMMANDS = hashMap;
        hashMap.put(smtpCommand.name().toString(), smtpCommand);
        hashMap.put(smtpCommand2.name().toString(), smtpCommand2);
        hashMap.put(smtpCommand3.name().toString(), smtpCommand3);
        hashMap.put(smtpCommand4.name().toString(), smtpCommand4);
        hashMap.put(smtpCommand5.name().toString(), smtpCommand5);
        hashMap.put(smtpCommand6.name().toString(), smtpCommand6);
        hashMap.put(smtpCommand7.name().toString(), smtpCommand7);
        hashMap.put(smtpCommand8.name().toString(), smtpCommand8);
        hashMap.put(smtpCommand9.name().toString(), smtpCommand9);
        hashMap.put(smtpCommand10.name().toString(), smtpCommand10);
        hashMap.put(smtpCommand11.name().toString(), smtpCommand11);
    }

    private SmtpCommand(AsciiString asciiString) {
        this.name = asciiString;
    }

    public static SmtpCommand valueOf(CharSequence charSequence) {
        ObjectUtil.checkNotNull(charSequence, "commandName");
        SmtpCommand smtpCommand = COMMANDS.get(charSequence.toString());
        return smtpCommand != null ? smtpCommand : new SmtpCommand(AsciiString.of(charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(ByteBuf byteBuf) {
        ByteBufUtil.writeAscii(byteBuf, this.name);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SmtpCommand) {
            return this.name.contentEqualsIgnoreCase(((SmtpCommand) obj).name());
        }
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isContentExpected() {
        return equals(DATA);
    }

    public AsciiString name() {
        return this.name;
    }

    public String toString() {
        return "SmtpCommand{name=" + ((Object) this.name) + '}';
    }
}

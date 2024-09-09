package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import javax.mail.Flags;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class FLAGS extends Flags implements l {
    static final char[] name = {'F', 'L', 'A', 'G', 'S'};
    private static final long serialVersionUID = 439049847053756670L;
    public int msgno;

    public FLAGS(i iVar) throws ParsingException {
        this.msgno = iVar.E();
        iVar.B();
        String[] H = iVar.H();
        if (H != null) {
            for (String str : H) {
                if (str.length() >= 2 && str.charAt(0) == '\\') {
                    char upperCase = Character.toUpperCase(str.charAt(1));
                    if (upperCase == '*') {
                        add(Flags.Flag.USER);
                    } else if (upperCase == 'A') {
                        add(Flags.Flag.ANSWERED);
                    } else if (upperCase != 'D') {
                        if (upperCase == 'F') {
                            add(Flags.Flag.FLAGGED);
                        } else if (upperCase == 'R') {
                            add(Flags.Flag.RECENT);
                        } else if (upperCase != 'S') {
                            add(str);
                        } else {
                            add(Flags.Flag.SEEN);
                        }
                    } else if (str.length() >= 3) {
                        char charAt = str.charAt(2);
                        if (charAt == 'e' || charAt == 'E') {
                            add(Flags.Flag.DELETED);
                        } else if (charAt == 'r' || charAt == 'R') {
                            add(Flags.Flag.DRAFT);
                        }
                    } else {
                        add(str);
                    }
                } else {
                    add(str);
                }
            }
        }
    }
}

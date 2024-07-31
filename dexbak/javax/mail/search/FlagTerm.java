package javax.mail.search;

import javax.mail.Flags;
import javax.mail.Message;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FlagTerm extends SearchTerm {
    private static final long serialVersionUID = -142991500302030647L;
    protected Flags flags;
    protected boolean set;

    public FlagTerm(Flags flags, boolean z) {
        this.flags = flags;
        this.set = z;
    }

    public boolean equals(Object obj) {
        if (obj instanceof FlagTerm) {
            FlagTerm flagTerm = (FlagTerm) obj;
            return flagTerm.set == this.set && flagTerm.flags.equals(this.flags);
        }
        return false;
    }

    public Flags getFlags() {
        return (Flags) this.flags.clone();
    }

    public boolean getTestSet() {
        return this.set;
    }

    public int hashCode() {
        return this.set ? this.flags.hashCode() : this.flags.hashCode() ^ (-1);
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            Flags flags = message.getFlags();
            if (this.set) {
                return flags.contains(this.flags);
            }
            for (Flags.Flag flag : this.flags.getSystemFlags()) {
                if (flags.contains(flag)) {
                    return false;
                }
            }
            for (String str : this.flags.getUserFlags()) {
                if (flags.contains(str)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}

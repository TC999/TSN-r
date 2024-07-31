package javax.mail;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Vector;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Flags implements Cloneable, Serializable {
    private static final int ANSWERED_BIT = 1;
    private static final int DELETED_BIT = 2;
    private static final int DRAFT_BIT = 4;
    private static final int FLAGGED_BIT = 8;
    private static final int RECENT_BIT = 16;
    private static final int SEEN_BIT = 32;
    private static final int USER_BIT = Integer.MIN_VALUE;
    private static final long serialVersionUID = 6243590407214169028L;
    private int system_flags;
    private Hashtable user_flags;

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class Flag {
        public static final Flag ANSWERED = new Flag(1);
        public static final Flag DELETED = new Flag(2);
        public static final Flag DRAFT = new Flag(4);
        public static final Flag FLAGGED = new Flag(8);
        public static final Flag RECENT = new Flag(16);
        public static final Flag SEEN = new Flag(32);
        public static final Flag USER = new Flag(Integer.MIN_VALUE);
        private int bit;

        private Flag(int i) {
            this.bit = i;
        }
    }

    public Flags() {
        this.system_flags = 0;
        this.user_flags = null;
    }

    public void add(Flag flag) {
        this.system_flags = flag.bit | this.system_flags;
    }

    public Object clone() {
        Flags flags;
        try {
            flags = (Flags) super.clone();
        } catch (CloneNotSupportedException unused) {
            flags = null;
        }
        Hashtable hashtable = this.user_flags;
        if (hashtable != null && flags != null) {
            flags.user_flags = (Hashtable) hashtable.clone();
        }
        return flags;
    }

    public boolean contains(Flag flag) {
        return (flag.bit & this.system_flags) != 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Flags) {
            Flags flags = (Flags) obj;
            if (flags.system_flags != this.system_flags) {
                return false;
            }
            Hashtable hashtable = flags.user_flags;
            if (hashtable == null && this.user_flags == null) {
                return true;
            }
            if (hashtable == null || this.user_flags == null || hashtable.size() != this.user_flags.size()) {
                return false;
            }
            Enumeration keys = flags.user_flags.keys();
            while (keys.hasMoreElements()) {
                if (!this.user_flags.containsKey(keys.nextElement())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Flag[] getSystemFlags() {
        Vector vector = new Vector();
        if ((this.system_flags & 1) != 0) {
            vector.addElement(Flag.ANSWERED);
        }
        if ((this.system_flags & 2) != 0) {
            vector.addElement(Flag.DELETED);
        }
        if ((this.system_flags & 4) != 0) {
            vector.addElement(Flag.DRAFT);
        }
        if ((this.system_flags & 8) != 0) {
            vector.addElement(Flag.FLAGGED);
        }
        if ((this.system_flags & 16) != 0) {
            vector.addElement(Flag.RECENT);
        }
        if ((this.system_flags & 32) != 0) {
            vector.addElement(Flag.SEEN);
        }
        if ((this.system_flags & Integer.MIN_VALUE) != 0) {
            vector.addElement(Flag.USER);
        }
        Flag[] flagArr = new Flag[vector.size()];
        vector.copyInto(flagArr);
        return flagArr;
    }

    public String[] getUserFlags() {
        Vector vector = new Vector();
        Hashtable hashtable = this.user_flags;
        if (hashtable != null) {
            Enumeration elements = hashtable.elements();
            while (elements.hasMoreElements()) {
                vector.addElement(elements.nextElement());
            }
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    public int hashCode() {
        int i = this.system_flags;
        Hashtable hashtable = this.user_flags;
        if (hashtable != null) {
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                i += ((String) keys.nextElement()).hashCode();
            }
        }
        return i;
    }

    public void remove(Flag flag) {
        this.system_flags = (flag.bit ^ (-1)) & this.system_flags;
    }

    public void add(String str) {
        if (this.user_flags == null) {
            this.user_flags = new Hashtable(1);
        }
        this.user_flags.put(str.toLowerCase(Locale.ENGLISH), str);
    }

    public boolean contains(String str) {
        Hashtable hashtable = this.user_flags;
        if (hashtable == null) {
            return false;
        }
        return hashtable.containsKey(str.toLowerCase(Locale.ENGLISH));
    }

    public void remove(String str) {
        Hashtable hashtable = this.user_flags;
        if (hashtable != null) {
            hashtable.remove(str.toLowerCase(Locale.ENGLISH));
        }
    }

    public Flags(Flags flags) {
        this.system_flags = 0;
        this.user_flags = null;
        this.system_flags = flags.system_flags;
        Hashtable hashtable = flags.user_flags;
        if (hashtable != null) {
            this.user_flags = (Hashtable) hashtable.clone();
        }
    }

    public boolean contains(Flags flags) {
        int i = flags.system_flags;
        if ((this.system_flags & i) != i) {
            return false;
        }
        Hashtable hashtable = flags.user_flags;
        if (hashtable != null) {
            if (this.user_flags == null) {
                return false;
            }
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                if (!this.user_flags.containsKey(keys.nextElement())) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public void remove(Flags flags) {
        this.system_flags &= flags.system_flags ^ (-1);
        Hashtable hashtable = flags.user_flags;
        if (hashtable == null || this.user_flags == null) {
            return;
        }
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            this.user_flags.remove(keys.nextElement());
        }
    }

    public void add(Flags flags) {
        this.system_flags |= flags.system_flags;
        if (flags.user_flags != null) {
            if (this.user_flags == null) {
                this.user_flags = new Hashtable(1);
            }
            Enumeration keys = flags.user_flags.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                this.user_flags.put(str, flags.user_flags.get(str));
            }
        }
    }

    public Flags(Flag flag) {
        this.system_flags = 0;
        this.user_flags = null;
        this.system_flags = flag.bit | 0;
    }

    public Flags(String str) {
        this.system_flags = 0;
        this.user_flags = null;
        Hashtable hashtable = new Hashtable(1);
        this.user_flags = hashtable;
        hashtable.put(str.toLowerCase(Locale.ENGLISH), str);
    }
}

package io.netty.handler.codec.http2.internal.hpack;

import io.netty.util.internal.ObjectUtil;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
class HeaderField {
    static final int HEADER_ENTRY_OVERHEAD = 32;
    final CharSequence name;
    final CharSequence value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HeaderField(CharSequence charSequence, CharSequence charSequence2) {
        this.name = (CharSequence) ObjectUtil.checkNotNull(charSequence, "name");
        this.value = (CharSequence) ObjectUtil.checkNotNull(charSequence2, "value");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int sizeOf(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence.length() + charSequence2.length() + 32;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HeaderField) {
            HeaderField headerField = (HeaderField) obj;
            return (HpackUtil.equalsConstantTime(this.value, headerField.value) & HpackUtil.equalsConstantTime(this.name, headerField.name)) != 0;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int size() {
        return this.name.length() + this.value.length() + 32;
    }

    public String toString() {
        return ((Object) this.name) + ": " + ((Object) this.value);
    }
}

package io.netty.util.internal;

import java.util.Arrays;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class AppendableCharSequence implements CharSequence, Appendable {
    private char[] chars;
    private int pos;

    public AppendableCharSequence(int i) {
        if (i >= 1) {
            this.chars = new char[i];
            return;
        }
        throw new IllegalArgumentException("length: " + i + " (length: >= 1)");
    }

    private void expand() {
        char[] cArr = this.chars;
        int length = cArr.length << 1;
        if (length >= 0) {
            char[] cArr2 = new char[length];
            this.chars = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        if (i <= this.pos) {
            return this.chars[i];
        }
        throw new IndexOutOfBoundsException();
    }

    public char charAtUnsafe(int i) {
        return this.chars[i];
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.pos;
    }

    public void reset() {
        this.pos = 0;
    }

    public String subStringUnsafe(int i, int i2) {
        return new String(this.chars, i, i2 - i);
    }

    public String substring(int i, int i2) {
        int i3 = i2 - i;
        int i4 = this.pos;
        if (i <= i4 && i3 <= i4) {
            return new String(this.chars, i, i3);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.chars, 0, this.pos);
    }

    @Override // java.lang.CharSequence
    public AppendableCharSequence subSequence(int i, int i2) {
        return new AppendableCharSequence(Arrays.copyOfRange(this.chars, i, i2));
    }

    private AppendableCharSequence(char[] cArr) {
        if (cArr.length >= 1) {
            this.chars = cArr;
            this.pos = cArr.length;
            return;
        }
        throw new IllegalArgumentException("length: " + cArr.length + " (length: >= 1)");
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(char c) {
        try {
            char[] cArr = this.chars;
            int i = this.pos;
            this.pos = i + 1;
            cArr[i] = c;
        } catch (IndexOutOfBoundsException unused) {
            expand();
            this.chars[this.pos - 1] = c;
        }
        return this;
    }

    private static char[] expand(char[] cArr, int i, int i2) {
        int length = cArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i > length);
        char[] cArr2 = new char[length];
        System.arraycopy(cArr, 0, cArr2, 0, i2);
        return cArr2;
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence charSequence) {
        return append(charSequence, 0, charSequence.length());
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence charSequence, int i, int i2) {
        if (charSequence.length() >= i2) {
            int i3 = i2 - i;
            char[] cArr = this.chars;
            int length = cArr.length;
            int i4 = this.pos;
            if (i3 > length - i4) {
                this.chars = expand(cArr, i4 + i3, i4);
            }
            if (charSequence instanceof AppendableCharSequence) {
                System.arraycopy(((AppendableCharSequence) charSequence).chars, i, this.chars, this.pos, i3);
                this.pos += i3;
                return this;
            }
            while (i < i2) {
                char[] cArr2 = this.chars;
                int i5 = this.pos;
                this.pos = i5 + 1;
                cArr2[i5] = charSequence.charAt(i);
                i++;
            }
            return this;
        }
        throw new IndexOutOfBoundsException();
    }
}

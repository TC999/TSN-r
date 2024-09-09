package io.netty.util.internal;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class AppendableCharSequence implements CharSequence, Appendable {
    private char[] chars;
    private int pos;

    public AppendableCharSequence(int i4) {
        if (i4 >= 1) {
            this.chars = new char[i4];
            return;
        }
        throw new IllegalArgumentException("length: " + i4 + " (length: >= 1)");
    }

    private static char[] expand(char[] cArr, int i4, int i5) {
        int length = cArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i4 > length);
        char[] cArr2 = new char[length];
        System.arraycopy(cArr, 0, cArr2, 0, i5);
        return cArr2;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i4) {
        if (i4 <= this.pos) {
            return this.chars[i4];
        }
        throw new IndexOutOfBoundsException();
    }

    public char charAtUnsafe(int i4) {
        return this.chars[i4];
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.pos;
    }

    public void reset() {
        this.pos = 0;
    }

    public String subStringUnsafe(int i4, int i5) {
        return new String(this.chars, i4, i5 - i4);
    }

    public String substring(int i4, int i5) {
        int i6 = i5 - i4;
        int i7 = this.pos;
        if (i4 <= i7 && i6 <= i7) {
            return new String(this.chars, i4, i6);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.chars, 0, this.pos);
    }

    @Override // java.lang.CharSequence
    public AppendableCharSequence subSequence(int i4, int i5) {
        if (i4 == i5) {
            return new AppendableCharSequence(Math.min(16, this.chars.length));
        }
        return new AppendableCharSequence(Arrays.copyOfRange(this.chars, i4, i5));
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
    public AppendableCharSequence append(char c4) {
        int i4 = this.pos;
        char[] cArr = this.chars;
        if (i4 == cArr.length) {
            char[] cArr2 = new char[cArr.length << 1];
            this.chars = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
        }
        char[] cArr3 = this.chars;
        int i5 = this.pos;
        this.pos = i5 + 1;
        cArr3[i5] = c4;
        return this;
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence charSequence) {
        return append(charSequence, 0, charSequence.length());
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence charSequence, int i4, int i5) {
        if (charSequence.length() >= i5) {
            int i6 = i5 - i4;
            char[] cArr = this.chars;
            int length = cArr.length;
            int i7 = this.pos;
            if (i6 > length - i7) {
                this.chars = expand(cArr, i7 + i6, i7);
            }
            if (charSequence instanceof AppendableCharSequence) {
                System.arraycopy(((AppendableCharSequence) charSequence).chars, i4, this.chars, this.pos, i6);
                this.pos += i6;
                return this;
            }
            while (i4 < i5) {
                char[] cArr2 = this.chars;
                int i8 = this.pos;
                this.pos = i8 + 1;
                cArr2[i8] = charSequence.charAt(i4);
                i4++;
            }
            return this;
        }
        throw new IndexOutOfBoundsException();
    }
}

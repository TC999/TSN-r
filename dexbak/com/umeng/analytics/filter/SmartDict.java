package com.umeng.analytics.filter;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.UByte;

/* renamed from: com.umeng.analytics.filter.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SmartDict {

    /* renamed from: b */
    private static final String f37588b = "Ă";

    /* renamed from: c */
    private MessageDigest f37590c;

    /* renamed from: e */
    private boolean f37592e;

    /* renamed from: a */
    private final String f37589a = "MD5";

    /* renamed from: d */
    private Set<Object> f37591d = new HashSet();

    public SmartDict(boolean z, String str) {
        this.f37592e = z;
        try {
            this.f37590c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (str != null) {
            int i = 0;
            if (z) {
                try {
                    byte[] decode = Base64.decode(str.getBytes(), 0);
                    while (i < decode.length / 4) {
                        int i2 = i * 4;
                        this.f37591d.add(Integer.valueOf(((decode[i2 + 0] & UByte.f41242c) << 24) + ((decode[i2 + 1] & UByte.f41242c) << 16) + ((decode[i2 + 2] & UByte.f41242c) << 8) + (decode[i2 + 3] & UByte.f41242c)));
                        i++;
                    }
                    return;
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            String[] split = str.split(f37588b);
            int length = split.length;
            while (i < length) {
                this.f37591d.add(split[i]);
                i++;
            }
        }
    }

    /* renamed from: c */
    private Integer m14770c(String str) {
        try {
            this.f37590c.update(str.getBytes());
            byte[] digest = this.f37590c.digest();
            return Integer.valueOf(((digest[0] & UByte.f41242c) << 24) + ((digest[1] & UByte.f41242c) << 16) + ((digest[2] & UByte.f41242c) << 8) + (digest[3] & UByte.f41242c));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public boolean m14772a(String str) {
        if (this.f37592e) {
            return this.f37591d.contains(m14770c(str));
        }
        return this.f37591d.contains(str);
    }

    /* renamed from: b */
    public void m14771b(String str) {
        if (this.f37592e) {
            this.f37591d.add(m14770c(str));
        } else {
            this.f37591d.add(str);
        }
    }

    public String toString() {
        if (this.f37592e) {
            byte[] bArr = new byte[this.f37591d.size() * 4];
            Iterator<Object> it = this.f37591d.iterator();
            int i = 0;
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                int i2 = i + 1;
                bArr[i] = (byte) (((-16777216) & intValue) >> 24);
                int i3 = i2 + 1;
                bArr[i2] = (byte) ((16711680 & intValue) >> 16);
                int i4 = i3 + 1;
                bArr[i3] = (byte) ((65280 & intValue) >> 8);
                i = i4 + 1;
                bArr[i4] = (byte) (intValue & 255);
            }
            return new String(Base64.encode(bArr, 0));
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.f37591d) {
            if (sb.length() > 0) {
                sb.append(f37588b);
            }
            sb.append(obj.toString());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void m14773a() {
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.f37591d) {
            sb.append(obj);
            if (sb.length() > 0) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }
}

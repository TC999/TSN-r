package com.umeng.analytics.filter;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: SmartDict.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private static final String f52482b = "\u0102";

    /* renamed from: c  reason: collision with root package name */
    private MessageDigest f52484c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f52486e;

    /* renamed from: a  reason: collision with root package name */
    private final String f52483a = "MD5";

    /* renamed from: d  reason: collision with root package name */
    private Set<Object> f52485d = new HashSet();

    public d(boolean z3, String str) {
        this.f52486e = z3;
        try {
            this.f52484c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
        }
        if (str != null) {
            int i4 = 0;
            if (z3) {
                try {
                    byte[] decode = Base64.decode(str.getBytes(), 0);
                    while (i4 < decode.length / 4) {
                        int i5 = i4 * 4;
                        this.f52485d.add(Integer.valueOf(((decode[i5 + 0] & 255) << 24) + ((decode[i5 + 1] & 255) << 16) + ((decode[i5 + 2] & 255) << 8) + (decode[i5 + 3] & 255)));
                        i4++;
                    }
                    return;
                } catch (IllegalArgumentException e5) {
                    e5.printStackTrace();
                    return;
                }
            }
            String[] split = str.split("\u0102");
            int length = split.length;
            while (i4 < length) {
                this.f52485d.add(split[i4]);
                i4++;
            }
        }
    }

    private Integer c(String str) {
        try {
            this.f52484c.update(str.getBytes());
            byte[] digest = this.f52484c.digest();
            return Integer.valueOf(((digest[0] & 255) << 24) + ((digest[1] & 255) << 16) + ((digest[2] & 255) << 8) + (digest[3] & 255));
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public boolean a(String str) {
        if (this.f52486e) {
            return this.f52485d.contains(c(str));
        }
        return this.f52485d.contains(str);
    }

    public void b(String str) {
        if (this.f52486e) {
            this.f52485d.add(c(str));
        } else {
            this.f52485d.add(str);
        }
    }

    public String toString() {
        if (this.f52486e) {
            byte[] bArr = new byte[this.f52485d.size() * 4];
            Iterator<Object> it = this.f52485d.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                int i5 = i4 + 1;
                bArr[i4] = (byte) (((-16777216) & intValue) >> 24);
                int i6 = i5 + 1;
                bArr[i5] = (byte) ((16711680 & intValue) >> 16);
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((65280 & intValue) >> 8);
                i4 = i7 + 1;
                bArr[i7] = (byte) (intValue & 255);
            }
            return new String(Base64.encode(bArr, 0));
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.f52485d) {
            if (sb.length() > 0) {
                sb.append("\u0102");
            }
            sb.append(obj.toString());
        }
        return sb.toString();
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.f52485d) {
            sb.append(obj);
            if (sb.length() > 0) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }
}

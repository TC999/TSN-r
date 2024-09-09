package xyz.adscope.common.network.simple.cache;

import java.io.Serializable;
import xyz.adscope.common.network.Headers;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class Cache implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f65018a;

    /* renamed from: b  reason: collision with root package name */
    public int f65019b;

    /* renamed from: c  reason: collision with root package name */
    public Headers f65020c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f65021d;

    /* renamed from: e  reason: collision with root package name */
    public long f65022e;

    public byte[] getBody() {
        return this.f65021d;
    }

    public int getCode() {
        return this.f65019b;
    }

    public long getExpires() {
        return this.f65022e;
    }

    public Headers getHeaders() {
        return this.f65020c;
    }

    public String getKey() {
        return this.f65018a;
    }

    public void setBody(byte[] bArr) {
        this.f65021d = bArr;
    }

    public void setCode(int i4) {
        this.f65019b = i4;
    }

    public void setExpires(long j4) {
        this.f65022e = j4;
    }

    public void setHeaders(Headers headers) {
        this.f65020c = headers;
    }

    public void setKey(String str) {
        this.f65018a = str;
    }
}

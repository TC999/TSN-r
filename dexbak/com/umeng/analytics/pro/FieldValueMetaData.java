package com.umeng.analytics.pro;

import java.io.Serializable;

/* renamed from: com.umeng.analytics.pro.ce */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FieldValueMetaData implements Serializable {

    /* renamed from: a */
    private final boolean f37971a;

    /* renamed from: b */
    public final byte f37972b;

    /* renamed from: c */
    private final String f37973c;

    /* renamed from: d */
    private final boolean f37974d;

    public FieldValueMetaData(byte b, boolean z) {
        this.f37972b = b;
        this.f37971a = false;
        this.f37973c = null;
        this.f37974d = z;
    }

    /* renamed from: a */
    public boolean m14473a() {
        return this.f37971a;
    }

    /* renamed from: b */
    public String m14472b() {
        return this.f37973c;
    }

    /* renamed from: c */
    public boolean m14471c() {
        return this.f37972b == 12;
    }

    /* renamed from: d */
    public boolean m14470d() {
        byte b = this.f37972b;
        return b == 15 || b == 13 || b == 14;
    }

    /* renamed from: e */
    public boolean m14469e() {
        return this.f37974d;
    }

    public FieldValueMetaData(byte b) {
        this(b, false);
    }

    public FieldValueMetaData(byte b, String str) {
        this.f37972b = b;
        this.f37971a = true;
        this.f37973c = str;
        this.f37974d = false;
    }
}

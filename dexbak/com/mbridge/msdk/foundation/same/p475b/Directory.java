package com.mbridge.msdk.foundation.same.p475b;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.mbridge.msdk.foundation.same.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class Directory {

    /* renamed from: a */
    private MBridgeDir f30624a;

    /* renamed from: b */
    private String f30625b;

    /* renamed from: c */
    private Directory f30626c;

    /* renamed from: d */
    private List<Directory> f30627d;

    /* renamed from: a */
    public final MBridgeDir m22364a() {
        return this.f30624a;
    }

    /* renamed from: b */
    public final String m22358b() {
        return this.f30625b;
    }

    /* renamed from: c */
    public final Directory m22357c() {
        return this.f30626c;
    }

    /* renamed from: d */
    public final List<Directory> m22356d() {
        return this.f30627d;
    }

    /* renamed from: a */
    public final void m22362a(MBridgeDir mBridgeDir) {
        this.f30624a = mBridgeDir;
    }

    /* renamed from: a */
    public final void m22360a(String str) {
        this.f30625b = str;
    }

    /* renamed from: a */
    private void m22363a(Directory directory) {
        if (this.f30627d == null) {
            this.f30627d = new ArrayList();
        }
        directory.f30626c = this;
        this.f30627d.add(directory);
    }

    /* renamed from: a */
    public final void m22361a(MBridgeDir mBridgeDir, String str) {
        Directory directory = new Directory();
        directory.f30624a = mBridgeDir;
        directory.f30625b = str;
        m22363a(directory);
    }

    /* renamed from: a */
    public final void m22359a(List<Directory> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (Directory directory : list) {
            m22363a(directory);
        }
    }
}

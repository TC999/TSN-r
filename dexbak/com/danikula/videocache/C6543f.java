package com.danikula.videocache;

import com.danikula.videocache.file.InterfaceC6544a;
import com.danikula.videocache.file.InterfaceC6546c;
import com.danikula.videocache.sourcestorage.InterfaceC6576c;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Config.java */
/* renamed from: com.danikula.videocache.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6543f {

    /* renamed from: a */
    public final File f23065a;

    /* renamed from: b */
    public final InterfaceC6546c f23066b;

    /* renamed from: c */
    public final InterfaceC6544a f23067c;

    /* renamed from: d */
    public final InterfaceC6576c f23068d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6543f(File file, InterfaceC6546c interfaceC6546c, InterfaceC6544a interfaceC6544a, InterfaceC6576c interfaceC6576c) {
        this.f23065a = file;
        this.f23066b = interfaceC6546c;
        this.f23067c = interfaceC6544a;
        this.f23068d = interfaceC6576c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public File m35943a(String str) {
        return new File(this.f23065a, this.f23066b.generate(str));
    }
}

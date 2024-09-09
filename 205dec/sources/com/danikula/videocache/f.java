package com.danikula.videocache;

import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: Config.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final File f36732a;

    /* renamed from: b  reason: collision with root package name */
    public final com.danikula.videocache.file.c f36733b;

    /* renamed from: c  reason: collision with root package name */
    public final com.danikula.videocache.file.a f36734c;

    /* renamed from: d  reason: collision with root package name */
    public final com.danikula.videocache.sourcestorage.c f36735d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(File file, com.danikula.videocache.file.c cVar, com.danikula.videocache.file.a aVar, com.danikula.videocache.sourcestorage.c cVar2) {
        this.f36732a = file;
        this.f36733b = cVar;
        this.f36734c = aVar;
        this.f36735d = cVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a(String str) {
        return new File(this.f36732a, this.f36733b.generate(str));
    }
}

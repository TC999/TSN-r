package com.beizi.ad.internal.b;

import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Config.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final File f13685a;

    /* renamed from: b  reason: collision with root package name */
    public final com.beizi.ad.internal.b.a.c f13686b;

    /* renamed from: c  reason: collision with root package name */
    public final com.beizi.ad.internal.b.a.a f13687c;

    /* renamed from: d  reason: collision with root package name */
    public final com.beizi.ad.internal.b.b.c f13688d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(File file, com.beizi.ad.internal.b.a.c cVar, com.beizi.ad.internal.b.a.a aVar, com.beizi.ad.internal.b.b.c cVar2) {
        this.f13685a = file;
        this.f13686b = cVar;
        this.f13687c = aVar;
        this.f13688d = cVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a(String str) {
        return new File(this.f13685a, this.f13686b.a(str));
    }
}

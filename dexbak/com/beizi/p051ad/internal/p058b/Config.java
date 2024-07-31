package com.beizi.p051ad.internal.p058b;

import com.beizi.p051ad.internal.p058b.p059a.DiskUsage;
import com.beizi.p051ad.internal.p058b.p059a.FileNameGenerator;
import com.beizi.p051ad.internal.p058b.p060b.SourceInfoStorage;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.beizi.ad.internal.b.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Config {

    /* renamed from: a */
    public final File f10008a;

    /* renamed from: b */
    public final FileNameGenerator f10009b;

    /* renamed from: c */
    public final DiskUsage f10010c;

    /* renamed from: d */
    public final SourceInfoStorage f10011d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Config(File file, FileNameGenerator fileNameGenerator, DiskUsage diskUsage, SourceInfoStorage sourceInfoStorage) {
        this.f10008a = file;
        this.f10009b = fileNameGenerator;
        this.f10010c = diskUsage;
        this.f10011d = sourceInfoStorage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public File m49621a(String str) {
        return new File(this.f10008a, this.f10009b.mo49631a(str));
    }
}

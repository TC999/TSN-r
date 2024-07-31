package com.p521ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import com.p521ss.android.socialbase.downloader.constants.EnumC12414kf;
import com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.p521ss.android.socialbase.downloader.depend.IDownloadListener;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12471sg;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v;
import com.p521ss.android.socialbase.downloader.model.C12598a;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.downloader.z */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12522z {
    /* renamed from: a */
    DownloadInfo mo17464a(String str, String str2);

    /* renamed from: a */
    List<DownloadInfo> mo17465a(String str);

    /* renamed from: a */
    void mo17470a(int i, int i2, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z);

    /* renamed from: a */
    void mo17469a(int i, List<C12598a> list);

    /* renamed from: a */
    void mo17468a(int i, boolean z);

    /* renamed from: a */
    void mo17467a(DownloadInfo downloadInfo);

    /* renamed from: a */
    void mo17466a(DownloadTask downloadTask);

    /* renamed from: a */
    void mo17463a(List<String> list);

    /* renamed from: a */
    boolean mo17472a();

    /* renamed from: a */
    boolean mo17471a(int i);

    /* renamed from: bl */
    List<DownloadInfo> mo17458bl(String str);

    /* renamed from: bl */
    void mo17461bl(int i);

    /* renamed from: bl */
    void mo17460bl(int i, boolean z);

    /* renamed from: bl */
    boolean mo17462bl();

    /* renamed from: bl */
    boolean mo17459bl(DownloadInfo downloadInfo);

    /* renamed from: h */
    boolean mo17457h();

    /* renamed from: h */
    boolean mo17456h(int i);

    /* renamed from: i */
    boolean mo17455i(int i);

    /* renamed from: j */
    boolean mo17454j(int i);

    /* renamed from: k */
    void mo17453k(int i);

    /* renamed from: kf */
    int mo17451kf(int i);

    /* renamed from: kf */
    void mo17452kf();

    /* renamed from: n */
    long mo17449n(int i);

    /* renamed from: n */
    List<DownloadInfo> mo17448n(String str);

    /* renamed from: n */
    boolean mo17450n();

    /* renamed from: ok */
    int mo17428ok(String str, String str2);

    /* renamed from: ok */
    List<DownloadInfo> mo17429ok(String str);

    /* renamed from: ok */
    void mo17447ok();

    /* renamed from: ok */
    void mo17446ok(int i);

    /* renamed from: ok */
    void mo17445ok(int i, int i2);

    /* renamed from: ok */
    void mo17444ok(int i, int i2, int i3, int i4);

    /* renamed from: ok */
    void mo17443ok(int i, int i2, int i3, long j);

    /* renamed from: ok */
    void mo17442ok(int i, int i2, long j);

    /* renamed from: ok */
    void mo17441ok(int i, int i2, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z);

    /* renamed from: ok */
    void mo17440ok(int i, int i2, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z, boolean z2);

    /* renamed from: ok */
    void mo17439ok(int i, long j);

    /* renamed from: ok */
    void mo17438ok(int i, Notification notification);

    /* renamed from: ok */
    void mo17437ok(int i, InterfaceC12427ep interfaceC12427ep);

    /* renamed from: ok */
    void mo17436ok(int i, List<C12598a> list);

    /* renamed from: ok */
    void mo17435ok(int i, boolean z);

    /* renamed from: ok */
    void mo17433ok(InterfaceC12471sg interfaceC12471sg);

    /* renamed from: ok */
    void mo17431ok(DownloadTask downloadTask);

    /* renamed from: ok */
    void mo17430ok(C12598a c12598a);

    /* renamed from: ok */
    void mo17427ok(List<String> list);

    /* renamed from: ok */
    void mo17426ok(boolean z, boolean z2);

    /* renamed from: ok */
    boolean mo17432ok(DownloadInfo downloadInfo);

    /* renamed from: p */
    DownloadInfo mo17424p(int i);

    /* renamed from: q */
    List<C12598a> mo17423q(int i);

    /* renamed from: r */
    void mo17422r(int i);

    /* renamed from: rh */
    boolean mo17421rh(int i);

    /* renamed from: s */
    List<DownloadInfo> mo17420s();

    /* renamed from: s */
    List<DownloadInfo> mo17418s(String str);

    /* renamed from: s */
    void mo17419s(int i);

    void startService();

    /* renamed from: t */
    void mo17417t(int i);

    /* renamed from: td */
    InterfaceC12480v mo17416td(int i);

    /* renamed from: x */
    InterfaceC12427ep mo17415x(int i);

    /* renamed from: z */
    int mo17414z(int i);

    /* renamed from: zz */
    IDownloadFileUriProvider mo17413zz(int i);
}

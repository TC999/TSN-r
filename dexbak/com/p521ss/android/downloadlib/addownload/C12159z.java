package com.p521ss.android.downloadlib.addownload;

import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.activity.TTDelegateActivity;
import com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12111bl;
import com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12120s;
import com.p521ss.android.downloadlib.addownload.p532s.InterfaceC12155p;
import com.p521ss.android.downloadlib.p534h.C12201n;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.impls.C12565td;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.z */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12159z {

    /* renamed from: a */
    private static InterfaceC12111bl f34395a;

    /* renamed from: ok */
    private static InterfaceC12120s f34396ok;

    /* renamed from: a */
    public static InterfaceC12111bl m18877a() {
        return f34395a;
    }

    /* renamed from: ok */
    public static InterfaceC12120s m18876ok() {
        return f34396ok;
    }

    /* renamed from: ok */
    public static boolean m18875ok(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    /* renamed from: ok */
    public static void m18872ok(InterfaceC12120s interfaceC12120s) {
        f34396ok = interfaceC12120s;
    }

    /* renamed from: ok */
    public static void m18873ok(InterfaceC12111bl interfaceC12111bl) {
        f34395a = interfaceC12111bl;
    }

    /* renamed from: ok */
    public static boolean m18874ok(final C11998a c11998a, DownloadInfo downloadInfo, int i, final InterfaceC12155p interfaceC12155p, final boolean z, final InterfaceC12111bl interfaceC12111bl) {
        boolean m18750a;
        if (c11998a == null) {
            C12235bl.m18640ok().m18639ok("tryReverseWifi nativeModel null");
            return false;
        } else if (downloadInfo == null) {
            C12235bl.m18640ok().m18639ok("tryReverseWifi info null");
            return false;
        } else {
            final int id = downloadInfo.getId();
            if (z) {
                m18750a = C12201n.m18745bl(c11998a);
            } else {
                m18750a = C12201n.m18750a(c11998a);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("switch_status", Integer.valueOf(m18750a ? 1 : 0));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (z) {
                C12270ok.m18539ok().m18521ok("cancel_pause_reserve_wifi_switch_status", jSONObject, c11998a);
            } else {
                C12270ok.m18539ok().m18521ok("pause_reserve_wifi_switch_status", jSONObject, c11998a);
            }
            if (m18750a && m18875ok(i) && !C12713kf.m16620a(C12128r.getContext())) {
                if (z || !downloadInfo.hasPauseReservedOnWifi()) {
                    m18872ok(new InterfaceC12120s() { // from class: com.ss.android.downloadlib.addownload.z.1
                        @Override // com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12120s
                        /* renamed from: a */
                        public void mo18871a() {
                            C12159z.m18872ok((InterfaceC12120s) null);
                            DownloadInfo downloadInfo2 = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(id);
                            if (downloadInfo2 != null) {
                                downloadInfo2.stopPauseReserveOnWifi();
                            }
                            if (z) {
                                C12270ok.m18539ok().m18526ok("cancel_pause_reserve_wifi_cancel", c11998a);
                            } else {
                                C12270ok.m18539ok().m18541a("pause_reserve_wifi_cancel", c11998a);
                            }
                            interfaceC12155p.mo18883ok(c11998a);
                        }

                        @Override // com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12120s
                        /* renamed from: ok */
                        public void mo18870ok() {
                            C12159z.m18872ok((InterfaceC12120s) null);
                            DownloadInfo downloadInfo2 = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(id);
                            if (downloadInfo2 != null) {
                                downloadInfo2.startPauseReserveOnWifi();
                                C12565td.m17403ok().m17393ok(downloadInfo2);
                                if (z) {
                                    C12270ok.m18539ok().m18526ok("cancel_pause_reserve_wifi_confirm", c11998a);
                                } else {
                                    C12270ok.m18539ok().m18541a("pause_reserve_wifi_confirm", c11998a);
                                }
                            }
                            interfaceC12155p.mo18883ok(c11998a);
                        }
                    });
                    if (z && interfaceC12111bl != null) {
                        m18873ok(new InterfaceC12111bl() { // from class: com.ss.android.downloadlib.addownload.z.2
                            @Override // com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12111bl
                            public void delete() {
                                C12270ok.m18539ok().m18526ok("cancel_pause_reserve_wifi_delete", C11998a.this);
                                interfaceC12111bl.delete();
                            }
                        });
                    }
                    if (z) {
                        TTDelegateActivity.m19353ok(c11998a, "删除");
                    } else {
                        TTDelegateActivity.m19369a(c11998a);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }
}

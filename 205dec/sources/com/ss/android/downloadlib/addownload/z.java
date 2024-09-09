package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.td;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.ok.bl f48742a;
    private static com.ss.android.downloadlib.addownload.ok.s ok;

    public static com.ss.android.downloadlib.addownload.ok.bl a() {
        return f48742a;
    }

    public static com.ss.android.downloadlib.addownload.ok.s ok() {
        return ok;
    }

    public static boolean ok(int i4) {
        return i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4 || i4 == 5 || i4 == 7 || i4 == 8;
    }

    public static void ok(com.ss.android.downloadlib.addownload.ok.s sVar) {
        ok = sVar;
    }

    public static void ok(com.ss.android.downloadlib.addownload.ok.bl blVar) {
        f48742a = blVar;
    }

    public static boolean ok(final com.ss.android.downloadad.api.ok.a aVar, DownloadInfo downloadInfo, int i4, final com.ss.android.downloadlib.addownload.s.p pVar, final boolean z3, final com.ss.android.downloadlib.addownload.ok.bl blVar) {
        boolean a4;
        if (aVar == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("tryReverseWifi nativeModel null");
            return false;
        } else if (downloadInfo == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("tryReverseWifi info null");
            return false;
        } else {
            final int id = downloadInfo.getId();
            if (z3) {
                a4 = com.ss.android.downloadlib.h.n.bl(aVar);
            } else {
                a4 = com.ss.android.downloadlib.h.n.a(aVar);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("switch_status", Integer.valueOf(a4 ? 1 : 0));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (z3) {
                com.ss.android.downloadlib.s.ok.ok().ok("cancel_pause_reserve_wifi_switch_status", jSONObject, aVar);
            } else {
                com.ss.android.downloadlib.s.ok.ok().ok("pause_reserve_wifi_switch_status", jSONObject, aVar);
            }
            if (a4 && ok(i4) && !com.ss.android.socialbase.downloader.q.kf.a(r.getContext())) {
                if (z3 || !downloadInfo.hasPauseReservedOnWifi()) {
                    ok(new com.ss.android.downloadlib.addownload.ok.s() { // from class: com.ss.android.downloadlib.addownload.z.1
                        @Override // com.ss.android.downloadlib.addownload.ok.s
                        public void a() {
                            z.ok((com.ss.android.downloadlib.addownload.ok.s) null);
                            DownloadInfo downloadInfo2 = Downloader.getInstance(r.getContext()).getDownloadInfo(id);
                            if (downloadInfo2 != null) {
                                downloadInfo2.stopPauseReserveOnWifi();
                            }
                            if (z3) {
                                com.ss.android.downloadlib.s.ok.ok().ok("cancel_pause_reserve_wifi_cancel", aVar);
                            } else {
                                com.ss.android.downloadlib.s.ok.ok().a("pause_reserve_wifi_cancel", aVar);
                            }
                            pVar.ok(aVar);
                        }

                        @Override // com.ss.android.downloadlib.addownload.ok.s
                        public void ok() {
                            z.ok((com.ss.android.downloadlib.addownload.ok.s) null);
                            DownloadInfo downloadInfo2 = Downloader.getInstance(r.getContext()).getDownloadInfo(id);
                            if (downloadInfo2 != null) {
                                downloadInfo2.startPauseReserveOnWifi();
                                td.ok().ok(downloadInfo2);
                                if (z3) {
                                    com.ss.android.downloadlib.s.ok.ok().ok("cancel_pause_reserve_wifi_confirm", aVar);
                                } else {
                                    com.ss.android.downloadlib.s.ok.ok().a("pause_reserve_wifi_confirm", aVar);
                                }
                            }
                            pVar.ok(aVar);
                        }
                    });
                    if (z3 && blVar != null) {
                        ok(new com.ss.android.downloadlib.addownload.ok.bl() { // from class: com.ss.android.downloadlib.addownload.z.2
                            @Override // com.ss.android.downloadlib.addownload.ok.bl
                            public void delete() {
                                com.ss.android.downloadlib.s.ok.ok().ok("cancel_pause_reserve_wifi_delete", com.ss.android.downloadad.api.ok.a.this);
                                blVar.delete();
                            }
                        });
                    }
                    if (z3) {
                        TTDelegateActivity.ok(aVar, "\u5220\u9664");
                    } else {
                        TTDelegateActivity.a(aVar);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }
}

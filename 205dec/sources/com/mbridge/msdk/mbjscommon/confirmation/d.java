package com.mbridge.msdk.mbjscommon.confirmation;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.r;
import com.mbridge.msdk.mbdownload.manager.ADownloadManager;
import com.mbridge.msdk.out.IDownloadListener;
import com.mbridge.msdk.widget.custom.baseview.MBButton;
import java.lang.reflect.InvocationTargetException;

/* compiled from: NativeProgressController.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    MBButton f40226a;

    /* renamed from: b  reason: collision with root package name */
    private int f40227b;

    /* renamed from: c  reason: collision with root package name */
    private int f40228c;

    /* renamed from: d  reason: collision with root package name */
    private int f40229d;

    /* renamed from: e  reason: collision with root package name */
    private String f40230e;

    /* renamed from: f  reason: collision with root package name */
    private String f40231f;

    /* renamed from: g  reason: collision with root package name */
    private int f40232g;

    /* renamed from: h  reason: collision with root package name */
    private int f40233h;

    /* renamed from: i  reason: collision with root package name */
    private IDownloadListener f40234i;

    public d(MBButton mBButton) {
        this.f40226a = mBButton;
        c();
    }

    private void c(final int i4) {
        this.f40227b = i4;
        if (this.f40233h == 1 || i4 == 0) {
            this.f40226a.post(new Runnable() { // from class: com.mbridge.msdk.mbjscommon.confirmation.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    int i5 = i4;
                    if (i5 == 1) {
                        d.b(d.this);
                    } else if (i5 == 2) {
                        MBButton mBButton = d.this.f40226a;
                        if (mBButton != null) {
                            mBButton.setText(r.a(mBButton.getContext(), "mbridge_cm_progress_status_descri_pause", "string"));
                        }
                    } else if (i5 == 3) {
                        d dVar = d.this;
                        MBButton mBButton2 = dVar.f40226a;
                        if (mBButton2 != null) {
                            mBButton2.setProgress(100);
                            try {
                                Context context = dVar.f40226a.getContext();
                                dVar.f40226a.setText(context.getResources().getString(r.a(context, "mbridge_cm_progress_status_descri_ins", "string")));
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    } else if (i5 != 4) {
                        d.a(d.this);
                    } else {
                        d dVar2 = d.this;
                        MBButton mBButton3 = dVar2.f40226a;
                        if (mBButton3 != null) {
                            mBButton3.setProgress(100);
                            try {
                                Context context2 = dVar2.f40226a.getContext();
                                dVar2.f40226a.setText(context2.getResources().getString(r.a(context2, "mbridge_cm_progress_status_descri_open", "string")));
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i4) {
        if (i4 == -1) {
            this.f40227b = 0;
        } else if (i4 == 9) {
            this.f40227b = 4;
        } else if (i4 == 1) {
            this.f40227b = 3;
        } else if (i4 == 2) {
            this.f40227b = 1;
        } else if (i4 == 3) {
            this.f40227b = 0;
        } else if (i4 == 5 || i4 == 6) {
            this.f40227b = 2;
        }
        c(this.f40227b);
    }

    public final void a(int i4) {
        this.f40229d = i4;
        if (this.f40228c == 2) {
            c(1);
        }
    }

    public final void b(int i4) {
        this.f40232g = i4;
    }

    public final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("1".equals(ai.a(str, "ctaldtype"))) {
            this.f40233h = 1;
            if (!TextUtils.isEmpty(this.f40231f)) {
                this.f40226a.setProgress(50);
            }
            if (this.f40234i == null) {
                this.f40234i = new IDownloadListener() { // from class: com.mbridge.msdk.mbjscommon.confirmation.d.3
                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onEnd(int i4, int i5, String str2) {
                    }

                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onProgressUpdate(int i4) {
                        d.this.a(i4);
                    }

                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onStart() {
                    }

                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onStatus(int i4) {
                        if (d.this.f40228c != i4) {
                            d.this.f40228c = i4;
                            d.this.d(i4);
                        }
                    }
                };
            }
            if (TextUtils.isEmpty(this.f40231f)) {
                return;
            }
            try {
                ADownloadManager.class.getMethod("addDownloadListener", String.class, IDownloadListener.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f40231f, this.f40234i);
                return;
            } catch (ClassNotFoundException e4) {
                e4.printStackTrace();
                return;
            } catch (IllegalAccessException e5) {
                e5.printStackTrace();
                return;
            } catch (NoSuchMethodException e6) {
                e6.printStackTrace();
                return;
            } catch (InvocationTargetException e7) {
                e7.printStackTrace();
                return;
            }
        }
        this.f40233h = 0;
    }

    private void c() {
        d(d());
    }

    public final void a(String str) {
        this.f40231f = str;
        c();
    }

    public final void a() {
        if (this.f40232g == 3) {
            c();
            if (this.f40227b != 2 || TextUtils.isEmpty(this.f40231f)) {
                return;
            }
            try {
                String b4 = com.mbridge.msdk.foundation.db.e.a(i.a(this.f40226a.getContext())).b(this.f40231f);
                ADownloadManager.class.getMethod(CampaignEx.JSON_NATIVE_VIDEO_START, String.class, String.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f40231f, b4);
            } catch (ClassNotFoundException e4) {
                e4.printStackTrace();
            } catch (IllegalAccessException e5) {
                e5.printStackTrace();
            } catch (NoSuchMethodException e6) {
                e6.printStackTrace();
            } catch (InvocationTargetException e7) {
                e7.printStackTrace();
            }
        }
    }

    private int d() {
        if (!TextUtils.isEmpty(this.f40231f)) {
            try {
                return ((Integer) ADownloadManager.class.getMethod("getTaskStatusByUniqueKey", String.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f40231f)).intValue();
            } catch (ClassNotFoundException e4) {
                e4.printStackTrace();
            } catch (IllegalAccessException e5) {
                e5.printStackTrace();
            } catch (NoSuchMethodException e6) {
                e6.printStackTrace();
            } catch (InvocationTargetException e7) {
                e7.printStackTrace();
            }
        }
        return -1;
    }

    public final void b() {
        if (TextUtils.isEmpty(this.f40231f)) {
            return;
        }
        try {
            ADownloadManager.class.getMethod("deleteDownloadListener", String.class, IDownloadListener.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f40231f, this.f40234i);
            this.f40234i = null;
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
        } catch (NoSuchMethodException e6) {
            e6.printStackTrace();
        } catch (InvocationTargetException e7) {
            e7.printStackTrace();
        }
    }

    static /* synthetic */ void a(d dVar) {
        if (dVar.f40226a != null) {
            if (TextUtils.isEmpty(dVar.f40230e)) {
                MBButton mBButton = dVar.f40226a;
                mBButton.setText(r.a(mBButton.getContext(), "mbridge_cm_progress_status_descri_default", "string"));
                return;
            }
            dVar.f40226a.setText(dVar.f40230e);
        }
    }

    static /* synthetic */ void b(d dVar) {
        MBButton mBButton = dVar.f40226a;
        if (mBButton != null) {
            mBButton.setIndeterminateProgressMode(false);
            dVar.f40226a.post(new Runnable() { // from class: com.mbridge.msdk.mbjscommon.confirmation.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d dVar2 = d.this;
                    dVar2.f40226a.setProgress(dVar2.f40229d);
                }
            });
            if (dVar.f40229d == 100) {
                try {
                    Context context = dVar.f40226a.getContext();
                    dVar.f40226a.setText(context.getResources().getString(r.a(context, "mbridge_cm_progress_status_descri_ins", "string")));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }
}

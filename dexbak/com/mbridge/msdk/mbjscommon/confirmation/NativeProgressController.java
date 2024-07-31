package com.mbridge.msdk.mbjscommon.confirmation;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p472db.CampaignDAIDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.tools.ResourceUtil;
import com.mbridge.msdk.foundation.tools.UriUtil;
import com.mbridge.msdk.mbdownload.manager.ADownloadManager;
import com.mbridge.msdk.out.IDownloadListener;
import com.mbridge.msdk.widget.custom.baseview.MBButton;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.mbridge.msdk.mbjscommon.confirmation.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class NativeProgressController {

    /* renamed from: a */
    MBButton f31454a;

    /* renamed from: b */
    private int f31455b;

    /* renamed from: c */
    private int f31456c;

    /* renamed from: d */
    private int f31457d;

    /* renamed from: e */
    private String f31458e;

    /* renamed from: f */
    private String f31459f;

    /* renamed from: g */
    private int f31460g;

    /* renamed from: h */
    private int f31461h;

    /* renamed from: i */
    private IDownloadListener f31462i;

    public NativeProgressController(MBButton mBButton) {
        this.f31454a = mBButton;
        m21480c();
    }

    /* renamed from: c */
    private void m21479c(final int i) {
        this.f31455b = i;
        if (this.f31461h == 1 || i == 0) {
            this.f31454a.post(new Runnable() { // from class: com.mbridge.msdk.mbjscommon.confirmation.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = i;
                    if (i2 == 1) {
                        NativeProgressController.m21483b(NativeProgressController.this);
                    } else if (i2 == 2) {
                        MBButton mBButton = NativeProgressController.this.f31454a;
                        if (mBButton != null) {
                            mBButton.setText(ResourceUtil.m21814a(mBButton.getContext(), "mbridge_cm_progress_status_descri_pause", "string"));
                        }
                    } else if (i2 == 3) {
                        NativeProgressController nativeProgressController = NativeProgressController.this;
                        MBButton mBButton2 = nativeProgressController.f31454a;
                        if (mBButton2 != null) {
                            mBButton2.setProgress(100);
                            try {
                                Context context = nativeProgressController.f31454a.getContext();
                                nativeProgressController.f31454a.setText(context.getResources().getString(ResourceUtil.m21814a(context, "mbridge_cm_progress_status_descri_ins", "string")));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (i2 != 4) {
                        NativeProgressController.m21488a(NativeProgressController.this);
                    } else {
                        NativeProgressController nativeProgressController2 = NativeProgressController.this;
                        MBButton mBButton3 = nativeProgressController2.f31454a;
                        if (mBButton3 != null) {
                            mBButton3.setProgress(100);
                            try {
                                Context context2 = nativeProgressController2.f31454a.getContext();
                                nativeProgressController2.f31454a.setText(context2.getResources().getString(ResourceUtil.m21814a(context2, "mbridge_cm_progress_status_descri_open", "string")));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m21476d(int i) {
        if (i == -1) {
            this.f31455b = 0;
        } else if (i == 9) {
            this.f31455b = 4;
        } else if (i == 1) {
            this.f31455b = 3;
        } else if (i == 2) {
            this.f31455b = 1;
        } else if (i == 3) {
            this.f31455b = 0;
        } else if (i == 5 || i == 6) {
            this.f31455b = 2;
        }
        m21479c(this.f31455b);
    }

    /* renamed from: a */
    public final void m21489a(int i) {
        this.f31457d = i;
        if (this.f31456c == 2) {
            m21479c(1);
        }
    }

    /* renamed from: b */
    public final void m21484b(int i) {
        this.f31460g = i;
    }

    /* renamed from: b */
    public final void m21481b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("1".equals(UriUtil.m21949a(str, "ctaldtype"))) {
            this.f31461h = 1;
            if (!TextUtils.isEmpty(this.f31459f)) {
                this.f31454a.setProgress(50);
            }
            if (this.f31462i == null) {
                this.f31462i = new IDownloadListener() { // from class: com.mbridge.msdk.mbjscommon.confirmation.d.3
                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onEnd(int i, int i2, String str2) {
                    }

                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onProgressUpdate(int i) {
                        NativeProgressController.this.m21489a(i);
                    }

                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onStart() {
                    }

                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onStatus(int i) {
                        if (NativeProgressController.this.f31456c != i) {
                            NativeProgressController.this.f31456c = i;
                            NativeProgressController.this.m21476d(i);
                        }
                    }
                };
            }
            if (TextUtils.isEmpty(this.f31459f)) {
                return;
            }
            try {
                ADownloadManager.class.getMethod("addDownloadListener", String.class, IDownloadListener.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f31459f, this.f31462i);
                return;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return;
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
                return;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return;
            }
        }
        this.f31461h = 0;
    }

    /* renamed from: c */
    private void m21480c() {
        m21476d(m21477d());
    }

    /* renamed from: a */
    public final void m21486a(String str) {
        this.f31459f = str;
        m21480c();
    }

    /* renamed from: a */
    public final void m21490a() {
        if (this.f31460g == 3) {
            m21480c();
            if (this.f31455b != 2 || TextUtils.isEmpty(this.f31459f)) {
                return;
            }
            try {
                String m22784b = CampaignDAIDao.m22789a(CommonSDKDBHelper.m22721a(this.f31454a.getContext())).m22784b(this.f31459f);
                ADownloadManager.class.getMethod(CampaignEx.JSON_NATIVE_VIDEO_START, String.class, String.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f31459f, m22784b);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    private int m21477d() {
        if (!TextUtils.isEmpty(this.f31459f)) {
            try {
                return ((Integer) ADownloadManager.class.getMethod("getTaskStatusByUniqueKey", String.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f31459f)).intValue();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        return -1;
    }

    /* renamed from: b */
    public final void m21485b() {
        if (TextUtils.isEmpty(this.f31459f)) {
            return;
        }
        try {
            ADownloadManager.class.getMethod("deleteDownloadListener", String.class, IDownloadListener.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f31459f, this.f31462i);
            this.f31462i = null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m21488a(NativeProgressController nativeProgressController) {
        if (nativeProgressController.f31454a != null) {
            if (TextUtils.isEmpty(nativeProgressController.f31458e)) {
                MBButton mBButton = nativeProgressController.f31454a;
                mBButton.setText(ResourceUtil.m21814a(mBButton.getContext(), "mbridge_cm_progress_status_descri_default", "string"));
                return;
            }
            nativeProgressController.f31454a.setText(nativeProgressController.f31458e);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m21483b(NativeProgressController nativeProgressController) {
        MBButton mBButton = nativeProgressController.f31454a;
        if (mBButton != null) {
            mBButton.setIndeterminateProgressMode(false);
            nativeProgressController.f31454a.post(new Runnable() { // from class: com.mbridge.msdk.mbjscommon.confirmation.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    NativeProgressController nativeProgressController2 = NativeProgressController.this;
                    nativeProgressController2.f31454a.setProgress(nativeProgressController2.f31457d);
                }
            });
            if (nativeProgressController.f31457d == 100) {
                try {
                    Context context = nativeProgressController.f31454a.getContext();
                    nativeProgressController.f31454a.setText(context.getResources().getString(ResourceUtil.m21814a(context, "mbridge_cm_progress_status_descri_ins", "string")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

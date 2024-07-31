package com.mbridge.msdk.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p472db.CampaignDAIDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.tools.ResourceUtil;
import com.mbridge.msdk.foundation.tools.UriUtil;
import com.mbridge.msdk.mbdownload.manager.ADownloadManager;
import com.mbridge.msdk.out.IDownloadListener;
import java.lang.reflect.InvocationTargetException;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBDownloadProgressBar extends RelativeLayout {
    public static final int PROGRESS_STATUS_DEFAULT = 0;
    public static final int PROGRESS_STATUS_DOING = 1;
    public static final int PROGRESS_STATUS_INT = 3;
    public static final int PROGRESS_STATUS_OPEN = 4;
    public static final int PROGRESS_STATUS_PAUSE = 2;

    /* renamed from: a */
    private int f32365a;

    /* renamed from: b */
    private int f32366b;

    /* renamed from: c */
    private int f32367c;

    /* renamed from: d */
    private ProgressBar f32368d;

    /* renamed from: e */
    private ImageView f32369e;

    /* renamed from: f */
    private TextView f32370f;

    /* renamed from: g */
    private String f32371g;

    /* renamed from: h */
    private String f32372h;

    /* renamed from: i */
    private int f32373i;

    /* renamed from: j */
    private int f32374j;

    /* renamed from: k */
    private IDownloadListener f32375k;

    public MBDownloadProgressBar(Context context) {
        this(context, null);
    }

    /* renamed from: c */
    private void m20627c() {
        if (TextUtils.isEmpty(this.f32372h)) {
            return;
        }
        try {
            String m22784b = CampaignDAIDao.m22789a(CommonSDKDBHelper.m22721a(getContext())).m22784b(this.f32372h);
            ADownloadManager.class.getMethod(CampaignEx.JSON_NATIVE_VIDEO_START, String.class, String.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f32372h, m22784b);
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

    /* renamed from: d */
    private int m20625d() {
        if (!TextUtils.isEmpty(this.f32372h)) {
            try {
                return ((Integer) ADownloadManager.class.getMethod("getTaskStatusByUniqueKey", String.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f32372h)).intValue();
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

    /* renamed from: e */
    private void m20623e() {
        if (this.f32375k == null) {
            this.f32375k = new IDownloadListener() { // from class: com.mbridge.msdk.widget.MBDownloadProgressBar.2
                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onEnd(int i, int i2, String str) {
                }

                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onProgressUpdate(int i) {
                    MBDownloadProgressBar.this.setProgress(i);
                }

                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onStart() {
                }

                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onStatus(int i) {
                    if (MBDownloadProgressBar.this.f32366b != i) {
                        MBDownloadProgressBar.this.f32366b = i;
                        MBDownloadProgressBar.this.m20630b(i);
                    }
                }
            };
            m20621f();
        }
    }

    public boolean NotProgressBarInterceptedClick() {
        if (this.f32373i == 3) {
            m20631b();
            if (this.f32365a == 2) {
                m20627c();
            }
        }
        return true;
    }

    public int getmStatus() {
        return this.f32365a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f32365a == 0 || this.f32374j != 1) {
            return;
        }
        m20623e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (TextUtils.isEmpty(this.f32372h)) {
            return;
        }
        try {
            ADownloadManager.class.getMethod("deleteDownloadListener", String.class, IDownloadListener.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f32372h, this.f32375k);
            this.f32375k = null;
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

    @Override // android.view.View
    public boolean performClick() {
        if (this.f32373i == 3) {
            m20623e();
            m20631b();
            if (this.f32365a == 2) {
                m20627c();
            }
        }
        return super.performClick();
    }

    public void setCtaldtypeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("1".equals(UriUtil.m21949a(str, "ctaldtype"))) {
            this.f32374j = 1;
            m20623e();
            return;
        }
        this.f32374j = 0;
    }

    public void setLinkType(int i) {
        this.f32373i = i;
    }

    public void setProgress(int i) {
        this.f32367c = i;
        if (this.f32366b == 2) {
            m20634a(1);
        }
    }

    public void setText(String str) {
        this.f32371g = str;
        m20635a();
    }

    public void setTextSize(float f) {
        this.f32370f.setTextSize(f);
    }

    public void setUniqueKey(String str) {
        this.f32372h = str;
        m20631b();
    }

    public MBDownloadProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: b */
    private void m20631b() {
        m20630b(m20625d());
    }

    /* renamed from: f */
    private void m20621f() {
        if (TextUtils.isEmpty(this.f32372h)) {
            return;
        }
        try {
            ADownloadManager.class.getMethod("addDownloadListener", String.class, IDownloadListener.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f32372h, this.f32375k);
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

    public MBDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(ResourceUtil.m21814a(context, "mbridge_same_download_progress_bar_layout", "layout"), (ViewGroup) null);
        addView(viewGroup);
        this.f32368d = (ProgressBar) viewGroup.findViewById(ResourceUtil.m21814a(context, "mbridge_same_download_mbprogress_progress", "id"));
        this.f32369e = (ImageView) viewGroup.findViewById(ResourceUtil.m21814a(context, "mbridge_same_download_mbprogress_status_icon", "id"));
        this.f32370f = (TextView) viewGroup.findViewById(ResourceUtil.m21814a(context, "mbridge_same_download_mbprogress_status_desc", "id"));
        m20631b();
    }

    /* renamed from: a */
    private void m20634a(final int i) {
        this.f32365a = i;
        if (this.f32374j == 1 || i == 0) {
            post(new Runnable() { // from class: com.mbridge.msdk.widget.MBDownloadProgressBar.1
                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = i;
                    if (i2 == 1) {
                        MBDownloadProgressBar.m20629b(MBDownloadProgressBar.this);
                    } else if (i2 == 2) {
                        MBDownloadProgressBar.m20626c(MBDownloadProgressBar.this);
                    } else if (i2 == 3) {
                        MBDownloadProgressBar.m20624d(MBDownloadProgressBar.this);
                    } else if (i2 != 4) {
                        MBDownloadProgressBar.this.m20635a();
                    } else {
                        MBDownloadProgressBar.m20622e(MBDownloadProgressBar.this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m20630b(int i) {
        if (i == -1) {
            this.f32365a = 0;
        } else if (i == 9) {
            this.f32365a = 4;
        } else if (i == 1) {
            this.f32365a = 3;
        } else if (i == 2) {
            this.f32365a = 1;
        } else if (i == 3) {
            this.f32365a = 0;
        } else if (i == 5 || i == 6) {
            this.f32365a = 2;
        }
        m20634a(this.f32365a);
    }

    /* renamed from: e */
    static /* synthetic */ void m20622e(MBDownloadProgressBar mBDownloadProgressBar) {
        ImageView imageView = mBDownloadProgressBar.f32369e;
        if (imageView != null && imageView.getVisibility() != 8) {
            mBDownloadProgressBar.f32369e.setVisibility(8);
        }
        ProgressBar progressBar = mBDownloadProgressBar.f32368d;
        if (progressBar != null) {
            progressBar.setProgress(100);
        }
        TextView textView = mBDownloadProgressBar.f32370f;
        if (textView != null) {
            textView.setText(ResourceUtil.m21814a(mBDownloadProgressBar.getContext(), "mbridge_cm_progress_status_descri_open", "string"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m20635a() {
        ImageView imageView = this.f32369e;
        if (imageView != null && imageView.getVisibility() != 8) {
            this.f32369e.setVisibility(8);
        }
        ProgressBar progressBar = this.f32368d;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        if (this.f32370f != null) {
            if (TextUtils.isEmpty(this.f32371g)) {
                this.f32370f.setText(ResourceUtil.m21814a(getContext(), "mbridge_cm_progress_status_descri_default", "string"));
            } else {
                this.f32370f.setText(this.f32371g);
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m20629b(MBDownloadProgressBar mBDownloadProgressBar) {
        ImageView imageView = mBDownloadProgressBar.f32369e;
        if (imageView != null && imageView.getVisibility() != 0) {
            mBDownloadProgressBar.f32369e.setVisibility(0);
        }
        ProgressBar progressBar = mBDownloadProgressBar.f32368d;
        if (progressBar != null) {
            progressBar.setProgress(mBDownloadProgressBar.f32367c);
        }
        TextView textView = mBDownloadProgressBar.f32370f;
        if (textView != null) {
            textView.setText(mBDownloadProgressBar.f32367c + "%");
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m20624d(MBDownloadProgressBar mBDownloadProgressBar) {
        ImageView imageView = mBDownloadProgressBar.f32369e;
        if (imageView != null && imageView.getVisibility() != 8) {
            mBDownloadProgressBar.f32369e.setVisibility(8);
        }
        ProgressBar progressBar = mBDownloadProgressBar.f32368d;
        if (progressBar != null) {
            progressBar.setProgress(100);
        }
        TextView textView = mBDownloadProgressBar.f32370f;
        if (textView != null) {
            textView.setText(ResourceUtil.m21814a(mBDownloadProgressBar.getContext(), "mbridge_cm_progress_status_descri_ins", "string"));
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m20626c(MBDownloadProgressBar mBDownloadProgressBar) {
        ImageView imageView = mBDownloadProgressBar.f32369e;
        if (imageView != null && imageView.getVisibility() != 0) {
            mBDownloadProgressBar.f32369e.setVisibility(0);
        }
        TextView textView = mBDownloadProgressBar.f32370f;
        if (textView != null) {
            textView.setText(ResourceUtil.m21814a(mBDownloadProgressBar.getContext(), "mbridge_cm_progress_status_descri_pause", "string"));
        }
    }
}

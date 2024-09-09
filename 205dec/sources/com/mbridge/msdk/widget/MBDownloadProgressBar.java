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
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.r;
import com.mbridge.msdk.mbdownload.manager.ADownloadManager;
import com.mbridge.msdk.out.IDownloadListener;
import java.lang.reflect.InvocationTargetException;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBDownloadProgressBar extends RelativeLayout {
    public static final int PROGRESS_STATUS_DEFAULT = 0;
    public static final int PROGRESS_STATUS_DOING = 1;
    public static final int PROGRESS_STATUS_INT = 3;
    public static final int PROGRESS_STATUS_OPEN = 4;
    public static final int PROGRESS_STATUS_PAUSE = 2;

    /* renamed from: a  reason: collision with root package name */
    private int f41076a;

    /* renamed from: b  reason: collision with root package name */
    private int f41077b;

    /* renamed from: c  reason: collision with root package name */
    private int f41078c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f41079d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f41080e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f41081f;

    /* renamed from: g  reason: collision with root package name */
    private String f41082g;

    /* renamed from: h  reason: collision with root package name */
    private String f41083h;

    /* renamed from: i  reason: collision with root package name */
    private int f41084i;

    /* renamed from: j  reason: collision with root package name */
    private int f41085j;

    /* renamed from: k  reason: collision with root package name */
    private IDownloadListener f41086k;

    public MBDownloadProgressBar(Context context) {
        this(context, null);
    }

    private void c() {
        if (TextUtils.isEmpty(this.f41083h)) {
            return;
        }
        try {
            String b4 = e.a(i.a(getContext())).b(this.f41083h);
            ADownloadManager.class.getMethod(CampaignEx.JSON_NATIVE_VIDEO_START, String.class, String.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f41083h, b4);
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

    private int d() {
        if (!TextUtils.isEmpty(this.f41083h)) {
            try {
                return ((Integer) ADownloadManager.class.getMethod("getTaskStatusByUniqueKey", String.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f41083h)).intValue();
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

    private void e() {
        if (this.f41086k == null) {
            this.f41086k = new IDownloadListener() { // from class: com.mbridge.msdk.widget.MBDownloadProgressBar.2
                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onEnd(int i4, int i5, String str) {
                }

                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onProgressUpdate(int i4) {
                    MBDownloadProgressBar.this.setProgress(i4);
                }

                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onStart() {
                }

                @Override // com.mbridge.msdk.out.IDownloadListener
                public final void onStatus(int i4) {
                    if (MBDownloadProgressBar.this.f41077b != i4) {
                        MBDownloadProgressBar.this.f41077b = i4;
                        MBDownloadProgressBar.this.b(i4);
                    }
                }
            };
            f();
        }
    }

    public boolean NotProgressBarInterceptedClick() {
        if (this.f41084i == 3) {
            b();
            if (this.f41076a == 2) {
                c();
            }
        }
        return true;
    }

    public int getmStatus() {
        return this.f41076a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f41076a == 0 || this.f41085j != 1) {
            return;
        }
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (TextUtils.isEmpty(this.f41083h)) {
            return;
        }
        try {
            ADownloadManager.class.getMethod("deleteDownloadListener", String.class, IDownloadListener.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f41083h, this.f41086k);
            this.f41086k = null;
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

    @Override // android.view.View
    public boolean performClick() {
        if (this.f41084i == 3) {
            e();
            b();
            if (this.f41076a == 2) {
                c();
            }
        }
        return super.performClick();
    }

    public void setCtaldtypeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("1".equals(ai.a(str, "ctaldtype"))) {
            this.f41085j = 1;
            e();
            return;
        }
        this.f41085j = 0;
    }

    public void setLinkType(int i4) {
        this.f41084i = i4;
    }

    public void setProgress(int i4) {
        this.f41078c = i4;
        if (this.f41077b == 2) {
            a(1);
        }
    }

    public void setText(String str) {
        this.f41082g = str;
        a();
    }

    public void setTextSize(float f4) {
        this.f41081f.setTextSize(f4);
    }

    public void setUniqueKey(String str) {
        this.f41083h = str;
        b();
    }

    public MBDownloadProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b() {
        b(d());
    }

    private void f() {
        if (TextUtils.isEmpty(this.f41083h)) {
            return;
        }
        try {
            ADownloadManager.class.getMethod("addDownloadListener", String.class, IDownloadListener.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), this.f41083h, this.f41086k);
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

    public MBDownloadProgressBar(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(r.a(context, "mbridge_same_download_progress_bar_layout", "layout"), (ViewGroup) null);
        addView(viewGroup);
        this.f41079d = (ProgressBar) viewGroup.findViewById(r.a(context, "mbridge_same_download_mbprogress_progress", "id"));
        this.f41080e = (ImageView) viewGroup.findViewById(r.a(context, "mbridge_same_download_mbprogress_status_icon", "id"));
        this.f41081f = (TextView) viewGroup.findViewById(r.a(context, "mbridge_same_download_mbprogress_status_desc", "id"));
        b();
    }

    private void a(final int i4) {
        this.f41076a = i4;
        if (this.f41085j == 1 || i4 == 0) {
            post(new Runnable() { // from class: com.mbridge.msdk.widget.MBDownloadProgressBar.1
                @Override // java.lang.Runnable
                public final void run() {
                    int i5 = i4;
                    if (i5 == 1) {
                        MBDownloadProgressBar.b(MBDownloadProgressBar.this);
                    } else if (i5 == 2) {
                        MBDownloadProgressBar.c(MBDownloadProgressBar.this);
                    } else if (i5 == 3) {
                        MBDownloadProgressBar.d(MBDownloadProgressBar.this);
                    } else if (i5 != 4) {
                        MBDownloadProgressBar.this.a();
                    } else {
                        MBDownloadProgressBar.e(MBDownloadProgressBar.this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i4) {
        if (i4 == -1) {
            this.f41076a = 0;
        } else if (i4 == 9) {
            this.f41076a = 4;
        } else if (i4 == 1) {
            this.f41076a = 3;
        } else if (i4 == 2) {
            this.f41076a = 1;
        } else if (i4 == 3) {
            this.f41076a = 0;
        } else if (i4 == 5 || i4 == 6) {
            this.f41076a = 2;
        }
        a(this.f41076a);
    }

    static /* synthetic */ void e(MBDownloadProgressBar mBDownloadProgressBar) {
        ImageView imageView = mBDownloadProgressBar.f41080e;
        if (imageView != null && imageView.getVisibility() != 8) {
            mBDownloadProgressBar.f41080e.setVisibility(8);
        }
        ProgressBar progressBar = mBDownloadProgressBar.f41079d;
        if (progressBar != null) {
            progressBar.setProgress(100);
        }
        TextView textView = mBDownloadProgressBar.f41081f;
        if (textView != null) {
            textView.setText(r.a(mBDownloadProgressBar.getContext(), "mbridge_cm_progress_status_descri_open", "string"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ImageView imageView = this.f41080e;
        if (imageView != null && imageView.getVisibility() != 8) {
            this.f41080e.setVisibility(8);
        }
        ProgressBar progressBar = this.f41079d;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        if (this.f41081f != null) {
            if (TextUtils.isEmpty(this.f41082g)) {
                this.f41081f.setText(r.a(getContext(), "mbridge_cm_progress_status_descri_default", "string"));
            } else {
                this.f41081f.setText(this.f41082g);
            }
        }
    }

    static /* synthetic */ void b(MBDownloadProgressBar mBDownloadProgressBar) {
        ImageView imageView = mBDownloadProgressBar.f41080e;
        if (imageView != null && imageView.getVisibility() != 0) {
            mBDownloadProgressBar.f41080e.setVisibility(0);
        }
        ProgressBar progressBar = mBDownloadProgressBar.f41079d;
        if (progressBar != null) {
            progressBar.setProgress(mBDownloadProgressBar.f41078c);
        }
        TextView textView = mBDownloadProgressBar.f41081f;
        if (textView != null) {
            textView.setText(mBDownloadProgressBar.f41078c + "%");
        }
    }

    static /* synthetic */ void d(MBDownloadProgressBar mBDownloadProgressBar) {
        ImageView imageView = mBDownloadProgressBar.f41080e;
        if (imageView != null && imageView.getVisibility() != 8) {
            mBDownloadProgressBar.f41080e.setVisibility(8);
        }
        ProgressBar progressBar = mBDownloadProgressBar.f41079d;
        if (progressBar != null) {
            progressBar.setProgress(100);
        }
        TextView textView = mBDownloadProgressBar.f41081f;
        if (textView != null) {
            textView.setText(r.a(mBDownloadProgressBar.getContext(), "mbridge_cm_progress_status_descri_ins", "string"));
        }
    }

    static /* synthetic */ void c(MBDownloadProgressBar mBDownloadProgressBar) {
        ImageView imageView = mBDownloadProgressBar.f41080e;
        if (imageView != null && imageView.getVisibility() != 0) {
            mBDownloadProgressBar.f41080e.setVisibility(0);
        }
        TextView textView = mBDownloadProgressBar.f41081f;
        if (textView != null) {
            textView.setText(r.a(mBDownloadProgressBar.getContext(), "mbridge_cm_progress_status_descri_pause", "string"));
        }
    }
}

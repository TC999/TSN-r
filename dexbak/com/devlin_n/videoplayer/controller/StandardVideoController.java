package com.devlin_n.videoplayer.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.view.GravityCompat;
import com.devlin_n.videoplayer.C6596R;
import com.devlin_n.videoplayer.controller.BaseVideoController;
import p601i0.C13583a;
import p601i0.C13584f;
import p601i0.L;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class StandardVideoController extends BaseVideoController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    /* renamed from: A */
    protected SeekBar f23272A;

    /* renamed from: B */
    protected ImageView f23273B;

    /* renamed from: C */
    protected ImageView f23274C;

    /* renamed from: D */
    protected ImageView f23275D;

    /* renamed from: E */
    protected TextView f23276E;

    /* renamed from: F */
    private boolean f23277F;

    /* renamed from: G */
    private boolean f23278G;

    /* renamed from: H */
    private View f23279H;

    /* renamed from: I */
    private ProgressBar f23280I;

    /* renamed from: J */
    private ImageView f23281J;

    /* renamed from: K */
    private ImageView f23282K;

    /* renamed from: L */
    private ProgressBar f23283L;

    /* renamed from: M */
    private ImageView f23284M;

    /* renamed from: N */
    private LinearLayout f23285N;

    /* renamed from: O */
    private Animation f23286O;

    /* renamed from: P */
    private Animation f23287P;

    /* renamed from: Q */
    private PopupMenu f23288Q;

    /* renamed from: v */
    protected TextView f23289v;

    /* renamed from: w */
    protected TextView f23290w;

    /* renamed from: x */
    protected ImageView f23291x;

    /* renamed from: y */
    protected LinearLayout f23292y;

    /* renamed from: z */
    protected LinearLayout f23293z;

    /* renamed from: com.devlin_n.videoplayer.controller.StandardVideoController$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6613a implements PopupMenu.OnMenuItemClickListener {
        C6613a() {
        }

        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == C6596R.C6599id.scale_default) {
                StandardVideoController.this.f23198b.mo35714e(0);
            } else if (itemId == C6596R.C6599id.scale_original) {
                StandardVideoController.this.f23198b.mo35714e(4);
            } else if (itemId == C6596R.C6599id.scale_match) {
                StandardVideoController.this.f23198b.mo35714e(3);
            } else if (itemId == C6596R.C6599id.scale_16_9) {
                StandardVideoController.this.f23198b.mo35714e(1);
            } else if (itemId == C6596R.C6599id.scale_4_3) {
                StandardVideoController.this.f23198b.mo35714e(2);
            }
            StandardVideoController.this.f23288Q.dismiss();
            return false;
        }
    }

    /* renamed from: com.devlin_n.videoplayer.controller.StandardVideoController$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC6614b implements Runnable {
        RunnableC6614b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StandardVideoController.this.setLayoutParams(new FrameLayout.LayoutParams(C13583a.f40163b, C13583a.f40162a));
        }
    }

    /* renamed from: com.devlin_n.videoplayer.controller.StandardVideoController$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnTouchListenerC6615c implements View.OnTouchListener {
        View$OnTouchListenerC6615c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public StandardVideoController(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: m */
    private void m35755m() {
        if (this.f23202f) {
            this.f23202f = false;
            this.f23199c = false;
            this.f23207k = true;
            mo35758g();
            this.f23275D.setSelected(false);
            Toast.makeText(getContext(), C6596R.C6602string.unlocked, 0).show();
        } else {
            mo35761d();
            this.f23202f = true;
            this.f23207k = false;
            this.f23275D.setSelected(true);
            Toast.makeText(getContext(), C6596R.C6602string.locked, 0).show();
        }
        this.f23198b.setLock(this.f23202f);
    }

    /* renamed from: n */
    private void m35754n() {
        this.f23293z.setVisibility(8);
        this.f23293z.startAnimation(this.f23287P);
        this.f23292y.setVisibility(8);
        this.f23292y.startAnimation(this.f23287P);
    }

    /* renamed from: o */
    private void m35753o(int i) {
        if (!this.f23199c) {
            if (this.f23198b.mo35720b()) {
                this.f23275D.setVisibility(0);
                if (!this.f23202f) {
                    m35752p();
                }
            } else {
                m35752p();
            }
            if (!this.f23202f && !this.f23277F) {
                this.f23280I.setVisibility(8);
                this.f23280I.startAnimation(this.f23287P);
            }
            this.f23199c = true;
        }
        removeCallbacks(this.f23213q);
        if (i != 0) {
            postDelayed(this.f23213q, i);
        }
    }

    /* renamed from: p */
    private void m35752p() {
        this.f23292y.setVisibility(0);
        this.f23292y.startAnimation(this.f23286O);
        this.f23293z.setVisibility(0);
        this.f23293z.startAnimation(this.f23286O);
        C13584f.m12697n(getContext());
        C13584f.m12698m(getContext());
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: d */
    public void mo35761d() {
        if (this.f23199c) {
            if (this.f23198b.mo35720b()) {
                this.f23275D.setVisibility(8);
                if (!this.f23202f) {
                    m35754n();
                    C13584f.m12701j(getContext());
                    C13584f.m12702i(getContext());
                }
            } else {
                m35754n();
            }
            if (!this.f23277F && !this.f23202f) {
                this.f23280I.setVisibility(0);
                this.f23280I.startAnimation(this.f23286O);
            }
            this.f23199c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: e */
    public void mo35760e() {
        super.mo35760e();
        ImageView imageView = (ImageView) this.f23197a.findViewById(C6596R.C6599id.more_menu);
        this.f23273B = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.f23197a.findViewById(C6596R.C6599id.fullscreen);
        this.f23291x = imageView2;
        imageView2.setOnClickListener(this);
        this.f23292y = (LinearLayout) this.f23197a.findViewById(C6596R.C6599id.bottom_container);
        this.f23293z = (LinearLayout) this.f23197a.findViewById(C6596R.C6599id.top_container);
        SeekBar seekBar = (SeekBar) this.f23197a.findViewById(C6596R.C6599id.seekBar);
        this.f23272A = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.f23289v = (TextView) this.f23197a.findViewById(C6596R.C6599id.total_time);
        this.f23290w = (TextView) this.f23197a.findViewById(C6596R.C6599id.curr_time);
        ImageView imageView3 = (ImageView) this.f23197a.findViewById(C6596R.C6599id.back);
        this.f23274C = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) this.f23197a.findViewById(C6596R.C6599id.lock);
        this.f23275D = imageView4;
        imageView4.setOnClickListener(this);
        ImageView imageView5 = (ImageView) this.f23197a.findViewById(C6596R.C6599id.thumb);
        this.f23284M = imageView5;
        imageView5.setOnClickListener(this);
        ImageView imageView6 = (ImageView) this.f23197a.findViewById(C6596R.C6599id.iv_play);
        this.f23281J = imageView6;
        imageView6.setOnClickListener(this);
        this.f23282K = (ImageView) this.f23197a.findViewById(C6596R.C6599id.start_play);
        this.f23283L = (ProgressBar) this.f23197a.findViewById(C6596R.C6599id.loading);
        this.f23280I = (ProgressBar) this.f23197a.findViewById(C6596R.C6599id.bottom_progress);
        ((ImageView) this.f23197a.findViewById(C6596R.C6599id.iv_replay)).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.f23197a.findViewById(C6596R.C6599id.complete_container);
        this.f23285N = linearLayout;
        linearLayout.setOnClickListener(this);
        this.f23276E = (TextView) this.f23197a.findViewById(C6596R.C6599id.title);
        View findViewById = this.f23197a.findViewById(C6596R.C6599id.status_holder);
        this.f23279H = findViewById;
        findViewById.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) C13584f.m12705f(getContext())));
        PopupMenu popupMenu = new PopupMenu(getContext(), this.f23273B, GravityCompat.END);
        this.f23288Q = popupMenu;
        popupMenu.getMenuInflater().inflate(C6596R.C6601menu.controller_menu, this.f23288Q.getMenu());
        this.f23288Q.setOnMenuItemClickListener(new C6613a());
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: f */
    protected int mo35759f() {
        BaseVideoController.InterfaceC6607d interfaceC6607d = this.f23198b;
        if (interfaceC6607d == null || this.f23278G) {
            return 0;
        }
        int currentPosition = interfaceC6607d.getCurrentPosition();
        int duration = this.f23198b.getDuration();
        SeekBar seekBar = this.f23272A;
        if (seekBar != null) {
            if (duration > 0) {
                seekBar.setEnabled(true);
                double d = currentPosition;
                Double.isNaN(d);
                double d2 = duration;
                Double.isNaN(d2);
                double d3 = (d * 1.0d) / d2;
                double max = this.f23272A.getMax();
                Double.isNaN(max);
                int i = (int) (d3 * max);
                this.f23272A.setProgress(i);
                this.f23280I.setProgress(i);
            } else {
                seekBar.setEnabled(false);
            }
            int bufferPercentage = this.f23198b.getBufferPercentage();
            if (bufferPercentage >= 95) {
                SeekBar seekBar2 = this.f23272A;
                seekBar2.setSecondaryProgress(seekBar2.getMax());
                ProgressBar progressBar = this.f23280I;
                progressBar.setSecondaryProgress(progressBar.getMax());
            } else {
                int i2 = bufferPercentage * 10;
                this.f23272A.setSecondaryProgress(i2);
                this.f23280I.setSecondaryProgress(i2);
            }
        }
        TextView textView = this.f23289v;
        if (textView != null) {
            textView.setText(m35775k(duration));
        }
        TextView textView2 = this.f23290w;
        if (textView2 != null) {
            textView2.setText(m35775k(currentPosition));
        }
        TextView textView3 = this.f23276E;
        if (textView3 != null) {
            textView3.setText(this.f23198b.getTitle());
        }
        return currentPosition;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: g */
    public void mo35758g() {
        m35753o(this.f23203g);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int getLayoutId() {
        return C6596R.C6600layout.layout_standard_controller;
    }

    public ImageView getThumb() {
        return this.f23284M;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: i */
    public void mo35757i(float f) {
        if (this.f23277F) {
            this.f23217u = false;
        } else {
            super.mo35757i(f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != C6596R.C6599id.fullscreen && id != C6596R.C6599id.back) {
            if (id == C6596R.C6599id.lock) {
                m35755m();
                return;
            } else if (id != C6596R.C6599id.iv_play && id != C6596R.C6599id.thumb && id != C6596R.C6599id.iv_replay) {
                if (id == C6596R.C6599id.more_menu) {
                    this.f23288Q.show();
                    mo35758g();
                    return;
                }
                return;
            } else {
                m35779b();
                return;
            }
        }
        m35778c();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            long duration = (this.f23198b.getDuration() * i) / this.f23272A.getMax();
            TextView textView = this.f23290w;
            if (textView != null) {
                textView.setText(m35775k((int) duration));
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.f23278G = true;
        removeCallbacks(this.f23212p);
        removeCallbacks(this.f23213q);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f23198b.seekTo((int) ((this.f23198b.getDuration() * seekBar.getProgress()) / this.f23272A.getMax()));
        this.f23278G = false;
        post(this.f23212p);
        mo35758g();
    }

    /* renamed from: q */
    public void m35751q() {
        this.f23276E.setVisibility(0);
    }

    public void setCanFast(boolean z) {
        this.f23272A.setOnTouchListener(new View$OnTouchListenerC6615c());
    }

    public void setLive(boolean z) {
        this.f23277F = z;
        this.f23280I.setVisibility(8);
        this.f23272A.setVisibility(4);
        this.f23289v.setVisibility(4);
        this.f23273B.setVisibility(0);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayState(int i) {
        super.setPlayState(i);
        switch (i) {
            case -1:
                L.m12717b("STATE_ERROR");
                return;
            case 0:
                L.m12717b("STATE_IDLE");
                mo35761d();
                this.f23202f = false;
                this.f23275D.setSelected(false);
                this.f23198b.setLock(false);
                this.f23285N.setVisibility(8);
                this.f23280I.setVisibility(8);
                this.f23283L.setVisibility(8);
                this.f23282K.setVisibility(0);
                this.f23284M.setVisibility(0);
                return;
            case 1:
                L.m12717b("STATE_PREPARING");
                this.f23285N.setVisibility(8);
                this.f23282K.setVisibility(8);
                this.f23283L.setVisibility(0);
                return;
            case 2:
                L.m12717b("STATE_PREPARED");
                if (!this.f23277F) {
                    this.f23280I.setVisibility(0);
                }
                this.f23283L.setVisibility(8);
                return;
            case 3:
                L.m12717b("STATE_PLAYING");
                post(this.f23212p);
                this.f23281J.setSelected(true);
                this.f23285N.setVisibility(8);
                this.f23284M.setVisibility(8);
                return;
            case 4:
                L.m12717b("STATE_PAUSED");
                this.f23281J.setSelected(false);
                return;
            case 5:
                L.m12717b("STATE_PLAYBACK_COMPLETED");
                mo35761d();
                this.f23284M.setVisibility(0);
                this.f23285N.setVisibility(0);
                this.f23280I.setProgress(0);
                this.f23280I.setSecondaryProgress(0);
                this.f23202f = false;
                this.f23198b.setLock(false);
                return;
            case 6:
                L.m12717b("STATE_BUFFERING");
                this.f23282K.setVisibility(8);
                this.f23283L.setVisibility(0);
                return;
            case 7:
                this.f23283L.setVisibility(8);
                L.m12717b("STATE_BUFFERED");
                return;
            default:
                return;
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayerState(int i) {
        if (i == 10) {
            L.m12717b("PLAYER_NORMAL");
            if (this.f23202f) {
                return;
            }
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f23207k = false;
            this.f23291x.setSelected(false);
            this.f23274C.setVisibility(8);
            this.f23275D.setVisibility(8);
            this.f23279H.setVisibility(8);
            this.f23276E.setVisibility(4);
        } else if (i != 11) {
        } else {
            L.m12717b("PLAYER_FULL_SCREEN");
            if (this.f23202f) {
                return;
            }
            postDelayed(new RunnableC6614b(), 300L);
            this.f23207k = true;
            this.f23291x.setSelected(true);
            this.f23279H.setVisibility(0);
            this.f23274C.setVisibility(0);
            this.f23276E.setVisibility(0);
            if (this.f23199c) {
                this.f23275D.setVisibility(0);
                C13584f.m12698m(getContext());
                C13584f.m12697n(getContext());
                return;
            }
            this.f23275D.setVisibility(8);
        }
    }

    public StandardVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StandardVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.f23286O = AnimationUtils.loadAnimation(getContext(), C6596R.anim.anim_alpha_in);
        this.f23287P = AnimationUtils.loadAnimation(getContext(), C6596R.anim.anim_alpha_out);
    }
}

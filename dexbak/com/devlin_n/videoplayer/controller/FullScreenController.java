package com.devlin_n.videoplayer.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import p601i0.C13584f;
import p601i0.L;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class FullScreenController extends BaseVideoController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    /* renamed from: A */
    protected ImageView f23228A;

    /* renamed from: B */
    protected ImageView f23229B;

    /* renamed from: C */
    protected ImageView f23230C;

    /* renamed from: D */
    protected TextView f23231D;

    /* renamed from: E */
    private boolean f23232E;

    /* renamed from: F */
    private boolean f23233F;

    /* renamed from: G */
    private ProgressBar f23234G;

    /* renamed from: H */
    private ImageView f23235H;

    /* renamed from: I */
    private ProgressBar f23236I;

    /* renamed from: J */
    private LinearLayout f23237J;

    /* renamed from: K */
    private Animation f23238K;

    /* renamed from: L */
    private Animation f23239L;

    /* renamed from: M */
    private PopupMenu f23240M;

    /* renamed from: v */
    protected TextView f23241v;

    /* renamed from: w */
    protected TextView f23242w;

    /* renamed from: x */
    protected LinearLayout f23243x;

    /* renamed from: y */
    protected LinearLayout f23244y;

    /* renamed from: z */
    protected SeekBar f23245z;

    /* renamed from: com.devlin_n.videoplayer.controller.FullScreenController$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6609a implements PopupMenu.OnMenuItemClickListener {
        C6609a() {
        }

        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == C6596R.C6599id.scale_default) {
                FullScreenController.this.f23198b.mo35714e(0);
            } else if (itemId == C6596R.C6599id.scale_original) {
                FullScreenController.this.f23198b.mo35714e(4);
            } else if (itemId == C6596R.C6599id.scale_match) {
                FullScreenController.this.f23198b.mo35714e(3);
            } else if (itemId == C6596R.C6599id.scale_16_9) {
                FullScreenController.this.f23198b.mo35714e(1);
            } else if (itemId == C6596R.C6599id.scale_4_3) {
                FullScreenController.this.f23198b.mo35714e(2);
            }
            FullScreenController.this.f23240M.dismiss();
            return false;
        }
    }

    public FullScreenController(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: m */
    private void m35772m() {
        if (this.f23202f) {
            this.f23202f = false;
            this.f23199c = false;
            this.f23207k = true;
            mo35758g();
            this.f23230C.setSelected(false);
            Toast.makeText(getContext(), C6596R.C6602string.unlocked, 0).show();
        } else {
            mo35761d();
            this.f23202f = true;
            this.f23207k = false;
            this.f23230C.setSelected(true);
            Toast.makeText(getContext(), C6596R.C6602string.locked, 0).show();
        }
        this.f23198b.setLock(this.f23202f);
    }

    /* renamed from: n */
    private void m35771n() {
        this.f23244y.setVisibility(8);
        this.f23244y.startAnimation(this.f23239L);
        this.f23243x.setVisibility(8);
        this.f23243x.startAnimation(this.f23239L);
    }

    /* renamed from: o */
    private void m35770o(int i) {
        if (!this.f23199c) {
            if (this.f23198b.mo35720b()) {
                this.f23230C.setVisibility(0);
                if (!this.f23202f) {
                    m35769p();
                }
            } else {
                m35769p();
            }
            if (!this.f23202f && !this.f23232E) {
                this.f23234G.setVisibility(8);
                this.f23234G.startAnimation(this.f23239L);
            }
            this.f23199c = true;
        }
        removeCallbacks(this.f23213q);
        if (i != 0) {
            postDelayed(this.f23213q, i);
        }
    }

    /* renamed from: p */
    private void m35769p() {
        this.f23243x.setVisibility(0);
        this.f23243x.startAnimation(this.f23238K);
        this.f23244y.setVisibility(0);
        this.f23244y.startAnimation(this.f23238K);
        C13584f.m12697n(getContext());
        C13584f.m12698m(getContext());
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: d */
    public void mo35761d() {
        if (this.f23199c) {
            if (this.f23198b.mo35720b()) {
                this.f23230C.setVisibility(8);
                if (!this.f23202f) {
                    m35771n();
                    C13584f.m12701j(getContext());
                    C13584f.m12702i(getContext());
                }
            } else {
                m35771n();
            }
            if (!this.f23232E && !this.f23202f) {
                this.f23234G.setVisibility(0);
                this.f23234G.startAnimation(this.f23238K);
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
        this.f23228A = imageView;
        imageView.setOnClickListener(this);
        this.f23243x = (LinearLayout) this.f23197a.findViewById(C6596R.C6599id.bottom_container);
        this.f23244y = (LinearLayout) this.f23197a.findViewById(C6596R.C6599id.top_container);
        SeekBar seekBar = (SeekBar) this.f23197a.findViewById(C6596R.C6599id.seekBar);
        this.f23245z = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.f23241v = (TextView) this.f23197a.findViewById(C6596R.C6599id.total_time);
        this.f23242w = (TextView) this.f23197a.findViewById(C6596R.C6599id.curr_time);
        ImageView imageView2 = (ImageView) this.f23197a.findViewById(C6596R.C6599id.back);
        this.f23229B = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) this.f23197a.findViewById(C6596R.C6599id.lock);
        this.f23230C = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) this.f23197a.findViewById(C6596R.C6599id.iv_play);
        this.f23235H = imageView4;
        imageView4.setOnClickListener(this);
        this.f23236I = (ProgressBar) this.f23197a.findViewById(C6596R.C6599id.loading);
        this.f23234G = (ProgressBar) this.f23197a.findViewById(C6596R.C6599id.bottom_progress);
        ((ImageView) this.f23197a.findViewById(C6596R.C6599id.iv_replay)).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.f23197a.findViewById(C6596R.C6599id.complete_container);
        this.f23237J = linearLayout;
        linearLayout.setOnClickListener(this);
        this.f23231D = (TextView) this.f23197a.findViewById(C6596R.C6599id.title);
        PopupMenu popupMenu = new PopupMenu(getContext(), this.f23228A, GravityCompat.END);
        this.f23240M = popupMenu;
        popupMenu.getMenuInflater().inflate(C6596R.C6601menu.controller_menu, this.f23240M.getMenu());
        this.f23240M.setOnMenuItemClickListener(new C6609a());
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: f */
    protected int mo35759f() {
        BaseVideoController.InterfaceC6607d interfaceC6607d = this.f23198b;
        if (interfaceC6607d == null || this.f23233F) {
            return 0;
        }
        int currentPosition = interfaceC6607d.getCurrentPosition();
        int duration = this.f23198b.getDuration();
        SeekBar seekBar = this.f23245z;
        if (seekBar != null) {
            if (duration > 0) {
                seekBar.setEnabled(true);
                double d = currentPosition;
                Double.isNaN(d);
                double d2 = duration;
                Double.isNaN(d2);
                double d3 = (d * 1.0d) / d2;
                double max = this.f23245z.getMax();
                Double.isNaN(max);
                int i = (int) (d3 * max);
                this.f23245z.setProgress(i);
                this.f23234G.setProgress(i);
            } else {
                seekBar.setEnabled(false);
            }
            int bufferPercentage = this.f23198b.getBufferPercentage();
            if (bufferPercentage >= 95) {
                SeekBar seekBar2 = this.f23245z;
                seekBar2.setSecondaryProgress(seekBar2.getMax());
                ProgressBar progressBar = this.f23234G;
                progressBar.setSecondaryProgress(progressBar.getMax());
            } else {
                int i2 = bufferPercentage * 10;
                this.f23245z.setSecondaryProgress(i2);
                this.f23234G.setSecondaryProgress(i2);
            }
        }
        TextView textView = this.f23241v;
        if (textView != null) {
            textView.setText(m35775k(duration));
        }
        TextView textView2 = this.f23242w;
        if (textView2 != null) {
            textView2.setText(m35775k(currentPosition));
        }
        TextView textView3 = this.f23231D;
        if (textView3 != null) {
            textView3.setText(this.f23198b.getTitle());
        }
        return currentPosition;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: g */
    public void mo35758g() {
        m35770o(this.f23203g);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int getLayoutId() {
        return C6596R.C6600layout.layout_fullscreen_controller;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: i */
    public void mo35757i(float f) {
        if (this.f23232E) {
            this.f23217u = false;
        } else {
            super.mo35757i(f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C6596R.C6599id.lock) {
            m35772m();
        } else if (id != C6596R.C6599id.iv_play && id != C6596R.C6599id.iv_replay) {
            if (id == C6596R.C6599id.more_menu) {
                this.f23240M.show();
                mo35758g();
            } else if (id == C6596R.C6599id.back) {
                C13584f.m12699l(getContext()).finish();
            }
        } else {
            m35779b();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            long duration = (this.f23198b.getDuration() * i) / this.f23245z.getMax();
            TextView textView = this.f23242w;
            if (textView != null) {
                textView.setText(m35775k((int) duration));
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.f23233F = true;
        removeCallbacks(this.f23212p);
        removeCallbacks(this.f23213q);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f23198b.seekTo((int) ((this.f23198b.getDuration() * seekBar.getProgress()) / this.f23245z.getMax()));
        this.f23233F = false;
        post(this.f23212p);
        mo35758g();
    }

    /* renamed from: q */
    public void m35768q() {
        this.f23231D.setVisibility(0);
    }

    public void setLive(boolean z) {
        this.f23232E = z;
        this.f23234G.setVisibility(8);
        this.f23245z.setVisibility(4);
        this.f23241v.setVisibility(4);
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
                this.f23230C.setSelected(false);
                this.f23198b.setLock(false);
                this.f23237J.setVisibility(8);
                this.f23234G.setVisibility(8);
                this.f23236I.setVisibility(8);
                return;
            case 1:
                L.m12717b("STATE_PREPARING");
                this.f23237J.setVisibility(8);
                this.f23236I.setVisibility(0);
                return;
            case 2:
                L.m12717b("STATE_PREPARED");
                if (!this.f23232E) {
                    this.f23234G.setVisibility(0);
                }
                this.f23236I.setVisibility(8);
                return;
            case 3:
                L.m12717b("STATE_PLAYING");
                post(this.f23212p);
                this.f23235H.setSelected(true);
                this.f23237J.setVisibility(8);
                return;
            case 4:
                L.m12717b("STATE_PAUSED");
                this.f23235H.setSelected(false);
                return;
            case 5:
                L.m12717b("STATE_PLAYBACK_COMPLETED");
                mo35761d();
                this.f23237J.setVisibility(0);
                this.f23234G.setProgress(0);
                this.f23234G.setSecondaryProgress(0);
                this.f23202f = false;
                this.f23198b.setLock(false);
                return;
            case 6:
                L.m12717b("STATE_BUFFERING");
                this.f23236I.setVisibility(0);
                return;
            case 7:
                this.f23236I.setVisibility(8);
                L.m12717b("STATE_BUFFERED");
                return;
            default:
                return;
        }
    }

    public FullScreenController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FullScreenController(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.f23238K = AnimationUtils.loadAnimation(getContext(), C6596R.anim.anim_alpha_in);
        this.f23239L = AnimationUtils.loadAnimation(getContext(), C6596R.anim.anim_alpha_out);
    }
}

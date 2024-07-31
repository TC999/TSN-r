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
public class StandardMusicController extends BaseVideoController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    /* renamed from: A */
    protected SeekBar f23247A;

    /* renamed from: B */
    protected ImageView f23248B;

    /* renamed from: C */
    protected ImageView f23249C;

    /* renamed from: D */
    protected ImageView f23250D;

    /* renamed from: E */
    protected TextView f23251E;

    /* renamed from: F */
    private boolean f23252F;

    /* renamed from: G */
    private boolean f23253G;

    /* renamed from: H */
    private View f23254H;

    /* renamed from: I */
    private ProgressBar f23255I;

    /* renamed from: J */
    private ImageView f23256J;

    /* renamed from: K */
    private ImageView f23257K;

    /* renamed from: L */
    private ProgressBar f23258L;

    /* renamed from: M */
    private ImageView f23259M;

    /* renamed from: N */
    private LinearLayout f23260N;

    /* renamed from: O */
    private Animation f23261O;

    /* renamed from: P */
    private Animation f23262P;

    /* renamed from: Q */
    private PopupMenu f23263Q;

    /* renamed from: v */
    protected TextView f23264v;

    /* renamed from: w */
    protected TextView f23265w;

    /* renamed from: x */
    protected ImageView f23266x;

    /* renamed from: y */
    protected LinearLayout f23267y;

    /* renamed from: z */
    protected LinearLayout f23268z;

    /* renamed from: com.devlin_n.videoplayer.controller.StandardMusicController$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6610a implements PopupMenu.OnMenuItemClickListener {
        C6610a() {
        }

        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == C6596R.C6599id.scale_default) {
                StandardMusicController.this.f23198b.mo35714e(0);
            } else if (itemId == C6596R.C6599id.scale_original) {
                StandardMusicController.this.f23198b.mo35714e(4);
            } else if (itemId == C6596R.C6599id.scale_match) {
                StandardMusicController.this.f23198b.mo35714e(3);
            } else if (itemId == C6596R.C6599id.scale_16_9) {
                StandardMusicController.this.f23198b.mo35714e(1);
            } else if (itemId == C6596R.C6599id.scale_4_3) {
                StandardMusicController.this.f23198b.mo35714e(2);
            }
            StandardMusicController.this.f23263Q.dismiss();
            return false;
        }
    }

    /* renamed from: com.devlin_n.videoplayer.controller.StandardMusicController$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC6611b implements Runnable {
        RunnableC6611b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StandardMusicController.this.setLayoutParams(new FrameLayout.LayoutParams(C13583a.f40163b, C13583a.f40162a));
        }
    }

    /* renamed from: com.devlin_n.videoplayer.controller.StandardMusicController$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnTouchListenerC6612c implements View.OnTouchListener {
        View$OnTouchListenerC6612c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public StandardMusicController(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: m */
    private void m35766m() {
        if (this.f23202f) {
            this.f23202f = false;
            this.f23199c = false;
            this.f23207k = true;
            mo35758g();
            this.f23250D.setSelected(false);
            Toast.makeText(getContext(), C6596R.C6602string.unlocked, 0).show();
        } else {
            mo35761d();
            this.f23202f = true;
            this.f23207k = false;
            this.f23250D.setSelected(true);
            Toast.makeText(getContext(), C6596R.C6602string.locked, 0).show();
        }
        this.f23198b.setLock(this.f23202f);
    }

    /* renamed from: n */
    private void m35765n() {
    }

    /* renamed from: o */
    private void m35764o(int i) {
        if (!this.f23199c) {
            if (this.f23198b.mo35720b()) {
                this.f23250D.setVisibility(0);
                if (!this.f23202f) {
                    m35763p();
                }
            } else {
                m35763p();
            }
            if (!this.f23202f && !this.f23252F) {
                this.f23255I.setVisibility(8);
                this.f23255I.startAnimation(this.f23262P);
            }
            this.f23199c = true;
        }
        removeCallbacks(this.f23213q);
        if (i != 0) {
            postDelayed(this.f23213q, i);
        }
    }

    /* renamed from: p */
    private void m35763p() {
        this.f23267y.setVisibility(0);
        this.f23267y.startAnimation(this.f23261O);
        this.f23268z.setVisibility(0);
        this.f23268z.startAnimation(this.f23261O);
        C13584f.m12697n(getContext());
        C13584f.m12698m(getContext());
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: d */
    public void mo35761d() {
        if (this.f23199c) {
            if (this.f23198b.mo35720b()) {
                this.f23250D.setVisibility(8);
                if (!this.f23202f) {
                    m35765n();
                    C13584f.m12701j(getContext());
                    C13584f.m12702i(getContext());
                }
            } else {
                m35765n();
            }
            if (!this.f23252F && !this.f23202f) {
                this.f23255I.setVisibility(0);
                this.f23255I.startAnimation(this.f23261O);
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
        this.f23248B = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.f23197a.findViewById(C6596R.C6599id.fullscreen);
        this.f23266x = imageView2;
        imageView2.setOnClickListener(this);
        this.f23267y = (LinearLayout) this.f23197a.findViewById(C6596R.C6599id.bottom_container);
        this.f23268z = (LinearLayout) this.f23197a.findViewById(C6596R.C6599id.top_container);
        SeekBar seekBar = (SeekBar) this.f23197a.findViewById(C6596R.C6599id.seekBar);
        this.f23247A = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.f23264v = (TextView) this.f23197a.findViewById(C6596R.C6599id.total_time);
        this.f23265w = (TextView) this.f23197a.findViewById(C6596R.C6599id.curr_time);
        ImageView imageView3 = (ImageView) this.f23197a.findViewById(C6596R.C6599id.back);
        this.f23249C = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) this.f23197a.findViewById(C6596R.C6599id.lock);
        this.f23250D = imageView4;
        imageView4.setOnClickListener(this);
        ImageView imageView5 = (ImageView) this.f23197a.findViewById(C6596R.C6599id.thumb);
        this.f23259M = imageView5;
        imageView5.setOnClickListener(this);
        ImageView imageView6 = (ImageView) this.f23197a.findViewById(C6596R.C6599id.iv_play);
        this.f23256J = imageView6;
        imageView6.setOnClickListener(this);
        this.f23257K = (ImageView) this.f23197a.findViewById(C6596R.C6599id.start_play);
        this.f23258L = (ProgressBar) this.f23197a.findViewById(C6596R.C6599id.loading);
        this.f23255I = (ProgressBar) this.f23197a.findViewById(C6596R.C6599id.bottom_progress);
        ((ImageView) this.f23197a.findViewById(C6596R.C6599id.iv_replay)).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.f23197a.findViewById(C6596R.C6599id.complete_container);
        this.f23260N = linearLayout;
        linearLayout.setOnClickListener(this);
        this.f23251E = (TextView) this.f23197a.findViewById(C6596R.C6599id.title);
        View findViewById = this.f23197a.findViewById(C6596R.C6599id.status_holder);
        this.f23254H = findViewById;
        findViewById.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) C13584f.m12705f(getContext())));
        PopupMenu popupMenu = new PopupMenu(getContext(), this.f23248B, GravityCompat.END);
        this.f23263Q = popupMenu;
        popupMenu.getMenuInflater().inflate(C6596R.C6601menu.controller_menu, this.f23263Q.getMenu());
        this.f23263Q.setOnMenuItemClickListener(new C6610a());
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: f */
    protected int mo35759f() {
        BaseVideoController.InterfaceC6607d interfaceC6607d = this.f23198b;
        if (interfaceC6607d == null || this.f23253G) {
            return 0;
        }
        int currentPosition = interfaceC6607d.getCurrentPosition();
        int duration = this.f23198b.getDuration();
        SeekBar seekBar = this.f23247A;
        if (seekBar != null) {
            if (duration > 0) {
                seekBar.setEnabled(true);
                double d = currentPosition;
                Double.isNaN(d);
                double d2 = duration;
                Double.isNaN(d2);
                double d3 = (d * 1.0d) / d2;
                double max = this.f23247A.getMax();
                Double.isNaN(max);
                int i = (int) (d3 * max);
                this.f23247A.setProgress(i);
                this.f23255I.setProgress(i);
            } else {
                seekBar.setEnabled(false);
            }
            int bufferPercentage = this.f23198b.getBufferPercentage();
            if (bufferPercentage >= 95) {
                SeekBar seekBar2 = this.f23247A;
                seekBar2.setSecondaryProgress(seekBar2.getMax());
                ProgressBar progressBar = this.f23255I;
                progressBar.setSecondaryProgress(progressBar.getMax());
            } else {
                int i2 = bufferPercentage * 10;
                this.f23247A.setSecondaryProgress(i2);
                this.f23255I.setSecondaryProgress(i2);
            }
        }
        TextView textView = this.f23264v;
        if (textView != null) {
            textView.setText(m35775k(duration));
        }
        TextView textView2 = this.f23265w;
        if (textView2 != null) {
            textView2.setText(m35775k(currentPosition));
        }
        TextView textView3 = this.f23251E;
        if (textView3 != null) {
            textView3.setText(this.f23198b.getTitle());
        }
        return currentPosition;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: g */
    public void mo35758g() {
        m35764o(this.f23203g);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int getLayoutId() {
        return C6596R.C6600layout.layout_standard_music_controller;
    }

    public ImageView getThumb() {
        return this.f23259M;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    /* renamed from: i */
    public void mo35757i(float f) {
        if (this.f23252F) {
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
                m35766m();
                return;
            } else if (id != C6596R.C6599id.iv_play && id != C6596R.C6599id.thumb && id != C6596R.C6599id.iv_replay) {
                if (id == C6596R.C6599id.more_menu) {
                    this.f23263Q.show();
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
            long duration = (this.f23198b.getDuration() * i) / this.f23247A.getMax();
            TextView textView = this.f23265w;
            if (textView != null) {
                textView.setText(m35775k((int) duration));
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.f23253G = true;
        removeCallbacks(this.f23212p);
        removeCallbacks(this.f23213q);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f23198b.seekTo((int) ((this.f23198b.getDuration() * seekBar.getProgress()) / this.f23247A.getMax()));
        this.f23253G = false;
        post(this.f23212p);
        mo35758g();
    }

    /* renamed from: q */
    public void m35762q() {
        this.f23251E.setVisibility(0);
    }

    public void setCanFast(boolean z) {
        this.f23247A.setOnTouchListener(new View$OnTouchListenerC6612c());
    }

    public void setLive(boolean z) {
        this.f23252F = z;
        this.f23255I.setVisibility(8);
        this.f23247A.setVisibility(4);
        this.f23264v.setVisibility(4);
        this.f23248B.setVisibility(0);
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
                this.f23250D.setSelected(false);
                this.f23198b.setLock(false);
                this.f23260N.setVisibility(8);
                this.f23255I.setVisibility(8);
                this.f23258L.setVisibility(8);
                this.f23257K.setVisibility(0);
                this.f23259M.setVisibility(0);
                return;
            case 1:
                L.m12717b("STATE_PREPARING");
                this.f23260N.setVisibility(8);
                this.f23257K.setVisibility(8);
                this.f23258L.setVisibility(0);
                return;
            case 2:
                L.m12717b("STATE_PREPARED");
                if (!this.f23252F) {
                    this.f23255I.setVisibility(0);
                }
                this.f23258L.setVisibility(8);
                return;
            case 3:
                L.m12717b("STATE_PLAYING");
                post(this.f23212p);
                this.f23256J.setSelected(true);
                this.f23260N.setVisibility(8);
                this.f23259M.setVisibility(8);
                return;
            case 4:
                L.m12717b("STATE_PAUSED");
                this.f23256J.setSelected(false);
                return;
            case 5:
                L.m12717b("STATE_PLAYBACK_COMPLETED");
                mo35761d();
                this.f23259M.setVisibility(0);
                this.f23260N.setVisibility(0);
                this.f23255I.setProgress(0);
                this.f23255I.setSecondaryProgress(0);
                this.f23202f = false;
                this.f23198b.setLock(false);
                return;
            case 6:
                L.m12717b("STATE_BUFFERING");
                this.f23257K.setVisibility(8);
                this.f23258L.setVisibility(0);
                return;
            case 7:
                this.f23258L.setVisibility(8);
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
            this.f23266x.setSelected(false);
            this.f23249C.setVisibility(8);
            this.f23250D.setVisibility(8);
            this.f23254H.setVisibility(8);
        } else if (i != 11) {
        } else {
            L.m12717b("PLAYER_FULL_SCREEN");
            if (this.f23202f) {
                return;
            }
            postDelayed(new RunnableC6611b(), 300L);
            this.f23207k = true;
            this.f23266x.setSelected(true);
            this.f23254H.setVisibility(0);
            this.f23249C.setVisibility(0);
            this.f23251E.setVisibility(0);
            if (this.f23199c) {
                this.f23250D.setVisibility(0);
                C13584f.m12698m(getContext());
                C13584f.m12697n(getContext());
                return;
            }
            this.f23250D.setVisibility(8);
        }
    }

    public StandardMusicController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StandardMusicController(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.f23261O = AnimationUtils.loadAnimation(getContext(), C6596R.anim.anim_alpha_in);
        this.f23262P = AnimationUtils.loadAnimation(getContext(), C6596R.anim.anim_alpha_out);
    }
}

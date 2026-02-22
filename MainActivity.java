package com.tflix.live;

import E4.h;
import H5.A;
import H5.C;
import H5.D;
import H5.E;
import H5.F;
import H5.G;
import H5.i;
import H5.y;
import H5.z;
import I5.j;
import L5.x;
import N5.f;
import N5.n;
import N5.o;
import N5.r;
import N5.u;
import P.k0;
import P5.a;
import P5.d;
import R5.c;
import Z5.b;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.H;
import androidx.fragment.app.L;
import androidx.fragment.app.services;
import androidx.recyclerview.widget.RecyclerView;
import b6.e;
import com.google.android.gms.internal.measurement.K1;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.tflix.live.app.ProApplication;
import d.g;
import g.k;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r5.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MainActivity extends k {
    public static final /* synthetic */ int w0 = 0;
    public p U;
    public c V;
    public e W;
    public g.c X;
    public MenuItem Y;
    public n Z;
    public f a0;
    public u b0;
    public N5.k c0;
    public r d0;
    public N5.c e0;
    public JSONArray f0;
    public JSONArray g0;
    public a h0;
    public String i0;
    public String j0;
    public String k0;
    public boolean o0;
    public boolean p0;
    public boolean q0;
    public int s0;
    public ProApplication u0;
    public boolean l0 = false;
    public boolean m0 = false;
    public boolean n0 = true;
    public boolean r0 = false;
    public int t0 = -1;
    public final g v0 = l(new H(2), new h(8));

    public static void r(MainActivity mainActivity, String str) {
        if (str == null) {
            mainActivity.t0 = 0;
            return;
        }
        mainActivity.t0 = str.isEmpty() ? 0 : 2;
        if (!mainActivity.p0) {
            if (mainActivity.m0) {
                mainActivity.c0.U(str);
                return;
            }
            n nVar = mainActivity.Z;
            if (nVar.C0 != null) {
                if (str.isEmpty()) {
                    j jVar = nVar.x0;
                    List list = nVar.C0;
                    b bVar = nVar.F0;
                    jVar.n(bVar.g, bVar.h, list);
                    ((LinearLayout) nVar.u0.w).setVisibility(8);
                } else {
                    List arrayList = new ArrayList();
                    String lowerCase = str.toLowerCase();
                    for (d dVar : nVar.C0) {
                        String lowerCase2 = dVar.d.toLowerCase();
                        String lowerCase3 = dVar.e.toLowerCase();
                        if (lowerCase2.contains(str) || lowerCase3.contains(str) || dVar.a.toLowerCase().contains(lowerCase) || dVar.b.toLowerCase().contains(lowerCase)) {
                            arrayList.add(dVar);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        ((LinearLayout) nVar.u0.w).setVisibility(0);
                    } else {
                        ((LinearLayout) nVar.u0.w).setVisibility(8);
                        j jVar2 = nVar.x0;
                        b bVar2 = nVar.F0;
                        jVar2.n(bVar2.g, bVar2.h, arrayList);
                    }
                }
            }
            mainActivity.b0.S(str);
            f fVar = mainActivity.a0;
            if (fVar != null) {
                fVar.R(str);
                return;
            }
            return;
        }
        N5.d dVar2 = mainActivity.d0.w0.m;
        if (dVar2 == null) {
            return;
        }
        if (!(dVar2 instanceof N5.p)) {
            o oVar = (o) dVar2;
            if (oVar.w0 == null) {
                return;
            }
            List arrayList2 = new ArrayList();
            Iterator it = oVar.w0.iterator();
            while (it.hasNext()) {
                P5.c cVar = (P5.c) it.next();
                String str2 = cVar.a;
                if (str2 != null && str2.toLowerCase().contains(str.toLowerCase())) {
                    arrayList2.add(cVar);
                }
            }
            if (arrayList2.isEmpty()) {
                ((RecyclerView) oVar.u0.x).setVisibility(8);
                ((TextView) oVar.u0.w).setVisibility(0);
                return;
            } else {
                ((RecyclerView) oVar.u0.x).setVisibility(0);
                ((TextView) oVar.u0.w).setVisibility(8);
                oVar.v0.m(arrayList2);
                return;
            }
        }
        N5.p pVar = (N5.p) dVar2;
        if (pVar.x0 == null) {
            return;
        }
        if (str.isEmpty()) {
            pVar.w0.n("no", "no", pVar.x0);
            ((RecyclerView) pVar.u0.x).setVisibility(0);
            ((TextView) pVar.u0.w).setVisibility(8);
            return;
        }
        List arrayList3 = new ArrayList();
        String lowerCase4 = str.toLowerCase();
        for (d dVar3 : pVar.x0) {
            String lowerCase5 = dVar3.d.toLowerCase();
            String lowerCase6 = dVar3.e.toLowerCase();
            if (lowerCase5.contains(str) || lowerCase6.contains(str) || dVar3.a.toLowerCase().contains(lowerCase4) || dVar3.b.toLowerCase().contains(lowerCase4)) {
                arrayList3.add(dVar3);
            }
        }
        if (arrayList3.isEmpty()) {
            ((RecyclerView) pVar.u0.x).setVisibility(8);
            ((TextView) pVar.u0.w).setVisibility(0);
        } else {
            ((RecyclerView) pVar.u0.x).setVisibility(0);
            ((TextView) pVar.u0.w).setVisibility(8);
            pVar.w0.n("no", "no", arrayList3);
        }
    }

    public final void onBackPressed() {
        if (this.t0 != -1) {
            this.t0 = 0;
        }
        N5.c cVar = this.e0;
        if (cVar != null) {
            if (cVar.y0 <= 0) {
                L m = m();
                androidx.fragment.app.a f = I1.a.f(m, m);
                f.h(this.e0);
                f.d(false);
                this.e0 = null;
                x();
                return;
            }
            return;
        }
        if (this.p0) {
            t();
            this.d0 = null;
            this.p0 = false;
            ((BottomNavigationView) this.U.v).setVisibility(0);
            ((TextView) this.V.x).setText(this.k0);
            if (this.m0) {
                return;
            }
            s();
            return;
        }
        if (this.m0) {
            N5.k kVar = this.c0;
            if (kVar.F0 != null) {
                ((FragmentContainerView) kVar.u0.e).setVisibility(8);
                kVar.F0 = null;
                ((TextView) this.V.x).setText(this.j0);
                ((BottomNavigationView) this.U.v).setVisibility(0);
                return;
            }
            s();
            this.m0 = false;
            this.l0 = false;
            this.c0 = null;
            ((BottomNavigationView) this.U.v).getMenu().getItem(2).setChecked(true);
            ((BottomNavigationView) this.U.v).setSelectedItemId(C.navigation_categories);
            return;
        }
        if (!this.o0) {
            if (!this.n0) {
                ((BottomNavigationView) this.U.v).getMenu().getItem(0).setChecked(true);
                ((BottomNavigationView) this.U.v).setSelectedItemId(C.navigation_events);
                return;
            } else {
                if (this.q0) {
                    super.onBackPressed();
                    return;
                }
                Toast.makeText(this, "Tap again to exit", 0).show();
                this.q0 = true;
                new Handler(Looper.getMainLooper()).postDelayed(new A0.a(11, this), 2000L);
                return;
            }
        }
        u uVar = this.b0;
        if (uVar.D0 != null) {
            ((FragmentContainerView) uVar.u0.e).setVisibility(8);
            uVar.D0 = null;
            s();
            ((TextView) this.V.x).setText("Sports");
            ((BottomNavigationView) this.U.v).setVisibility(0);
            return;
        }
        if (this.n0) {
            ((BottomNavigationView) this.U.v).getMenu().getItem(0).setChecked(true);
            ((BottomNavigationView) this.U.v).setSelectedItemId(C.navigation_events);
        } else {
            ((BottomNavigationView) this.U.v).getMenu().getItem(2).setChecked(true);
            ((BottomNavigationView) this.U.v).setSelectedItemId(C.navigation_categories);
        }
    }

    public final void onCreate(Bundle bundle) {
        LinearLayout h;
        RelativeLayout h2;
        FragmentContainerView h3;
        FragmentContainerView h4;
        FragmentContainerView h5;
        FragmentContainerView h6;
        Toolbar h7;
        TextView h8;
        g.o.l();
        super.onCreate(bundle);
        services.api(this);
        if (bundle != null) {
            startActivity(new Intent(this, SplashActivity.class));
            finish();
            return;
        }
        DrawerLayout inflate = getLayoutInflater().inflate(D.activity_main, (ViewGroup) null, false);
        int r2 = C.bottom_navigation;
        BottomNavigationView h9 = K1.h(inflate, r2);
        if (h9 != null) {
            DrawerLayout drawerLayout = inflate;
            r2 = C.navigationView;
            NavigationView h10 = K1.h(inflate, r2);
            if (h10 != null && (h = K1.h(inflate, (r2 = C.toolbar_binding))) != null) {
                int r0 = C.app_bar_icon;
                if (K1.h(h, r0) != null && (h2 = K1.h(h, (r0 = C.content))) != null) {
                    int r02 = C.categories_fragment_container;
                    FragmentContainerView h11 = K1.h(h2, r02);
                    if (h11 == null || (h3 = K1.h(h2, (r02 = C.channels_fragment_container))) == null || (h4 = K1.h(h2, (r02 = C.events_fragment_container))) == null || (h5 = K1.h(h2, (r02 = C.fav_fragment_container))) == null || (h6 = K1.h(h2, (r02 = C.sports_fragment_container))) == null) {
                        throw new NullPointerException("Missing required view with ID: ".concat(h2.getResources().getResourceName(r02)));
                    }
                    e eVar = new e(h11, h3, h4, h5, h6);
                    r0 = C.main_toolbar_layout;
                    if (K1.h(h, r0) != null && (h7 = K1.h(h, (r0 = C.toolbar))) != null && (h8 = K1.h(h, (r0 = C.toolbar_title))) != null) {
                        this.U = new p(drawerLayout, h9, drawerLayout, h10, new c(eVar, h7, h8, 24), 6);
                        setContentView((View) drawerLayout);
                        c cVar = (c) this.U.y;
                        this.V = cVar;
                        this.W = (e) cVar.v;
                        this.u0 = (ProApplication) getApplication();
                        int r03 = Build.VERSION.SDK_INT;
                        if (r03 >= 33 && E.c.a(this, "android.permission.POST_NOTIFICATIONS") != 0 && !shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) {
                            this.v0.a("android.permission.POST_NOTIFICATIONS");
                        }
                        this.i0 = getString(G.app_name);
                        Intent intent = getIntent();
                        if (r03 > 33) {
                            this.h0 = (a) C0.a.g(intent);
                        } else {
                            this.h0 = (a) intent.getParcelableExtra("appDetail");
                        }
                        try {
                            this.f0 = new JSONArray(this.h0.u);
                            this.g0 = new JSONArray(this.h0.v);
                        } catch (JSONException unused) {
                        }
                        q((Toolbar) this.V.w);
                        g.c cVar2 = new g.c(this, (Toolbar) this.V.w, (DrawerLayout) this.U.w, G.open_drawer, G.close_drawer);
                        this.X = cVar2;
                        ((DrawerLayout) this.U.w).a(cVar2);
                        this.X.e();
                        com.bumptech.glide.c p = p();
                        Objects.requireNonNull(p);
                        p.E();
                        ((Toolbar) this.V.w).setTitleTextColor(-1);
                        ((TextView) this.V.x).setSelected(true);
                        i.f fVar = this.X.c;
                        Paint paint = fVar.a;
                        if (-1 != paint.getColor()) {
                            paint.setColor(-1);
                            fVar.invalidateSelf();
                        }
                        ((BottomNavigationView) this.U.v).setOnItemSelectedListener(new H5.e(this));
                        ((NavigationView) this.U.x).getMenu().findItem(C.telegram).setTitle(this.h0.y);
                        ((NavigationView) this.U.x).setNavigationItemSelectedListener(new H5.e(this));
                        try {
                            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                            if (Build.VERSION.SDK_INT >= 29) {
                                this.s0 = (int) k0.b(packageInfo);
                            } else {
                                this.s0 = packageInfo.versionCode;
                            }
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                        int r04 = getApplicationInfo().targetSdkVersion;
                        int a = Build.VERSION.SDK_INT >= 24 ? C0.C.a(getApplicationInfo()) : 21;
                        int r5 = this.s0;
                        Q5.b bVar = new Q5.b();
                        bVar.a = false;
                        bVar.b = this;
                        if (r5 > 1 || r5 < 1) {
                            throw new RuntimeException("");
                        }
                        if (r04 != 35 || a != 23) {
                            throw new RuntimeException("");
                        }
                        String absolutePath = getFilesDir().getAbsolutePath();
                        int r52 = 0;
                        for (int r22 = 0; r22 < absolutePath.length() && r52 <= 2; r22++) {
                            if (absolutePath.charAt(r22) == '.') {
                                r52++;
                            }
                        }
                        if (r52 > 2) {
                            Y5.j.H();
                            throw null;
                        }
                        for (PackageInfo packageInfo2 : getPackageManager().getInstalledPackages(0)) {
                            bVar.a = false;
                            if (packageInfo2.packageName.equalsIgnoreCase(Q5.a.a("553259705a6e636c4e58616b6c57626f5233627652585a31786d5975515761764a485a75466d4c74393259")) || packageInfo2.packageName.equalsIgnoreCase(Q5.a.a("6f5233627652585a31786d5975515761764a485a75466d4c74393259"))) {
                                bVar.a = true;
                                break;
                            }
                        }
                        if (!bVar.a) {
                            Y5.j.H();
                            throw null;
                        }
                        int[] r23 = {F.live, F.loading, F.error, F.update};
                        for (int r53 = 0; r53 < 4; r53++) {
                            InputStream openRawResource = bVar.b.getResources().openRawResource(r23[r53]);
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                try {
                                    try {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine != null) {
                                            sb.append(readLine);
                                        } else {
                                            try {
                                                break;
                                            } catch (IOException e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                        openRawResource.close();
                                        bufferedReader.close();
                                    }
                                } finally {
                                }
                            }
                            openRawResource.close();
                            bufferedReader.close();
                            try {
                                new JSONObject(sb.toString());
                            } catch (JSONException unused2) {
                                Y5.j.H();
                                throw null;
                            }
                        }
                        try {
                            Field[] declaredFields = F.class.getDeclaredFields();
                            if (declaredFields.length > 4 || declaredFields.length < 4) {
                                Y5.j.H();
                                throw null;
                            }
                            if (getResources().getResourceName(declaredFields[3].getInt(F.class) + 1) != null) {
                                Y5.j.H();
                                throw null;
                            }
                            try {
                                String[] strArr = getPackageManager().getPackageInfo(getPackageName(), 4096).requestedPermissions;
                                if (strArr != null) {
                                    String b = Q5.a.b("LW5ejc9qSJ5wSYZxfYDsfW9hNnPIVIZSY0PCXP9TTHDNTHkPHw==");
                                    for (String str : strArr) {
                                        if (str.equals(b)) {
                                            Q5.b.a(this);
                                            if (!Q5.b.c || !Q5.b.d) {
                                                Y5.j.H();
                                                throw null;
                                            }
                                            this.r0 = true;
                                            w();
                                            u();
                                            if (!this.r0) {
                                                Y5.j.H();
                                                throw null;
                                            }
                                            String str2 = this.h0.H;
                                            if (str2 == null || !str2.trim().startsWith("http")) {
                                                x();
                                            } else {
                                                String str3 = this.h0.I;
                                                H5.e eVar2 = new H5.e(this);
                                                N5.c cVar3 = new N5.c();
                                                cVar3.x0 = new Handler(Looper.getMainLooper());
                                                cVar3.y0 = 3;
                                                cVar3.u0 = str2;
                                                cVar3.v0 = str3;
                                                cVar3.w0 = eVar2;
                                                this.e0 = cVar3;
                                                L m = m();
                                                androidx.fragment.app.a f = I1.a.f(m, m);
                                                f.b = 17432576;
                                                f.c = 17432577;
                                                f.d = 0;
                                                f.e = 0;
                                                f.f(16908290, this.e0, null, 1);
                                                if (!f.h) {
                                                    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                                                }
                                                f.g = true;
                                                f.i = null;
                                                f.d(false);
                                            }
                                            this.u0.x = new H5.e(this);
                                            return;
                                        }
                                    }
                                }
                            } catch (PackageManager.NameNotFoundException unused3) {
                            }
                            Y5.j.H();
                            throw null;
                        } catch (IllegalAccessException unused4) {
                            Y5.j.H();
                            throw null;
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(h.getResources().getResourceName(r0)));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(r2)));
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(E.menu_buttons, menu);
        MenuItem findItem = menu.findItem(C.favorites);
        v(findItem, getDrawable(A.favorite_full_white));
        findItem.setOnMenuItemClickListener(new H5.h(this, 0));
        MenuItem findItem2 = menu.findItem(C.donate);
        v(findItem2, getDrawable(A.donate));
        findItem2.setOnMenuItemClickListener(new H5.h(this, 1));
        MenuItem findItem3 = menu.findItem(C.search);
        this.Y = findItem3;
        findItem3.setOnActionExpandListener(new i(this, findItem, findItem2));
        SearchView actionView = this.Y.getActionView();
        SearchView.SearchAutoComplete findViewById = actionView.findViewById(f.f.search_src_text);
        findViewById.setHintTextColor(getColor(y.gray_77));
        findViewById.setTextColor(-1);
        actionView.setQueryHint("Search..");
        actionView.setOnQueryTextListener(new t2.d(9, this));
        return super.onCreateOptionsMenu(menu);
    }

    public final void s() {
        p().D(false);
        g.c cVar = this.X;
        if (true != cVar.e) {
            View f = cVar.b.f(8388611);
            int r1 = f != null ? DrawerLayout.o(f) : false ? cVar.g : cVar.f;
            i.f fVar = cVar.c;
            boolean z = cVar.h;
            g.a aVar = cVar.a;
            if (!z && !aVar.e()) {
                Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
                cVar.h = true;
            }
            aVar.a(fVar, r1);
            cVar.e = true;
        }
        this.X.e();
        ((Toolbar) this.V.w).setNavigationOnClickListener(new H5.f(this, 0));
    }

    public final void t() {
        if (this.d0 != null) {
            L m = m();
            androidx.fragment.app.a f = I1.a.f(m, m);
            f.h(this.d0);
            f.d(false);
            this.d0 = null;
        }
        ((FragmentContainerView) this.W.x).setVisibility(8);
    }

    public final void u() {
        if (this.Z == null) {
            b bVar = (b) new K5.e(this).y(b.class);
            bVar.d = this.f0;
            a aVar = this.h0;
            bVar.e = aVar.C;
            bVar.f = aVar.D;
            bVar.g = aVar.E;
            bVar.h = aVar.F;
            this.Z = new n();
            L m = m();
            androidx.fragment.app.a f = I1.a.f(m, m);
            f.f(C.events_fragment_container, this.Z, null, 1);
            f.d(false);
        }
        this.n0 = true;
        this.o0 = false;
        this.m0 = false;
        ProApplication proApplication = this.u0;
        proApplication.A = null;
        proApplication.I = false;
        ((FragmentContainerView) this.W.w).setVisibility(0);
        ((FragmentContainerView) this.W.y).setVisibility(8);
        ((FragmentContainerView) this.W.u).setVisibility(8);
        ((FragmentContainerView) this.W.v).setVisibility(8);
        s();
    }

    public final void v(MenuItem menuItem, Drawable drawable) {
        if (drawable != null) {
            int dimension = (int) getResources().getDimension(z.menu_icon_size);
            Bitmap createBitmap = Bitmap.createBitmap(dimension, dimension, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, dimension, dimension);
            drawable.draw(canvas);
            menuItem.setIcon(new BitmapDrawable(getResources(), createBitmap));
        }
    }

    public final void w() {
        if (this.b0 == null) {
            String str = this.h0.w;
            u uVar = new u();
            Bundle bundle = new Bundle();
            bundle.putString("api", str);
            uVar.L(bundle);
            this.b0 = uVar;
            L m = m();
            androidx.fragment.app.a f = I1.a.f(m, m);
            f.f(C.sports_fragment_container, this.b0, null, 1);
            f.d(false);
        }
        this.o0 = true;
        this.m0 = false;
        u uVar2 = this.b0;
        ProApplication proApplication = this.u0;
        proApplication.A = uVar2.y0;
        proApplication.I = true;
        ((FragmentContainerView) this.W.v).setVisibility(8);
        ((FragmentContainerView) this.W.w).setVisibility(8);
        ((FragmentContainerView) this.W.u).setVisibility(8);
        ((FragmentContainerView) this.W.y).setVisibility(0);
        s();
        if (this.t0 == 0) {
            this.b0.S("");
        }
    }

    public final void x() {
        if (this.h0.G.equalsIgnoreCase("yes")) {
            a aVar = this.h0;
            String str = aVar.x;
            int r0 = aVar.S;
            int r2 = x.w;
            long j = getSharedPreferences("DataPreferences", 0).getLong("tg_dialog_timestamp", -1L);
            if (j != -1) {
                if (System.currentTimeMillis() - j < r0 * 3600000) {
                    return;
                }
            }
            x xVar = new x(this, str);
            xVar.setCancelable(true);
            xVar.setCanceledOnTouchOutside(false);
            xVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            xVar.show();
        }
    }

    public final void y() {
        p().D(true);
        ((Toolbar) this.V.w).setNavigationOnClickListener(new H5.f(this, 1));
    }

    public final void z(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, e.getMessage(), 0).show();
        }
    }
}

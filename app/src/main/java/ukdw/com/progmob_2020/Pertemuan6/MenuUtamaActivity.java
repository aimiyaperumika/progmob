package com.example.progmobtugas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.progmobtugas.Adapter.MenuUtamaAdapter;
import com.example.progmobtugas.CrudDosen.MainDosenActivity;
import com.example.progmobtugas.CrudMatKul.MainMatkulActivity;
import com.example.progmobtugas.CrudMhs.MahasiswaGetAllActivity;
import com.example.progmobtugas.CrudMhs.MainMhsActivity;

public class MenuUtamaActivity extends AppCompatActivity {
    GridView gridView;
    String[] namaIcon = {"Menu Mahasiswa","Menu Dosen","Menu Matakuliah"};
    int[] nomerIcon = {R.drawable.mahasiswa1,R.drawable.dosen1,R.drawable.matakuliah1};
    String isLogin="";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menulogout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SharedPreferences pref = MenuUtamaActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        String isLogin = pref.getString("isLogin", "0");
        editor.putString("isLogin", "0");
        editor.commit();
        Intent intent = new Intent(MenuUtamaActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        androidx.appcompat.widget.Toolbar logoutToolbar = (Toolbar)findViewById(R.id.toolbarLogout);
        setSupportActionBar(logoutToolbar);


        gridView = findViewById(R.id.gridView);
        MenuUtamaAdapter muAdapter = new MenuUtamaAdapter(MenuUtamaActivity.this,namaIcon,nomerIcon);
        gridView.setAdapter(muAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(),"Anda Memilih Menu "+namaIcon[i],Toast.LENGTH_SHORT).show();
                if ("Menu Mahasiswa".equals(namaIcon[i])) {
                    Intent intentmhs = new Intent(MenuUtamaActivity.this, MainMhsActivity.class);
                    startActivity(intentmhs);
                } else if ("Menu Dosen".equals(namaIcon[i])) {
                    Intent intentdosen = new Intent(MenuUtamaActivity.this, MainDosenActivity.class);
                    startActivity(intentdosen);
                } else if ("Menu Matakuliah".equals(namaIcon[i])) {
                    Intent intentmatkul = new Intent(MenuUtamaActivity.this, MainMatkulActivity.class);
                    startActivity(intentmatkul);
                }
            }
        });
    }
}
package ukdw.com.progmob_2020.Pertemuan4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ukdw.com.progmob_2020.Adapter.MahasiswaRecyclerAdapter;
import ukdw.com.progmob_2020.Tugas3Model.Mahasiswa;
import ukdw.com.progmob_2020.Tugas3Model.MahasiswaDebugging;
import ukdw.com.progmob_2020.Tugas3.RecyclerActivity;
import ukdw.com.progmob_2020.R;

public class DebuggingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debugging);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvLatihan);
        MahasiswaRecyclerAdapter mahasiswaRecyclerAdapter;

        //data dummy
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        //generate data mahasiswa
        Mahasiswa m1 = new Mahasiswa("Aimiya","72170142","1234567890");
        Mahasiswa m2 = new Mahasiswa("Silvi","72170001","084646464646");
        Mahasiswa m3 = new Mahasiswa("Melvi","72170456","084646464646");
        Mahasiswa m4 = new Mahasiswa("Sandi","72110111","084646464646");
        Mahasiswa m5 = new Mahasiswa("Ilham","72110222","084646464646");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);
        mahasiswaList.add(m5);

        List<Mahasiswa> mahasiswaListDebug = new ArrayList<Mahasiswa>();
        
        mahasiswaRecyclerAdapter = new MahasiswaRecyclerAdapter(DebuggingActivity.this);
        mahasiswaRecyclerAdapter.setMahasiswaList(mahasiswaListDebug);

        rv.setLayoutManager(new LinearLayoutManager(DebuggingActivity.this));
        rv.setAdapter(mahasiswaRecyclerAdapter);
    }
}

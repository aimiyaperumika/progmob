package ukdw.com.progmob_2020.Crud_matkul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ukdw.com.progmob_2020.Adapter.DosenRecyclerAdapter;
import ukdw.com.progmob_2020.Adapter.MatkulRecyclerAdapter;
import ukdw.com.progmob_2020.Crud_dosen.DosenGetAllActivity;
import ukdw.com.progmob_2020.Tugas3Model.Dosen;
import ukdw.com.progmob_2020.Tugas3Model.Matakuliah;
import ukdw.com.progmob_2020.Network.GetDataService;
import ukdw.com.progmob_2020.Network.RetrofitClientInstance;
import ukdw.com.progmob_2020.R;

public class MatkulGetallActivity extends AppCompatActivity {
    RecyclerView rvMatakuliah;
    MatkulRecyclerAdapter matkulAdapter;
    ProgressDialog pd;
    List<Matakuliah> matakuliahList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_getall);

        rvMatakuliah = (RecyclerView)findViewById(R.id.rvMatakuliah);
        pd = new ProgressDialog(this);
        pd.setTitle("Mohon Bersabar");
        pd.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Matakuliah>> call = service.getMatkul("72170142");

        call.enqueue(new Callback<List<Matakuliah>>() {
            @Override
            public void onResponse(Call<List<Matakuliah>> call, Response<List<Matakuliah>> response) {
                pd.dismiss();
                matakuliahList = response.body();
                matkulAdapter = new MatkulRecyclerAdapter(matakuliahList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MatkulGetallActivity.this);
                rvMatakuliah.setLayoutManager(layoutManager);
                rvMatakuliah.setAdapter(matkulAdapter);
            }
            @Override
            public void onFailure(Call<List<Matakuliah>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(MatkulGetallActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}
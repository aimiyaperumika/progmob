package ukdw.com.progmob_2020.Crud;

import android.app.ProgressDialog;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ukdw.com.progmob_2020.Tugas3Model.DefaultResult;
import ukdw.com.progmob_2020.Network.GetDataService;
import ukdw.com.progmob_2020.Network.RetrofitClientInstance;
import ukdw.com.progmob_2020.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MahasiswaAddActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_mahasiswa_add);


          final EditText editTextNama = (EditText)findViewById(R.id.editTextNama);
          final EditText editTextNim = (EditText)findViewById(R.id.editTextNim);
         final EditText editTextAlamat = (EditText)findViewById(R.id.editTextAlamat);
         final EditText editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        Button btnSimpan = (Button)findViewById(R.id.buttonSimpanMhs);
        pd = new ProgressDialog(MahasiswaAddActivity.this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_mhs(
                        editTextNama.getText().toString(),
                        editTextNim.getText().toString(),
                        editTextAlamat.getText().toString(),
                        editTextEmail.getText().toString(),
                        "kosongkan saja diisi sembarang karean dirandom sistem",
                        "72170142" //diisi nim masing-masing
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                    pd.dismiss();
                    Toast.makeText(MahasiswaAddActivity.this, "DATA BERHASISL DISIMPAN", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                    pd.dismiss();
                    Toast.makeText(MahasiswaAddActivity.this, "GAGAL", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}

package ukdw.com.progmob_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ukdw.com.progmob_2020.Tugas3.ListActivity;
import ukdw.com.progmob_2020.Tugas3.RecyclerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variabel
        final TextView textView = (TextView)findViewById(R.id.mainActivityTextView);
        Button myBtn = (Button)findViewById(R.id.button1);
        final EditText myEditText = (EditText)findViewById(R.id.editText1);
        Button btnHelp = (Button)findViewById(R.id.btnHelp);
        Button btnTugas = (Button)findViewById(R.id.btnTugas);

        //tugas3
        Button btnList = (Button)findViewById(R.id.buttonListView);
        Button btnRecycler = (Button)findViewById(R.id.buttonRecylerView);
        Button btnCard = (Button)findViewById(R.id.buttonCard);


        //action
        textView.setText(R.string.text_hello_world);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Log.d("COBA KLIK",myEditText.getText().toString());
                textView.setText(myEditText.getText().toString());
            }
        });
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HelpActivity.class);
                Bundle b = new Bundle();

                b.getString("help_string",myEditText.getText().toString());
                intent.putExtras(b);

                startActivity(intent);
            }
        });
       btnTugas.setOnClickListener((new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,TrackerActivity.class);
               startActivity(intent);
           }
       }));
       btnList.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, ListActivity.class);
               startActivity(intent);
           }
       });
       btnRecycler.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
               startActivity(intent);
           }
       });
    }
}
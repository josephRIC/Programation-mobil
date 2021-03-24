package com.example.progmobile_tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    PlaneteAdapter adapter;
    Button btnVerifier;

    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listView);
        this.data = new Data();
        adapter = new PlaneteAdapter(this, data);
        listview.setAdapter(adapter);

        btnVerifier = (Button) findViewById(R.id.btnVerifier);
        btnVerifier.setEnabled(false);
        btnVerifier.setOnClickListener(btnVerifierOnClickListener);
    }
    //----------------------------------------------------------------------------------------------
    View.OnClickListener btnVerifierOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(verifTaille()){
                popUp("Bingo!! Le résultat est bon!");
            }
            else{
                popUp("Faux!");
            }
        }
    };

    public boolean verifTaille(){
        for (int i=0;i<adapter.getCount();i++) {
            View itemview= (View) listview.getChildAt(i);
            Spinner spin=itemview.findViewById(R.id.spinner);
            if(data.getTaillePlanetes()[i].equals(spin.getSelectedItem().toString())){
                //popUp("pour i="+i+" nous avons rempli : "+spin.getPrompt().toString()+" alors que la plane"+d.getTaillePlanetes(i));
                return false;
            }
        }
        return true;
    }

    public void popUp(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

package com.example.progmobile_tp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

class PlaneteAdapter extends BaseAdapter {
    private MainActivity mainActivity;
    private Data data;

    private int checked_elements = 0;

    public PlaneteAdapter(MainActivity mainActivity, Data data) {
        this.mainActivity = mainActivity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.getPlanetes().size();
    }

    @Override
    public Object getItem(int arg0) {
        return data.getPlanetes().get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }

        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);

        nomPlanete.setText(data.getPlanetes().get(position));
        //  installer l'adaptateur pour la liste déroulante (spinner)
        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(mainActivity, android.R.layout.simple_spinner_item, data.getTaillePlanetes());
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Button btnVerifier = mainActivity.findViewById(R.id.btnVerifier);
                if (checkBox.isChecked()){
                    checked_elements++;
                }
                else {
                    checked_elements--;
                }
                if (checked_elements >= data.getPlanetes().size()){
                    btnVerifier.setEnabled(true);
                }
                else {
                    if (btnVerifier.isEnabled()){
                        btnVerifier.setEnabled(false);
                    }
                }
                spinner.setEnabled(!checkBox.isChecked());
                spinadapter.notifyDataSetChanged();
            }
        });

        return itemView;
    }
    //----------------------------------------------------------------------------------------------

}

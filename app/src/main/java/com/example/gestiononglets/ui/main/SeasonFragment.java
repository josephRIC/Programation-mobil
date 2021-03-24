package com.example.gestiononglets.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.gestiononglets.MainActivity;
import com.example.gestiononglets.R;

public class SeasonFragment extends Fragment {
    private String title;
    private int page;

    private SeasonFragment fragment;

    private  static final String ARG_SECTION_NUMBER = "numero_page";
    private static final String ARG_SECTION_TITLE = "titre_page";
    private Context context;

    public static SeasonFragment newInstance(int position, String title){
        SeasonFragment fragment = new SeasonFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(ARG_SECTION_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        title = getArguments().getString(ARG_SECTION_TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if(title.equals("Saisons")){
            View view = inflater.inflate(R.layout.fragment_saisons, container, false);
            ImageView imageHiver = (ImageView) view.findViewById(R.id.imageView1);
            ImageView imagePrintemps= (ImageView) view.findViewById(R.id.imageView2);
            ImageView imageEte= (ImageView) view.findViewById(R.id.imageView3);
            ImageView imageAutomne= (ImageView) view.findViewById(R.id.imageView4);

            imageHiver.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // your code here
                    MainActivity a = (MainActivity) getActivity();
                    a.getViewPager().setCurrentItem(0);
                }
            });

            imagePrintemps.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // your code here
                    MainActivity a = (MainActivity) getActivity();
                    a.getViewPager().setCurrentItem(1);
                }
            });

            imageEte.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // your code here
                    MainActivity a = (MainActivity) getActivity();
                    a.getViewPager().setCurrentItem(2);
                }
            });

            imageAutomne.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // your code here
                    MainActivity a = (MainActivity) getActivity();
                    a.getViewPager().setCurrentItem(3);
                }
            });


            imageHiver.setImageResource(SectionsPagerAdapter.getImage("hiver"));
            imagePrintemps.setImageResource(SectionsPagerAdapter.getImage("printemps"));
            imageEte.setImageResource(SectionsPagerAdapter.getImage("ete"));
            imageAutomne.setImageResource(SectionsPagerAdapter.getImage("automne"));
            return view;
        }
        else {
            View view = inflater.inflate(R.layout.fragment_main, container, false);
            TextView tvLabel = (TextView) view.findViewById(R.id.section_label);
            tvLabel.setText(page + " -- " + title);
            ImageView image;
            image = (ImageView) view.findViewById(R.id.imageView);
            image.setImageResource(SectionsPagerAdapter.getImage(title));
            return view;
        }
    }
}

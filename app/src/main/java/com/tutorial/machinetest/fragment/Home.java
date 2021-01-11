package com.tutorial.machinetest.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.tutorial.machinetest.R;
import com.tutorial.machinetest.display.DisplayActivity;
import com.tutorial.machinetest.mvvm.CountriesViewModel;
import com.tutorial.machinetest.mvvm.MVVMActivity;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {
    ScrollView scrollView;



    private List<String> listValues = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;
    private CountriesViewModel viewModel;
    private Button retryButton;
    private ProgressBar progress;
    ImageView imageview1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.activity_mvvm, container, false);



        viewModel = ViewModelProviders.of(this).get(CountriesViewModel.class);
       // imageview1=rootView.findViewById(R.id.imageview1);






        for(int i=0;i<listValues.size();i++)
        {
            String imageUrl=listValues.get(i);
            Log.i("imageurl",imageUrl);
        }



        list = rootView.findViewById(R.id.list);
        retryButton = rootView.findViewById(R.id.retryButton);
        progress = rootView.findViewById(R.id.progress);
        adapter = new ArrayAdapter<>(getActivity(), R.layout.row_layout, R.id.listText, listValues);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "You clicked " + listValues.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), DisplayActivity.class);
                intent.putExtra("image", listValues.get(position));
                startActivity(intent);


            }
        });

        observeViewModel();


        return rootView;
    }


    private void observeViewModel() {
        viewModel.getCountries().observe(getActivity(), countries -> {
            if(countries != null) {
                listValues.clear();
                listValues.addAll(countries);
                list.setVisibility(View.VISIBLE);
                adapter.notifyDataSetChanged();
            } else {
                list.setVisibility(View.GONE);
            }
        });

        viewModel.getCountryError().observe(getActivity(), error -> {
            progress.setVisibility(View.GONE);
            if(error) {
                Toast.makeText(getActivity(), getString(R.string.error_message), Toast.LENGTH_SHORT).show();
                retryButton.setVisibility(View.VISIBLE);
            } else {
                retryButton.setVisibility(View.GONE);
            }
        });
    }

    public void onRetry(View view) {
        viewModel.onRefresh();
        list.setVisibility(View.GONE);
        retryButton.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MVVMActivity.class);
    }
}
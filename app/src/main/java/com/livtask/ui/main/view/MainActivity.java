package com.livtask.ui.main.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.livtask.ApplicationController;
import com.livtask.R;
import com.livtask.databinding.ActivityMainBinding;
import com.livtask.ui.main.viewmodel.MainViewModel;
import com.livtask.util.Constant;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        setContentView(mainBinding.getRoot());
        setUpViews();
        updateStrings();
    }

    private void updateStrings() {
        mainBinding.textViewTitle.setText(getResources().getString(R.string.title));
        mainBinding.textViewName.setText(getResources().getString(R.string.name));
    }
    /**
     * Language Button Click Listener setup.
     */
    private void setUpViews() {
        mainBinding.buttonLangTelugu.setOnClickListener(this::onTeluguClicked);
        mainBinding.buttonLangHindi.setOnClickListener(this::onHindiClicked);
        mainBinding.buttonLangSpanish.setOnClickListener(this::onSpanishClicked);
        mainBinding.buttonLangEnglish.setOnClickListener(this::OnEnglishClicked);
    }

    private void onTeluguClicked(View view) {
        ApplicationController.languageKey = Constant.TELUGU;
        updateStrings();
    }

    private void onHindiClicked(View view) {
        ApplicationController.languageKey = Constant.HINDI;
        updateStrings();
    }

    private void onSpanishClicked(View view) {
        ApplicationController.languageKey = Constant.SPANISH;
        updateStrings();
    }

    private void OnEnglishClicked(View view) {
        ApplicationController.languageKey = Constant.ENGLISH;
        updateStrings();
    }
}
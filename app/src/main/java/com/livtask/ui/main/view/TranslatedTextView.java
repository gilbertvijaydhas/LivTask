package com.livtask.ui.main.view;


import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.livtask.ApplicationController;

public class TranslatedTextView extends AppCompatTextView {

    public TranslatedTextView(@NonNull Context context) {
        super(context);
    }

    public TranslatedTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TranslatedTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        String titleString = null;
        try {
            titleString = ApplicationController.languageJsonObject.getJSONObject(text.toString()).getString(ApplicationController.languageKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(TextUtils.isEmpty(titleString)) {
            super.setText(text, type);
        } else {
            super.setText(titleString, type);
        }

    }

}

package com.livtask;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.livtask.ui.main.viewmodel.MainViewModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class MainViewModelTest {

    private MainViewModel SUT;

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Before
    public void setUp() throws Exception {
        SUT = new MainViewModel();
        SUT.title.postValue("Title");
        SUT.name.postValue("Name");
    }

    @Test
    public void applyTransformation_wrongKey_applyTranslationNeverCalled(){

    }

    @Test
    public void applyTranslation_wrongKey_noChangeInUI() {
        SUT.applyTranslation("hi");
        Assert.assertEquals("Title",SUT.title.getValue());
        Assert.assertEquals("Name",SUT.name.getValue());
    }


}
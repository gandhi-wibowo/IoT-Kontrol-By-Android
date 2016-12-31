package com.skripsi.saklarnyagandhi.fragment;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import com.skripsi.saklarnyagandhi.R;

/**
 * Created by gandhi on 12/30/16.
 */

public class TorchFragment extends Fragment {
    ToggleButton toggleButton;

    @SuppressWarnings("deprecation")
    Camera kamera;

    public TorchFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.torch_fragment, container, false);


        toggleButton = (ToggleButton) v.findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(v == toggleButton){
                    try{
                        if(toggleButton.isChecked()){
                            kamera = Camera.open();
                            Camera.Parameters params = kamera.getParameters();
                            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                            kamera.setParameters(params);
                            kamera.startPreview();
                        } else {
                            Camera.Parameters params = kamera.getParameters();
                            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                            kamera.setParameters(params);
                            kamera.stopPreview();
                            kamera.release();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("exceptionku", e.getMessage());
                    }
                }
            }
        });
        return v;
    }
}

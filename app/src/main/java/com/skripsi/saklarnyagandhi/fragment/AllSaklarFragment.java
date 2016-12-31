package com.skripsi.saklarnyagandhi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.skripsi.saklarnyagandhi.Constant;
import com.skripsi.saklarnyagandhi.MainActivity;
import com.skripsi.saklarnyagandhi.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gandhi on 12/30/16.
 */

public class AllSaklarFragment extends Fragment {
    Button onAll, offAll;

    public AllSaklarFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.all_saklar, container, false);

        onAll = (Button) v.findViewById(R.id.onAll);
        onAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // post hidupkan semua
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant.url_saklar,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Intent intent = new Intent(getActivity(),MainActivity.class);
                                startActivity(intent);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Intent intent = new Intent(getActivity(),MainActivity.class);
                                startActivity(intent);
                            }
                        }
                ) {
                    @Override
                    public String getBodyContentType() {
                        return "application/x-www-form-urlencoded";
                    }

                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("OnAll", "hidup");
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(stringRequest);

            }
        });
        offAll = (Button) v.findViewById(R.id.offAll);
        offAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // post matikan semua

                StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant.url_saklar,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Intent intent = new Intent(getActivity(),MainActivity.class);
                                startActivity(intent);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Intent intent = new Intent(getActivity(),MainActivity.class);
                                startActivity(intent);
                            }
                        }
                ) {
                    @Override
                    public String getBodyContentType() {
                        return "application/x-www-form-urlencoded";
                    }

                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("OffAll", "mati");
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(stringRequest);
            }
        });

        return v;
    }

}

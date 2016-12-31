package com.skripsi.saklarnyagandhi.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.skripsi.saklarnyagandhi.Constant;
import com.skripsi.saklarnyagandhi.R;
import com.skripsi.saklarnyagandhi.RenameGas;
import com.skripsi.saklarnyagandhi.adapter.CustomListGas;
import com.skripsi.saklarnyagandhi.model.Saklar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gandhi on 12/30/16.
 */

public class GasFragment extends Fragment {
    private ProgressDialog pDialog;
    private List<Saklar> saklarList = new ArrayList<Saklar>();
    private ListView listView;
    private CustomListGas adapter;
    public GasFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.gas_fragment, container, false);

        saklarList.clear();
        listView = (ListView) v.findViewById(R.id.list);
        adapter = new CustomListGas(getActivity(),saklarList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(v.getContext());
        pDialog.setMessage("Loading...");
        pDialog.show();

        GetSaklar();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Saklar listSaklar = saklarList.get(position);
                Intent intent = new Intent(getActivity(), RenameGas.class);
                Bundle b = new Bundle();
                b.putString("id_saklar",listSaklar.getIdSaklar());
                b.putString("nama_saklar",listSaklar.getNamaSaklar());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        return v;
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void GetSaklar(){
        JsonArrayRequest saklarReq = new JsonArrayRequest(Constant.url_gas,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                Saklar saklar = new Saklar();
                                saklar.setIdSaklar(obj.getString("id_gas"));
                                saklar.setNamaSaklar(obj.getString("nama_gas"));
                                saklar.setStatusSaklar(obj.getString("status_gas"));
                                saklarList.add(saklar);
                                hidePDialog();

                            } catch (JSONException e) {
                                e.printStackTrace();
                                hidePDialog();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Errornya tuh disini :" + error);
                hidePDialog();
            }
        });
        Volley.newRequestQueue(getActivity()).add(saklarReq);
    }
}

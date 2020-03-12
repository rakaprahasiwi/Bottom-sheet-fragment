package com.prahasiwi.bottomsheet.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.prahasiwi.bottomsheet.R;
import com.prahasiwi.bottomsheet.adapter.ListTemanAdapter;
import com.prahasiwi.bottomsheet.model.Teman;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BottomSheetListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottomSheetListFragment extends Fragment implements ListTemanAdapter.ListTemanAdapterListener {
    private RecyclerView rv_listteman;
    private ListTemanAdapter adapter;
    private List<Teman> list = new ArrayList<>();

    private ImageView iv_backButton;
    private FrameLayout root;
    private ConstraintLayout dialog_fp;

    Animation slide_up, slide_down;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Context context;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BottomSheetListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BottomSheetListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BottomSheetListFragment newInstance(String param1, String param2) {
        BottomSheetListFragment fragment = new BottomSheetListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bottom_sheet_list, container, false);
        context = getContext();

        initComponent(v);

        return v;
    }

    private void initComponent(View v) {
        iv_backButton = v.findViewById(R.id.iv_backButton);
        dialog_fp = v.findViewById(R.id.dialog_fp);
        rv_listteman = v.findViewById(R.id.rv_listteman);

        slide_down = AnimationUtils.loadAnimation(getContext().getApplicationContext(), R.anim.slide_down);
        slide_up = AnimationUtils.loadAnimation(getContext().getApplicationContext(), R.anim.slide_up);

        root = v.findViewById(R.id.root);
        dialog_fp.startAnimation(slide_up);

        getTeman();

        rv_listteman.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_listteman.setNestedScrollingEnabled(false);
        adapter = new ListTemanAdapter(this);
        adapter.setData(list);
        rv_listteman.setAdapter(adapter);

        iv_backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog_fp.startAnimation(slide_down);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        onBackPressed();
                    }
                }, 400);
            }
        });

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void getTeman() {
        list.clear();
        list.add(new Teman("Abu", "Jakarta", "12/12/2011"));
        list.add(new Teman("John", "Semarang", "12/12/2011"));
        list.add(new Teman("Obi mikel", "Bandung", "12/12/2011"));
        list.add(new Teman("Morata", "Jogja", "12/12/2011"));
        list.add(new Teman("Bepe", "Solo", "12/12/2011"));
    }

    public void onBackPressed() {
        getActivity().onBackPressed();
    }

    @Override
    public void onClickListTemanAdapter(int position) {

    }
}

package com.madonasyombua.growwithgoogleteamproject.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.madonasyombua.growwithgoogleteamproject.R;
import com.madonasyombua.growwithgoogleteamproject.actvities.ProjectsActivity;
import com.madonasyombua.growwithgoogleteamproject.adapter.PortfolioAdapter;
import com.madonasyombua.growwithgoogleteamproject.interfaces.OnFragmentInteractionListener;
import com.madonasyombua.growwithgoogleteamproject.models.Project;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * to handle interaction events.
 * Use the {@link ProjectsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProjectsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<Project> projectList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PortfolioAdapter mAdapter;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProjectsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProjectsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProjectsFragment newInstance(String param1, String param2) {
        ProjectsFragment fragment = new ProjectsFragment();
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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_projects, container, false);
        recyclerView = view.findViewById(R.id.portfolio_recycler_view);


        mAdapter = new PortfolioAdapter(projectList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        FloatingActionButton addProject = view.findViewById(R.id.add_project);
        if (addProject != null){
            addProject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openProjectsActivity(view);
                }
            });
        }

        testPortfolioData();


        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }

    }

    private void openProjectsActivity(@SuppressWarnings("unused") View view) {
        Intent intent = new Intent(this.getActivity(), ProjectsActivity.class);
        startActivity(intent);
        Toast.makeText(getContext(), "Adding Project", Toast.LENGTH_SHORT).show();

    }

    private void testPortfolioData() {
        Project project = new Project("Simple Maths", "Android Application", "Simple Maths is a" +
                "mobile app project that I did for kids. It's a learning app for Arithmetic", R.drawable.ic_facebook, "http://www.facebook.com");
        projectList.add(project);

        project = new Project("Essay Tutors", "Web Development", "This is an online tutoring network" +
                "for teachers and students.", R.drawable.logo, "http://www.udacity.com");
        projectList.add(project);

        project = new Project("Budgeting Buddy", "Android Development", "This is a budgeting planner" +
                " and expense tracking mobile device for Android devices.", R.drawable.ic_google, "https://www.google.com");
        projectList.add(project);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        ((AppCompatActivity)(context)).getSupportActionBar().setTitle(getString(R.string.projects));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}

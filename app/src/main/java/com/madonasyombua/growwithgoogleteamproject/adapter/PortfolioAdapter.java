package com.madonasyombua.growwithgoogleteamproject.adapter;

/**
 * Created by jantz on 2/18/2018.
 */

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.madonasyombua.growwithgoogleteamproject.R;
import com.madonasyombua.growwithgoogleteamproject.models.Project;

import java.util.List;

public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.MyViewHolder> {

    private List<Project> projectList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, longDescription, shortDescription;
        public ImageView portfolioImage;
        public Button btnView;
        private String url;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            shortDescription = (TextView) view.findViewById(R.id.shortDescription);
            longDescription = (TextView) view.findViewById(R.id.longDescription);
            portfolioImage = (ImageView) view.findViewById(R.id.portfolio_image);
            btnView = (Button) view.findViewById(R.id.btn_view);
            btnView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    v.getContext().startActivity(i);

                }
            });

        }
    }


    public PortfolioAdapter(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.portfolio_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Project project = projectList.get(position);
        holder.title.setText(project.getTitle());
        holder.shortDescription.setText(project.getShortDescription());
        holder.longDescription.setText(project.getLongDescription());
        holder.portfolioImage.setImageResource(project.getPortfolioImage());
        holder.url = project.getUrl();
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }
}

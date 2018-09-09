package projects.condorlabs.com.laligaapp.app.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import projects.condorlabs.com.laligaapp.R;
import projects.condorlabs.com.laligaapp.app.ui.listener.TeamListListener;
import projects.condorlabs.com.laligaapp.domain.model.TeamModel;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder>{

    private Context context;
    private TeamListListener listener;
    private List<TeamModel> teamModelList;

    public TeamsAdapter(Context context, TeamListListener listener, List<TeamModel> teamModelList){
        this.context = context;
        this.listener = listener;
        this.teamModelList = teamModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_team, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final TeamModel teamModel = teamModelList.get(position);
        if(teamModel != null){
            holder.tviTeamName.setText(teamModel.getTeamName());
            holder.tviTeamStadium.setText(teamModel.getStadiumName());
            Picasso.with(context).load(teamModel.getTeamBadge()).into(holder.iviTeamBadge);
            holder.claTeam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.goToTeamDetail(teamModel);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return teamModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout claTeam;
        private ImageView iviTeamBadge;
        private TextView tviTeamName;
        private TextView tviTeamStadium;

        public ViewHolder(View view) {
            super(view);
            claTeam = (ConstraintLayout) view.findViewById(R.id.claTeam);
            iviTeamBadge = (ImageView) view.findViewById(R.id.iviTeamBadge);
            tviTeamName = (TextView) view.findViewById(R.id.tviTeamName);
            tviTeamStadium = (TextView) view.findViewById(R.id.tviTeamStadium);
        }
    }
}

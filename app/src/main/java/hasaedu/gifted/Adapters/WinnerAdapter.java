package hasaedu.gifted.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import hasaedu.gifted.Models.ArchiveWinner;
import hasaedu.gifted.R;


/**
 * Created by Ashraf on Mar 06, 2015.
 */
public class WinnerAdapter extends ArrayAdapter<ArchiveWinner> {

    public WinnerAdapter(Context context, ArrayList<ArchiveWinner> winners) {
        super(context, 0, winners);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ArchiveWinner winner = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_winner, parent, false);
        }
        // Lookup view for data population
        TextView winnerName = (TextView) convertView.findViewById(R.id.winnerName);
        TextView winnerdesc = (TextView) convertView.findViewById(R.id.winnerinfo);
        // Populate the data into the template view using the data object
        winnerName.setText(winner.WinnerName);
        winnerdesc.setText(winner.WinnerInfo);
        // Return the completed view to render on screen
        return convertView;
    }

}

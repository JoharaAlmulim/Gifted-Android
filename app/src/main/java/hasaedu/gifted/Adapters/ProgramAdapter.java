package hasaedu.gifted.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import hasaedu.gifted.Models.Program;
import hasaedu.gifted.R;

/**
 * Created by Ashraf on Mar 05, 2015.
 */
public class ProgramAdapter extends ArrayAdapter<Program> {

    public ProgramAdapter(Context context, ArrayList<Program> programs) {
        super(context, 0, programs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Program program = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_program, parent, false);
        }
        // Lookup view for data population
        TextView programName = (TextView) convertView.findViewById(R.id.programName);
        TextView programdesc = (TextView) convertView.findViewById(R.id.programdesc);
        // Populate the data into the template view using the data object
        programName.setText(program.ProgramName);
        programdesc.setText(program.ProgramDesc);
        // Return the completed view to render on screen
        return convertView;
    }

}

package gr.aueb.animalshelter.Utils;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import gr.aueb.animalshelter.R;

public class ObligationsListViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nameView, descriptionView;


    public ObligationsListViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView    );
        nameView = itemView.findViewById(R.id.name);
        descriptionView = itemView.findViewById(R.id.description);
    }
}

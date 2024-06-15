package gr.aueb.animalshelter.Adapters;

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
        imageView = itemView.findViewById(R.id.obligationPic);
        nameView = itemView.findViewById(R.id.obligationAnimalName);
        descriptionView = itemView.findViewById(R.id.obligationDescription);
    }
}

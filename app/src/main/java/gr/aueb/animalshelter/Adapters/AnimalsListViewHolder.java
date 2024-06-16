package gr.aueb.animalshelter.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import gr.aueb.animalshelter.R;

public class AnimalsListViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nameView;

    public AnimalsListViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.animalPic);
        nameView = itemView.findViewById(R.id.animalName);
    }
}

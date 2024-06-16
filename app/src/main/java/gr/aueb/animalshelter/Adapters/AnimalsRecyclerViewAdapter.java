package gr.aueb.animalshelter.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import gr.aueb.animalshelter.R;

public class AnimalsRecyclerViewAdapter extends RecyclerView.Adapter<AnimalsListViewHolder> {
    Context context;
    List<AnimalItem> animalsList;

    public AnimalsRecyclerViewAdapter(Context context, List<AnimalItem> animalsList) {
        this.context = context;
        this.animalsList = animalsList;
    }

    @NonNull
    @Override
    public AnimalsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnimalsListViewHolder(LayoutInflater.from(context).inflate(R.layout.animals_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalsListViewHolder holder, int position) {
        holder.nameView.setText(animalsList.get(position).getName());
        holder.imageView.setImageResource(animalsList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return animalsList.size();
    }
}

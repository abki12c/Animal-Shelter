package gr.aueb.animalshelter.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import gr.aueb.animalshelter.R;

public class ObligationsRecyclerViewAdapter extends RecyclerView.Adapter<ObligationsListViewHolder> {

    Context context;
    List<ObligationItem> items;

    public ObligationsRecyclerViewAdapter(Context context, List<ObligationItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ObligationsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ObligationsListViewHolder(LayoutInflater.from(context).inflate(R.layout.obligation_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ObligationsListViewHolder holder, int position) {
        holder.nameView.setText(items.get(position).getName());
        holder.descriptionView.setText(items.get(position).getDescription());
        holder.imageView.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

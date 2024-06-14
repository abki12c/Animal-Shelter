package gr.aueb.animalshelter.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.domain.Animal;

public class MyAdapter extends BaseAdapter
{
    private Context context;

    private boolean details=false;
    private LayoutInflater inflater;
    private List<Animal> dataSource, rawDataSource;

    /**
     * Constructor
     * @param context activity context
     * @param details true if we want a detailed view of the object(animal)
     * false if we want just the picture,name and button for more
     * info
     */
    public MyAdapter(Context context,boolean details)
    {
        this.context = context;
        this.details=details;
        dataSource = rawDataSource = new ArrayList<>();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Returns size of the list
     * @return list size
     */

    @Override
    public int getCount()
    {
        return dataSource.size();
    }

    /**
     * Returns object based on its position in the list
     * @param position object position
     * @return the object
     */
    @Override
    public Object getItem(int position)
    {
        return dataSource.get(position);
    }

    /**
     * Returns id based on object position
     * @param position object position
     * @return object id
     */
    @Override
    public long getItemId(int position)
    {
        return position;
    }

    /**
     * Creates view based on object position.
     * @param position object position
     * @param convertView not used
     * @param parent view parent
     * @return view
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        Animal attachedAnimal = (Animal) getItem(position);
        if(!details) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.animal_item_brief, null);
            }
            ImageView imageView = convertView.findViewById(R.id.item_image);
            setImage(imageView,attachedAnimal);

            ((TextView) convertView.findViewById(R.id.item_name)).setText(attachedAnimal.getName());

            final Button buy = convertView.findViewById(R.id.buttonMoreInfo);
            buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((GridView) parent).performItemClick(v, position, 0);
                }
            });
        }else{
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.animal_details, null);
            }
            ImageView imageView = convertView.findViewById(R.id.animalPic);
            setImage(imageView,attachedAnimal);


            ((TextView) convertView.findViewById(R.id.animalName)).setText(attachedAnimal.getName());
            ((TextView) convertView.findViewById(R.id.type)).setText(attachedAnimal.getType());
            ((TextView) convertView.findViewById(R.id.breed)).setText(attachedAnimal.getBreed());
            ((TextView) convertView.findViewById(R.id.age)).setText(attachedAnimal.getAge()+"");
            ((TextView) convertView.findViewById(R.id.gender)).setText(attachedAnimal.getGender());
            ((TextView) convertView.findViewById(R.id.chipped)).setText(attachedAnimal.getChipped() ? "yes" : "no");
            ((TextView) convertView.findViewById(R.id.description)).setText(attachedAnimal.getDescription());


        }

        return convertView;


    }

    public void setImage(ImageView imageView, Animal attachedAnimal){
        Bitmap bitmap = null;
        try {
            FileInputStream fis = context.openFileInput(attachedAnimal.getImageName());
            bitmap = BitmapFactory.decodeStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    /**
     * Loads data from source
     * @param dataSource list of animals
     */
    public void loadSource(List<Animal> dataSource)
    {
        this.dataSource = dataSource;
        Collections.reverse(this.dataSource);

        this.rawDataSource = dataSource.subList(0, dataSource.size());//shallow copy
        notifyDataSetChanged();
    }


    //FILTER BELOW-NOT NEEDED FOR ADOPTER




    /**
     * Returns filter
     * @return filter
     */
   /* public Filter getFilter()
    {
        return mFilter;
    }*/

    /**
     * Animal Filter by type
     */
   /* private class ItemFilter extends Filter
    {
        /**
         * Publishes filtered results
         * @param constraint Constraint String
         * @param results results
         */
      //  @Override
      /*  protected void publishResults(CharSequence constraint, FilterResults results)
        {
            dataSource = (List<Animal>)results.values;
            notifyDataSetChanged();
        }

        /**
         * ΦFilters results
         * @param constraint Constraint string
         * @return filtered results
         */
       // @Override
       /* protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();
            FilterResults results = new FilterResults();
            List<Animal> matches = new ArrayList<>();

            for(Animal a : rawDataSource)
                if (a.getType().toLowerCase().equals(filterString))
                    matches.add(a);

            results.values = matches;
            results.count = matches.size();

            return results;
        }
    }*/
}
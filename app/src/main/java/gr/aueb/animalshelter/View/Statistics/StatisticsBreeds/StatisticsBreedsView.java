package gr.aueb.animalshelter.View.Statistics.StatisticsBreeds;

import android.widget.TextView;

import java.util.List;

public interface StatisticsBreedsView {

    public TextView getTextView();

    /**
     * Loads list of animal breeds for the search bar
     * @param input the list.
     */
    void loadBreeds(List<String> input);
    /**
     * When user clicks on adoption requests button on the menu
     * it loads the manageAdoptionRequestsActivity if not in activity already
     */
    void viewHomePage();
    /**
     * When user clicks on the settings button from the Home Page
     * it loads the corresponding activity for the settings, if not in activity already
     */
    void manageSettings();

    /**
     * When user clicks on the statistics button from the Home Page
     * it loads the manageStatisticsActivity if not in activity already
     */
    void manageStatistics();

    /**
     * When user clicks on the obligations button from the Home Page
     * it loads the manageObligationsActivity if not in activity already
     */
    void manageObligations();

    /**
     * When user clicks on the animals button from the Home Page
     * it loads the manageAnimalsActivity if not in activity already
     */
    void manageAnimals();
}

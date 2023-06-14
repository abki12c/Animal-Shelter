package gr.aueb.animalshelter.domain;

import java.time.LocalDateTime;


/** Class for the adoption of an {@link Animal} by an {@link Adopter}.  <p>
 * The adoption is one that is already completed and the animal is to be taken out of the animal Shelter or has already been taken out of there.
 */
public class Adoption {

    private LocalDateTime adoptionTime;
    private AdoptionRequest adoptionRequest;

    private int id;

    private static int lastAdoptionId = 0;

    public Adoption(AdoptionRequest adoptionRequest){

        this.adoptionRequest = adoptionRequest;
        this.adoptionTime = LocalDateTime.now();
        this.id = NextAdoptionID();
    }


    public LocalDateTime getAdoptionTime() {
        return adoptionTime;
    }


    public AdoptionRequest getAdoptionRequest() {
        return adoptionRequest;
    }

    public void setAdoptionRequest(AdoptionRequest adoptionRequest) {
        this.adoptionRequest = adoptionRequest;
    }

    public int getID() {
        return id;
    }

    public static int NextAdoptionID(){

        return ++lastAdoptionId;
    }
}
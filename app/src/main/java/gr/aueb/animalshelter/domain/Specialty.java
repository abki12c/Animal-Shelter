package gr.aueb.animalshelter.domain;

import java.io.Serializable;

/** Class for the specialty of a subordinate {@link Employee}
 * @author Komnas Kafasis
 */
public enum Specialty implements Serializable {

    cleaning,
    medical_care,
    vet,
    bureaucratic_tasks,
    nutritionist
}

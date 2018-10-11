/*
 * The TeamMember enum file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package model;

/**
 *
 * @author Gail Lee
 */
public enum TeamMember {
    GAIL_LEE("Gail Lee", "Empress"),
    CAROLYN_MURRAY("Carolyn Murray", "Master"),
    DRAZEN_LUCIC("Drazen Lucic", "Guitarist");
    
    private final String name;
    private final String title;

    TeamMember(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
}

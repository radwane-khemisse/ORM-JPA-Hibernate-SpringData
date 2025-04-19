package ma.enset.hospital.entities;

import jakarta.persistence.Entity;

import java.util.Collection;
import java.util.Date;
public class Patient {
    private Long id;
    private String nom;
    private Date dateNaissance;
    private boolean malade;
    private int score;

    private Collection<RendezVous> rendezVous;

}

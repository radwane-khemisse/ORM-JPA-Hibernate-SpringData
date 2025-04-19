package ma.enset.hospital.entities;

import java.util.Collection;

public class Medecin {
    private Long id;
    private String nom;
    private String email;
    private String specialite;
    private Collection<RendezVous> rendezVous;

}

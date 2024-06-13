package model;

import enums.DeltagerStatus;

public class Deltagelse {

    private boolean registreret;
    private DeltagerStatus status;
    private Lektion lektion;
    private Studerende studerende;

    public Deltagelse(boolean registreret, DeltagerStatus status, Lektion lektion, Studerende studerende) {
        this.registreret = registreret;
        this.status = status;
        this.lektion = lektion;
        this.studerende = studerende;
    }

    public boolean isRegistreret() {
        return registreret;
    }

    public DeltagerStatus getStatus() {
        return status;
    }

    public Lektion getLektion() {
        return lektion;
    }

    public Studerende getStuderende() {
        return studerende;
    }

    public boolean erRegistreretFraværende() {
        if (registreret == true && status == DeltagerStatus.FRAVÆR) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Hej";
    }
}

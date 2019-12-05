package com.hyte.fysio;

/** Luokassa luodaan olio "Muscle", jolle annetaan parametreina nimi, liikkeen nimi, liikeohjeistus,
 * kuva ja lihaksen tiedot sekä getterit jokaiselle parametrille.
 * @author Santeri
 * pvm 28.12.2019, 5.12.2019
 */

public class Muscle {

    /**
     * "Muscle"-olion parametrien luonti
     */
    private String muscleName;
    private String exerciseName;
    private String exerciseInstructions;
    private String exerciseImage;
    private String muscleInfo;

    /**
     *Konstruktori
     */

    public Muscle(String muscleName, String exerciseName, String exerciseInstructions, String exerciseImage, String muscleInfo) {
        this.muscleName = muscleName;
        this.exerciseName = exerciseName;
        this.exerciseInstructions = exerciseInstructions;
        this.exerciseImage = exerciseImage;
        this.muscleInfo = muscleInfo;
    }

    /**
     *Getterit ja toString -metodi
     */

    public String getImageName() {
        return exerciseImage;
    }

    public String getInstructions() {
        return exerciseInstructions;
    }

    public String getMuscleName() {
        return muscleName;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getMuscleInfo() {
        return muscleInfo;
    }


    @Override
    public String toString() {
        return this.exerciseName;
    }
}

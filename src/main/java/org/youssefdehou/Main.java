package org.youssefdehou;

import java.util.*;

class GestionNotes{

    private Map<Integer, List<Integer>> NotesByWeek = new HashMap<>();

    public boolean isSemaineValide(int semaine){
        int prochaineSemaine = NotesByWeek.size() + 1;
        return semaine >= 1 && semaine <= 18 && semaine == prochaineSemaine;
    }

    public boolean isNotesofweek(List<Integer> notes, int semaine){

        if(!isSemaineValide(semaine) || (notes.size() != 5)){
            return false;
        }

        for( int note : notes){
                if(note < 1 || note > 9){
                    return false;
                }
        }
        NotesByWeek.put(semaine, new ArrayList<>(notes));
        return true;
    }


    public void affichageDashboardNotesByWeek(){

        for(int semaine = 1; semaine <= NotesByWeek.size(); semaine++){
            int min = NotesByWeek.get(semaine).get(0);
            for(int note = 0; note < NotesByWeek.get(semaine).size(); note++){

                if(NotesByWeek.get(semaine).get(note) < min){
                    min = NotesByWeek.get(semaine).get(note);
                }


            }

            System.out.print(" Week " + semaine);

            for (int note = 1; note <= min; note++) {
                System.out.print("=");
            }
            System.out.println(">");
        }


    }



}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GestionNotes gestionNotes = new GestionNotes();

        //lire les données semaine et detreminer si valide ou non

        System.out.print("-> Week ");

        int semaine = scanner.nextInt();

        while (semaine != 42) {
            if (!gestionNotes.isSemaineValide(semaine)) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }

            List<Integer> notes = new ArrayList<>();

            for (int i = 1; i < 6; i++) {

                System.out.print("-> ");
                notes.add(scanner.nextInt());

            }

            if(!gestionNotes.isNotesofweek(notes, semaine)){
                System.err.println("IllegalArgument");
                System.exit(-1);
            }

            System.out.print("-> Week ");

            semaine = scanner.nextInt();

        }

            gestionNotes.affichageDashboardNotesByWeek();




    }
}
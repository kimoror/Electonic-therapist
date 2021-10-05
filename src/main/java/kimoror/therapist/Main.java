package kimoror.therapist;


public class Main {
    public static void main(String[] args) {
        Therapist therapist = new Therapist();
        therapist.setCurrentClient(new Client());
        therapist.setClientName();
        therapist.setClientSex();
        therapist.setClientAge();
        therapist.setClientPainType();
        therapist.healing();

    }
}

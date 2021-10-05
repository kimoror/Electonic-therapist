package kimoror.therapist;

public enum QuestionsBase {
    NAME("Укажите своё имя?"),
    SEX("Укажите свой пол? (М или Ж)"),
    AGE("Сколько вам лет?"),
    WHAT_PAIN("Что у вас болит?"),
    HEAD_ACHE("Если у вас болит голова - нажмите 1"),
        HEAD_TWO_DAYS("Болит больше двух дней?"),
        HEAD_THROBBING_PAIN("Боль режущая?"),
            HIGH_PRESSURE("Давление повышенное?"),
            LOW_PRESSURE("Давление пониженное?"),
        HEAD_NERVOUS("Вы нервничали последние 3 дня?"),
    BELLY_ACHE("Если у вас болит живот - нажмите 2"),
        BELLY_DIARRHEA("У вас есть диарея?"),
        BELLY_NAGGING_PAIN("Боль ноющая?"),
        BELLY_URINA_BLOOD("Есть кровь при мочеиспускании?"),
        BELLY_ALCOHOL("Вы часто употребляете алкоголь?"),
    BLACK_EYE_ACHE("Если у вас болит чёрные пятна перед глазами - нажмите 3"),
        EYE_FAINTING("Вы часто падаете в обморок?"),
        EYE_PRESSURE_DROPS("У вас часто есть перепады давления?"),
        EYE_BANGING("Вы ударялись головой?"),
    TEMPERATURE_ACHE("Если у вас температура - нажмите 4"),
        TEMPERATURE_COVID("Вы переболели ковидом?"),
            SMELLS("Вы чувствуете запахи?"),
            COUGH("У вас есть кашель?"),
    COLD("Если у вас насморк или болит горло - нажмите 5"),
        COLD_ALLERGY("У вас есть аллергия на что-то?"),
        DRY_COUGH("У вас сухой кашель?")
    ;

    private final String question;
    QuestionsBase(String question){
        this.question = question;
    }

    public String getQuestion() {return question;}
}

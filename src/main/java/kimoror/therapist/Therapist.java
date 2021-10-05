package kimoror.therapist;

import kimoror.therapist.Client;
import kimoror.therapist.QuestionsBase;

import java.util.Objects;
import java.util.Scanner;

public class Therapist {
    private Client currentClient;
    private Scanner scanner;

    public void setCurrentClient(Client currentClient) {
        this.currentClient = currentClient;
    }

    public Client getCurrentClient(){
        return currentClient;
    }

    public void setClientName(){
        scanner = new Scanner(System.in);
        System.out.println(QuestionsBase.NAME.getQuestion());
        String name = scanner.nextLine();
        while(name.matches("[0-9]+") || name.equals("")){
            System.out.println("Введите имя буквами:");
            name = scanner.nextLine();
        }
        currentClient.setName(name);

    }

    public void setClientSex(){
        scanner = new Scanner(System.in);
        System.out.println(QuestionsBase.SEX.getQuestion());
        String sex = scanner.nextLine();
        while (!Objects.equals(sex, "М") && !Objects.equals(sex, "Ж")){
            System.out.println("Введите только букву М или Ж:");
            sex = scanner.nextLine();

        }
        currentClient.setSex(sex);
    }

    public void setClientAge(){
        scanner = new Scanner(System.in);
        System.out.println(QuestionsBase.AGE.getQuestion());
        String age = scanner.nextLine();
        while(!age.matches("\\d+")){
            System.out.println("Введите возраст как целое число:");
            age = scanner.nextLine();
        }
        currentClient.setAge(Integer.parseInt(age));
    }

    public void setClientPainType(){
        scanner = new Scanner(System.in);
        System.out.println(QuestionsBase.HEAD_ACHE.getQuestion());
        System.out.println(QuestionsBase.BELLY_ACHE.getQuestion());
        System.out.println(QuestionsBase.BLACK_EYE_ACHE.getQuestion());
        System.out.println(QuestionsBase.TEMPERATURE_ACHE.getQuestion());
        System.out.println(QuestionsBase.COLD.getQuestion());
        String painType = scanner.nextLine();
        while(!painType.matches("[1-5]")){
            System.out.println("Введите цифру от 1 до 5");
            painType = scanner.nextLine();
        }
        currentClient.setPainType(Integer.parseInt(painType));
    }

     public void healing(){
        switch (currentClient.getPainType()){
            case 1:
                headHealing();
                break;
            case 2:
                bellyHealing();
                break;
            case 3:
                blackEyeHealing();
                break;
            case 4:
                temperatureHealing();
                break;
            case 5:
                coldHealing();
                break;
        }
     }

    private void coldHealing() {
        System.out.println(QuestionsBase.COLD_ALLERGY.getQuestion());
        final boolean coldAllergy = getClientHealingAnswer();
        System.out.println(QuestionsBase.DRY_COUGH.getQuestion());
        final boolean dryCough = getClientHealingAnswer();
        if(coldAllergy){
            System.out.println("Ваш диагноз: две недели пить по одной таблетке «Зодак» в день");
        } else if(dryCough){
            System.out.println("Ваш диагноз: у вас ОРВИ");
        } else {
            System.out.println("Ваш диагноз: у вас гайморит");
        }
    }

    private void temperatureHealing() {
        System.out.println(QuestionsBase.TEMPERATURE_COVID.getQuestion());
        final boolean temperatureCovid = getClientHealingAnswer();
        if(!temperatureCovid){
            System.out.println(QuestionsBase.SMELLS.getQuestion());
            final boolean covidSmells= getClientHealingAnswer();
            System.out.println(QuestionsBase.COUGH.getQuestion());
            final boolean covidCough= getClientHealingAnswer();
            if(covidCough && !covidSmells){
                System.out.println("Ваш диагноз: У вас Ковид. Оставайтесь дома, вы посажены на самоизоляцию.");
            }
        } else{
            System.out.println("Ваш диагноз: простуда");
        }
    }

    private void blackEyeHealing() {
        System.out.println(QuestionsBase.EYE_FAINTING.getQuestion());
        final boolean eyeFainting = getClientHealingAnswer();
        System.out.println(QuestionsBase.EYE_PRESSURE_DROPS.getQuestion());
        final boolean eyePressureDrops = getClientHealingAnswer();
        System.out.println(QuestionsBase.EYE_BANGING.getQuestion());
        final boolean eyeBanging = getClientHealingAnswer();
        if(eyeFainting){
            System.out.println("Ваш диагноз: больше спите, отдыхайте. Пейте глюкозу и кордиамин");
        }else if(eyePressureDrops){
            System.out.println("Ваш диагноз: «Пятна могут появляться из-за частого перепад давления. Выдано направление к кардиологу.»");
        } else if(eyeBanging){
            System.out.println("Ваш диагноз: возможно черепно-мозговая травма. Выдано направление на МРТ. После результатов обследования ждём вас снова");
        } else {
            System.out.println("Ваш диагноз: у вас нарушение кровообращения");
        }
    }

    private void bellyHealing() {
        System.out.println(QuestionsBase.BELLY_DIARRHEA.getQuestion());
        final boolean bellyDiarrhea = getClientHealingAnswer();
        System.out.println(QuestionsBase.BELLY_NAGGING_PAIN.getQuestion());
        getClientHealingAnswer();
        System.out.println(QuestionsBase.BELLY_URINA_BLOOD.getQuestion());
        final boolean bellyUrinaBlood = getClientHealingAnswer();
        System.out.println(QuestionsBase.BELLY_ALCOHOL.getQuestion());
        final boolean bellyAlcohol = getClientHealingAnswer();
        if(bellyDiarrhea){
            System.out.println("Ваш диагноз: отравление - две таблетки фуразалидона перед едой. Сегодня есть только рис");
        } else if(bellyUrinaBlood){
            System.out.println("Ваш диагноз: камни в почках. Выдано направление на приём к хирургу");
        } else if(bellyAlcohol){
            System.out.println("Ваш диагноз: язва ");
        } else{
            System.out.println("Ваш диагноз: гастрит");
        }
    }

    private void headHealing() {
        System.out.println(QuestionsBase.HEAD_TWO_DAYS.getQuestion());
        final boolean headTwoDays = getClientHealingAnswer();
        System.out.println(QuestionsBase.HEAD_THROBBING_PAIN.getQuestion());
        final boolean headThrobbingPain = getClientHealingAnswer();
        if(headThrobbingPain){
            System.out.println(QuestionsBase.HIGH_PRESSURE.getQuestion());
            final boolean highPressure = getClientHealingAnswer();
            if(!highPressure){
                System.out.println(QuestionsBase.LOW_PRESSURE.getQuestion());
                final boolean lowPressure = getClientHealingAnswer();
                if(lowPressure){
                    System.out.println("Ваш диагноз: гипотония. Примите - Кофеин Актив");
                }
            } else{
                System.out.println("Ваш диагноз: гипертония. Примите Капотен");
            }
        }
        System.out.println(QuestionsBase.HEAD_NERVOUS.getQuestion());
        final boolean headNervous = getClientHealingAnswer();
        if(!headTwoDays){
            System.out.println("Если нет - Примите анальгин. Если не поможет? То приходите завтра");
        } else if(headNervous) {
            System.out.println("Ваш диагноз: переутомление, рекомендуется поспать");
        } else{
            System.out.println("Ваш диагноз: мигрень. Примите парацетомол");
        }
    }

     private boolean getClientHealingAnswer(){
        scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        while(!answer.equals("Да") && !answer.equals("Нет") &&
                !answer.equals("да") && !answer.equals("нет")){
            System.out.println("Введите только \"Да\" или \"Нет\"");
            answer = scanner.nextLine();
        }
         return answer.equals("Да") || answer.equals("да");
     }
}

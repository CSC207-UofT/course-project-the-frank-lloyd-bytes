package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * This class just stores String values of title and question for the self-assessment page. Hardcoded for use in UI.
 * The questions are iterated through and produce an entity UCheckQuestion which displays on UCheckQuestionnaireActivity.
 */
public class UCheckQuestions {

    /**
     * @return an ArrayList containing the title and question for UCheck self-assessment.
     */
    public static List<UCheckQuestion> getQuestions() {
        List<UCheckQuestion> UCheckQuestionList = new ArrayList<>();
        UCheckQuestionList.add(new UCheckQuestion("Do any of the following statements apply to you?","\u2022 I am fully vaccinated against COVID-19.\n\n" +
                "\u2022 I am partially vaccinated against COVID-19 and am working with the University towards full vaccination. I will obtain my final dose within 30 days of my last dose and am participating in the University’s rapid screening program until fully vaccinated (14 days following my last dose).\n\n" +
                "\u2022 I have a University-approved exemption and am participating in the rapid screening program.\n\n" +
                "Fully vaccinated means 14 days following the recommended number of doses of a Health Canada-approved vaccine or 14 days after completing a Health Canada-recommended vaccination schedule for those who received non-Health Canada-approved vaccines.\n"));
        UCheckQuestionList.add(new UCheckQuestion("Do any of the following statements apply to you?","Any/all that are new, worsening, and not related to other known causes or conditions you already have.\n\n" +
                "\u2022 Fever and/or chills (Temperature of 37.8 degrees Celsius/100 degrees Fahrenheit or higher)\n\n" +
                "\u2022 Cough or barking cough (croup) (Continuous, more than usual, making a whistling noise when breathing (not related to asthma, post-infectious reactive airways, COPD, or other known causes or conditions you already have))\n\n" +
                "\u2022 Shortness of breath (Out of breath, unable to breathe deeply (not related to asthma or other known causes or conditions you already have))\n\n" +
                "\u2022 Decrease or loss sense of taste or smell (Not related to seasonal allergies, neurological disorders, or other known causes or conditions you already have)\n\n" +
                "\u2022 Muscle aches/joint pain (Unusual, long-lasting (not related to getting a COVID-19 vaccine in the last 48 hours, a sudden injury, fibromyalgia, or other known causes or conditions you already have))\n\n" +
                "\u2022 Extreme tiredness (Unusual, fatigue, lack of energy (not related to getting a COVID-19 vaccine in the last 48 hours, depression, insomnia, thyroid dysfunction, or other known causes or conditions you already have))"));
        UCheckQuestionList.add(new UCheckQuestion("Is anyone you live with currently experiencing any new COVID-19 symptoms and/or waiting for test results after experiencing symptoms?", "If you are fully vaccinated (it has been 14 or more days since your final dose of either a two-dose or a one-dose vaccine series), select “No.”\n\n" +
                "If the person got a COVID-19 vaccination in the last 48 hours and is experiencing mild headache, fatigue, muscle aches, and/or joint pain that only began after vaccination, select “No.”"));
        UCheckQuestionList.add(new UCheckQuestion("In the last 14 days, have you travelled outside of Canada and been told to quarantine (per the federal quarantine requirements)?", "Note: if you have travelled but have received an exemption from the travel quarantine requirements (eg. fully vaccinated etc.), click No."));
        UCheckQuestionList.add(new UCheckQuestion("Has a doctor, health care provider, or public health unit told you that you should currently be isolating (staying at home)?","This can be because of an outbreak or contact tracing."));
        UCheckQuestionList.add(new UCheckQuestion("In the last 10 days, have you been identified as a \"close contact\" of someone who currently has COVID-19?","“Close contact” as determined or identified by a public health authority or the University of Toronto Occupational Health Nurse.\n\n" +
                "If public health has advised you that you do not need to self-isolate (for example, you are fully vaccinated or for another reason), select “No.”"));
        UCheckQuestionList.add(new UCheckQuestion("In the last 14 days, have you received a COVID Alert exposure notification on your cell phone?","If you are fully vaccinated (it has been 14 or more days since your final dose of either a two-dose or a one-dose vaccine series), select “No.”\n\n" +
                "If you already went for a test and got a negative result, select “No.”"));
        UCheckQuestionList.add(new UCheckQuestion("In the last 10 days, have you tested positive on a rapid antigen test or home-based self-testing kit?","If you have since tested negative on a lab-based PCR test, select “No.\""));
        return UCheckQuestionList;
    }
}

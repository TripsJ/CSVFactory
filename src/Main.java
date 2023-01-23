/*Write a program that will create csv files. The csv files will contain the following fields:

firstname: The firstname is a name which will be chosen randomly from a set of 30 firstnames.
Lastname: The lastname is a name which will be chosen randomly from a set of 40 lastnames.
Reason: This value is to be chosen randomly from 2 values: Appointment or visit
Department: This value is a value chosen from 5 values:
Cardiology, Radiology, Pediatrics, Geriatrics, Pulmonology.
This is only to be filled in if the reason of the visit is 'Appointment'
Date of the visit. The date can be something random, but let's keep it in a certain month in the current year.
You can decide how long this file is,
don't make it too long though.
Ideally, this challenge also consists out of multiple classes

Note: This challenge plays with the idea of code reuse.
OO is not about code reuse, however,
randomly picking a value from a fixed set of values is something that can be abstracted out.
The coach should pay attention to this.

A small word on code reuse: Code reuse is only viable when change is out of the equation. In 80% of the cases,
change originates from stakeholders (users, customers, managers, financiers, etc)
and they mostly want feature changes. If this 'random' csv factory was to be a real life feature,
it is very unlikely that one of the stakeholders is interested in how these values were randomly picked.
Nobody cares how these values are randomly pickd.
That means that the chances that it will need to change are very limited.
And this makes it a perfect candidate for an abstraction/code reuse.*/


import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataCreator creator;

        {
            try {
                creator = new DataCreator();
                ArrayList<String>dataset = creator.makeDataset(10);
                CsvWriter writer = new CsvWriter(dataset,"rdv.csv");
                writer.writeToCsv();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

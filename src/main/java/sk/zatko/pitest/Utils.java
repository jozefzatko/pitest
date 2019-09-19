package sk.zatko.pitest;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static HappyDeveloperResult findTheHappiestDeveloper(List<Developer> developerList) {

        HappyDeveloperResult result = new HappyDeveloperResult();
        result.setNames(new ArrayList<String>());

        if (developerList == null || developerList.isEmpty()) {
            return null;
        }

        result.setMood(developerList.get(0).getMood());

        for (Developer developer : developerList) {
            if (developer.getMood() == result.getMood()) {
                result.getNames().add(developer.getName());
            }
            if (developer.getMood() > result.getMood()) {
                result.getNames().clear();
                result.getNames().add(developer.getName());
                result.setMood(developer.getMood());
            }
        }
        return result;
    }
}

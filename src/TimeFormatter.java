import java.util.LinkedList;
import java.util.List;

public class TimeFormatter {
    public static void main(String[] args) {
        System.out.println(formatDuration(15731080));
    }

    public static String formatDuration(int time) {
        if (time <= 0) {
            return "now";
        }
        List<String> timeUnits = new LinkedList<String>();

        int seconds = time % 60;
        if (seconds == 1) {
            timeUnits.add(seconds + " second");
        } else  if (seconds > 1) {
            timeUnits.add(seconds + " seconds");
        }
        time /= 60;

        int minutes = time % 60;
        if (minutes == 1) {
            timeUnits.add(minutes + " minute");
        } else  if (minutes > 1) {
            timeUnits.add(minutes + " minutes");
        }
        time /= 60;

        int hours = time % 24;
        if (hours == 1) {
            timeUnits.add(hours + " hour");
        } else  if (hours > 1) {
            timeUnits.add(hours + " hours");
        }
        time /= 24;

        int days = time % 365;
        if (days == 1) {
            timeUnits.add(days + " day");
        } else  if (days > 1) {
            timeUnits.add(days + " days");
        }

        int years = time / 365;
        if (years == 1) {
            timeUnits.add(years + " year");
        } else  if (years > 1) {
            timeUnits.add(years + " years");
        }

        StringBuilder result = new StringBuilder(timeUnits.get(0));
        if (timeUnits.size() == 1) {
            return result.toString();
        }
        result.insert(0, " and ").insert(0, timeUnits.get(1));
        for (int i = 2; i < timeUnits.size(); i++) {
            result.insert(0, ", ").insert(0, timeUnits.get(i));
        }
        return result.toString();
    }
}

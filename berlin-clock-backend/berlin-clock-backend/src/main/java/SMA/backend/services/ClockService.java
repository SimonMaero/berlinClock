package SMA.backend.services;

import SMA.backend.dto.DigitalTimeDto;
import SMA.backend.dto.LightDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClockService {

    public List<LightDto> getBerlinTimeSingleMinutesRow(String digitalTime){
        int minuteDigit = Integer.parseInt(digitalTime.substring(4,5));
        ArrayList<LightDto> returnList = new ArrayList<LightDto>();

        switch (minuteDigit){
            case 1:
            case 6:
                returnList.addAll( Arrays.asList(new LightDto(1,true,true),
                        new LightDto(2,true,false),
                        new LightDto(3,true,false),
                        new LightDto(4,true,false)));
                break;
            case 2:
            case 7:
                returnList.addAll( Arrays.asList(new LightDto(1,true,true),
                        new LightDto(2,true,true),
                        new LightDto(3,true,false),
                        new LightDto(4,true,false)));
                break;
            case 3:
            case 8:
                returnList.addAll( Arrays.asList(new LightDto(1,true,true),
                        new LightDto(2,true,true),
                        new LightDto(3,true,true),
                        new LightDto(4,true,false)));
                break;
            case 4:
            case 9:
                returnList.addAll( Arrays.asList(new LightDto(1,true,true),
                        new LightDto(2,true,true),
                        new LightDto(3,true,true),
                        new LightDto(4,true,true)));
                break;
            case 0:
            case 5:
            default:
                returnList.addAll( Arrays.asList(new LightDto(1,true,false),
                        new LightDto(2,true,false),
                        new LightDto(3,true,false),
                        new LightDto(4,true,false)));
            break;
        }
        return returnList;
    }

    public List<LightDto> getBerlinTimeFiveMinutesRow(String digitalTime){
        int minuteTensDigit = Integer.parseInt(digitalTime.substring(3,4));
        int minuteDigit = Integer.parseInt(digitalTime.substring(4,5));
        ArrayList<LightDto> returnList = new ArrayList<LightDto>();
        if(minuteDigit<5 && minuteTensDigit==0){
                returnList.addAll( Arrays.asList(new LightDto(1,true,false),
                        new LightDto(2,true,false),
                        new LightDto(3,false,false),
                        new LightDto(4,true,false),
                        new LightDto(5,true,false),
                        new LightDto(6,false,false),
                        new LightDto(7,true,false),
                        new LightDto(8,true,false),
                        new LightDto(9,false,false),
                        new LightDto(10,true,false),
                        new LightDto(11,true,false)));
        } else if (minuteDigit>4 && minuteTensDigit==0) {
            returnList.addAll( Arrays.asList(new LightDto(1,true,true),
                    new LightDto(2,true,false),
                    new LightDto(3,false,false),
                    new LightDto(4,true,false),
                    new LightDto(5,true,false),
                    new LightDto(6,false,false),
                    new LightDto(7,true,false),
                    new LightDto(8,true,false),
                    new LightDto(9,false,false),
                    new LightDto(10,true,false),
                    new LightDto(11,true,false)));
        } else if (minuteDigit<5 && minuteTensDigit==1){
            returnList.addAll( Arrays.asList(new LightDto(1,true,true),
                    new LightDto(2,true,true),
                    new LightDto(3,false,false),
                    new LightDto(4,true,false),
                    new LightDto(5,true,false),
                    new LightDto(6,false,false),
                    new LightDto(7,true,false),
                    new LightDto(8,true,false),
                    new LightDto(9,false,false),
                    new LightDto(10,true,false),
                    new LightDto(11,true,false)));
        } else if (minuteDigit>4 && minuteTensDigit==1) {
            returnList.addAll( Arrays.asList(new LightDto(1,true,true),
                    new LightDto(2,true,true),
                    new LightDto(3,false,true),
                    new LightDto(4,true,false),
                    new LightDto(5,true,false),
                    new LightDto(6,false,false),
                    new LightDto(7,true,false),
                    new LightDto(8,true,false),
                    new LightDto(9,false,false),
                    new LightDto(10,true,false),
                    new LightDto(11,true,false)));
        } else if (minuteDigit<5 && minuteTensDigit==2){
            returnList.addAll( Arrays.asList(new LightDto(1,true,true),
                    new LightDto(2,true,true),
                    new LightDto(3,false,true),
                    new LightDto(4,true,true),
                    new LightDto(5,true,false),
                    new LightDto(6,false,false),
                    new LightDto(7,true,false),
                    new LightDto(8,true,false),
                    new LightDto(9,false,false),
                    new LightDto(10,true,false),
                    new LightDto(11,true,false)));
        } else if (minuteDigit>4 && minuteTensDigit==2) {
            returnList.addAll( Arrays.asList(new LightDto(1,true,true),
                    new LightDto(2,true,true),
                    new LightDto(3,false,true),
                    new LightDto(4,true,true),
                    new LightDto(5,true,true),
                    new LightDto(6,false,false),
                    new LightDto(7,true,false),
                    new LightDto(8,true,false),
                    new LightDto(9,false,false),
                    new LightDto(10,true,false),
                    new LightDto(11,true,false)));
        } else if (minuteDigit<5 && minuteTensDigit==3){
            returnList.addAll( Arrays.asList(new LightDto(1,true,true),
                    new LightDto(2,true,true),
                    new LightDto(3,false,true),
                    new LightDto(4,true,true),
                    new LightDto(5,true,true),
                    new LightDto(6,false,true),
                    new LightDto(7,true,false),
                    new LightDto(8,true,false),
                    new LightDto(9,false,false),
                    new LightDto(10,true,false),
                    new LightDto(11,true,false)));
        } else if (minuteDigit>4 && minuteTensDigit==3) {
            returnList.addAll( Arrays.asList(new LightDto(1,true,true),
                    new LightDto(2,true,true),
                    new LightDto(3,false,true),
                    new LightDto(4,true,true),
                    new LightDto(5,true,true),
                    new LightDto(6,false,true),
                    new LightDto(7,true,true),
                    new LightDto(8,true,false),
                    new LightDto(9,false,false),
                    new LightDto(10,true,false),
                    new LightDto(11,true,false)));
        } else if (minuteDigit<5 && minuteTensDigit==4){
            returnList.addAll( Arrays.asList(new LightDto(1,true,true),
                    new LightDto(2,true,true),
                    new LightDto(3,false,true),
                    new LightDto(4,true,true),
                    new LightDto(5,true,true),
                    new LightDto(6,false,true),
                    new LightDto(7,true,true),
                    new LightDto(8,true,true),
                    new LightDto(9,false,false),
                    new LightDto(10,true,false),
                    new LightDto(11,true,false)));
        } else if (minuteDigit>4 && minuteTensDigit==4) {
            returnList.addAll( Arrays.asList(new LightDto(1,true,true),
                    new LightDto(2,true,true),
                    new LightDto(3,false,true),
                    new LightDto(4,true,true),
                    new LightDto(5,true,true),
                    new LightDto(6,false,true),
                    new LightDto(7,true,true),
                    new LightDto(8,true,true),
                    new LightDto(9,false,true),
                    new LightDto(10,true,false),
                    new LightDto(11,true,false)));
        } else if (minuteDigit<5 && minuteTensDigit==5){
            returnList.addAll( Arrays.asList(new LightDto(1,true,true),
                    new LightDto(2,true,true),
                    new LightDto(3,false,true),
                    new LightDto(4,true,true),
                    new LightDto(5,true,true),
                    new LightDto(6,false,true),
                    new LightDto(7,true,true),
                    new LightDto(8,true,true),
                    new LightDto(9,false,true),
                    new LightDto(10,true,true),
                    new LightDto(11,true,false)));
        } else if (minuteDigit>4 && minuteTensDigit==5) {
            returnList.addAll( Arrays.asList(new LightDto(1,true,true),
                    new LightDto(2,true,true),
                    new LightDto(3,false,true),
                    new LightDto(4,true,true),
                    new LightDto(5,true,true),
                    new LightDto(6,false,true),
                    new LightDto(7,true,true),
                    new LightDto(8,true,true),
                    new LightDto(9,false,true),
                    new LightDto(10,true,true),
                    new LightDto(11,true,true)));
        } else {
            returnList.addAll( Arrays.asList(new LightDto(1,true,false),
                    new LightDto(2,true,false),
                    new LightDto(3,false,false),
                    new LightDto(4,true,false),
                    new LightDto(5,true,false),
                    new LightDto(6,false,false),
                    new LightDto(7,true,false),
                    new LightDto(8,true,false),
                    new LightDto(9,false,false),
                    new LightDto(10,true,false),
                    new LightDto(11,true,false)));
        }
        return returnList;

    }

    public List<LightDto> getBerlinTimeSingleHoursRow(String digitalTime){
        int hoursDigit = Integer.parseInt(digitalTime.substring(1,2));
        ArrayList<LightDto> returnList = new ArrayList<LightDto>();

        switch (hoursDigit){
            case 1:
            case 6:
                returnList.addAll( Arrays.asList(new LightDto(1,false,true),
                        new LightDto(2,false,false),
                        new LightDto(3,false,false),
                        new LightDto(4,false,false)));
                break;
            case 2:
            case 7:
                returnList.addAll( Arrays.asList(new LightDto(1,false,true),
                        new LightDto(2,false,true),
                        new LightDto(3,false,false),
                        new LightDto(4,false,false)));
                break;
            case 3:
            case 8:
                returnList.addAll( Arrays.asList(new LightDto(1,false,true),
                        new LightDto(2,false,true),
                        new LightDto(3,false,true),
                        new LightDto(4,false,false)));
                break;
            case 4:
            case 9:
                returnList.addAll( Arrays.asList(new LightDto(1,false,true),
                        new LightDto(2,false,true),
                        new LightDto(3,false,true),
                        new LightDto(4,false,true)));
                break;
            case 0:
            case 5:
            default:
                returnList.addAll( Arrays.asList(new LightDto(1,false,false),
                        new LightDto(2,false,false),
                        new LightDto(3,false,false),
                        new LightDto(4,false,false)));
                break;
        }
        return returnList;

    }

    public List<LightDto> getBerlinTimeFiveHoursRow(String digitalTime){
        int hoursFull = Integer.parseInt(digitalTime.substring(0,2));
        ArrayList<LightDto> returnList = new ArrayList<LightDto>();

        if (hoursFull<5) {
            returnList.addAll(Arrays.asList(new LightDto(1, false, false),
                    new LightDto(2, false, false),
                    new LightDto(3, false, false),
                    new LightDto(4, false, false)));
        } else if (hoursFull<10) {
            returnList.addAll(Arrays.asList(new LightDto(1, false, true),
                    new LightDto(2, false, false),
                    new LightDto(3, false, false),
                    new LightDto(4, false, false)));
        } else if (hoursFull<15) {
                returnList.addAll( Arrays.asList(new LightDto(1,false,true),
                        new LightDto(2,false,true),
                        new LightDto(3,false,false),
                        new LightDto(4,false,false)));
        } else if (hoursFull<20) {
                returnList.addAll( Arrays.asList(new LightDto(1,false,true),
                        new LightDto(2,false,true),
                        new LightDto(3,false,true),
                        new LightDto(4,false,false)));
        } else if (hoursFull<24) {
            returnList.addAll(Arrays.asList(new LightDto(1, false, true),
                    new LightDto(2, false, true),
                    new LightDto(3, false, true),
                    new LightDto(4, false, true)));
        } else {
            returnList.addAll(Arrays.asList(new LightDto(1, false, false),
                    new LightDto(2, false, false),
                    new LightDto(3, false, false),
                    new LightDto(4, false, false)));
        }
        return returnList;
    }

    public List<LightDto> getBerlinTimeSecondsRow(String digitalTime){
        int secondsDigit = Integer.parseInt(digitalTime.substring(7,8));
        ArrayList<LightDto> returnList = new ArrayList<LightDto>();

        if (secondsDigit % 2 == 0) {
            returnList.addAll(Arrays.asList(new LightDto(1, true, true)));
        } else {
            returnList.addAll(Arrays.asList(new LightDto(1, true, false)));
        }
        return returnList;
    }

    public DigitalTimeDto getDigitalTime(String berlinTimeRaw){
        DigitalTimeDto digitalTimeDto = new DigitalTimeDto("00:00:00");
        String berlinTime=berlinTimeRaw.replace("R","Y");
        String secondsDigit = berlinTime.substring(0,1);
        String digitalTimeSeconds="XX";
        String digitalTimeMinutes="XX";
        String digitalTimeHours="XX";
        Pattern p = Pattern.compile("Y");

        //seconds conversion
        if (secondsDigit.equals("Y")) {
            digitalTimeSeconds="00";
        } else {
            digitalTimeSeconds="01";
        }
        //minutes conversion
        String singleMinutesSegment = berlinTime.substring(20,24);
        String fiveMinutesSegment = berlinTime.substring(9,20);
        Matcher singleMinutesMatcher = p.matcher(singleMinutesSegment);
        long numberOfSingleMinutes = singleMinutesMatcher.results().count();
        Matcher fiveMinutesMatcher = p.matcher(fiveMinutesSegment);
        long numberOfFiveMinutes = fiveMinutesMatcher.results().count();
        digitalTimeMinutes=String.valueOf(numberOfSingleMinutes+(numberOfFiveMinutes*5));
        if(digitalTimeMinutes.equals("0")){digitalTimeMinutes="00";};
        //hours conversion
        String singleHoursSegment = berlinTime.substring(5,9);
        String fiveHoursSegment = berlinTime.substring(1,5);
        Matcher singleHoursMatcher = p.matcher(singleHoursSegment);
        long numberOfSingleHours =  singleHoursMatcher.results().count();
        Matcher fiveHoursMatcher = p.matcher(fiveHoursSegment);
        long numberOfFiveHours = fiveHoursMatcher.results().count();
        digitalTimeHours=String.valueOf(numberOfSingleHours+(numberOfFiveHours*5));
        if(digitalTimeHours.equals("0")){digitalTimeHours="00";};

        digitalTimeDto.setDigitalTime(String.join(":",digitalTimeHours,digitalTimeMinutes,digitalTimeSeconds));
        return digitalTimeDto;
    }
}

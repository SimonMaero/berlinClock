package SMA.backend.controllers;

import SMA.backend.dto.BerlinTimeDto;
import SMA.backend.dto.LightDto;
import SMA.backend.dto.DigitalTimeDto;
import SMA.backend.services.ClockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/timeConversion")
public class ClockController {

    private final ClockService clockService;

    public ClockController(ClockService clockService){
        this.clockService = clockService;
    }

    @PostMapping("/berlinTime/singleMinutesRow")
    public ResponseEntity<List<LightDto>> getBerlinTimeSingleMinutesRow(
            @RequestBody DigitalTimeDto digitalTime) {
        return ResponseEntity.ok(clockService.getBerlinTimeSingleMinutesRow(digitalTime.getDigitalTime()));
    }

    @PostMapping("/berlinTime/fiveMinutesRow")
    public ResponseEntity<List<LightDto>> getBerlinTimeFiveMinutesRow(
            @RequestBody DigitalTimeDto digitalTime) {
        return ResponseEntity.ok(clockService.getBerlinTimeFiveMinutesRow(digitalTime.getDigitalTime()));
    }

    @PostMapping("/berlinTime/singleHoursRow")
    public ResponseEntity<List<LightDto>> getBerlinTimeSingleHoursRow(
            @RequestBody DigitalTimeDto digitalTime) {
        return ResponseEntity.ok(clockService.getBerlinTimeSingleHoursRow(digitalTime.getDigitalTime()));
    }

    @PostMapping("/berlinTime/fiveHoursRow")
    public ResponseEntity<List<LightDto>> getBerlinTimeFiveHoursRow(
            @RequestBody DigitalTimeDto digitalTime) {
        return ResponseEntity.ok(clockService.getBerlinTimeFiveHoursRow(digitalTime.getDigitalTime()));
    }

    @PostMapping("/berlinTime/secondsRow")
    public ResponseEntity<List<LightDto>> getBerlinTimeSecondsRow(
            @RequestBody DigitalTimeDto digitalTime) {
        return ResponseEntity.ok(clockService.getBerlinTimeSecondsRow(digitalTime.getDigitalTime()));
    }

    @PostMapping("/digitalTime")
    public ResponseEntity<DigitalTimeDto> getDigitalTime(
            @RequestBody BerlinTimeDto berlinTime) {
        return ResponseEntity.ok(clockService.getDigitalTime(berlinTime.getBerlinTime()));

    }
}

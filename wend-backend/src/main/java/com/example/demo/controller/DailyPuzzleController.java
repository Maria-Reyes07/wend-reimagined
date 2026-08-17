import com.example.demo.entity.DailyPuzzle;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Puzzle;
import com.example.demo.repository.DailyPuzzleRepository;

@RestController
public class DailyPuzzleController {

    private DailyPuzzleRepository dailyPuzzleRepository;

    public DailyPuzzleController(DailyPuzzleRepository dailyPuzzleRepository) {
        this.dailyPuzzleRepository = dailyPuzzleRepository;
    }

    @GetMapping("/api/puzzles/today")
    public Puzzle getTodaysPuzzle() {

        LocalDate today = LocalDate.now();

        DailyPuzzle dailyPuzzle = dailyPuzzleRepository.findByDate(today).orElseThrow();

        return dailyPuzzle.getPuzzle();
    }
}
package com.example.demo.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Difficulty;
import com.example.demo.entity.Puzzle;
import com.example.demo.entity.Theme;
import com.example.demo.entity.Word;
import com.example.demo.repository.PuzzleRepository;
import com.example.demo.repository.ThemeRepository;
import com.example.demo.repository.WordRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ThemeRepository themeRepository;
    private final PuzzleRepository puzzleRepository;
    private final WordRepository wordRepository;

    public DataInitializer(
            ThemeRepository themeRepository,
            PuzzleRepository puzzleRepository,
            WordRepository wordRepository) {

        this.themeRepository = themeRepository;
        this.puzzleRepository = puzzleRepository;
        this.wordRepository = wordRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("DataInitializer is running!");

        // Disney Theme
        Theme disney = themeRepository.findByName("Disney")
                .orElseGet(() -> {
                    Theme theme = new Theme();
                    theme.setName("Disney");
                    return themeRepository.save(theme);
                });

        // Disney - EASY
        Puzzle disneyEasy = puzzleRepository
                .findByThemeAndDifficulty(disney, Difficulty.EASY)
                .orElseGet(() -> {
                    Puzzle puzzle = new Puzzle();
                    puzzle.setTheme(disney);
                    puzzle.setDifficulty(Difficulty.EASY);
                    puzzle.setGrid("MRACS/I####/CKEER/OMYGG/USETI");

                    Puzzle savedPuzzle = puzzleRepository.save(puzzle);

                    addWord(savedPuzzle, "MICKEYMOUSE",
                            List.of(0, 5, 10, 11, 12, 17, 16, 15, 20, 21, 22));

                    addWord(savedPuzzle, "SCAR",
                            List.of(4, 3, 2, 1));

                    addWord(savedPuzzle, "TIGGER",
                            List.of(23, 24, 19, 18, 13, 14));

                    return savedPuzzle;
                });

        // Disney - MEDIUM
        Puzzle disneyMedium = puzzleRepository
                .findByThemeAndDifficulty(disney, Difficulty.MEDIUM)
                .orElseGet(() -> {
                    Puzzle puzzle = new Puzzle();
                    puzzle.setTheme(disney);
                    puzzle.setDifficulty(Difficulty.MEDIUM);
                    puzzle.setGrid("RA#EN/SPLEC/TUNZA/ITCHN/###OT");

                    Puzzle savedPuzzle = puzzleRepository.save(puzzle);

                    addWord(savedPuzzle, "RAPUNZEL",
                            List.of(0, 1, 6, 11, 12, 13, 8, 7));

                    addWord(savedPuzzle, "STITCH",
                            List.of(5, 10, 15, 16, 17, 18));

                    addWord(savedPuzzle, "ENCANTO",
                            List.of(3, 4, 9, 14, 19, 24, 23));

                    return savedPuzzle;
                });

        // Disney - HARD
        Puzzle disneyHard = puzzleRepository
                .findByThemeAndDifficulty(disney, Difficulty.HARD)
                .orElseGet(() -> {
                    Puzzle puzzle = new Puzzle();
                    puzzle.setTheme(disney);
                    puzzle.setDifficulty(Difficulty.HARD);
                    puzzle.setGrid("LEURC/L##EL/A#WAL/ENTLA/CIFEM");

                    Puzzle savedPuzzle = puzzleRepository.save(puzzle);

                    addWord(savedPuzzle, "MALEFICENT",
                            List.of(24, 19, 18, 23, 22, 21, 20, 15, 16, 17));

                    addWord(savedPuzzle, "CRUELLA",
                            List.of(4, 3, 2, 1, 0, 5));

                    addWord(savedPuzzle, "WALLE",
                            List.of(12, 13, 14, 9, 8));

                    return savedPuzzle;
                });

        // Space Theme
        Theme space = themeRepository.findByName("Space")
                .orElseGet(() -> {
                    Theme theme = new Theme();
                    theme.setName("Space");
                    return themeRepository.save(theme);
                });

        // EASY
        Puzzle spaceEasy = puzzleRepository
                .findByThemeAndDifficulty(space, Difficulty.EASY)
                .orElseGet(() -> {
                    Puzzle puzzle = new Puzzle();
                    puzzle.setTheme(space);
                    puzzle.setDifficulty(Difficulty.EASY);
                    puzzle.setGrid("RTHGN/A#LAA/E#AXS/MOSYA/NOUN#");

                    Puzzle savedPuzzle = puzzleRepository.save(puzzle);

                    addWord(savedPuzzle, "SUN",
                            List.of(17, 22, 23));

                    addWord(savedPuzzle, "NASA",
                            List.of(4, 8, 14, 9));

                    addWord(savedPuzzle, "MOON",
                            List.of(15, 16, 21, 20));

                    addWord(savedPuzzle, "EARTH",
                            List.of(10, 5, 0, 1, 2));

                    addWord(savedPuzzle, "GALAXY",
                            List.of(3, 8, 7, 12, 13, 19));

                    return savedPuzzle;
                });

        // Space - MEDIUM
        Puzzle spaceMedium = puzzleRepository
                .findByThemeAndDifficulty(space, Difficulty.MEDIUM)
                .orElseGet(() -> {
                    Puzzle puzzle = new Puzzle();
                    puzzle.setTheme(space);
                    puzzle.setDifficulty(Difficulty.MEDIUM);
                    puzzle.setGrid("AURAN/PO#SU/#LY##/#LTIV/#OGRA");

                    Puzzle savedPuzzle = puzzleRepository.save(puzzle);

                    addWord(savedPuzzle, "APOLLO",
                            List.of(0, 5, 6, 11, 16, 21));

                    addWord(savedPuzzle, "URANUS",
                            List.of(1, 2, 3, 4, 9, 8));

                    addWord(savedPuzzle, "GRAVITY",
                            List.of(22, 23, 24, 19, 18, 17, 12));

                    return savedPuzzle;
                });

        // Space - HARD
        Puzzle spaceHard = puzzleRepository
                .findByThemeAndDifficulty(space, Difficulty.HARD)
                .orElseGet(() -> {
                    Puzzle puzzle = new Puzzle();
                    puzzle.setTheme(space);
                    puzzle.setDifficulty(Difficulty.HARD);
                    puzzle.setGrid("EYAGE/XOETR/OVNGE/PLAIM/###NI");

                    Puzzle savedPuzzle = puzzleRepository.save(puzzle);

                    addWord(savedPuzzle, "VOYAGER",
                            List.of(11, 6, 1, 2, 3, 4, 9));

                    addWord(savedPuzzle, "EXOPLANET",
                            List.of(0, 5, 10, 15, 16, 17, 12, 7, 8));

                    addWord(savedPuzzle, "GEMINI",
                            List.of(13, 14, 19, 18, 23, 24));

                    return savedPuzzle;
                });
    }

    // Helper method for creating words
    private void addWord(Puzzle puzzle, String text, List<Integer> path) {

        Word word = new Word();

        word.setText(text);
        word.setPuzzle(puzzle);
        word.setPath(path);

        wordRepository.save(word);
    }
}
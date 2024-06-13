package Quiz.service;
import Quiz.model.Theme;
import Quiz.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    private static final List<String> AVAILABLE_THEMES = Arrays.asList(
            "Стандартная тема",
            "Новогодняя тема",
            "Хеллоуин тема",
            "Летняя тема"
    );

    public List<String> getAvailableThemes() {
        return AVAILABLE_THEMES;
    }

    public boolean isValidTheme(String theme) {
        return AVAILABLE_THEMES.contains(theme);
    }

    public void setCurrentTheme(String theme) {
        if (isValidTheme(theme)) {
            Theme currentTheme = themeRepository.findByName(theme);
            if (currentTheme == null) {
                currentTheme = new Theme();
                currentTheme.setName(theme);
                themeRepository.save(currentTheme);
            } else {
                currentTheme.setName(theme);
                themeRepository.save(currentTheme);
            }
        } else {
            throw new IllegalArgumentException("Выбрана недопустимая тема");
        }
    }
}
